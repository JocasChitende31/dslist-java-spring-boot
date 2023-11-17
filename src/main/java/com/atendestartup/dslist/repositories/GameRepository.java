package com.atendestartup.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atendestartup.dslist.entities.Game;
import com.atendestartup.dslist.projections.GameMinProjection;

// interface responsável por efectuar queries com o banco de dados;
public interface GameRepository extends JpaRepository<Game, Long> {

//	This allow us to personalized queries according that we want, because of 
//	SQL and not JPQL language we're using, we must specify nativeQuery by true in order to have success 
	@Query(nativeQuery = true, value = """
			SELECT
			tb_game.id,
			tb_game.title,
			tb_game.game_year AS gameYear,
			tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription,
			tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging
			ON
			tb_game.id = tb_belonging.game_id
			WHERE
			tb_belonging.list_id = :listId
			ORDER BY
			tb_belonging.position
			""")
//	To have a return of data we must create a interface called GameProjection or whatever the name of our entities.
	List<GameMinProjection> searchById(Long listId);

}
