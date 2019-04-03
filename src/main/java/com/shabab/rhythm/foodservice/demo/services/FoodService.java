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


	public Food getFood(Long id) {
		return rest.findById(id).orElse(null);
	}
}
