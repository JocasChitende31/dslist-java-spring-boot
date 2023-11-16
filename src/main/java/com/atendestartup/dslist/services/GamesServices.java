package com.atendestartup.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atendestartup.dslist.dto.GameDTO;
import com.atendestartup.dslist.dto.GameMinDTO;
import com.atendestartup.dslist.entities.Game;
import com.atendestartup.dslist.projections.GameMinProjection;
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

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {

		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchById(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}

}
