package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.PlayerDao;
import model.entities.Player;

public class PlayerDaoJDBC implements PlayerDao{

	private Connection conn;

	public PlayerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Player s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Player s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> findByDepartment(Integer team) {
		// TODO Auto-generated method stub
		return null;
	}
}
