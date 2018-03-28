package lesson10.abstracFirstEexample;

public abstract class DbProvider {

    private String dbHost;

    //public DbProvider(String dbHost) {
    //    this.dbHost = dbHost;
    //}

    abstract void connectToDb();

    abstract void disconnectToDb();

    void printDbHost() {
        System.out.println("DB Host is" + dbHost);
    }
}
