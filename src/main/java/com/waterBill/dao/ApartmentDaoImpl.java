package com.waterBill.dao;

import com.waterBill.models.Apartment;

import java.util.HashMap;
import java.util.Map;


public class ApartmentDaoImpl implements ApartmentDao {
    private static Map<Integer, Apartment> apartmentMap = new HashMap<Integer, Apartment>();

    public int save(Apartment apartment) {
        apartmentMap.put(apartment.getApartmentNumber(),apartment);
        return apartment.getApartmentNumber();
    }

    public int addGuests(int apartmentNumber, int numberOfGuests) {
        Apartment apartment = apartmentMap.get(apartmentNumber);
        if(apartment!=null){
            apartment.setNumberOfguests(apartment.getNumberOfguests() + numberOfGuests);
            return save(apartment);
        }
        return -1;
    }

    public Apartment getApartmentByApartmentNumber(int apartmentNumber) {
        return apartmentMap.get(apartmentNumber);
    }
}
