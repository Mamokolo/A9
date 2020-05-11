package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paintbrush {
	
	private GraphicsContext gc;
	
	public Paintbrush(Canvas canvas) {
		gc = canvas.getGraphicsContext2D();
	}
	
	public void setColor(Color color) {
		gc.setFill(color);
		gc.setStroke(color);
	}
	public void setLineWidth(double w) {
		gc.setLineWidth(w);
	}
	public double getLineWidth() {
		return gc.getLineWidth();
	}
	public void drawLine(double x1,double y1,double x2,double y2) {
		gc.strokeLine(x1, y1, x2, y2);
	}
	public void eraser(double x,double y,double width,double height) {
		gc.clearRect(x, y, width, height);
	}
	

}
