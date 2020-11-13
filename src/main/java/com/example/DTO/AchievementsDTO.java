package com.example.DTO;

import java.util.Date;

import com.example.entity.Achievements;

public class AchievementsDTO {
	private String id;
	
	private String displayName;
	
	private String description;
	
	private String icon;
	
	private Integer displayOrder;
	
	private Date created;
	
	private Date updated;
	
	private String gameName;
	
	public AchievementsDTO() {
		
	}
	public AchievementsDTO(Achievements ach) {
		this.id = ach.getId();
		this.displayName = ach.getDisplayName();
		this.description = ach.getDescription();
		this.icon = ach.getIcon();
		this.displayOrder = ach.getDisplayOrder();
		this.created = ach.getCreated();
		this.updated = ach.getUpdated();
		this.gameName = ach.getGames().getDisplayName();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
}
