package com.image.dto;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ImageResponse {

	private String success;
	private int imageId;
}
