package com.kitm;

public class Food extends Product {

	public Food(String name, double price) {
		super(name, price);
	}

	@Override
	public String displayInfo() {
		return String.format("|%-20s|%-10s|\n", getName(), getPrice());
	}
}
