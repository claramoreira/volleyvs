package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

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
import model.services.PlayerService;
import utils.GameLogic;

public class GameViewController implements Initializable {

	private PlayerService playerService;

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
	private Label labelFirstTeamFirstPosition;

	@FXML
	private Label labelFirstTeamSecondPosition;

	@FXML
	private Label labelFirstTeamThirdPosition;

	@FXML
	private Label labelFirstTeamFourthPosition;

	@FXML
	private Label labelFirstTeamFifthPosition;

	@FXML
	private Label labelFirstTeamSixthPosition;

	@FXML
	private Label labelSecondTeamFirstPosition;

	@FXML
	private Label labelSecondTeamSecondPosition;

	@FXML
	private Label labelSecondTeamThirdPosition;

	@FXML
	private Label labelSecondTeamFourthPosition;

	@FXML
	private Label labelSecondTeamFifthPosition;

	@FXML
	private Label labelSecondTeamSixthPosition;

	@FXML
	private Button buttonStartMatch;

	@FXML
	private Label labelWinningTeam;

	private Timeline timeline;

	private String set = "first";

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	private void setFirstTeamLabels(List<Player> team) {
		labelFirstTeamFirstPosition.setText(team.get(0).getName());
		labelFirstTeamSecondPosition.setText(team.get(1).getName());
		labelFirstTeamThirdPosition.setText(team.get(2).getName());
		labelFirstTeamFourthPosition.setText(team.get(3).getName());
		labelFirstTeamFifthPosition.setText(team.get(4).getName());
		labelFirstTeamSixthPosition.setText(team.get(5).getName());
	}

	private void setSecondTeamLabels(List<Player> team) {
		labelSecondTeamFirstPosition.setText(team.get(0).getName());
		labelSecondTeamSecondPosition.setText(team.get(1).getName());
		labelSecondTeamThirdPosition.setText(team.get(2).getName());
		labelSecondTeamFourthPosition.setText(team.get(3).getName());
		labelSecondTeamFifthPosition.setText(team.get(4).getName());
		labelSecondTeamSixthPosition.setText(team.get(5).getName());
	}

	private void setTimeline() {
		timeline = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {

				String pointer = gameLogic.evaluateCurrentSquad(teamOne, teamTwo, serving);
				if (pointer == "first") {
					score1 += 1;
					serving = "first";
					teamTwo = gameLogic.rotateTeam(teamTwo);
					setSecondTeamLabels(teamTwo);
				} else {
					score2 += 1;
					serving = "second";
					teamOne = gameLogic.rotateTeam(teamOne);
					setFirstTeamLabels(teamOne);
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

					if (Collections.frequency(setWinner, "first") == 3
							|| Collections.frequency(setWinner, "second") == 3) {
						set = "end";
					}

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
						break;
					}
					case "end": {
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
		labelFirstTeam.setText("Minas");
		labelSecondTeam.setText("Praia");

	}

	public void stop() {
		timeline.stop();
	}

	public void playGame() throws InterruptedException {

		teamOne = playerService.findByTeam(1);
		teamTwo = playerService.findByTeam(2);

		System.out.println("team ONE");
		System.out.println(teamOne);
		System.out.println(teamOne.get(0).getAttackHeight());
		
		setTimeline();
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

	}

}
