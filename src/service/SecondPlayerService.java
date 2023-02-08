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
		Player p1 = new Player(8L, "Daroit", 80, Condition.GOOD, Position.PONTEIRA);
		Player p2 = new Player(9L, "Bruna Honorio", 77, Condition.BAD, Position.PONTEIRA);
		Player p3 = new Player(10L, "Suellen", 78, Condition.EXCELLENT, Position.LIBERO);
		Player p4 = new Player(11L, "Claudinha", 83, Condition.EXCELLENT, Position.LEVANTADORA);
		Player p5 = new Player(12L, "Carolana", 90, Condition.AWFUL, Position.CENTRAL);
		Player p6 = new Player(13L, "Thaisa", 89, Condition.NEUTRAL, Position.CENTRAL);
		Player p7 = new Player(14L, "Kisy", 81, Condition.BAD, Position.OPOSTA);
		return Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
	}
}
