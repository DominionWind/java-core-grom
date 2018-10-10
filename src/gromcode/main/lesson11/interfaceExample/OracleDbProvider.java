package gromcode.main.lesson11.interfaceExample;

public class OracleDbProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic fro oracle
    }

    @Override
    public void disconnectFromDb() {
        //some logic fro oracle
    }

    @Override
    public void encryptData() {
        //some logic fro oracle
    }
}
