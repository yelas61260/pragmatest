package com.pragma.imagemanager.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("imagerepo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageEntity {
	
	@Id
	private String id;
	
	private String imageName;
	private String bodyBase64;

}
