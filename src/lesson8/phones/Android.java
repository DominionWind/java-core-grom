package lesson8.phones;

public class Android extends Phone{
    String androidVersion;
    int screenSize;

    String secretFeviseCode;

    public Android(int price, double weight, String countryProduce, String androidVersion, int screenSize, String secretFeviseCode) {
        super(price, weight, countryProduce);

        // this - reference to the current class obhect
        // super - reference to the parent class object

        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretFeviseCode = secretFeviseCode;
    }

    void installNewAndroidVersion(){
        System.out.println("installNewAndroidVersion invoked...");
    }
}
