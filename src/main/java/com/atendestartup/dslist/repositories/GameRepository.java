package com.atendestartup.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendestartup.dslist.entities.Game;

// interface responsável por efectuar queries com o banco de dados;
public interface GameRepository extends JpaRepository<Game, Long> {

	
}
