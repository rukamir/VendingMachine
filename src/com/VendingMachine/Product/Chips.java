package com.VendingMachine.Product;

import com.VendingMachine.Machine.ProductBase;

public class Chips extends ProductBase {
	public Chips() {
		name = "Chips";
	}
	
	@Override
	public void Sound() {
		super.Sound();
		System.out.println("Crinkle!");
	}
}
