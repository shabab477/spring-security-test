package com.shabab.rhythm.foodservice.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Food {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
    private String name;
	private double price;
	@ManyToOne(cascade = CascadeType.ALL)
	private Restaurant res;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cart> carts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
}
