package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import model.entities.Player;
import model.entities.Position;

public class GameLogic {

	private static final List<Integer> net = Arrays.asList(1, 2, 3);
	private static final List<Integer> deffense = Arrays.asList(0, 4, 5);
	
	public final static List<Player> rotateTeam(List<Player> team) {
		Collections.rotate(team, 1);
		return team;
	}

	public final static List<Player> validateLiberoPosition(List<Player> team) {

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

	public final static List<Player> organizeStartTeam(List<Player> team, Boolean serving) {

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

	public final static String evaluateCurrentSquad(List<Player> teamOne, List<Player> teamTwo, String serving) {
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

		Double servingScore = serverPower * 10 - secondTeamDeffenseAverage;
		if (servingScore > 0.0) {
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

}
