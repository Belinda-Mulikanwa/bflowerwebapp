package com.bflowerApp.bflowerApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bflowerApp.bflowerApp.entity.Popularflower;
import com.bflowerApp.bflowerApp.repository.MyPopularRepository;

@Service 
public class MyPopularListService {

	@Autowired
	private MyPopularRepository mypopular;
	
	public void savedMyPopular(Popularflower popular) {
		mypopular.save(popular);
	}
	
	public List<Popularflower> getAllMyPopular(){
		return mypopular.findAll();
	}
	
	public void deleteById(int id) {
		mypopular.deleteById(id);
	}
}
