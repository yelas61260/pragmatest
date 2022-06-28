package com.pragma.usermanager.domain.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonEntity {
	
	private int id;
	private String name;
	private String email;
	private int cityId;
	private String cityName;
	private String image;
	private int profileId;
	private String profileName;
	private Date createDate;
	private Date updateDate;

}
