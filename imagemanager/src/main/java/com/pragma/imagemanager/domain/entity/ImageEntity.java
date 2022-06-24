package com.pragma.imagemanager.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageEntity {

	private int resourceId;
	private int associationType;
	private String imageName;
	private String bodyBase64;
	
}