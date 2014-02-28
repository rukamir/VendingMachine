package com.VendingMachine.Product;

import com.VendingMachine.Machine.ProductBase;

public class CandyBar extends ProductBase {
	public CandyBar() {
		name = "CandyBar";
	}
	
	@Override
	public void Sound() {
		super.Sound();
		System.out.println("Thud!");
	}
}
