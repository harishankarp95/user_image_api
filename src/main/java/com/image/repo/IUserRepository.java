package com.image.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.image.entity.UserDetails;

public interface IUserRepository extends JpaRepository<UserDetails, Integer>{

	UserDetails findByUsername(String username);
}