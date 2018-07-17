package lesson30.HomeWork;

import java.util.ArrayList;

public class FirmDAO {

    private ArrayList<Firm>firms = new ArrayList<>();

    public void addFirm(Firm firm){
        firms.add(firm);
    }

    public void deleteFirm(Firm firm){
        firms.remove(firms);
    }

    public ArrayList<Firm> getFirms() {
        return firms;
    }
}
