package com.shabab.rhythm.foodservice.demo.repositories;

import java.util.List;

import com.shabab.rhythm.foodservice.demo.models.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface FoodRepository extends CrudRepository <Food, String> {
	public List <Food> findByResId(String id);

	
}
