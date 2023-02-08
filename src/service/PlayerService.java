package service;

import java.util.List;

import model.entities.Player;

public interface PlayerService {
	
	public String findTeamName();

	public List<Player> findAll();

}
