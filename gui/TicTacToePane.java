package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import tictactoeFX.Coordinate;
import tictactoeFX.Game;
import tictactoeFX.Game.Turn;

public class TicTacToePane extends GridPane {
	Label[][] labels;
	Game g;
	
	public void startGame() {
		setUpLabels();
		g = new Game();
		
		
	}
	
	public Game getGame() {
		return g;
	}
	
	private void setUpLabels() {
		labels = new Label[3][3];

		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++) {
				Label l = new Label();
				setUpLabel(l, row, col);
				labels[row][col] = l;
				add(l, col, row);
			}
	}
	
	private void updateLabel() {
		for (int i = 0; i < labels.length ; ++i) {
			for (int j = 0; j < labels[0].length; ++j) {
				 labels[i][j].setText(Character.toString(g.getboard()[i][j])); 
				 labels[i][j].getStyleClass().remove("victory");
			}
		}
	}

	private void setUpLabel(final Label l, final int row, final int col) {
		l.setPrefHeight(75);
		l.setPrefWidth(75);

		if (row < 2) {
			if (col > 0)
				l.getStyleClass().add("leftAndBottomBorder");
			else
				l.getStyleClass().add("bottomBorder");
		} else if (col > 0)
			l.getStyleClass().add("leftBorder");
		l.setOnMouseClicked(new EventHandler<InputEvent>() {
			@Override
			public void handle(InputEvent arg0) {
				updateLabel();
				if (!g.gameOver() && g.getTurn() == Turn.X) {
					if(g.makePlayerMove(row, col)) l.setText("X");
				}
				if (!g.gameOver()&& g.getTurn() == Turn.O) {
					Coordinate c = g.makeAutoMove();
					labels[c.getRow()][c.getCol()].setText("O");
				}
				if (g.gameOver()) {
					if (g.getVictoryExists()) {
						Coordinate[] victoryCoords = g.getVictoryCoords();
						for (Coordinate c : victoryCoords)
							labels[c.getRow()][c.getCol()].getStyleClass().add(
									"victory");
					}
				}
			}
		});
		
		
		HBox hb = new HBox(100);
        hb.setPrefSize(99999, 70);
        hb.setStyle("-fx-background-color: #7fffd4;");
        hb.setAlignment(Pos.TOP_CENTER);
        hb.getStyleClass().add("hb"); 
        add(hb,0,3,11,1);
		
		Button undo = new Button("<");
		undo.setStyle("-fx-font-size: 20; ");
		
		Button redo = new Button(">");
		redo.setStyle("-fx-font-size: 20; ");
		
		undo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				g.undo();
				updateLabel();
			}	
		});
		
		redo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
					g.redo();
					updateLabel();
					
					if (g.gameOver()) {
						if (g.getVictoryExists()) {
							Coordinate[] victoryCoords = g.getVictoryCoords();
							for (Coordinate c : victoryCoords)
								labels[c.getRow()][c.getCol()].getStyleClass().add(
										"victory");
						}
					}
					
			}	
		});
		
		hb.getChildren().addAll(undo,redo);
		
	}
}
