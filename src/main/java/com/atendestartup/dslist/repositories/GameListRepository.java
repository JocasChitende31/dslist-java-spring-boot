package com.atendestartup.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendestartup.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
