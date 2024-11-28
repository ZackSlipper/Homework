package com.kitm;

public class Clothing extends Product {

	public Clothing(String name, double price) {
		super(name, price);
	}

	@Override
	public String displayInfo() {
		return String.format("|%-20s|%-10s|\n", getName(), getPrice());
	}

}
