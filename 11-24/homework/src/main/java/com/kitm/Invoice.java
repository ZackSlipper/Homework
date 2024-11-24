package com.kitm;

public class Invoice {
	private int id;
	private Customer customer;
	private double amount;

	public Invoice(int id, Customer customer, double amount) {
		this.id = id;
		this.customer = customer;
		this.amount = amount;
	}

	private int getId() {
		return id;
	}

	private Customer getCustomer() {
		return customer;
	}

	private double getAmount() {
		return amount;
	}

	private void setAmount(double amount) {
		this.amount = amount;
	}

	private int getCustomerId() {
		return customer.getId();
	}

	private String getCustomerName() {
		return customer.getName();
	}

	private int getCustomerDiscount() {
		return customer.getDiscount();
	}

	private double getAmountAfterDiscount() {
		return amount - (amount * customer.getDiscount() / 100);
	}

	@Override
	public String toString() {
		return "Invoice[id=" + id + ",customer=" + customer + ",amount=" + amount + "]";
	}
}
