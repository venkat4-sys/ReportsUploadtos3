package com.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CITIZEN_TBL")
public class Citizen {
	
	@Id
	private Integer citizenId;
	
	private String citizenName;
	
	private String contactNumber;
	

}
