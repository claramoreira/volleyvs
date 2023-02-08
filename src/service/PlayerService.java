package service;

import java.util.Arrays;
import java.util.List;

import model.entities.Player;
import model.entities.Position;

public class PlayerService {

	public List<Player> findAll() {
		Player p1 = new Player(1L, "Gabi", 99, "Good", Position.PONTEIRA);
		Player p2 = new Player(2L, "Natalia", 90, "Bad", Position.PONTEIRA);
		Player p3 = new Player(3L, "Bright", 95, "Excellent", Position.LIBERO);
		Player p4 = new Player(3L, "Macris", 95, "Good", Position.LEVANTADORA);
		Player p5 = new Player(3L, "Mara", 95, "Bad", Position.CENTRAL);
		Player p6 = new Player(3L, "Gattaz", 95, "Excellent", Position.CENTRAL);
		Player p7 = new Player(3L, "Egonu", 95, "Good", Position.OPOSTA);
		return Arrays.asList(p1, p2, p3);
	}
}
