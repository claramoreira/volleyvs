package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import model.entities.Player;
import model.entities.Position;
import model.entities.Score;

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

	public Integer getFirstTeamScore() {
		return firstTeamScore;
	}

	public void setFirstTeamScore(Integer firstTeamScore) {
		this.firstTeamScore = firstTeamScore;
	}

	public Integer getSecondTeamScore() {
		return secondTeamScore;
	}

	public void setSecondTeamScore(Integer secondTeamScore) {
		this.secondTeamScore = secondTeamScore;
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
		return team;
	}

	public List<Player> validateLiberoPosition(List<Player> team) {

		int liberoPosition = team.indexOf(team.stream().filter(a -> Objects.equals(a.getPosition(), Position.LIBERO))
				.collect(Collectors.toList()).get(0));

		if (liberoPosition == -1) {
			return team;
		}

		if (net.contains(liberoPosition)) {
			System.out.println("Libero no ataque, não é possível!");
		}

		return team;
	}

	public List<Player> organizeStartTeam(List<Player> team, Boolean serving) {

		Player position2 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.PONTEIRA))
				.collect(Collectors.toList()).get(0);
		Player position3 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.CENTRAL))
				.collect(Collectors.toList()).get(0);
		Player position4 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.OPOSTA))
				.collect(Collectors.toList()).get(0);

		Player position1 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.LEVANTADORA))
				.collect(Collectors.toList()).get(0);
		Player position5 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.PONTEIRA))
				.collect(Collectors.toList()).get(1);

		Player position6;
		if (serving == true) {
			position6 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.CENTRAL))
					.collect(Collectors.toList()).get(1);
		} else {
			position6 = team.stream().filter(a -> Objects.equals(a.getPosition(), Position.LIBERO))
					.collect(Collectors.toList()).get(0);
		}

		List<Player> organized = Arrays.asList(position1, position2, position3, position4, position5, position6);

		return organized;
	}

	public void playGame(List<Player> teamOne, List<Player> teamTwo) {

		List<String> sets = new ArrayList<>();

		System.out.println("FIRST SET:");
		Map<String, Integer> firstSet = playSet(teamOne, teamTwo, false);
		String firstSetWinner = firstSet.entrySet().stream().max((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : -1)
				.get().getKey();
		sets.add(firstSetWinner);

		System.out.println("SECOND SET:");
		Map<String, Integer> secondSet = playSet(teamOne, teamTwo, false);
		String secondSetWinner = secondSet.entrySet().stream().max((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : -1)
				.get().getKey();
		sets.add(secondSetWinner);

		System.out.println("THIRD SET:");
		Map<String, Integer> thirdSet = playSet(teamOne, teamTwo, false);
		String thirdSetWinner = thirdSet.entrySet().stream().max((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : -1)
				.get().getKey();
		sets.add(thirdSetWinner);

		if (Collections.frequency(sets, "firstTeam") == 3 || Collections.frequency(sets, "secondTeam") == 3) {
			System.out.println("Game over!");
		} else {
			System.out.println("FOURTH SET:");
			Map<String, Integer> fourthSet = playSet(teamOne, teamTwo, false);
			String fourthSetWinner = fourthSet.entrySet().stream()
					.max((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : -1).get().getKey();
			sets.add(fourthSetWinner);
			if (Collections.frequency(sets, "firstTeam") == 3 || Collections.frequency(sets, "secondTeam") == 3) {
				System.out.println("Game over!");
			} else {
				System.out.println("FIFTH SET:");
				Map<String, Integer> fifthSet = playSet(teamOne, teamTwo, true);
				String fifthSetWinner = fifthSet.entrySet().stream()
						.max((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : -1).get().getKey();
				sets.add(fifthSetWinner);
				System.out.println("Game over!");
			}
		}

		System.out.println();

		System.out.println(sets);
		System.out.println("--- RESULTADO FINAL ---");
		System.out.println("First team: " + Collections.frequency(sets, "firstTeam"));
		System.out.println("Second team: " + Collections.frequency(sets, "secondTeam"));

	}

	private Map<String, Integer> playSet(List<Player> teamOne, List<Player> teamTwo, Boolean tieBreak) {
		Integer serverCount = 25;
		if (tieBreak == true) {
			serverCount = 15;
		}
		Integer score1 = 0;
		Integer score2 = 0;
		String serving = "first";
		while ((score1 < serverCount && score2 < serverCount) || (Math.abs(score1 - score2) < 2)) {
			String pointer = evaluateCurrentSquad(teamOne, teamTwo, serving);
			if (pointer == "first") {
				score1 += 1;
				serving = "first";
				teamTwo = rotateTeam(teamTwo);
			} else {
				score2 += 1;
				serving = "second";
				teamOne = rotateTeam(teamOne);
			}
			// System.out.println("SCORE: ");
			// System.out.println("TeamOne: " + score1 + " -- -- TeamTwo: " + score2);
		}
		System.out.println("SET OVER: ");
		System.out.println("TeamOne: " + score1);
		System.out.println("TeamTwo: " + score2);

		Map result = new HashMap<>();
		result.put("firstTeam", score1);
		result.put("secondTeam", score2);
		return result;
	}

	public String evaluateCurrentSquad(List<Player> teamOne, List<Player> teamTwo, String serving) {
		List<Player> firstTeamNet = IntStream.range(0, teamOne.size()).filter(i -> net.contains(i))
				.mapToObj(teamOne::get).collect(Collectors.toList());
		List<Player> secondTeamNet = IntStream.range(0, teamTwo.size()).filter(i -> net.contains(i))
				.mapToObj(teamTwo::get).collect(Collectors.toList());

		List<Player> firstTeamDeffense = IntStream.range(0, teamOne.size()).filter(i -> deffense.contains(i))
				.mapToObj(teamOne::get).collect(Collectors.toList());
		List<Player> secondTeamDeffense = IntStream.range(0, teamTwo.size()).filter(i -> deffense.contains(i))
				.mapToObj(teamTwo::get).collect(Collectors.toList());

		String attacking; // true == second team;
		Player playerServing;
		if (serving == "first") {
			playerServing = teamOne.get(0);
			attacking = "second";
		} else {
			playerServing = teamTwo.get(0);
			attacking = "first";
		}

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
				.mapToDouble(p -> p.getReceptionPower() * p.getAvgReceptionsPerMatch() / 10 * p.getCondition().value())
				.average().orElse(0);

		Double serverPower = playerServing.getServerPower() * playerServing.getAvgServerPointsPerMatch() / 10
				* playerServing.getCondition().value();

		Double firstTeamStatusAvg = firstTeam.stream().mapToDouble(p -> p.getCondition().value()).average().orElse(0);

		Double secondTeamStatusAvg = secondTeam.stream().mapToDouble(p -> p.getCondition().value()).average().orElse(0);

		/*
		 * System.out.println(); System.out.println(firstTeamNet);
		 * System.out.println(secondTeamNet); System.out.println(firstTeamDeffense);
		 * System.out.println(secondTeamDeffense); System.out.println();
		 * System.out.println("firstTeamAttackAverage: " +
		 * String.valueOf(firstTeamAttackAverage));
		 * System.out.println("secondTeamAttackAverage: " +
		 * String.valueOf(secondTeamAttackAverage));
		 * System.out.println("firstTeamDeffenseAverage: " +
		 * String.valueOf(firstTeamDeffenseAverage));
		 * System.out.println("secondTeamDeffenseAverage: " +
		 * String.valueOf(secondTeamDeffenseAverage));
		 * System.out.println("serverPower: " + String.valueOf(serverPower));
		 * System.out.println("firstTeamStatusAvg: " +
		 * String.valueOf(firstTeamStatusAvg));
		 * System.out.println("secondTeamStatusAvg: " +
		 * String.valueOf(secondTeamStatusAvg));
		 */

		// System.out.println();
		// System.out.println("------- SERVING EVALUATION ---------");
		Double servingScore = serverPower * 10 - secondTeamDeffenseAverage;
		// System.out.println("serving: " + String.valueOf(serving));
		// System.out.println("Serving: " + serving);
		// System.out.println(playerServing.getName());
		if (servingScore > 0.0) {
			// System.out.println("TEAM " + serving + " serving - ACE FROM " +
			// playerServing.getName());
			return serving;
		}

		Double pointThreshold = 1.0;
		Integer rally = 1;
		Double attackScore = 0.0;

		Random randomTeamOne = new Random();
		Random randomTeamTwo = new Random();

		Double randomTeamOneValue = 0.0;
		Double randomTeamTwoValue = 0.0;

		// System.out.println();

		while (pointThreshold < 100.00) {
			switch (attacking) {
			case "first":
				// System.out.println("first");
				randomTeamOneValue = 1 + 8 * randomTeamOne.nextDouble();
				randomTeamTwoValue = 1 + 8 * randomTeamTwo.nextDouble();
				attackScore = (firstTeamAttackAverage / (randomTeamOne.nextDouble() * 5.0) - secondTeamDeffenseAverage)
						+ (randomTeamOneValue - randomTeamTwoValue);
				break;
			case "second":
				// System.out.println("second");
				randomTeamOneValue = 1 + 8 * randomTeamOne.nextDouble();
				randomTeamTwoValue = 1 + 8 * randomTeamTwo.nextDouble();
				attackScore = (secondTeamAttackAverage / (randomTeamTwo.nextDouble() * 5.0) - firstTeamDeffenseAverage)
						+ (randomTeamTwoValue - randomTeamOneValue);
				break;
			}
			pointThreshold = attackScore;
			// System.out.println(attacking + " : " + attackScore);
			rally += 1;
			// System.out.println("Rally: " + rally);
			if (attacking == "second") {
				attacking = "first";
			} else {
				attacking = "second";
			}

		}

		if (attacking == "second") {
			attacking = "first";
		} else {
			attacking = "second";
		}

		return attacking;

	}

	public String getWinningTeam() {
		return "Minas 2019";
	}

}
