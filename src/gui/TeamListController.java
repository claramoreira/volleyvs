package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Player;
import service.PlayerService;

public class TeamListController implements Initializable {

	private PlayerService service;
	
	@FXML
	private TableView<Player> tableViewPlayer;

	@FXML
	private TableColumn<Player, Long> tableColumnId;

	@FXML
	private TableColumn<Player, String> tableColumnName;

	@FXML
	private TableColumn<Player, Integer> tableColumnOverall;

	@FXML
	private TableColumn<Player, String> tableColumnCondition;

	private ObservableList<Player> obsList;

	
	public void setPlayerService(PlayerService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tableColumnOverall.setCellValueFactory(new PropertyValueFactory<>("overall"));
		tableColumnCondition.setCellValueFactory(new PropertyValueFactory<>("condition"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewPlayer.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Player> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);

		tableViewPlayer.setItems(obsList);
	}

}
