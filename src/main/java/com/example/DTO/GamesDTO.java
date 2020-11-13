package com.example.DTO;

import com.example.entity.Games;

public class GamesDTO {
	
	private String id;
	
	private String displayName;
	
	public GamesDTO() {
		
	}
	
	public GamesDTO(Games games) {
		
		this.id = games.getId();
		this.displayName = games.getDisplayName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}
