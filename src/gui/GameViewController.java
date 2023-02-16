package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import java.util.function.Function;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

	private Integer pointsPerSet = 25;

	private List<String> setWinner = new ArrayList<>();

	private Integer score1 = 0;

	private Integer score2 = 0;

	private String serving;

	private List<Player> teamOne;

	private List<Player> teamTwo;

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

	private Timeline timeline;

	private String set = "first";

	private void setTimeline() {
		timeline = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {

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
				
				switch (set) {
				case "first": {
					labelFirstTeamFirstSet.setText(String.valueOf(score1));
					labelSecondTeamFirstSet.setText(String.valueOf(score2));
					break;
				}
				case "second": {
					labelFirstTeamSecondSet.setText(String.valueOf(score1));
					labelSecondTeamSecondSet.setText(String.valueOf(score2));
					break;
				}
				case "third": {
					labelFirstTeamThirdSet.setText(String.valueOf(score1));
					labelSecondTeamThirdSet.setText(String.valueOf(score2));
					break;
				}
				case "fourth": {
					labelFirstTeamFourthSet.setText(String.valueOf(score1));
					labelSecondTeamFourthSet.setText(String.valueOf(score2));
					break;
				}
				case "fifth": {
					labelFirstTeamFifthSet.setText(String.valueOf(score1));
					labelSecondTeamFifthSet.setText(String.valueOf(score2));
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + set);
				}

				
				if (!((score1 < pointsPerSet && score2 < pointsPerSet) || (Math.abs(score1 - score2) < 2))) {
					setWinner.add((score1 > score2) ? "first" : "second");
					
					score1 = 0;
					score2 = 0;
					
					switch (set) {
					case "first": {
						set = "second";
						break;
					}
					case "second": {
						set = "third";
						break;
					}
					case "third": {
						set = "fourth";
						break;
					}
					case "fourth": {
						set = "fifth";
						pointsPerSet = 15;
						break;
					}
					case "fifth": {
						set = "end";
						System.out.println("GameOver!");
						stop();
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + set);
					}
					
					
				}

			}

		}));

	}

	/*
	 * private Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),
	 * new EventHandler<ActionEvent>() { public void handle(ActionEvent actionEvent)
	 * { System.out.println("cycling"); String pointer =
	 * gameLogic.evaluateCurrentSquad(teamOne, teamTwo, serving); if (pointer ==
	 * "first") { score1 += 1; serving = "first"; teamTwo =
	 * gameLogic.rotateTeam(teamTwo); } else { score2 += 1; serving = "second";
	 * teamOne = gameLogic.rotateTeam(teamOne); }
	 * labelFirstTeamFirstSet.setText(String.valueOf(score1));
	 * labelSecondTeamFirstSet.setText(String.valueOf(score2));
	 * 
	 * if (score1 > 14 || score2 > 14) { stop(); } }
	 * 
	 * }));
	 */

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
		System.out.println("back to playgame");
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

	}

	public void stop() {
		timeline.stop();
	}

	public void playGame() throws InterruptedException {

		teamOne = firstTeamService.findAll();
		teamTwo = secondTeamService.findAll();

		Integer serverCount = 25;

		setTimeline();
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

	}

}
