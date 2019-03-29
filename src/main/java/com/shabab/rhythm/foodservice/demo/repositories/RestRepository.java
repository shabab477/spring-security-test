package com.shabab.rhythm.foodservice.demo.repositories;


import com.shabab.rhythm.foodservice.demo.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface RestRepository extends CrudRepository <Restaurant, String> {
	
}
