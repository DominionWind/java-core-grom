package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer custumerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, custumerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    private boolean ConfirmCity() {
        String CityForOrder[] = {"Киев", "Одесса", "Днепр", "Харьков"};
        for (int i = 0; i < CityForOrder.length; i++)
            if (getCustumerOwned().getCity() == (CityForOrder[i]);
        return true;
    }

    @Override
    void validateOrder() {
        if (getBasePrice() >= 100 && ConfirmCity(getCustumerOwned().getCity()) = true && getCustumerOwned().getGender() == "female")
            confirmShipping();
    }

    @Override
    void calculatePrice() {

    }
}
