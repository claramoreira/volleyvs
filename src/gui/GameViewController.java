package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	 System.out.println("Game View initialized!");
		
	}
	

}
