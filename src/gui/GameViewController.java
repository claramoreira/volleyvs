package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import model.entities.Player;
import service.PlayerService;
import utils.GameLogic;

public class GameViewController implements Initializable {

	private PlayerService firstTeamService;

	private PlayerService secondTeamService;

	private GameLogic gameLogic;
	
	private Integer firstScore;
	
	private Integer secondScore;

	@FXML
	private Label labelFirstTeam;

	@FXML
	private Label labelSecondTeam;

	@FXML
	private Label labelFirstTeamFirstSet;

	@FXML
	private Label labelFirstTeamSecondSet;

	@FXML
	private Label labelFirstTeamThirdSet;

	@FXML
	private Label labelFirstTeamFourthSet;

	@FXML
	private Label labelFirstTeamFifthSet;

	@FXML
	private Label labelSecondTeamFirstSet;

	@FXML
	private Label labelSecondTeamSecondSet;

	@FXML
	private Label labelSecondTeamThirdSet;

	@FXML
	private Label labelSecondTeamFourthSet;

	@FXML
	private Label labelSecondTeamFifthSet;
	
	@FXML
	private Button buttonStartMatch;

	@FXML
	private Label labelWinningTeam;

	public void setFirstTeamService(PlayerService firstTeamService) {
		this.firstTeamService = firstTeamService;
	}

	public void setSecondTeamService(PlayerService secondTeamService) {
		this.secondTeamService = secondTeamService;
	}

	public void setGameLogic(GameLogic gameLogic) {
		this.gameLogic = gameLogic;
	}
	
	public void onButtonClickAction() throws InterruptedException {
		playGame();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		System.out.println("Game View initialized!");
		initializeNodes();
	}

	private void initializeNodes() {

	}

	public void updateGameView() {
		if (firstTeamService == null || secondTeamService == null) {
			throw new IllegalStateException("Service was null");
		}
		

		labelFirstTeam.setText(firstTeamService.findTeamName());
		labelSecondTeam.setText(secondTeamService.findTeamName());

		// Map<String, Score> scores = gameLogic.evaluateMatch();
		
		/*
		labelFirstTeamFirstSet.setText(String.valueOf(scores.get("FirstSet").getFirstTeamScore()));
		labelSecondTeamFirstSet.setText(String.valueOf(scores.get("FirstSet").getSecondTeamScore()));

		labelFirstTeamSecondSet.setText(String.valueOf(scores.get("SecondSet").getFirstTeamScore()));
		labelSecondTeamSecondSet.setText(String.valueOf(scores.get("SecondSet").getSecondTeamScore()));

		labelFirstTeamThirdSet.setText(String.valueOf(scores.get("ThirdSet").getFirstTeamScore()));
		labelSecondTeamThirdSet.setText(String.valueOf(scores.get("ThirdSet").getSecondTeamScore()));
		
		labelWinningTeam.setText("Time vencedor: " + gameLogic.getWinningTeam());
		*/

	}
	
	public void playGame() throws InterruptedException {
		
		List<Player> teamOne = firstTeamService.findAll();
		List<Player> teamTwo = secondTeamService.findAll();
		
		teamOne = gameLogic.organizeStartTeam(teamOne, true);
		teamTwo = gameLogic.organizeStartTeam(teamTwo, false);
		
		// Map<String, Score> scores = gameLogic.evaluateMatch();
		
		Boolean tieBreak = false;
		Integer serverCount = 25;
		if (tieBreak == true) {
			serverCount = 15;
		}
		Integer score1 = 0;
		Integer score2 = 0;
		String serving = "first";
		while ((score1 < serverCount && score2 < serverCount) || (Math.abs(score1 - score2) < 2)) {
			String pointer = gameLogic.evaluateCurrentSquad(teamOne, teamTwo, serving);
			if (pointer == "first") {
				score1 += 1;
				serving = "first";
				teamTwo = gameLogic.rotateTeam(teamTwo);
			} else {
				score2 += 1;
				serving = "second";
				teamOne = gameLogic.rotateTeam(teamOne);
			}
			System.out.println("SCORE: ");
			System.out.println("TeamOne: " + score1 + " -- -- TeamTwo: " + score2);
			
			labelFirstTeamFirstSet.setText(String.valueOf(score1));
			labelSecondTeamFirstSet.setText(String.valueOf(score2));
		}
		
	}

}
