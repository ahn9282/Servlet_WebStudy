package edu.sejong.ex;

public class Rectangle{
	private double width, height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
		
	}
	public double getRectangleArea() {
		return width * height;
	}
}