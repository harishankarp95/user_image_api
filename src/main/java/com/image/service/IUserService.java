package com.image.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.image.dto.UserSignIn;
import com.image.entity.UserDetails;

public interface IUserService {

	List<UserDetails> fetch();
	
	String insert(UserDetails emp);
	
	String userSignIn(UserSignIn userSignIn) throws LoginException;
}
