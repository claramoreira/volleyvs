package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.PlayerDao;
import model.entities.Player;

public class PlayerService {
	
	private PlayerDao dao = DaoFactory.createPlayerDao();

	public List<Player> findByTeam(Integer id) {
		return dao.findByTeam(id);
	}
	
}
