package com.image.controller;

import javax.security.auth.login.LoginException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.image.dto.UserSignIn;
import com.image.entity.UserDetails;
import com.image.service.IUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/userapi")
public class UserController {

	private final IUserService userService;
	
	@GetMapping("/")
	public String homePage() {
		log.info("UserController homePage");
		return "home page";
	}
	
	@PostMapping("/adduser")
	public String addUserDetails(@RequestBody UserDetails userDetails) {
		log.info("Request inside UserController addUserDetails method");
		return userService.insert(userDetails);
	}
	
	@PostMapping("/signin")
	public String userSignin(@RequestBody UserSignIn userSignIn) throws LoginException {
		log.info("Inside user/signin :");
		return userService.userSignIn(userSignIn);
	}
	
}
