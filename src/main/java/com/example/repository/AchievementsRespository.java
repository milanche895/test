package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Achievements;

@Repository
public interface AchievementsRespository extends JpaRepository<Achievements, String>{
	
	public Achievements findOneById(String id);
	
	public Achievements findFirstByOrderByCreatedDesc();

}

