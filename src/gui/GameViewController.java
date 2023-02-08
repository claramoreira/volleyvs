package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Player;
import service.FirstPlayerService;
import service.PlayerService;

public class GameViewController implements Initializable {

	private PlayerService firstTeamService;

	private PlayerService secondTeamService;

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

}
