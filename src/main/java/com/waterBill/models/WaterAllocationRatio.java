package com.waterBill.models;

public class WaterAllocationRatio {
    int corporationPart;
    int borewellPart;

    public WaterAllocationRatio(int corporationPart, int borewellPart) {
        this.corporationPart = corporationPart;
        this.borewellPart = borewellPart;
    }

    public int getCorporationPart() {
        return corporationPart;
    }

    public int getBorewellPart() {
        return borewellPart;
    }
}
