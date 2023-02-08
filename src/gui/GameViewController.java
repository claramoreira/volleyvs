package gui;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.entities.Score;
import service.PlayerService;
import utils.GameLogic;

public class GameViewController implements Initializable {

	private PlayerService firstTeamService;

	private PlayerService secondTeamService;

	private GameLogic gameLogic;

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

		Map<String, Score> scores = gameLogic.evaluateMatch();

		labelFirstTeamFirstSet.setText(String.valueOf(scores.get("FirstSet").getFirstTeamScore()));
		labelSecondTeamFirstSet.setText(String.valueOf(scores.get("FirstSet").getSecondTeamScore()));

		labelFirstTeamSecondSet.setText(String.valueOf(scores.get("SecondSet").getFirstTeamScore()));
		labelSecondTeamSecondSet.setText(String.valueOf(scores.get("SecondSet").getSecondTeamScore()));

		labelFirstTeamThirdSet.setText(String.valueOf(scores.get("ThirdSet").getFirstTeamScore()));
		labelSecondTeamThirdSet.setText(String.valueOf(scores.get("ThirdSet").getSecondTeamScore()));
		
		labelWinningTeam.setText("Time vencedor: " + gameLogic.getWinningTeam());

	}

}
