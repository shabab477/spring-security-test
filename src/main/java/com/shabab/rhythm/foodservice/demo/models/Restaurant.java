package com.shabab.rhythm.foodservice.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Restaurant {
    @Id
	private String id;
	private String name;
	private String location;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}