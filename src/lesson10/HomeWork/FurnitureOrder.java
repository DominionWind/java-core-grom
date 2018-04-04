package lesson10.HomeWork;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    /*@Override
    public void validateOrder() {
        String[] cityFrom = {"Киев", "Львов"};
        if (getBasePrice() < 500 && confirmFromCity(cityFrom) && getCustomerOwned().getName() != "Тест")
            confirmShipping();
    }*/

    @Override
    public void validateOrder() {
        if ((getShipFromCity() == "Киев" || getShipFromCity() == "Львов") && getBasePrice() > 500 && getCustomerOwned().getName() != "Тест") {
            setDateConfirmed(new Date());
        }
    }


    @Override
    public void calculatePrice() {
        double price;
        if (getBasePrice() < 5000) {
            price = +getBasePrice() + (getBasePrice() * 0.05);
        } else {
            price = +getBasePrice() + (getBasePrice() * 0.02);
        }
        setTotalPrice(price);
    }
    /*@Override
    public void calculatePrice() {
        double price;
        double discount;
        if (getBasePrice() < 5000) {
            discount = (getBasePrice() * 0.05);
            price = getBasePrice() + discount;
        } else {
            discount = (getBasePrice()*0.02);
            price = getBasePrice() + discount;
        }
        setTotalPrice(price);
    }*/

    /*@Override
    public void calculatePrice() {
        setTotalPrice(getBasePrice() >= 5000 ? getBasePrice() * 1.02 : getBasePrice() * 1.05);
    }*/
}
