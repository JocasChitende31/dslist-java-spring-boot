package com.atendestartup.dslist.dto;

import com.atendestartup.dslist.entities.Game;

// DTO=> Data Transfer Object, Class that display a minor quantities of data from Game class but not from database. 
public class GameMinDTO {

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	public GameMinDTO() {

	}

	public GameMinDTO(Game entity) {

		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();

	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

}
