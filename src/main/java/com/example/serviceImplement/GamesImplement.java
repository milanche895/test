package com.example.serviceImplement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.GamesDTO;
import com.example.entity.Games;
import com.example.repository.GamesRespository;
import com.example.service.GamesService;

@Service
public class GamesImplement implements GamesService {
	
	@Autowired
	public GamesRespository gamesRepository;
	
	@Autowired
	EntityManager em;
	
	@Override
	public List<GamesDTO> getAllGames(){
		
		List<Games> gameList = gamesRepository.findAll();
		
		List<GamesDTO> gamesDTOList = new ArrayList<GamesDTO>();
		
		for (Games game : gameList) {
			
			GamesDTO gamesDTO = new GamesDTO(game);
			
			gamesDTOList.add(gamesDTO);
		}
		return gamesDTOList;
	}
	@Override
	public GamesDTO createGame(GamesDTO gamesDTO) {
		
		Games games = new Games();
		
		games.setDisplayName(gamesDTO.getDisplayName());
		
		gamesRepository.save(games);
		
		return gamesDTO;
	}

}
