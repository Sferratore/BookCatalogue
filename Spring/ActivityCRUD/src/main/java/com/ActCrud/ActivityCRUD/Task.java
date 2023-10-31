package com.ActCrud.ActivityCRUD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity  //Identifies Task as an Entity
public class Task {
	
	public Task() {}
	
	public Long getId() {
		return this.id;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setId(Long parId) {
		this.id = parId;
	}
	
	public void setDescription(String parDescription) {
		this.description = parDescription;
	}
	
	
    @Id @GeneratedValue
    private Long id;
    private String description;

}