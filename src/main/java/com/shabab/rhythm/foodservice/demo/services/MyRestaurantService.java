package com.shabab.rhythm.foodservice.demo.services;

import java.util.ArrayList;

import java.util.List;

import com.shabab.rhythm.foodservice.demo.models.Restaurant;
import com.shabab.rhythm.foodservice.demo.repositories.RestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyRestaurantService {

	@Autowired
	private RestRepository rest;

	public List<Restaurant> getAllRes() {
		List<Restaurant> res = new ArrayList<>();
		rest.findAll()
				.forEach(res::add);
		return res;
	}

	public Restaurant getRes(String id) {

		return rest.findById(id).orElse(null);
	}

	public void addRes(Restaurant res2) {

		rest.save(res2);

	}

	public void putres(Restaurant res2, String id) {
		rest.save(res2);

	}

	public void delres(String id) {
		rest.deleteById(id);

	}
}
