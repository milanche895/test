package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.GamesDTO;
import com.example.serviceImplement.GamesImplement;

@RestController
@RequestMapping("demo/game")
public class GamesController {

	@Autowired
	GamesImplement gamesImplement;
	
	@GetMapping("/all")
	public ResponseEntity<List<GamesDTO>> getAllGames(){
		return new ResponseEntity<List<GamesDTO>>(gamesImplement.getAllGames(),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<GamesDTO> createGame(@RequestBody GamesDTO gamesDTO){
		
		return new ResponseEntity<GamesDTO>(gamesImplement.createGame(gamesDTO),HttpStatus.OK);
	}
}
