package com.kitm;

import java.util.ArrayList;

public class ProductManager {
	private ArrayList<Category> categories = new ArrayList<>();

	public void addCategory(Category category) {
		categories.add(category);
	}

	public void addProductToCategory(Product product, String categoryName) {
		for (Category category : categories) {
			if (category.getName().equals(categoryName)) {
				category.addProduct(product);
				break;
			}
		}
	}

	public ArrayList<Product> getProductsByName(String name) {
		ArrayList<Product> products = new ArrayList<>();
		for (Category category : categories) {
			for (Product product : category.getProducts()) {
				if (product.getName().equals(name)) {
					products.add(product);
				}
			}
		}
		return products;
	}

	public ArrayList<Product> getProductsByCategory(String categoryName) {
		for (Category category : categories) {
			if (category.getName().equals(categoryName)) {
				return category.getProducts();
			}
		}
		return null;
	}

	public ArrayList<Product> getProductsByPriceInterval(double minPrice, double maxPrice) {
		ArrayList<Product> products = new ArrayList<>();
		for (Category category : categories) {
			for (Product product : category.getProducts()) {
				if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
					products.add(product);
				}
			}
		}
		return products;
	}

	public static ArrayList<Product> SortProductsByPrice(ArrayList<Product> products, boolean ascending) {
		products.sort((p1, p2) -> {
			if (ascending) {
				return Double.compare(p1.getPrice(), p2.getPrice());
			} else {
				return Double.compare(p2.getPrice(), p1.getPrice());
			}
		});
		return products;
	}

	public ArrayList<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<>();
		for (Category category : categories) {
			products.addAll(category.getProducts());
		}
		return products;
	}

	public static String productsToString(ArrayList<Product> products) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("+%-20s+%-10s+\n", "", "").replace(' ', '-'));
		sb.append(String.format("|%-20s|%-10s|\n", "Name", "Price"));
		sb.append(String.format("+%-20s+%-10s+\n", "", "").replace(' ', '-'));

		for (Product product : products) {
			sb.append(product.displayInfo());
		}

		sb.append(String.format("+%-20s+%-10s+\n", "", "").replace(' ', '-'));
		return sb.toString();
	}
}
