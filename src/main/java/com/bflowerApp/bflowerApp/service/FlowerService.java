package com.bflowerApp.bflowerApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bflowerApp.bflowerApp.entity.Flower;
import com.bflowerApp.bflowerApp.repository.FlowerRepository;

@Service 
public class FlowerService {
	
	@Autowired 
	private FlowerRepository fRepo;
	public void save(Flower f) {
		fRepo.save(f);
	}
	
	public List<Flower> getAllFlower(){
		return fRepo.findAll();
	}
	
	public Flower getFlowerById(int id) {
		return fRepo.findById(id).get();
	}
	public void deleteById(int id) {
		fRepo.deleteById(id);
	}
}
