package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    /*@Override
    public void validateOrder() {
        String[] cityFrom = {"Киев", "Одесса", "Днепр", "Харьков"};
        String[] cityTo = {"Киев", "Одесса", "Днепр", "Харьков"};
        if (getBasePrice() >= 100 && confirmFromCity(cityFrom) && confirmToCity(cityTo) && getCustomerOwned().getGender() == "Женский"){
            setDateConfirmed(new Date());
        }
    }*/

    @Override
    public void validateOrder() {
        if ((getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" || getShipFromCity() == "Днепр" || getShipFromCity() == "Харьков") && (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков") && getBasePrice() >= 100 && getCustomerOwned().getGender() == "Женский") {
            setDateConfirmed(new Date());
        }
    }

    /*@Override
    public void calculatePrice() {
        String[] city = {"Киев", "Одесса"};
        if (confirmToCity(city) && confirmFromCity(city))
            setTotalPrice(getBasePrice() * 1.1);

        setTotalPrice(getBasePrice() * 1.15);

        if (getTotalPrice() > 1000)
            setTotalPrice(getTotalPrice() * 0.95);
    }*/

    @Override
    public void calculatePrice() {
        //String[] city = {"Киев", "Одесса"};
        double price = getBasePrice();
        double delivery;
        double discount = 0;
        if (getShipToCity() == "Киев" || getShipToCity() == "Одесса"){
            delivery = price * 0.1;
        } else
            delivery = price * 0.15;

            if (price > 1000) {
                discount = (price + delivery) * 0.05;
            }
            else {
            discount = 0;
            }
            setTotalPrice(price + delivery - discount);
        }
}
