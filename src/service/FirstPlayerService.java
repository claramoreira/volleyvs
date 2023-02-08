package service;

import java.util.Arrays;
import java.util.List;

import model.entities.Condition;
import model.entities.Player;
import model.entities.Position;

public class FirstPlayerService implements PlayerService {

	public List<Player> findAll() {
		Player p1 = new Player(1L, "Gabi", 95, Condition.GOOD, Position.PONTEIRA);
		Player p2 = new Player(2L, "Natalia", 80, Condition.BAD, Position.PONTEIRA);
		Player p3 = new Player(3L, "Bright", 82, Condition.EXCELLENT, Position.LIBERO);
		Player p4 = new Player(3L, "Macris", 84, Condition.EXCELLENT, Position.LEVANTADORA);
		Player p5 = new Player(3L, "Mara", 81, Condition.AWFUL, Position.CENTRAL);
		Player p6 = new Player(3L, "Gattaz", 88, Condition.NEUTRAL, Position.CENTRAL);
		Player p7 = new Player(3L, "Egonu", 93, Condition.BAD, Position.OPOSTA);
		return Arrays.asList(p1, p2, p3);
	}
}
