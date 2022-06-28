package com.pragma.usermanager.infrastructure.db.entity;


import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "profile")
@Getter @Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProfileMySqlEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "profileId", fetch = FetchType.LAZY)
	private Set<PersonMySqlEntity> persons;

}