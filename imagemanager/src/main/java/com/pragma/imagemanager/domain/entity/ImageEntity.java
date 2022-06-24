package com.pragma.imagemanager.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document("imagerepo")
@Data
@AllArgsConstructor
public class ImageEntity {
	
	@Id
	private String id;
	
	private String imageName;
	private String bodyBase64;

}
