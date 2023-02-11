package com.techelevator;

public class VendingMachineCLI {

	public void run() {
		// entry point for the vending machine
	}

	public static void main(String[] args) {
//		VendingMachineCLI cli = new VendingMachineCLI();
//		cli.run();

		UserInterface UI = new UserInterface();
		Inventory machineInventory = new Inventory();
		UI.printWelcome();
		UI.printMenu();
		UI.getMenuSelection();
		UI.loadMoney();
		UI.pickItem();
	}
}
