package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Player;
import model.services.PlayerService; 

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
		List<Player> list = service.findByTeam(1);
		obsList = FXCollections.observableArrayList(list);

		tableViewPlayer.setItems(obsList);
	}

	public void onTableColumnIdAction(MouseEvent event) {
		Player selectedPlayer = tableViewPlayer.getSelectionModel().getSelectedItem();
		Stage parentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		createDialogForm(selectedPlayer, "/gui/PlayerView.fxml", parentStage);
	}
		
	
	private void createDialogForm(Player obj, String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			PlayerViewController controller = loader.getController();
			controller.loadPlayerInfo(obj);
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Player Details");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
