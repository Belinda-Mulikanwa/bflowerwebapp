package com.bflowerApp.bflowerApp.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bflowerApp.bflowerApp.entity.Flower;
import com.bflowerApp.bflowerApp.entity.Login;
import com.bflowerApp.bflowerApp.entity.Popularflower;
import com.bflowerApp.bflowerApp.service.FlowerService;
import com.bflowerApp.bflowerApp.service.LoginService;
import com.bflowerApp.bflowerApp.service.MyPopularListService;

@Controller 
public class FlowerController {
	
	@Autowired
	private FlowerService service;
	
	@Autowired
	private MyPopularListService myPopularService;
	
	@Autowired
	private LoginService userService;
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new Login());
		return mav;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") Login user) {
		Login oauthUser = userService.login(user.getUsername(), user.getPassword());
		
		System.out.print(oauthUser);
		if(Objects.nonNull(oauthUser)) {
			
			return "redirect:/index";
		}
		else {
			return "redirect:/login";
		}
	}
	
	
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}
	@GetMapping("/home")
	public String goHome() {
		return "home";
	}

	@GetMapping("/flowerRegister")
	public String flowerRegister() {
		return "flowerRegister";
	}
	@GetMapping("/availabeFlower")
	public ModelAndView getAllFlower() {
		List<Flower>list=service.getAllFlower();
		//ModelAndView m=new ModelAndView();
		//m.setViewName("availabeFlower");
		//m.addObject("Flower", list);
		return new ModelAndView("availabeFlower", "Flower", list);
	}
	
	@PostMapping("/save")
	public String addFlower(@ModelAttribute Flower f) {
		service.save(f);
		return "redirect:/availabeFlower";
	}
	@GetMapping("/popularflower")
	public String getPopularflower(Model model) {
		
		List<Popularflower>list=myPopularService.getAllMyPopular();
		model.addAttribute("popular",list);
		return "popularflower";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Flower f=service.getFlowerById(id);
		Popularflower pf=new Popularflower(f.getId(), f.getFname(), f.getFprice(), f.getFdesc());
		myPopularService.savedMyPopular(pf);
		return "redirect:/popularflower";
	}
	@RequestMapping("/editFlower/{id}")
	public String editFlower(@PathVariable("id") int id, Model model) {
		Flower f=service.getFlowerById(id);
		model.addAttribute("flower", f);
		return "flowerEdit";
	}
	@RequestMapping("/deleteFlower/{id}")
	public String deleteFlower(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/availabeFlower";
	}
	
	
	
}


