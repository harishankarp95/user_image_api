package com.image.dto;

import lombok.Data;

@Data
public class DeleteImageRequest {

	private int userId;
	private int imageId;
}
