package application;

import java.util.List;

import model.entities.Player;
import service.FirstPlayerService;
import service.SecondPlayerService;
import utils.GameLogic;

public class Alternative {
	
	
	public static void main(String[] args) {
		List<Player> firstTeam = (new FirstPlayerService()).findAll();
		List<Player> secondTeam = (new SecondPlayerService()).findAll();
		GameLogic gameLogic = new GameLogic(firstTeam, secondTeam);
		System.out.println("Calling organizeTeam:");
		List<Player> team1 = gameLogic.organizeStartTeam(firstTeam, true);
		List<Player> team2 = gameLogic.organizeStartTeam(secondTeam, false);
		
		System.out.println();
		gameLogic.playSet(team1, team2);
		
		
	}
}
