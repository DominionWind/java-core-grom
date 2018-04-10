package lesson12;

public abstract class Bank {

    private long id;
    private String bankCountry;
    private Currency currency;
    private int numbersOfEmploees;
    private double avrSalaryOfEmploee;
    private long rating;
    private long totalCapital;

    public Bank(long id, String bankCountry, Currency currency, int numbersOfEmploees, double avrSalaryOfEmploee, long rating, long totalCapital) {
        this.id = id;
        this.bankCountry = bankCountry;
        this.currency = currency;
        this.numbersOfEmploees = numbersOfEmploees;
        this.avrSalaryOfEmploee = avrSalaryOfEmploee;
        this.rating = rating;
        this.totalCapital = totalCapital;
    }

    public abstract int getLimitOfWindrawal();
    public abstract int getLimitOfFunding();
    public abstract double getMonthlyRate();
    public abstract double getCommission(int amount);


    public double moneyPaidMonthlyForSalary(){
        return numbersOfEmploees * avrSalaryOfEmploee;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getNumbersOfEmploees() {
        return numbersOfEmploees;
    }

    public void setNumbersOfEmploees(int numbersOfEmploees) {
        this.numbersOfEmploees = numbersOfEmploees;
    }

    public double getAvrSalaryOfEmploee() {
        return avrSalaryOfEmploee;
    }

    public void setAvrSalaryOfEmploee(double avrSalaryOfEmploee) {
        this.avrSalaryOfEmploee = avrSalaryOfEmploee;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(long totalCapital) {
        this.totalCapital = totalCapital;
    }
}
