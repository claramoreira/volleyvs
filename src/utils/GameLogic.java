package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import model.entities.Player;
import model.entities.Score;
import model.entities.Position;

public class GameLogic {

	private List<Player> firstTeam;
	private List<Player> secondTeam;

	public GameLogic(List<Player> firstTeam, List<Player> secondTeam) {
		super();
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
	}

	public List<Player> getFirstTeam() {
		return firstTeam;
	}

	public void setFirstTeam(List<Player> firstTeam) {
		this.firstTeam = firstTeam;
	}

	public List<Player> getSecondTeam() {
		return secondTeam;
	}

	public void setSecondTeam(List<Player> secondTeam) {
		this.secondTeam = secondTeam;
	}

	public Map<String, Score> evaluateMatch() {
		Map<String, Score> scores = new HashMap<String, Score>();
		scores.put("FirstSet", new Score(25L, 15L));
		scores.put("SecondSet", new Score(25L, 21L));
		scores.put("ThirdSet", new Score(25L, 13L));
		return scores;
	}

	public List<Player> rotateTeam(List<Player> team) {
		Collections.rotate(team, 1);
		validateLiberoPosition(team);
		return team;
	}

	public List<Player> validateLiberoPosition(List<Player> team) {

		List<Integer> pos = Arrays.asList(1, 2, 3);
		int liberoPosition = team.indexOf(team.stream().filter(a -> Objects.equals(a.getPosition(), Position.LIBERO))
				.collect(Collectors.toList()).get(0));

		if (pos.contains(liberoPosition)) {
			System.out.println("Libero no ataque, não é possível!");
		}

		return team;
	}

	public List<Player> organizeStartTeam(List<Player> team, Boolean serving) {

		Player position2 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.PONTEIRA1))
				.collect(Collectors.toList()).get(0);
		Player position3 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.CENTRAL1))
				.collect(Collectors.toList()).get(0);
		Player position4 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.OPOSTA))
				.collect(Collectors.toList()).get(0);

		Player position1 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.LEVANTADORA))
				.collect(Collectors.toList()).get(0);
		Player position5 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.PONTEIRA2))
				.collect(Collectors.toList()).get(0);

		Player position6;
		if (serving == true) {
			position6 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.CENTRAL2))
					.collect(Collectors.toList()).get(0);
		} else {
			position6 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.LIBERO))
					.collect(Collectors.toList()).get(0);
		}

		List<Player> organized = Arrays.asList(position1, position2, position3, position4, position5, position6);

		return organized;
	}

	public String getWinningTeam() {
		return "Minas 2019";
	}

}
