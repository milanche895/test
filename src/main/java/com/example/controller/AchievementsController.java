package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.AchievementsDTO;
import com.example.exception.DynamicBadRequestException;
import com.example.serviceImplement.AchievementsImplement;

@RestController
@RequestMapping("/demo/ach")
public class AchievementsController {
	
	@Autowired
	AchievementsImplement achImplements;
	
	@GetMapping("/all")
	public ResponseEntity<List<AchievementsDTO>> getAllAchievements(){
		return new ResponseEntity<List<AchievementsDTO>>(achImplements.getAllAchievements(),HttpStatus.OK);
	}
	@GetMapping("/ach/{id}")
	public ResponseEntity<AchievementsDTO> getOneById(@PathVariable String id) throws DynamicBadRequestException{
		return new ResponseEntity<AchievementsDTO>(achImplements.getOneById(id),HttpStatus.OK);
	}
	@PostMapping("/created")
	public ResponseEntity<AchievementsDTO> createdAchievements(@RequestBody AchievementsDTO achievementsDTO) throws DynamicBadRequestException{
		
		return new ResponseEntity<AchievementsDTO>(achImplements.createAchievement(achievementsDTO),HttpStatus.OK);
	}
	@PutMapping("/updated/{id}")
	public ResponseEntity<AchievementsDTO> updateAchievements(@RequestBody AchievementsDTO achievementsDTO, @PathVariable(name = "id") String id) throws DynamicBadRequestException{
		
		return new ResponseEntity<AchievementsDTO>(achImplements.updateAchievements(achievementsDTO, id),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAchievement(@PathVariable(name = "id") String id) throws DynamicBadRequestException{
		return new ResponseEntity<String>(achImplements.deleteAchiements(id), HttpStatus.OK);
	}
	
}
