package com.pragma.reactive.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
	
	private String nombre;
	private String apellido;

}
