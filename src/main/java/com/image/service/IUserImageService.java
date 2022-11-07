package com.image.service;

import org.springframework.web.multipart.MultipartFile;

import com.image.dto.DeleteImageRequest;
import com.image.dto.ImageResponse;
import com.image.dto.UserDetailsDto;
import com.image.entity.UploadFileResponse;
import com.image.exception.FileStorageException;

public interface IUserImageService {

	UserDetailsDto viewImage(Integer imageId);

	UploadFileResponse uploadImage(MultipartFile multipartFile, String userName) throws FileStorageException;

	ImageResponse delete(DeleteImageRequest deleteImageRequest);
}
