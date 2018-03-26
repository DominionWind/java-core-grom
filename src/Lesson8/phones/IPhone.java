package Lesson8.phones;

public class IPhone extends Phone{
    int price;
    double weight;
    String countryProduce;

    boolean fingerPrint;

    public IPhone(int price, double weight, String countryProduce, boolean fingerPrint) {
        super(price, weight, countryProduce);
        System.out.println("IPhone constructor was inwoked...");
        this.fingerPrint = fingerPrint;
    }

    void deleteIPhoneFrobDb(){
        System.out.println("deletedIPhonefronDb invoked...");
    }
}
