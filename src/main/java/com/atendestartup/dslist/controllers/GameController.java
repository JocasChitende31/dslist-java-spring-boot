package com.atendestartup.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendestartup.dslist.dto.GameDTO;
import com.atendestartup.dslist.dto.GameMinDTO;
import com.atendestartup.dslist.services.GamesServices;

// Class responsible to deal with Game requests and responses in our application.
@RestController
@RequestMapping(value = "/games")
public class GameController {

//	Inject a GameServices component to the GameController component
	@Autowired
	private GamesServices gameService;

	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		GameDTO result = gameService.findById(id);
		return result;
	}

//	making a get request mapping to a GameServices where there is a logicBusisses of get data
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}

}
