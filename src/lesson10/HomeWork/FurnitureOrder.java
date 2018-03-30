package lesson10.HomeWork;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        String[] cityFrom = {"Киев", "Львов"};
        if (getBasePrice() < 500 && confirmFromCity(cityFrom) && getCustomerOwned().getName() != "Тест")
            confirmShipping();
    }

    @Override
    public void calculatePrice() {
        /*if (getBasePrice() < 5000);{
            setTotalPrice(getBasePrice()*1.05);
        }
            setTotalPrice(getBasePrice()*1.02);*/
        setTotalPrice(getBasePrice() >= 5000 ? getBasePrice() * 1.02 : getBasePrice() * 1.05);
    }
}
