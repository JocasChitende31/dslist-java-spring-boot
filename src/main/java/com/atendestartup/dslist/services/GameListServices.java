package com.atendestartup.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atendestartup.dslist.dto.GameListDTO;
import com.atendestartup.dslist.entities.GameList;
import com.atendestartup.dslist.repositories.GameListRepository;

@Service
public class GameListServices {

	@Autowired
	private GameListRepository gameListRepository;
	
	public List<GameListDTO> findAll(){
		
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x-> new GameListDTO(x)).toList();
		return dto;
	}
}
