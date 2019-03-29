package com.shabab.rhythm.foodservice.demo.services;

import java.util.ArrayList;

import java.util.List;

import com.shabab.rhythm.foodservice.demo.models.Food;
import com.shabab.rhythm.foodservice.demo.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

	@Autowired
	private FoodRepository rest;

	public List<Food> getAllFood(String id) {
		List<Food> re = new ArrayList<>();
		rest.findByResId(id)
				.forEach(re::add);
		return re;
	}

	public Food getFood(String id) {

		return rest.findById(id).orElse(null);
	}

	public void addFood(Food res2) {

		rest.save(res2);

	}

	public void putFood(Food res2) {
		rest.save(res2);

	}

	public void delFood(String id) {
		rest.deleteById(id);

	}
}
