package com.VendingMachine.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.VendingMachine.Machine.IVendMachine;
import com.VendingMachine.Machine.ProductBase;

public class CandyMachine implements IVendMachine {
	// Total cost of combined purchases
	private float 	totalFunds = 0.0f;
	
	// Records number of transactions
	private int		totalTransactions = 0;
	
	// Funds available for current purchase
	private float 	allowance = 0.0f;
	
	// number of locations
	private int		locationCount = 6;
	
	// location item limit
	private int		itemLimit = 10;
	
	// Products with locationId as key
	private Map<Integer, LinkedList<ProductBase>>	products = new HashMap<Integer, LinkedList<ProductBase>>();
	
	// Prices with index as locationId
	private List<Float>								prices = new ArrayList<Float>();
	
	/**
	  * Default constructor
	*/
	public CandyMachine() {
		System.out.println("Candy Machine created!");
		// populate open slots
		for (int i=0; i<locationCount; i++) {
			products.put(i, new LinkedList<ProductBase>());
			prices.add(0.0f);
		}
	}

	/**
	  * Adds available funds to the machine
	  * / float amount of money to add
	*/
	@Override
	public void addFunds(float amt) {
		// Validate a positive value
		if (amt > 0) {
			allowance += amt;
			System.out.println(amt + " added. Available funds: " + allowance);
		} else {
			// Not valid value
			System.out.println("No funds added. Available funds: " + allowance);
		}
	}

	/**
	  * Selects an item by location in machine
	  * / int id of desired item
	*/
	@Override
	public ProductBase selectItem(int locationId) {
		ProductBase selectedItem = null;
		
		// If location is valid proceed with stocking
		if (products.get(locationId) != null) {
			
			// Look to see if first item is valid
			if (products.get(locationId).peekFirst() != null) {
				
				// Check if sufficient funds
				if (allowance >= prices.get(locationId)) {
					
					// From first
					selectedItem = products.get(locationId).pop();
					
					// add to totalFunds and increment totalTransactions
					totalFunds += prices.get(locationId);
					totalTransactions++;
					
					// Subtract allowance by location price
					allowance -= prices.get(locationId);
					
					System.out.println(allowance + " funds still available.");
					selectedItem.Sound();
					System.out.println("Item dispensed.");
					return selectedItem;
				} else {
					// Not enough money
					System.out.println("Insufficient funds. " + allowance + " funds still available.");
					return null;
				}
			} else {
				// Inventory at this location is empty
				System.out.println("No items left. Please make another selection.");
				return null;
			}
		} else {
			// Not a valid location
			System.out.println("Invalid selection.");
			return null;
		}
	}

	/**
	  * Add a product to machine
	  * / ProductBase item to be added
	  * / int number of the same item to be added
	  * / int location to add all these products
	  * return- amount of overstock products if any
	*/
	@Override
	public	int addProduct(ProductBase prod, int cnt, int locationId) {
		// Number of successful items places
		int stockCnt = 0;
		
		// If location is valid proceed with stocking
		if (products.get(locationId) != null) {
			
			// If location is not full proceed with stocking
			if (products.get(locationId).size() <= this.itemLimit) {
				
				// Start stocking products till cnt is achieved
				for (int i=0; i<cnt; i++) {
					products.get(locationId).add(prod);
					stockCnt++;
					
					// Check if this location has reached max stock
					if (products.get(locationId).size() == this.itemLimit) {
						System.out.println("Item at location " + locationId + " added " + stockCnt + " more units. " + (cnt - stockCnt) + " left over.");
						return cnt - stockCnt;						
					}
				}
				
				// Print statistics for this action
				System.out.println("Item at location " + locationId + " added " + stockCnt + " more units. " + (cnt - stockCnt) + " left over.");
				return cnt - stockCnt;
			} else {
				// Cannot add to full location
				System.out.println("None added. Inventory full for this location.");
				return cnt;
			}
		} else {
			// Not a valid location to stock
			System.out.println("Invalid item location.");
			return cnt;
		}
	}

	/**
	  * Ends the machine and returns any excess funding
	  * returns- returns excess funding to user
	*/
	@Override
	public float cancel() {
		// Return money and reset allowance
		float returnMoney = allowance;
		allowance = 0.0f;
		
		return returnMoney;
	}

	/**
	  * Changes the price of a location slot
	  * / int location of price to be changed
	  * / float value of the new changed slot
	*/
	@Override
	public void setPrice(int locationId, float price) {
		// If location is valid proceed with stocking
		if (products.get(locationId) != null) {
			prices.set(locationId, price);
			System.out.println("Item location " + locationId + " was set to " + price + ".");
		} else {
			System.out.println("Invalid Location.");
		}
	}

	/**
	  * Prints to screen all front slots of the machine and prices
	*/
	@Override
	public void displaySelections() {
		ProductBase prod;
		for (int i=0; i<locationCount; i++){
			
			if (products.get(i).size() != 0){
				prod = products.get(i).get(0);
				System.out.println(i + ": " + prod.getProductName() + " at " + prices.get(i) + ".");
			} else {
				System.out.println(i + ": empty at " + prices.get(i) + ".");
			}
		}
	}

	/**
	  * Prints to screen # of transactions and amount of money collected
	*/
	@Override
	public void displayStatistics() {
		System.out.println("Total transactions: " + totalTransactions);
		System.out.println("Bank: " + totalFunds);
	}

}
