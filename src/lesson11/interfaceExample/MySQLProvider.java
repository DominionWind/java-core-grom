package lesson11.interfaceExample;

public class MySQLProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic fro mysql
    }

    @Override
    public void disconnectFromDb() {
        //some logic fro mysql
    }

    @Override
    public void encryptData() {
        //some logic fro mysql
    }
}
