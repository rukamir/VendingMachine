***************************************
	VENDING MACHINE BY JIMMY ROLAND
***************************************

This program demonstrates the use of the following notable
techniques:
- Interfaces
- Inheritance
- Polymorphism
- Abstract classes
- Multiple Collection types
- Object oriented programming/design
- and more...

I wanted to capture the simplistic nature of a vending machine. Each row
has a price independent of the actual product and each row can contain
different products within itself.

Order of operation for the program:
1. Create machine.
2. Set prices for each location.
3. Add products to machine. (accepts a ProductBase Abstract 
	class for developer designed products)
4. Display selections
5. Add funds.
6. Select item location.
7. Dispense item.
8. Exit machine and return money. Display stats.

****************************************
	CANDYMACHINE DOCUMENTATION
****************************************
/**
  * Default constructor
*/
public CandyMachine();

/**
  * Adds available funds to the machine
  * / float amount of money to add
*/
public void addFunds(float amt);

/**
  * Selects an item by location in machine
  * / int id of desired item
*/
public ProductBase selectItem(int locationId);

/**
  * Add a product to machine
  * / ProductBase item to be added
  * / int number of the same item to be added
  * / int location to add all these products
  * return- amount of overstock products if any
*/
public	int addProduct(ProductBase prod, int cnt, int locationId);

/**
  * Ends the machine and returns any excess funding
  * returns- returns excess funding to user
*/
public float cancel();

/**
  * Changes the price of a location slot
  * / int location of price to be changed
  * / float value of the new changed slot
*/
public void setPrice(int locationId, float price);

/**
  * Prints to screen all front slots of the machine and prices
*/
public float displaySelections();

/**
  * Prints to screen # of transactions and amount of money collected
*/
public void displayStatistics();