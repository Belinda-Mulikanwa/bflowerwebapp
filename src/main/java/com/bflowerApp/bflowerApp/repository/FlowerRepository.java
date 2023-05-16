package com.bflowerApp.bflowerApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bflowerApp.bflowerApp.entity.Flower;

@Repository 
public interface FlowerRepository extends JpaRepository<Flower, Integer>{

}
