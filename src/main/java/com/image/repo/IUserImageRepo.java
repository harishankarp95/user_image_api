package com.image.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.image.entity.UserImage;

public interface IUserImageRepo extends JpaRepository<UserImage, Integer> {
	
	@Modifying
	@Query("Delete FROM UserImage i WHERE i.id =:imageId")
	
	int deleteImageByUserId(int imageId);
}
