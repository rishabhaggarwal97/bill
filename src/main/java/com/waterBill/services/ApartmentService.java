package com.waterBill.services;

import com.waterBill.models.Bill;

public interface ApartmentService {

    int allotWater(int apartmentNumber,int rooms, String waterAllocationString);
    int addGuests(int apartmentNumber, int numberOfGuests);
    Bill generateBill(int apartmentNumber);
}
