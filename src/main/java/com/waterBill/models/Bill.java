package com.waterBill.models;

public class Bill {

    private int apartmentNumber;
    private int amount;
    private int totalWaterUsage;

    public Bill(int apartmentNumber, int amount, int totalWaterUsage) {
        this.apartmentNumber = apartmentNumber;
        this.amount = amount;
        this.totalWaterUsage = totalWaterUsage;
    }

    public Bill(int apartmentNumber, int amount) {
        this.apartmentNumber = apartmentNumber;
        this.amount = amount;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public int getTotalWaterUsage() {
        return totalWaterUsage;
    }

    public int getAmount() {
        return amount;
    }

}
