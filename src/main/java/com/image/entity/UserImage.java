package com.image.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "USER_IMAGE")
public class UserImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(length = 50)
	private String fileName;
	@Column(length = 50)
	private String fileType;

	@Lob
	private byte[] fileData;
	
	@OneToOne
	@JoinColumn(
			name = "userId",
			referencedColumnName = "ID"
	)
	private UserDetails userDetails;

}
