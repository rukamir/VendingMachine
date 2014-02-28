package com.VendingMachine.Machine;


public interface IVendMachine {
	/**
	  * Adds available funds to the machine
	  * / float amount of money to add
	*/
	public void 		addFunds(float amt);
	
	/**
	  * Selects an item by location in machine
	  * / int id of desired item
	*/
	public ProductBase 	selectItem(int locationId);
	
	/**
	  * Add a product to machine
	  * / ProductBase item to be added
	  * / int number of the same item to be added
	  * / int location to add all these products
	  * return- amount of overstock products if any
	*/
	public int 			addProduct(ProductBase prod, int cnt, int locationId);
	
	/**
	  * Changes the price of a location slot
	  * / int location of price to be changed
	  * / float value of the new changed slot
	*/
	public void			setPrice(int locationId, float price);
	
	/**
	  * Ends the machine and returns any excess funding
	  * returns- returns excess funding to user
	*/
	public float		cancel();
	
	/**
	  * Prints to screen all front slots of the machine and prices
	*/
	public void			displaySelections();
	
	/**
	  * Prints to screen # of transactions and amount of money collected
	*/
	public void			displayStatistics();
}
