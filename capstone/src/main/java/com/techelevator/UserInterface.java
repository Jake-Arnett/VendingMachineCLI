package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private Scanner userInput = new Scanner(System.in);
    Inventory machineInventory = new Inventory();
    BigDecimal zero = new BigDecimal("0");
    Money cash = new Money(zero);

    public UserInterface() {
        machineInventory.loadInventory();

    }


    public void loadInventory() {

    }

    public void printWelcome() {
        System.out.println("===Welcome to The Vendo-matic 800===");
    }

    public void printMenu() {
        System.out.println("(1) Display Vending Machine Items\n(2) Purchase\n(3) Exit");
    }

    public void printInventory() {

        for (Map.Entry<String, Item> item : machineInventory.getInventoryMap().entrySet()) {
            System.out.println(item.getValue().toString());
        }
    }

    public void getMenuSelection() {
        while (true) {
            final String userIn = userInput.nextLine();
            if (userIn.equals("1") || userIn.equals("2") || userIn.equals("3")) {
                final int menuSelect = Integer.parseInt(userIn);
                if (menuSelect == 1) {
                    System.out.println("\n");
                    printInventory();
                    System.out.println("\n");
                    printMenu();
                } else if (menuSelect == 2) {
                    getPurchaseSelection();
                } else {
                    System.out.println("GOODBYE");
                    System.exit(69420);
                }

            } else {
                System.out.println("\nPlease input proper selection e.g. (1)(2)(3)");
                printMenu();
            }
        }
    }


    public void getPurchaseSelection() {
        while (true) {
            System.out.printf("\nCurrent Money Provided: $%s\n(1) Feed Money\n(2) Select Product\n(3) Finish Transaction\n", cash.getCash());
            final String userIn = userInput.nextLine();

            if (userIn.equals("1") || userIn.equals("2") || userIn.equals("3")) {

                final int purchaseSelect = Integer.parseInt(userIn);
                if (purchaseSelect == 1) {
                    loadMoney();
                    break;
                } else if (purchaseSelect == 2) {
                    pickItem();
                    break;
                } else {
                    printMenu();
                    getMenuSelection();
                }

            } else {
                System.out.println("\nPlease input proper selection e.g. (1)(2)(3)");
            }
        }
    }

    public void loadMoney() {
        while (true) {
            System.out.println("\n How much money do you want to add? (e.g. 1.25 or 5.00)");
            try {
                final String userIn = userInput.nextLine();
                final BigDecimal moneyIn = new BigDecimal(userIn);
                cash.setCash(moneyIn.add(cash.getCash()));
                getPurchaseSelection();
                break;

            } catch (NumberFormatException e) {
                System.out.println("Please input proper selection (e.g. 1.25 or 5.00)");
            }
        }
    }

    public void pickItem() {

        while (true) {
            System.out.println("\nPlease input Slot Location");
            final String userIn = userInput.nextLine();

            if (machineInventory.getInventoryMap().containsKey(userIn)) {

                if (cash.getCash().compareTo(machineInventory.getInventoryMap().get(userIn).getPrice())==1
                        || cash.getCash().compareTo(machineInventory.getInventoryMap().get(userIn).getPrice())==0){

                    machineInventory.getInventoryMap().get(userIn).decreaseQuantity();
                    System.out.printf("Dispensing %s: %s \n",userIn, machineInventory.getInventoryMap().get(userIn).getProductName());
                    getPurchaseSelection();
                    break;

                }else {
                    System.out.println("LOL Broke boi");

                }
                
            } else {
                System.out.println("Please input proper selection e.g. (A1)(B2)(C3)");
            }

        }
    }


}







