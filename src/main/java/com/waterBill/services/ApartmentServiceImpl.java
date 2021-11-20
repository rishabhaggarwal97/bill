package com.waterBill.services;

import com.waterBill.dao.ApartmentDao;
import com.waterBill.dao.ApartmentDaoImpl;
import com.waterBill.models.Apartment;
import com.waterBill.models.Bill;
import com.waterBill.utility.ApartmentUtility;
import com.waterBill.utility.BillUtility;

public class ApartmentServiceImpl implements ApartmentService {

    private ApartmentDao apartmentDao = new ApartmentDaoImpl();

    public int allotWater(int apartmentNumber,int rooms,String waterAllocationString) {
        Apartment apartment = ApartmentUtility.getApartment(apartmentNumber,rooms,waterAllocationString);
        return apartmentDao.save(apartment);
    }

    public int addGuests(int apartmentNumber, int numberOfGuests) {
        return apartmentDao.addGuests(apartmentNumber,numberOfGuests);
    }

    public Bill generateBill(int apartmentNumber) {
        Apartment apartment = apartmentDao.getApartmentByApartmentNumber(apartmentNumber);
        if(apartment!=null){
            return BillUtility.generateBillForApartment(apartment);
        }
        return null;
    }
}
