package com.example.serviceImplement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.AchievementsDTO;
import com.example.entity.Achievements;
import com.example.entity.Games;
import com.example.exception.DynamicBadRequestException;
import com.example.repository.AchievementsRespository;
import com.example.repository.GamesRespository;
import com.example.service.AchievementsService;

@Service
public class AchievementsImplement implements AchievementsService{
	
	@Autowired
	public AchievementsRespository achRepository;
	
	@Autowired
	public GamesRespository gameRepository;
	
	@Override
	public List<AchievementsDTO> getAllAchievements(){
		
		List<Achievements> achList = achRepository.findAll();
		System.out.println(achList);
		List<AchievementsDTO> achDTOList = new ArrayList<AchievementsDTO>();
		
		for (Achievements ach : achList) {
			AchievementsDTO achDTO = new AchievementsDTO(ach);
			
			achDTOList.add(achDTO);
		}
		return achDTOList;
	}
	@Override
	public AchievementsDTO getOneById(String id) throws DynamicBadRequestException {
		
		Achievements ach = achRepository.findOneById(id);
		
		if (Objects.nonNull(ach)) {
		
		AchievementsDTO achievementsDTO = new AchievementsDTO(ach);
		
		return achievementsDTO;
		} else {
			throw new DynamicBadRequestException("Achievements does not exist");
		}
	}
	
	@Override
	public AchievementsDTO createAchievement(AchievementsDTO achievementsDTO) throws DynamicBadRequestException {
		
		Achievements achFind = achRepository.findFirstByOrderByCreatedDesc();
		
		Games games = gameRepository.findOneByDisplayName(achievementsDTO.getGameName());
		
		if (Objects.isNull(games)) {
			throw new DynamicBadRequestException("The game you entered does not exist");
		}
		
		Achievements ach = new Achievements();
		
		if (Objects.nonNull(achievementsDTO.getDisplayName())){
			ach.setDisplayName(achievementsDTO.getDisplayName());
		} else {
			throw new DynamicBadRequestException("Please insert display name");
		}
		if (Objects.nonNull(achievementsDTO.getDescription())) {
			ach.setDescription(achievementsDTO.getDescription());
		} else {
			throw new DynamicBadRequestException("Please insert Description");
		}
		achievementsDTO.setDisplayOrder(achFind.getDisplayOrder()+1);
		ach.setDisplayOrder(achievementsDTO.getDisplayOrder());
		System.out.println(achFind);
		ach.setIcon(achievementsDTO.getIcon());
		ach.setGames(games);
		Date currentDate = new Date();
		achievementsDTO.setCreated(currentDate);
		ach.setCreated(achievementsDTO.getCreated());
		achievementsDTO.setUpdated(currentDate);
		ach.setUpdated(achievementsDTO.getUpdated());
		
		achRepository.save(ach);
		
		return achievementsDTO;
	}
	@Override
	public AchievementsDTO updateAchievements(AchievementsDTO achievementsDTO, String id) throws DynamicBadRequestException {
		
		Achievements ach = achRepository.findOneById(id);
		
		if (Objects.nonNull(ach)) {
			ach.setId(id);
			ach.setDisplayName(achievementsDTO.getDisplayName());
			ach.setDescription(achievementsDTO.getDescription());
			ach.setIcon(achievementsDTO.getIcon());
			Date currentDate = new Date();
			achievementsDTO.setUpdated(currentDate);
			ach.setUpdated(achievementsDTO.getUpdated());
			
			achRepository.save(ach);
			
			return achievementsDTO;
		} else {
			throw new DynamicBadRequestException("Achievements does not exist");
		}
	}
	@Override
	public String deleteAchiements(String id) throws DynamicBadRequestException {
		Achievements ach = achRepository.findOneById(id);
		
		if (Objects.nonNull(ach)) {		
			achRepository.delete(ach);
			
			return "Achievements is delete!";
		} else {
			throw new DynamicBadRequestException("Achievements does not exist");
		}
	}

}
