package com.kitm;

public class Other extends Product {

	public Other(String name, double price) {
		super(name, price);
	}

	@Override
	public String displayInfo() {
		return String.format("|%-20s|%-10s|\n", getName(), getPrice());
	}

}
