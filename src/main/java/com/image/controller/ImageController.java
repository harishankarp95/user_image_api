package com.image.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.image.dto.DeleteImageRequest;
import com.image.dto.ImageResponse;
import com.image.dto.UserDetailsDto;
import com.image.entity.UploadFileResponse;
import com.image.exception.FileStorageException;
import com.image.service.IUserImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/imageApi")
public class ImageController {

	private final IUserImageService service;

	@PostMapping("/upload/{userName}")
	public ResponseEntity<UploadFileResponse> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable("userName") String userName)
			throws FileStorageException {
		log.info("Request inside image controller uploadImage method: ", userName);
		UploadFileResponse uploadFileResponse = service.uploadImage(file, userName);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(uploadFileResponse);
	}

	@GetMapping("/view/{imageId}")
	public ResponseEntity<UserDetailsDto> viewImage(@PathVariable("imageId") Integer imageId) {
		log.info("Request inside UserController viewImage : ", imageId);
		
		UserDetailsDto userDetailsDto = service.viewImage(imageId);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDetailsDto);
		
	}
	
	@GetMapping("/download/{imageId}")
	public ResponseEntity<UserDetailsDto> viewJsonImage(@PathVariable("imageId") Integer imageId) {
		log.info("Request Inside UserController viewJsonImage : ",imageId);
		UserDetailsDto userDetailsDto = service.viewImage(imageId);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDetailsDto);
	}

	@GetMapping("/delete")
	public ImageResponse deleteImage(@RequestBody DeleteImageRequest deleteImageRequest) {
		log.info("Request inside UserController deleteImage: ");
		ImageResponse imageResponse = service.delete(deleteImageRequest);
		return imageResponse;
	}
}
