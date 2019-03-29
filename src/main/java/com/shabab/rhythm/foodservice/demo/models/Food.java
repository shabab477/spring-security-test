package com.shabab.rhythm.foodservice.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Food {
    @Id
	private String id;
	private double price;
	@ManyToOne
	private Restaurant res;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Restaurant getRes() {
		return res;
	}
	public void setRes(Restaurant res) {
		this.res = res;
	}
	
}
