package com.waterBill.enums;

public enum ApartmentType {
    BHK_2(2,3),
    BHK_3(3,5);

    public final int numberOfRooms;
    public final int numberOfPeople;

    ApartmentType(int numberOfRooms,int numberOfPeople){
        this.numberOfRooms = numberOfRooms;
        this.numberOfPeople = numberOfPeople;
    }
}
