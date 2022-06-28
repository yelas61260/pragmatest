package com.pragma.reactive.app.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Comments {
	
	private List<String> comments;
	
	public Comments() {
		comments = new ArrayList<>();
	}
	
	public void addComment(String comment) {
		comments.add(comment);
	}

}
