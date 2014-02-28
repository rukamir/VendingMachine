package com.VendingMachine.Prog;

import java.util.Scanner;

import com.VendingMachine.Machine.IVendMachine;
import com.VendingMachine.Machine.ProductBase;
import com.VendingMachine.Product.CandyBar;
import com.VendingMachine.Product.CandyMachine;
import com.VendingMachine.Product.Chips;

public class VendingProgram {

	// This is the main point of entry for the vending machine program
	public static void main(String[] args) {
		float leftOver = 0.0f;
		Scanner reader = new Scanner(System.in);
		String input;
		
		// Create myMachine
		IVendMachine myMachine = new CandyMachine();
		
		// Create two types of products to put into machine
		ProductBase prod = new Chips(), prod2 = new CandyBar();
		
		// Add some products and set some prices
		myMachine.addProduct(prod, 12, 4); // this one will over stock
		myMachine.setPrice(4, 0.75f);
		myMachine.addProduct(prod2, 2, 2);
		myMachine.addProduct(prod, 2, 2); // add a different product behind the first
		myMachine.setPrice(2, 0.85f);

		// infinite loop for interacting with machine
		while (true) {
			myMachine.displaySelections();
			System.out.println("Please make a selection...");
			System.out.println("Commands: 99- Exit. 98- Add money.");
			input = reader.nextLine();
			
			// Exit loop if input 99
			// Add funds if input 98
			if (Integer.parseInt(input) == 99) {
				System.out.println("Exiting the vending machine. Please recycle.");
				leftOver = myMachine.cancel();
				break;
			}
			else if (Integer.parseInt(input) == 98) {
				// Add more funds
				System.out.println("add more money to spend.");
				input = reader.nextLine();
				myMachine.addFunds(Float.parseFloat(input));
			} else {
				myMachine.selectItem(Integer.parseInt(input));
			}
		}
		
		// Return money
		System.out.println(leftOver + " returned. Please take your money.");
		
		// Show stats for this execution
		myMachine.displayStatistics();
		
		// Close reader
		reader.close();
	}

}
