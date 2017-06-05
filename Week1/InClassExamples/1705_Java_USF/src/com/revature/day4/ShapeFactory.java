package com.revature.day4;

public class ShapeFactory {
	public Shape getShape(String request){
		
		if(request.toLowerCase().equals("square")){
			return new Square();
		}
		if(request.toLowerCase().equals("circle")){
			return new Circle();
		}
		return null;
	}
}
