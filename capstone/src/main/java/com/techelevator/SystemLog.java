package com.techelevator;

import java.io.*;

public class SystemLog {
    private final File log = new File("C:\\Users\\Student\\workspace\\capstone-1-team-6\\capstone\\vendingmachinelog");

    public void printToLog(String string){
        try(PrintWriter machineLog = new PrintWriter(new FileWriter(log,true))){
            machineLog.println(string);
        } catch (IOException e){
            System.out.println("File not Found");
        }
    }



}
