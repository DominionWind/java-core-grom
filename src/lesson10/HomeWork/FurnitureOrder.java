package lesson10.HomeWork;

import java.util.Date;

public class FurnitureOrder extends Order {
    String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer custumerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, custumerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    void validateOrder() {
        String[] cityFrom = {"Киев", "Львов"};
        if (getBasePrice() < 500 && confirmFromCity(cityFrom) && getCustumerOwned().getName() != "Тест")
            confirmShipping();
    }

    @Override
    void calculatePrice() {
        /*if (getBasePrice() < 5000);{
            setTotalPrice(getBasePrice()*1.05);
        }
            setTotalPrice(getBasePrice()*1.02);*/
        setTotalPrice(getBasePrice() >= 5000 ? getBasePrice() * 1.02 : getBasePrice() * 1.05);
    }
}
