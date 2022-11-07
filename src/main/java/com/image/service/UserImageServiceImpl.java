package com.image.service;

import java.io.IOException;
import java.util.Optional;

import javax.security.auth.login.LoginException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.image.dto.DeleteImageRequest;
import com.image.dto.ImageResponse;
import com.image.dto.UserDetailsDto;
import com.image.entity.UploadFileResponse;
import com.image.entity.UserDetails;
import com.image.entity.UserImage;
import com.image.exception.FileStorageException;
import com.image.repo.IUserImageRepo;
import com.image.repo.IUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Service
public class UserImageServiceImpl implements IUserImageService {

	private final IUserImageRepo imageRepo;
	private final IUserRepository iUserRepo;
	public static final String SUCCESS_MESSAGE = "Image uploaded successfully";

	@Override
	public UploadFileResponse uploadImage(MultipartFile multipartFile, String userName) throws FileStorageException {
		log.info("inside upload image service Impl");
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		UserDetails userDetails = iUserRepo.findByUsername(userName);
		
		try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Oops! Filename contains invalid path sequence " + fileName);
            }
            
            UserImage userImage = new UserImage();
            userImage.setFileName(fileName);
            userImage.setFileType(multipartFile.getContentType());
            userImage.setFileData(multipartFile.getBytes());
            userImage.setUserDetails(userDetails);
            imageRepo.save(userImage);
            
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
		
		return UploadFileResponse.builder()
				.fileName(fileName)
				.fileType(multipartFile.getContentType())
				.size(multipartFile.getSize())
				.successMsg(SUCCESS_MESSAGE)
				.build();
	}

	@Override
	public UserDetailsDto viewImage(Integer imageId) {

		Optional<UserImage> userImage = imageRepo.findById(imageId);
		UserDetailsDto userDetailsDto = null;
		if(userImage.isEmpty()) {
			//throw new LoginException("Photo details not available");
		}else {
			userDetailsDto = UserDetailsDto.builder()
					.name(userImage.get().getUserDetails().getName())
					.age(userImage.get().getUserDetails().getAge())
					.city(userImage.get().getUserDetails().getCity())
					.image(userImage.get().getFileData())
					.build();
		}
		return userDetailsDto;
	}

	@Transactional
	public ImageResponse delete(DeleteImageRequest deleteImageRequest) {
		
		int count = imageRepo.deleteImageByUserId(deleteImageRequest.getImageId());
		log.info("Image record Deleted successfully for the id: ", count);
		return ImageResponse.builder()
				.imageId(deleteImageRequest.getImageId())
				.success("Image Deleted Successfully")
				.build();
	}

}
