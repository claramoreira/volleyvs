package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import model.entities.Player;
import model.entities.Score;
import model.entities.Position;

public class GameLogic {

	private List<Player> firstTeam;
	private List<Player> secondTeam;

	private Integer firstTeamScore;
	private Integer secondTeamScore;

	private static List<Integer> net = Arrays.asList(1, 2, 3);
	private static List<Integer> deffense = Arrays.asList(0, 4, 5);

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

		int liberoPosition = team.indexOf(team.stream().filter(a -> Objects.equals(a.getPosition(), Position.LIBERO))
				.collect(Collectors.toList()).get(0));

		// Libero is not in the team
		if (liberoPosition == -1) {
			return team;
		}

		if (net.contains(liberoPosition)) {
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

	public void evaluateCurrentSquad(List<Player> teamOne, List<Player> teamTwo) {
		List<Player> firstTeamNet = IntStream.range(0, teamOne.size()).filter(i -> net.contains(i))
				.mapToObj(teamOne::get).collect(Collectors.toList());
		List<Player> secondTeamNet = IntStream.range(0, teamTwo.size()).filter(i -> net.contains(i))
				.mapToObj(teamTwo::get).collect(Collectors.toList());

		List<Player> firstTeamDeffense = IntStream.range(0, teamOne.size()).filter(i -> deffense.contains(i))
				.mapToObj(teamOne::get).collect(Collectors.toList());
		List<Player> secondTeamDeffense = IntStream.range(0, teamTwo.size()).filter(i -> deffense.contains(i))
				.mapToObj(teamTwo::get).collect(Collectors.toList());

		Player playerServing = teamOne.get(0);

		Double firstTeamAttackAverage = firstTeamNet.stream()
				.mapToDouble(p -> p.getAttackPower() * p.getAvgAttackPointsPerMatch() / 10 * p.getCondition().value())
				.average().orElse(0);
		Double secondTeamAttackAverage = secondTeamNet.stream()
				.mapToDouble(p -> p.getAttackPower() * p.getAvgAttackPointsPerMatch() / 10 * p.getCondition().value())
				.average().orElse(0);

		Double firstTeamDeffenseAverage = firstTeamDeffense.stream()
				.mapToDouble(p -> p.getReceptionPower() * p.getAvgReceptionsPerMatch() / 10 * p.getCondition().value())
				.average().orElse(0);
		Double secondTeamDeffenseAverage = secondTeamDeffense.stream()
				.mapToDouble(p -> p.getReceptionPower() * p.getAvgReceptionsPerMatch() /10 * p.getCondition().value())
				.average().orElse(0);

		Double serverPower = playerServing.getServerPower() * playerServing.getAvgServerPointsPerMatch() / 10
				* playerServing.getCondition().value();

		System.out.println(firstTeamNet);
		System.out.println(secondTeamNet);
		System.out.println(firstTeamDeffense);
		System.out.println(secondTeamDeffense);
		System.out.println("firstTeamAttackAverage: " + String.valueOf(firstTeamAttackAverage));
		System.out.println("secondTeamAttackAverage: " + String.valueOf(secondTeamAttackAverage));
		System.out.println("firstTeamDeffenseAverage: " + String.valueOf(firstTeamDeffenseAverage));
		System.out.println("secondTeamDeffenseAverage: " + String.valueOf(secondTeamDeffenseAverage));
		System.out.println("serverPower: " + String.valueOf(serverPower));

	}

	public String getWinningTeam() {
		return "Minas 2019";
	}

}
