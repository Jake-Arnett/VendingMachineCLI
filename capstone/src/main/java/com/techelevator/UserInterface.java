package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private Scanner userInput = new Scanner(System.in);
    Inventory machineInventory = new Inventory();
    BigDecimal zero = new BigDecimal("0.00");
//    MathContext mc = new MathContext(4);
    Money cash = new Money(zero);
    BigDecimal tender = cash.getCash();
    SystemLog log = new SystemLog();


    public UserInterface() {
        machineInventory.loadInventory();

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
            System.out.printf("\nCurrent Money Provided: $%s\n(1) Feed Money\n(2) Select Product\n(3) Finish Transaction\n", tender);
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
                    BigDecimal changeAmt = tender;
                    cash.getChange(tender);
                    tender = tender.subtract(tender);
                    String feedLog = String.format("%s GIVE CHANGE $%s $%s",LocalDateTime.now(),changeAmt,tender);
                    log.printToLog(feedLog);

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
                tender = cash.getCash();
                String feedLog = String.format("%s FEED MONEY $%s $%s",LocalDateTime.now(),userIn,tender);
                log.printToLog(feedLog);
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

                if (cash.getCash().compareTo(machineInventory.getInventoryMap().get(userIn).getPrice()) == 1
                        || cash.getCash().compareTo(machineInventory.getInventoryMap().get(userIn).getPrice()) == 0) {

                    machineInventory.getInventoryMap().get(userIn).decreaseQuantity();
                    tender = cash.getCash().subtract(machineInventory.getInventoryMap().get(userIn).getPrice());
                    System.out.printf("Dispensing %s: %s \n", userIn, machineInventory.getInventoryMap().get(userIn).getProductName());

                    String dispenseLog = String.format(" %s %s %s $%s $%s",
                            LocalDateTime.now(),
                            machineInventory.getInventoryMap().get(userIn).getProductName(),
                            userIn,
                            machineInventory.getInventoryMap().get(userIn).getPrice(),
                            tender);
                    log.printToLog(dispenseLog);

//                    itemTypePrompt();
                    if (machineInventory.getInventoryMap().get(userIn).getType().equals("Chip")) {
                        System.out.println("Crunch Crunch, Yum!");
                    }
                    if (machineInventory.getInventoryMap().get(userIn).getType().equals("Candy")) {
                        System.out.println("Munch Munch, Yum!");
                    }
                    if (machineInventory.getInventoryMap().get(userIn).getType().equals("Drink")) {
                        System.out.println("Glug Glug, Yum!");
                    }
                    if (machineInventory.getInventoryMap().get(userIn).getType().equals("Gum")) {
                        System.out.println("Chew Chew, Yum!");
                    }
                    getPurchaseSelection();
                } else {
                    System.out.println("Insufficient funds to purchase item");
                    getPurchaseSelection();

                }
            } else {
                System.out.println("Please input proper selection e.g. (A1)(B2)(C3)");
            }
        }
    }

//        public void itemTypePrompt() {
//        final String userIn = userInput.nextLine();
//        if (machineInventory.getInventoryMap().get(userIn).getType().equals("Chip")){
//            System.out.println("Crunch Crunch, Yum!");
//        }
//        if (machineInventory.getInventoryMap().get(userIn).getType().equals("Candy")){
//            System.out.println("Munch Munch, Yum!");
//        }
//        if (machineInventory.getInventoryMap().get(userIn).getType().equals("Drink")){
//            System.out.println("Glug Glug, Yum!");
//        }
//        if (machineInventory.getInventoryMap().get(userIn).getType().equals("Gum")){
//            System.out.println("Chew Chew, Yum!");
//        }
//    }
}







