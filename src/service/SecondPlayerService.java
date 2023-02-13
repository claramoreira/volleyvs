package service;

import java.util.Arrays;
import java.util.List;

import model.entities.Condition;
import model.entities.Player;
import model.entities.Position;

public class SecondPlayerService implements PlayerService {

	public String findTeamName() {
		return "Praia Minas Mix";
	}

	public List<Player> findAll() {
		Player p1 = new Player(8L, "Daroit", 80, Condition.GOOD, Position.PONTEIRA1, 1.84, 2.90, 2.80, 0.99, 42.82, 8.11,
				10.1, 0.75, 15.32, 1.01, 4.97);
		Player p2 = new Player(9L, "Bruna Honorio", 77, Condition.BAD, Position.PONTEIRA2, 1.81, 3.10, 2.92, 4.20, 39.93,
				9.1, 3.9, 3.8, 10.84, 1.12, 6.23);
		Player p3 = new Player(10L, "Suellen", 78, Condition.EXCELLENT, Position.LIBERO, 1.66, 2.62, 2.38, 1.80, 0.0,
				0.01, 10.0, 0.0, 0.02, 0.0, 24.0);
		Player p4 = new Player(11L, "Claudinha", 83, Condition.EXCELLENT, Position.LEVANTADORA, 1.81, 2.90, 2.66, 1.80,
				10.92, 4.91, 8.44, 1.33, 1.4, 1.21, 13.32);
		Player p5 = new Player(12L, "Carolana", 90, Condition.AWFUL, Position.CENTRAL1, 1.83, 3.16, 3.09, 3.22, 34.92,
				25.1, 6.9, 3.5, 4.7, 7.88, 2.21);
		Player p6 = new Player(13L, "Thaisa", 89, Condition.NEUTRAL, Position.CENTRAL2, 1.96, 3.20, 3.15, 4.51, 48.31,
				20.74, 1.15, 1.95, 17.4, 4.95, 1.82);
		Player p7 = new Player(14L, "Kisy", 81, Condition.BAD, Position.OPOSTA, 1.91, 3.03, 2.90, 2.41, 41.32, 11.1,
				3.9, 2.3, 10.15, 0.92, 2.15);
		return Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
	}

}
