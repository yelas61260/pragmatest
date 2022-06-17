package com.pragma.usermanager.city.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserManagerConstant {
	
	CITY_NULL(0, "N/A");
	
	private int id;
	private String value;

}
