package com.pragma.imagemanager.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageEntity {

	private int resourceId;
	private int associationType;
	private String imageName;
	private String bodyBase64;
	
}