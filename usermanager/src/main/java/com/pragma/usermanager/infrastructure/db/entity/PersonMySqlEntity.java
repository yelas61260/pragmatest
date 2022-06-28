package com.pragma.usermanager.infrastructure.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter @Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PersonMySqlEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID")
	private CityMySqlEntity cityId;
	
	@Column(name = "IMAGE")
	private String image;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROFILE_ID")
	private ProfileMySqlEntity profileId;
	
	@Column(name = "CREATE_DATE", insertable = false, updatable = false)
	private Date createDate;
	
	@Column(name = "UPDATE_DATE", insertable = false, updatable = false)
	private Date updateDate;
	
}
