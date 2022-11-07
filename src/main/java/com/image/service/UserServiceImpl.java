package com.image.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.image.dto.UserSignIn;
import com.image.entity.UserDetails;
import com.image.repo.IUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

	private final IUserRepository repo;

	@Transactional(readOnly = true)
	public List<UserDetails> fetch() {
		log.info("UserService fetch method");
		return repo.findAll();
	}

	@Transactional
	public String insert(UserDetails emp) {
		log.info("Inside UserService insert method", emp);
		repo.save(emp);
		return "User inserted Successfully:: ";
	}

	@Override
	public String userSignIn(UserSignIn userSignIn) throws LoginException {

		UserDetails userDetails = repo.findByUsername(userSignIn.getUserName());
		if (userDetails != null) {
			if(!userDetails.getPassword().equals(userSignIn.getUserPass())) {
				throw new LoginException("Incorrect user credentials....");
			}
		}else {
			throw new LoginException("User Details not found...");
		}
		return "Login Successfully!!!!!!!";
	}
}
