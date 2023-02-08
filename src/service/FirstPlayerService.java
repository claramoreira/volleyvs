package service;

import java.util.Arrays;
import java.util.List;

import model.entities.Condition;
import model.entities.Player;
import model.entities.Position;

public class FirstPlayerService implements PlayerService {

	public String findTeamName() {
		return "Minas 2019";
	}

	public List<Player> findAll() {
		Player p1 = new Player(1L, "Gabi", 95, Condition.GOOD, Position.PONTEIRA, 1.80, 3.05, 2.89, 1.80, 51.92, 13.1,
				10.9, 0.8, 17.4, 1.52, 14.32);
		Player p2 = new Player(2L, "Natalia", 80, Condition.BAD, Position.PONTEIRA, 1.86, 3.11, 2.95, 3.2, 48.02, 14.9,
				3.40, 1.1, 14.11, 2.3, 9.0);
		Player p3 = new Player(3L, "Brait", 82, Condition.EXCELLENT, Position.LIBERO, 1.70, 2.71, 2.56, 0.0, 0.02, 0.0,
				30.00, 0.0, 0.01, 0.0, 40.0);
		Player p4 = new Player(4L, "Macris", 84, Condition.EXCELLENT, Position.LEVANTADORA, 1.78, 2.92, 2.75, 1.11,
				34.62, 14.04, 6.4, 0.13, 0.60, 0.53, 7.0);
		Player p5 = new Player(5L, "Mara", 81, Condition.AWFUL, Position.CENTRAL, 1.90, 3.10, 2.97, 7.0, 41.20, 14.81,
				2.0, 0.2, 5.0, 2.01, 1.2);
		Player p6 = new Player(6L, "Gattaz", 88, Condition.NEUTRAL, Position.CENTRAL, 1.93, 3.15, 2.99, 4.58, 59.15,
				16.79, 10.0, 0.5, 1.0, 1.83, 5.0);
		Player p7 = new Player(7L, "Egonu", 93, Condition.BAD, Position.OPOSTA, 1.93, 3.47, 3.30, 11.50, 49.07, 25.00,
				10.00, 1.18, 16.73, 1.27, 2.5);
		return Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
	}

}
