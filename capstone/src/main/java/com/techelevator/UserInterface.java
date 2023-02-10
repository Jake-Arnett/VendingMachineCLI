package com.techelevator;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private Scanner userInput = new Scanner(System.in);
    Inventory machineInventory = new Inventory();
    Money cash = new Money(0);


    public void printMenu() {
        System.out.println("===Welcome to The Vendo-matic 800===");
        System.out.println("(1) Display Vending Machine Items\n(2) Purchase\n(3) Exit\n");
    }


    public void getMenuSelection() {
       while (true){
           final String userIn = userInput.nextLine();
           if (userIn.equals("1") || userIn.equals("2") || userIn.equals("3")) {
               final int menuSelect = Integer.parseInt(userIn);
               if (menuSelect == 1) {
                   machineInventory.loadInventory();
                   Map<String, Item> fullStockItems = machineInventory.getInventoryMap();
                   for (Map.Entry<String, Item> item : fullStockItems.entrySet()) {
                       System.out.println(item.getValue().toString());
                   }
                   System.out.println("\n(1) Display Vending Machine Items\n(2) Purchase\n(3) Exit\n");
               }else if (menuSelect == 2){
                   getPurchaseSelection();
               }else {
                   System.out.println("GOODBYE");
                   System.exit(69420);
               }
           } else {
               System.out.println("Please input proper selection e.g. (1)(2)(3)\n\n(1) Display Vending Machine Items\n(2) Purchase\n(3) Exit\n");
           }
       }
    }


    public void getPurchaseSelection() {
        while (true){
            System.out.printf("\nCurrent Money Provided: %d Cents\n(1) Feed Money\n(2) Select Product\n(3) Finish Transaction\n",cash.getCash());
            final String userIn = userInput.nextLine();

            if (userIn.equals("1") || userIn.equals("2") || userIn.equals("3")) {

                final int purchaseSelect = Integer.parseInt(userIn);
                if (purchaseSelect == 1) {
                    System.out.println("In Cents How much money do you want to add?");
                    loadMoney();
                    break;
                }else if (purchaseSelect == 2){
                    System.out.println("Select a product Dummy!");
                    break;
                }else {
                    printMenu();
                    getMenuSelection();
                }

            } else {
                System.out.printf("\nPlease input proper selection e.g. (1)(2)(3)\n\nCurrent Money Provided: %d Cents\n(1) Feed Money\n(2) Select Product\n(3) Finish Transaction\n",cash.getCash());
            }
        }
    }

    public void loadMoney() {
        while (true){
            try {
                final String userIn = userInput.nextLine();
                final int moneyIn = Integer.parseInt(userIn);
                cash.setCash(moneyIn + cash.getCash());
                getPurchaseSelection();
                break;


            } catch (NumberFormatException e){
                System.out.println("Please input proper selection e.g. 58008\n\nIn Cent How much money do you want to add?");
            }
        }
    }




}







