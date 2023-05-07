package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Player;
import model.services.PlayerService;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemGame;

	@FXML
	private MenuItem menuItemTeam;

	@FXML
	private MenuItem menuItemAbout;

	@FXML
	private Button buttonStartNextMatch;

	@FXML
	private ImageView imageViewTeamLogo;

	@FXML
	private Label labelFans;

	@FXML
	private  Label labelCash;
	
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

	@FXML
	private void onMenuItemGameAction() {
		loadView("/gui/GameView.fxml", (GameViewController controller) -> {
			controller.setPlayerService(new PlayerService());
			controller.updateGameView();
		});
	}

	@FXML
	public void onMenuItemTeamAction() {
		loadView("/gui/TeamList.fxml", (TeamListController controller) -> {
			controller.setPlayerService(new PlayerService());
			controller.updateTableView();
		});
	}

	@FXML
	private void onButtonStartNextMatchAction() {
		loadView("/gui/GameView.fxml", (GameViewController controller) -> {
			controller.setPlayerService(new PlayerService());
			controller.updateGameView();
		});
	}

	@FXML
	private void onMenuItemAboutAction() {
		System.out.println("onMenuItemAboutAction");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// Set team's logo
		Image logo = new Image("file:resources/images/praia.png");
		imageViewTeamLogo.setImage(logo);

		// Set team's fans and cash
		Long fans = 5000L;
		labelFans.setText("Torcedores: " + fans);
		Double cash = 150000.0;
		labelCash.setText("Verba: R$" + String.format("%.2f", cash));

		System.out.println("Loading MainView");
	}

	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVbox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();

			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVbox.getChildren());

			T controller = loader.getController();
			initializingAction.accept(controller);

		} catch (IOException e) {
			System.out.println("ERROR!");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
