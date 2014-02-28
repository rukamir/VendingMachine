package com.VendingMachine.Machine;

public abstract class ProductBase {
	protected String name = "Generic Product";
	
	// Getter for the product name
	public String getProductName() {
		return name;
	}
	
	// Displays that an item as been dropped
	public void Sound() {
		System.out.println("Item released.");
	}
}
