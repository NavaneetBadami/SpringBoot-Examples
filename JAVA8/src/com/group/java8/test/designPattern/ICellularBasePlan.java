package com.group.java8.test.designPattern;

@FunctionalInterface
public interface ICellularBasePlan {
     double getRate();

     default void viewPlan() {
         System.out.println("Rate:"+this.getRate() + " GST:18+");
     }

     default void getMonthPlan(int months) {
         System.out.println("Monthly Charges No_of Months: "+ months +" Total price: "+ (months*getRate()));
     }
}

class KarPlan implements ICellularBasePlan{

    @Override
    public double getRate() {
        return 499;
    }
}

class MhPlan implements ICellularBasePlan {

    @Override
    public double getRate() {
        return 399;
    }
}

class RegionPlansFactory {

    public ICellularBasePlan getICellularBasePlan(String regionCode) {
        if (regionCode.equalsIgnoreCase("KA")) {
            return new KarPlan();
        }
        if (regionCode.equalsIgnoreCase("MH")) {
            return new MhPlan();
        }
        return null;
    }
}
class Run {
    public static void main(String[] args) {

        RegionPlansFactory regionPlansFactory = new RegionPlansFactory();
        System.out.println(regionPlansFactory.getICellularBasePlan("KA").getRate());
        System.out.println(regionPlansFactory.getICellularBasePlan("Mh").getRate());
        regionPlansFactory.getICellularBasePlan("KA").viewPlan();
        regionPlansFactory.getICellularBasePlan("Mh").viewPlan();
        regionPlansFactory.getICellularBasePlan("KA").getMonthPlan(6);
        regionPlansFactory.getICellularBasePlan("Mh").getMonthPlan(10);
    }
}