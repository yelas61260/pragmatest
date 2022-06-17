package com.pragma.usermanager.profile.domain.entity;


import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pragma.usermanager.person.domain.entity.PersonEntity;

import lombok.*;

@Entity
@Table(name = "profile")
@Getter @Setter
@NoArgsConstructor
public class ProfileEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "profileId", fetch = FetchType.LAZY)
	private Set<PersonEntity> persons;

	public ProfileEntity(int id) {
		super();
		this.id = id;
	}

}