package com.waterBill.utility;

import com.waterBill.constants.Constants;
import com.waterBill.constants.WaterRates;
import com.waterBill.models.Apartment;
import com.waterBill.models.Bill;

public class BillUtility {
    private static double calculateCorporateComponent(Apartment apartment){
        int corporatePart = apartment.getWaterAllocationRatio().getCorporationPart();
        int borewellPart = apartment.getWaterAllocationRatio().getBorewellPart();
        int totalPart = corporatePart + borewellPart;
        double waterUsagePerPersonPerDay = ((double) corporatePart / (double) totalPart)
                                                    *Constants.WATER_ALLOTED_PER_PERSON_PER_DAY;
        double totalWaterUsage = waterUsagePerPersonPerDay*apartment.getApartmentType().numberOfPeople
                                *Constants.DAYS_IN_MONTH;
        double totalCorporateAmount = totalWaterUsage* WaterRates.CORPORATION_RATE;
        return totalCorporateAmount;
    }
    private static double calculateBorewellComponent(Apartment apartment){
        int corporatePart = apartment.getWaterAllocationRatio().getCorporationPart();
        int borewellPart = apartment.getWaterAllocationRatio().getBorewellPart();
        int totalPart = corporatePart + borewellPart;
        double waterUsagePerPersonPerDay = ((double) borewellPart / (double) totalPart)
                *Constants.WATER_ALLOTED_PER_PERSON_PER_DAY;
        double totalWaterUsage = waterUsagePerPersonPerDay*apartment.getApartmentType().numberOfPeople
                *Constants.DAYS_IN_MONTH;
        double totalBorewellAmount = totalWaterUsage* WaterRates.BOREWELL_RATE;
        return totalBorewellAmount;
    }
    private static double calculateTankerComponent(int numberOfGuests){
        double totalWaterUsage = numberOfGuests * Constants.WATER_ALLOTED_PER_PERSON_PER_DAY * Constants.DAYS_IN_MONTH;
        double totalTankerAmount = 0.0;
        if(totalWaterUsage<=500){
            totalTankerAmount = totalWaterUsage*WaterRates.TANKER_RATE_0_TO_500;
        }else if(totalWaterUsage>500 && totalWaterUsage<=1500){
            totalTankerAmount = 500*WaterRates.TANKER_RATE_0_TO_500;
            totalTankerAmount += (totalWaterUsage-500)*WaterRates.TANKER_RATE_501_TO_1500;
        }else if(totalWaterUsage>1500 && totalWaterUsage<=3000){
            totalTankerAmount = 500*WaterRates.TANKER_RATE_0_TO_500;
            totalTankerAmount += 1000*WaterRates.TANKER_RATE_501_TO_1500;
            totalTankerAmount += (totalWaterUsage-1500)*WaterRates.TANKER_RATE_1501_TO_3000;
        }else {
            totalTankerAmount = 500*WaterRates.TANKER_RATE_0_TO_500;
            totalTankerAmount += 1000*WaterRates.TANKER_RATE_501_TO_1500;
            totalTankerAmount += 1500*WaterRates.TANKER_RATE_1501_TO_3000;
            totalTankerAmount += (totalWaterUsage-3000) * WaterRates.TANKER_RATE_POST_3001;
        }
        return totalTankerAmount;
    }

    private static int getTotalWaterUsage(Apartment apartment){
        int waterUsageByApartmentOwners = apartment.getApartmentType().numberOfPeople * (int)Constants.WATER_ALLOTED_PER_PERSON_PER_DAY
                                            * Constants.DAYS_IN_MONTH;
        int waterUsageByGuests = apartment.getNumberOfguests() * (int) Constants.WATER_ALLOTED_PER_PERSON_PER_DAY
                                            * Constants.DAYS_IN_MONTH;

        return waterUsageByApartmentOwners + waterUsageByGuests;
    }
    public static Bill generateBillForApartment(Apartment apartment){
        double corporateComponent = calculateCorporateComponent(apartment);
        double borewellComponent = calculateBorewellComponent(apartment);
        double tankerComponent = calculateTankerComponent(apartment.getNumberOfguests());
        double totalAmount = corporateComponent + borewellComponent + tankerComponent;
        int totalWaterUsage = getTotalWaterUsage(apartment);
        Bill bill = new Bill(apartment.getApartmentNumber(),(int)Math.round(totalAmount),totalWaterUsage);
        return bill;
    }
}
