package com.example.service;

import java.util.List;

import com.example.DTO.GamesDTO;

public interface GamesService {

	public List<GamesDTO> getAllGames();

	public GamesDTO createGame(GamesDTO gamesDTO);

}