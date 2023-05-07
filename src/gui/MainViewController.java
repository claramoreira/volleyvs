package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
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
		Image logo = new Image("file:resources/images/praia.png");
		imageViewTeamLogo.setImage(logo);
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
