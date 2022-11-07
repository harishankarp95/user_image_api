package com.image.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@ToString
@Data
@Entity
@Table(name = "USER")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(nullable = false, length = 20)
	private String name;

	@Column(nullable = false)
	private Integer age;

	@Column(nullable = false, length = 20)
	private String city;

	@Column(nullable = false, unique = true, length = 10)
	private String username;

	@Column(nullable = false, unique = true, length = 10)
	private String password;
	
	@OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
	private UserImage userImage;

}