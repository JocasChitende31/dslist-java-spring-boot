package com.atendestartup.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendestartup.dslist.dto.GameListDTO;
import com.atendestartup.dslist.services.GameListServices;

@RestController
@RequestMapping(value = "/game-list")
public class GameListController {

	@Autowired
	private GameListServices gameListServices;

	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListServices.findAll();
		return result;
	}

}
