package com.waterBill;

import com.waterBill.models.Bill;
import com.waterBill.services.ApartmentService;
import com.waterBill.services.ApartmentServiceImpl;

import java.io.*;
import java.util.ArrayList;

public class GeekTrust {
    public static void run(String[] args) {

        String filePath = args[0];
        Bill bill = null;
        ApartmentService apartmentService = new ApartmentServiceImpl();
        ArrayList<String> commands = getCommands(filePath);
        for(String commandLine : commands){
            String[] commandHub = commandLine.split(" ");

            if(commandHub[0].equals("ALLOT_WATER")){
                int apartmentNumber = apartmentService.allotWater(101,Integer.parseInt(commandHub[1]),commandHub[2]);
            }else if(commandHub[0].equals("ADD_GUESTS")){
                int num = apartmentService.addGuests(101,Integer.parseInt(commandHub[1]));
            }else {
                bill = apartmentService.generateBill(101);
            }
        }

        System.out.println(bill.getTotalWaterUsage() + " " + bill.getAmount());

    }

    private static ArrayList<String> getCommands(String filePath){
        FileInputStream stream = null;
        try{
            stream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String strLine;

        ArrayList<String> lines = new ArrayList<String>();
        try{
            while ((strLine = reader.readLine()) != null){
                lines.add(strLine);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return lines;
    }
}
