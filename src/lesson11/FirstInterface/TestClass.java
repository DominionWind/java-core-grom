package lesson11.FirstInterface;

public class TestClass implements FirstInterface{

    private int test = 10;

    @Override
    public void send() {
        //some logic
    }

    @Override
    public String recive() {
        //some logic
        return null;
    }
}
