package com.image.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.image.dto.UserSignIn;
import com.image.entity.UserDetails;
import com.image.repo.IUserRepository;


@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@SpringBootTest
public class UserControllerTest {


	@Autowired
	IUserRepository iUserRepository;

	@Autowired 
	MockMvc mockMvc;

	@Test
	@DisplayName("/user/addUser") void testAddUserTest() throws Exception {

		UserDetails details = new UserDetails();
		details.setName("test");
		details.setAge(12);
		details.setCity("Bangalore");
		details.setUsername("test@232");
		details.setPassword("test@232");
		String requestBody = new ObjectMapper().writeValueAsString(details);

		String actions = "{\"name\":\"Test\",\"age\":12,\"city\":\"Bangalore\",\"username\":\"test@123\",\"password\":\"test@111\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/userapi/adduser").accept(MediaType.APPLICATION_JSON).content(requestBody)
				.accept(MediaType.APPLICATION_JSON));
	}
	
	@Test
	@DisplayName("/user/signIn")
	void testUserSignIn() throws Exception {

		UserDetails details = new UserDetails();
		details.setName("test");
		details.setAge(12);
		details.setCity("Bangalore");
		details.setUsername("test@111");
		details.setPassword("test@232");
		iUserRepository.save(details);
		
		UserSignIn userSignIn = new UserSignIn();
		userSignIn.setUserName("test@111");
		userSignIn.setUserPass("test@232");
		
		String requestBody = new ObjectMapper().writeValueAsString(userSignIn);

		//String actions = "{\"name\":\"Test\",\"age\":12,\"city\":\"Bangalore\",\"username\":\"test@123\",\"password\":\"test@111\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/userapi/signin")
				.accept(MediaType.APPLICATION_JSON).content(requestBody)
				.accept(MediaType.APPLICATION_JSON));
	}

}
