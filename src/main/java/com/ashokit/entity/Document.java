package com.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DOCUMENT_TBL")
public class Document {
	
	@Id
	private Integer documentId;
	
	private String documentUrl;

}
