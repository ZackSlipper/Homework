package com.kitm;

public class Electronics extends Product {

	public Electronics(String name, double price) {
		super(name, price);
	}

	@Override
	public String displayInfo() {
		return String.format("|%-20s|%-10s|\n", getName(), getPrice());
	}
}
