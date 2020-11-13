package com.example.service;

import java.util.List;

import com.example.DTO.AchievementsDTO;
import com.example.exception.DynamicBadRequestException;

public interface AchievementsService {
	
	public List<AchievementsDTO> getAllAchievements();

	public AchievementsDTO createAchievement(AchievementsDTO achievementsDTO) throws DynamicBadRequestException;

	public AchievementsDTO updateAchievements(AchievementsDTO achievementsDTO, String id) throws DynamicBadRequestException;

	public AchievementsDTO getOneById(String id) throws DynamicBadRequestException;

	public String deleteAchiements(String id) throws DynamicBadRequestException;

}
