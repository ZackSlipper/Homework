package com.kitm;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<Product> products = new ArrayList<>();

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public String showProducts() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("+%-20s+%-10s+\n", "", "").replace(' ', '-'));
		sb.append(String.format("|%-20s|%-10s|\n", getName(), "Price"));
		sb.append(String.format("+%-20s+%-10s+\n", "", "").replace(' ', '-'));

		for (Product product : products) {
			sb.append(product.displayInfo());
		}

		sb.append(String.format("+%-20s+%-10s+\n", "", "").replace(' ', '-'));
		return sb.toString();
	}
}
