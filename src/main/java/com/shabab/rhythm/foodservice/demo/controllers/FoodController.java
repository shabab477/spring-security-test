package com.shabab.rhythm.foodservice.demo.controllers;

import java.util.List;

import com.shabab.rhythm.foodservice.demo.services.FoodService;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodController {

	@Autowired
	private FoodService rs;
	
//	@RequestMapping("/restaurant/{id}/food")
//	public List<Food> getallFood(@PathVariable String id) {
//		return rs.getAllFood(id);
//
//	}
//	@RequestMapping("/restaurant/{resid}/food/{id}")
//	public Food getFood(@PathVariable String id) {
//
//		return rs.getFood(id);
//	}
//
//	@RequestMapping(method=RequestMethod.POST, value="/admin/restaurant/{resid}/food")
//	public void addFood(@RequestBody Food food,@PathVariable String resid) {
//		food.setRes(new Restaurant(resid,"",""));
//		rs.addFood(food);
//	}
//
//	@RequestMapping(method=RequestMethod.PUT, value="/admin/restaurant/{resid}/food/{id}")
//	public void putFood(@RequestBody Food food,@PathVariable String resid, @PathVariable String id) {
//		food.setRes(new Restaurant(resid,"",""));
//		rs.putFood(food);
//	}
//
//	@RequestMapping(method=RequestMethod.DELETE, value="/admin/restaurant/{resid}/food/{id}")
//	public void delFood( @PathVariable String id) {
//		rs.delFood(id);
//	}

	
	
}