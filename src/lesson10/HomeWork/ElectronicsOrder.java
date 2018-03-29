package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer custumerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, custumerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    void validateOrder() {
        String[] cityFrom = {"Киев", "Одесса", "Днепр", "Харьков"};
        String[] cityTo = {"Киев", "Одесса", "Днепр", "Харьков"};
        if (getBasePrice() >= 100 && confirmFromCity(cityFrom) && confirmToCity(cityTo) && getCustumerOwned().getGender() == "female")
            confirmShipping();
    }

    /*@Override
    void calculatePrice() {
        double price;
        if(getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" && getShipToCity() == "Киев" || getShipToCity() == "Одесса") {
            price = getBasePrice() + getBasePrice()*0.1;
            if (price > 1000)
                price = price - price * 0.05;
        }
        price = getBasePrice() + getBasePrice() *0.15;
            if(price > 1000)
                price = price * 0.95;
    }*/

    @Override
    void calculatePrice() {
        String[] city = {"Киев", "Одесса"};
        if (confirmToCity(city) && confirmFromCity(city))
            setTotalPrice(getBasePrice() + getBasePrice() * 0.1);

        setTotalPrice(getBasePrice() * 1.15);

        if (getTotalPrice() > 1000)
            setTotalPrice(getTotalPrice() * 0.95);
    }
}
