package com.waterBill.models;

import com.waterBill.enums.ApartmentType;

public class Apartment {
    private int apartmentNumber;
    private ApartmentType apartmentType;
    private WaterAllocationRatio waterAllocationRatio;
    private int numberOfguests;

    public Apartment(int apartmentNumber, ApartmentType apartmentType, WaterAllocationRatio waterAllocationRatio) {
        this.apartmentNumber = apartmentNumber;
        this.apartmentType = apartmentType;
        this.waterAllocationRatio = waterAllocationRatio;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public WaterAllocationRatio getWaterAllocationRatio() {
        return waterAllocationRatio;
    }

    public int getNumberOfguests() {
        return numberOfguests;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public void setWaterAllocationRatio(WaterAllocationRatio waterAllocationRatio) {
        this.waterAllocationRatio = waterAllocationRatio;
    }

    public void setNumberOfguests(int numberOfguests) {
        this.numberOfguests = numberOfguests;
    }
}
