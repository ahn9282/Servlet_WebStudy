package edu.sejong.ex;

public class Circle{
	private double r;
	
	public Circle(double r) {
		this.r = r;
		
	}
	public double getCircleArea() {
		return Math.PI *r*r;
	}
}
