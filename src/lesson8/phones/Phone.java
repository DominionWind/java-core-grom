package lesson8.phones;

public class Phone {
    int price;
    double weight;
    String countryProduce;

    public Phone(int price, double weight, String countryProduce) {
        System.out.println("Phone constructor was inwoked...");
        this.price = price;
        this.weight = weight;
        this.countryProduce = countryProduce;
    }

    void orderPhone(){
        System.out.println("order phone invoked...");
    }
}
