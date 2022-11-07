package com.image.entity;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UploadFileResponse {

	private String successMsg;
	private String fileName;
    private String fileType;
    private long size;

}
