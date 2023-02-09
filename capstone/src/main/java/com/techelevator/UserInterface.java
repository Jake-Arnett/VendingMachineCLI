package com.techelevator;

import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private Scanner userInput = new Scanner(System.in);
    Inventory machineInventory = new Inventory();


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
                   break;
               }else if (menuSelect == 2){
                   System.out.println("GREAT CODE FOR PURCHASE");
                   break;
               }else {
                   System.out.println("GOODBYE");
                   break;
               }

           } else {
               System.out.println("Please input proper selection e.g. (1)(2)(3)\n\n(1) Display Vending Machine Items\n(2) Purchase\n(3) Exit\n");
           }

       }
    }
}







