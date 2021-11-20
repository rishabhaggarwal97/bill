package com.waterBill.utility;

import com.waterBill.enums.ApartmentType;
import com.waterBill.exceptions.NoApartmentConfigurationfoundException;
import com.waterBill.models.Apartment;
import com.waterBill.models.WaterAllocationRatio;

public class ApartmentUtility {

    public static ApartmentType getApartmentType(int rooms) throws NoApartmentConfigurationfoundException{
        ApartmentType apartmentType;
        switch (rooms){
            case 2 : apartmentType = ApartmentType.BHK_2;
                break;
            case 3 : apartmentType = ApartmentType.BHK_3;
                break;
            default:
                throw new NoApartmentConfigurationfoundException("No Apartments found with such configuration");
        }

        return apartmentType;
    }

    public static WaterAllocationRatio getWaterAllocationRatio(String waterAllocationString){
        String[] ratioArray = waterAllocationString.split(":");
        return new WaterAllocationRatio(Integer.parseInt(ratioArray[0]),Integer.parseInt(ratioArray[1]));
    }

    public static Apartment getApartment(int apartmentNumber, int rooms, String waterAllocationString) {
        try{
            ApartmentType apartmentType = getApartmentType(rooms);
            WaterAllocationRatio waterAllocationRatio = getWaterAllocationRatio(waterAllocationString);
            return new Apartment(apartmentNumber,apartmentType,waterAllocationRatio);
        }catch (NoApartmentConfigurationfoundException noApartmentConfigurationException){
            System.out.println("No configuration found for this apartment");
        }

        return null;
    }
}
