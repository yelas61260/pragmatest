package com.pragma.usermanager.infrastructure.db.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "city")
@Getter @Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CityMySqlEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cityId", fetch = FetchType.LAZY)
	private Set<PersonMySqlEntity> persons;

}
