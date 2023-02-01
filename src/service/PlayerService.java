package service;

import java.util.Arrays;
import java.util.List;

import model.entities.Player;

public class PlayerService {

	public List<Player> findAll() {
		Player p1 = new Player(1L, "Gabi", 99, "Good");
		Player p2 = new Player(2L, "Natalia", 90, "Bad");
		Player p3 = new Player(3L, "Bright", 95, "Excellent");

		return Arrays.asList(p1, p2, p3);
	}
}
