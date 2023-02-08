package utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.entities.Player;
import model.entities.Score;

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
	
	public String getWinningTeam() {
		return "Minas 2019";
	}

}
