package com.waterBill.dao;

import com.waterBill.models.Apartment;

public interface ApartmentDao {

    int save(Apartment apartment);
    int addGuests(int apartmentNumber,int numberOfGuests);
    Apartment getApartmentByApartmentNumber(int apartmentNumber);
}
