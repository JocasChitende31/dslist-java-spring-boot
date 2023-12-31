package com.atendestartup.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// Making one type having two attribute in one type of
@Embeddable
public class BelongingPK {

//	The notation responsible to deal with relational data table
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name="list_id")
	private GameList list;
	
	public BelongingPK() {
		
	}
	public BelongingPK(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public GameList getGameListe() {
		return list;
	}
	public void setGameList(GameList list) {
		this.list = list;
	}
	
	@Override 
	public int hashCode() {
		return Objects.hash(game, list);
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
}
