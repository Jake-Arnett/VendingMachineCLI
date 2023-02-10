package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    private final String inventorySource = "C:\\Users\\Student\\workspace\\capstone-1-team-6\\capstone\\vendingmachine.csv";
    private final File inventoryFile = new File(inventorySource);
    private Map<String, Item> inventoryMap = new HashMap();

    public void loadInventory() {
        try (
                Scanner inventoryInput = new Scanner(inventoryFile);
        ) {
            while (inventoryInput.hasNextLine()) {
                BigDecimal price;
                String lineOfText = inventoryInput.nextLine();
                String[] itemsArr = lineOfText.split("\\|");
                Item itemChan = new Item(itemsArr[0], itemsArr[1], price=new BigDecimal(itemsArr[2]), itemsArr[3], 5);
                inventoryMap.put(itemChan.getSlotLocation(), itemChan);
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void subItemInventory(String slotLocation) {
        inventoryMap.get(slotLocation).decreaseQuantity();
    }

    public Map<String, Item> getInventoryMap() {
        return inventoryMap;
    }
}
