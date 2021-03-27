package application;
	
import gui.TicTacToePane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tictactoeFX.Game;




public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TicTacToePane root = new TicTacToePane();
			
			Scene scene = new Scene(root,200,290);
			primaryStage.setTitle("TicTacToe");
			primaryStage.setScene(scene);
			primaryStage.show();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
	        
			
			root.startGame();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
