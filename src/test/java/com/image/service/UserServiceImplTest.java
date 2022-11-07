package com.image.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.security.auth.login.LoginException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.image.dto.UserSignIn;
import com.image.entity.UserDetails;
import com.image.repo.IUserRepository;



@AutoConfigureTestDatabase
@SpringBootTest
public class UserServiceImplTest {

	
	@Autowired
	IUserService  iUserService;
	
	@Autowired
	IUserRepository iUserRepository;
	
	@Test
	@DisplayName("/insert service")
	void testInsert() 
	{
		
		UserDetails details = new UserDetails();
		details.setName("test");
		details.setAge(12);
		details.setCity("Bangalore");
		details.setUsername("test@232");
		details.setPassword("test@232");
		
		String insertServiceRes = iUserService.insert(details);
		assertEquals("User inserted Successfully:: ", insertServiceRes);
	}
	
	@Test
	@DisplayName("/user signin service")
	void testUserSignIn() throws LoginException {
		
		UserDetails details = new UserDetails();
		details.setName("test");
		details.setAge(12);
		details.setCity("Bangalore");
		details.setUsername("test@123");
		details.setPassword("test@111");
		
		iUserRepository.save(details);
		UserSignIn userSignIn = new UserSignIn();
		userSignIn.setUserName("test@123");
		userSignIn.setUserPass("test@111");
		
		String userSigninMsgRes = iUserService.userSignIn(userSignIn);
		
		assertEquals("Login Successfully!!!!!!!", userSigninMsgRes);
	}
	
}
