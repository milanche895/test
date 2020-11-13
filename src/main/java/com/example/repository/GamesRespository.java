package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Games;

@Repository
public interface GamesRespository extends JpaRepository<Games, String> {
	
	public Games findOneByDisplayName(String displayName);

}
