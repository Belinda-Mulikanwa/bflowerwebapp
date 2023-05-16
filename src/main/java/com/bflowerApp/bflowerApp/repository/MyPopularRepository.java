package com.bflowerApp.bflowerApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bflowerApp.bflowerApp.entity.Popularflower;

@Repository 
public interface MyPopularRepository extends JpaRepository<Popularflower, Integer>{

}
