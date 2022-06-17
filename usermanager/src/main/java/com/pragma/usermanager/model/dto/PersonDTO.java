package com.pragma.usermanager.model.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class PersonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
