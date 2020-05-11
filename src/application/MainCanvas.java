package application;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MainCanvas {
	private Canvas canvas,canvas2;
	private Paintbrush paintbrush,paintbrush2;
	private String mode;
	private double startX,endX,startY,endY;
	
	
	public MainCanvas(Canvas canvas,Canvas canvas2) {
		this.canvas = canvas;
		this.canvas2 = canvas2;
		paintbrush = new Paintbrush(canvas);
		paintbrush2 = new Paintbrush(canvas2);
		
		mode="default";
		creatCanvasBorder();
		setCanvasEvent();
		
	}
	public void setColor(Color color) {
		paintbrush.setColor(color);
	}
	public void setLineWidth(double width) {
		paintbrush.setLineWidth(width);
		paintbrush2.setLineWidth(width);
		
	}
	private void creatCanvasBorder() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	

	private void setCanvasEvent() {
		
		canvas2.setOnMousePressed(new EventHandler<MouseEvent>(){
			
			public void handle(MouseEvent event) {
				startX = event.getX();
				startY = event.getY();
			}
		});
		canvas2.setOnMouseDragged(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent event) {
				switch(mode) {
					case "pancil":
						paintbrush.drawLine(event.getX(), event.getY(), event.getX(), event.getY());
						break;
					case "eraser":
						break;
						
				}
			}
		});
		canvas2.setOnMouseReleased(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent event) {
				endX = event.getX();
				endY = event.getY();
			}
		});
		
	}
	public void setMode(String mode) {
		this.mode = mode;
	}


	
	
	

}
