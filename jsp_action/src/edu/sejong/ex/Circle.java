package edu.sejong.ex;

public class Circle {
	String in;
	double radius;
	double area;

	public Circle() {

	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setArea(double radius) {
		this.area = (radius * radius) * Math.PI;
	}

	public double getArea() {
		return area;
	}
}
