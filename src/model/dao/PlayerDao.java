package model.dao;

import java.util.List;

import model.entities.Player;

public interface PlayerDao {

	void insert(Player s);

	void update(Player s);

	void deleteById(Integer id);

	Player findById(Integer id);

	List<Player> findAll();

	List<Player> findByTeam(Integer team);
}
