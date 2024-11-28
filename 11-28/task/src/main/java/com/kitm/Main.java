package com.kitm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ProductManager productManager = new ProductManager();
		Scanner scanner = new Scanner(System.in);

		showHelp();
		while (processMenuOption(Integer.parseInt(scanner.nextLine()), productManager, scanner))
		{
			System.out.println();
			showHelp();
		}

		scanner.close();
	}

	private static void showHelp() {
		System.out.println("1. Add category");
		System.out.println("2. Add product");
		System.out.println("3. Search products by name");
		System.out.println("4. Filter products by category");
		System.out.println("5. Filter products by price interval");
		System.out.println("6. Sort products by price");
		System.out.println("7. Show all products");
		System.out.println("8. Exit");
		System.out.println();
		System.out.print("Choose an option: ");
	}

	private static boolean processMenuOption(int option, ProductManager productManager,
			Scanner scanner) {
		switch (option) {
			case 1:
				addCategory(productManager, scanner);
				break;
			case 2:
				addProduct(productManager, scanner);
				break;
			case 3:
				searchProductsByName(productManager, scanner);
				break;
			case 4:
				filterProductsByCategory(productManager, scanner);
				break;
			case 5:
				filterProductsByPriceInterval(productManager, scanner);
				break;
			case 6:
				sortProductsByPrice(productManager, scanner);
				break;
			case 7:
				showAllProducts(productManager);
				break;
			case 8:
				return false;
			default:
				System.out.println("Invalid option");
				break;
		}
		return true;
	}

	private static void addCategory(ProductManager productManager, Scanner scanner) {
		System.out.print("Enter category name: ");
		String categoryName = scanner.nextLine();
		productManager.addCategory(new Category(categoryName));
		System.out.println("Category named '" + categoryName + "' added successfully");
	}

	private static void addProduct(ProductManager productManager, Scanner scanner) {
		System.out.print("Enter product name: ");
		String productName = scanner.nextLine();

		System.out.print("Enter product price: ");
		double productPrice = Double.parseDouble(scanner.nextLine());

		System.out.print("Enter category name: ");
		String categoryName = scanner.nextLine();

		Product product;
		switch (categoryName.toLowerCase()) {
			case "food":
				product = new Food(productName, productPrice);
				break;
			case "electronics":
				product = new Electronics(productName, productPrice);
				break;
			case "clothing":
				product = new Clothing(productName, productPrice);
				break;
			default:
				product = new Other(productName, productPrice);
				break;
		}

		productManager.addProductToCategory(product, categoryName);
		System.out.println("Product named '" + productName + "' added successfully to category '" + categoryName + "'");
	}

	private static void searchProductsByName(ProductManager productManager, Scanner scanner) {

		System.out.print("Enter product name: ");
		String productName = scanner.nextLine();

		ArrayList<Product> products = productManager.getProductsByName(productName);
		if (products.isEmpty()) {
			System.out.println("No products found with name '" + productName + "'");
		} else {
			System.out.println("Products found with name '" + productName + "':");
			System.out.println(ProductManager.productsToString(products));
		}
	}
	
	private static void filterProductsByCategory(ProductManager productManager, Scanner scanner) {

		System.out.print("Enter category name: ");
		String categoryName = scanner.nextLine();

		ArrayList<Product> products = productManager.getProductsByCategory(categoryName);
		if (products == null) {
			System.out.println("No products found in category '" + categoryName + "'");
		} else {
			System.out.println("Products found in category '" + categoryName + "':");
			System.out.println(ProductManager.productsToString(products));
		}
	}

	private static void filterProductsByPriceInterval(ProductManager productManager, Scanner scanner) {

		System.out.print("Enter minimum price: ");
		double minPrice = Double.parseDouble(scanner.nextLine());

		System.out.print("Enter maximum price: ");
		double maxPrice = Double.parseDouble(scanner.nextLine());

		ArrayList<Product> products = productManager.getProductsByPriceInterval(minPrice, maxPrice);
		if (products.isEmpty()) {
			System.out.println("No products found in price interval [" + minPrice + ", " + maxPrice + "]");
		} else {
			System.out.println("Products found in price interval [" + minPrice + ", " + maxPrice + "]:");
			System.out.println(ProductManager.productsToString(products));
		}
	}

	private static void sortProductsByPrice(ProductManager productManager, Scanner scanner) {
		System.out.print("Sort in descending order (true/false): ");
		boolean descending = Boolean.parseBoolean(scanner.nextLine());

		ArrayList<Product> products = productManager.getProducts();
		products = ProductManager.SortProductsByPrice(products, descending);

		System.out.println("Products sorted by price:");
		System.out.println(ProductManager.productsToString(products));
	}

	private static ArrayList<Product> showAllProducts(ProductManager productManager) {
		System.out.println("All products:");
		ArrayList<Product> products = productManager.getProducts();
		System.out.println(ProductManager.productsToString(products));
		return products;
	}
}