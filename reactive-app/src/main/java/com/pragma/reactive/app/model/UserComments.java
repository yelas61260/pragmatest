package com.pragma.reactive.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserComments {

	private User user;
	private Comments comments;
	
}
