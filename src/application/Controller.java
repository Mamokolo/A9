package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Controller {
	private Scene scene;
	private VBox buttonList;
	private Button pencilBtn, lineBtn, rectBtn, circleBtn, eraserBtn, cleanBtn;
	private ChoiceBox<String> lineWidthChoice;
	private ColorPicker colorPicker;
	private MenuBar menuBar;
	private Canvas canvas, canvas2;
	
	private MainCanvas mainCanvas;
	
	public Controller(Scene scene) {
		this.scene = scene;
		pencilBtn = (Button)scene.lookup("#pencilBtn");
		lineBtn = (Button)scene.lookup("#lineBtn");
		rectBtn = (Button)scene.lookup("#rectBtn");
		circleBtn = (Button)scene.lookup("#circleBtn");
		eraserBtn = (Button)scene.lookup("#eraserBtn");
		cleanBtn = (Button)scene.lookup("#cleanBtn");
		lineWidthChoice = (ChoiceBox)scene.lookup("#lineWidthChoice");
		colorPicker = (ColorPicker)scene.lookup("#colorPicker");
		menuBar = (MenuBar)scene.lookup("#menuBar");
		buttonList = (VBox)scene.lookup("#buttonList");
		canvas = (Canvas)scene.lookup("#mainCanvas");
		canvas2 = (Canvas)scene.lookup("#canvas2");
		
		
		
		colorPicker.setValue(Color.BLUE);
		
		mainCanvas = new MainCanvas(canvas,canvas2);
		mainCanvas.setColor(colorPicker.getValue());
		
		setLineWidthChoice();
		setButtonGraphic();
		setButtonEvent();
	}
	
	public void setButtonGraphic() {
		pencilBtn.setGraphic(new ImageView(new Image("pencil.png", 32, 32, false, false)));
		lineBtn.setGraphic(new ImageView(new Image("line.png", 32, 32, false, false)));
		rectBtn.setGraphic(new ImageView(new Image("rectangleFill.png", 32, 32, false, false)));
		eraserBtn.setGraphic(new ImageView(new Image("eraser.png", 32, 32, false, false)));
		circleBtn.setGraphic(new ImageView(new Image("circle.png", 32, 32, false, false)));
	}
	
	public void setLineWidthChoice() {
		ArrayList<String> width = new ArrayList<String>();
		for(int i=4; i<30; i+=2) {
			width.add(String.valueOf(i));
		}
		lineWidthChoice.getItems().addAll(width);
		lineWidthChoice.getSelectionModel().select("10");
		
		mainCanvas.setLineWidth(Double.parseDouble((String)lineWidthChoice.getValue()));
	}
	
	public void setButtonEvent() {
		pencilBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				mainCanvas.setMode("pencil");
				
			}
		});
		lineBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
			}
		});
		
		rectBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
			}
		});
		
		circleBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
			}
		});
		
		eraserBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
			}
		});
		
		cleanBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				
				
			}
		});
		
		colorPicker.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				mainCanvas.setColor(colorPicker.getValue());
				
			}
		});
		
		lineWidthChoice.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				mainCanvas.setLineWidth(Double.parseDouble((String)lineWidthChoice.getValue()));
				
			}
		});
		
	}
}
