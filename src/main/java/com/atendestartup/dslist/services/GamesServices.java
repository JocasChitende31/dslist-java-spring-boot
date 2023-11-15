package com.atendestartup.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atendestartup.dslist.dto.GameMinDTO;
import com.atendestartup.dslist.entities.Game;
import com.atendestartup.dslist.repositories.GameRepository;

// This GameServices is class that deal with or 
//handle with all operations that happened in our application,
//all business logic this it is responsible for.

// Register the component in order to make sure that our frames will understood.@Component/Service
@Service
public class GamesServices {

// Inject a GameRepository component to GameService.
	@Autowired
	private GameRepository gameRepository;

	public List<GameMinDTO> findAll() {

		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x-> new GameMinDTO(x)).toList();
		return dto;
	}
}
