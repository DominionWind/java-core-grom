package lesson12;

public class EUBank extends Bank{

    public EUBank(long id, String bankCountry, Currency currency, int numbersOfEmploees, double avrSalaryOfEmploee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numbersOfEmploees, avrSalaryOfEmploee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWindrawal() {
        return 0;
    }

    @Override
    public int getLimitOfFunding() {
        return 0;
    }

    @Override
    public double getMonthlyRate() {
        return 0;
    }

    @Override
    public double getCommission(int amount) {
        return 0;
    }
}
