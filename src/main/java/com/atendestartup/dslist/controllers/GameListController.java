package com.atendestartup.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendestartup.dslist.dto.GameListDTO;
import com.atendestartup.dslist.dto.GameMinDTO;
import com.atendestartup.dslist.dto.ReplacementDTO;
import com.atendestartup.dslist.services.GameListServices;
import com.atendestartup.dslist.services.GamesServices;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListServices gameListServices;
	
	@Autowired
	private GamesServices gameService;

	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListServices.findAll();
		return result;
	}

	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {

		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		
		gameListServices.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}

}
