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
		List<Player> team1 = gameLogic.organizeTeam(firstTeam, true);
		List<Player> team2 = gameLogic.organizeTeam(secondTeam, false);
		
		System.out.println("TEAM ONE: ");
		int index = 1;
		for (Player p : team1) {
			System.out.println("Position " + (index++) + ": " + p);
		}
		
		System.out.println("TEAM TWO: ");
		index = 1;
		for (Player p : team2) {
			System.out.println("Position " + (index++) + ": " + p);
		}
		
	}
}
