package com.shabab.rhythm.foodservice.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestaurantController {

//	@Autowired
//	private restaurantService rs;
//
//	@RequestMapping("/restaurant")
//	public List<Restaurant> getallRes() {
//		return rs.getAllRes();
//		//return rx.getAllFood();
//	}
//
//	@RequestMapping("/restaurant/{id}")
//	public Restaurant getRes(@PathVariable String id) {
//
//		return rs.getRes(id);
//		}
//	@RequestMapping(method=RequestMethod.POST, value="/admin/restaurant")
//	public void addRes(@RequestBody Restaurant res) {
//		//rx.addFood(res);
//		rs.addRes(res);
//
//	}
//
//	@RequestMapping(method=RequestMethod.PUT, value="/admin/restaurant/{id}")
//	public void putRes(@RequestBody Restaurant res, @PathVariable String id) {
//		rs.putres(res,id);
//
//	}
//
//	@RequestMapping(method=RequestMethod.DELETE, value="/admin/restaurant/{id}")
//	public void delRes(@RequestBody Restaurant res, @PathVariable String id) {
//		rs.delres(id);
//
//	}
}
