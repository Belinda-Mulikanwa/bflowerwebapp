package com.bflowerApp.bflowerApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bflowerApp.bflowerApp.service.MyPopularListService;

@Controller 
public class MyPopularListController {
	
	@Autowired 
	private MyPopularListService service; 
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/popularflower";
	}

}
