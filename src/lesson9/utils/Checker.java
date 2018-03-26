package lesson9.utils;

public class Checker {
    //public
    //private 90+
    //default
    //protected

    public int companyNamesValidaytedCount = 0;

    public boolean checkCompanyName(String companyName) {

        if(companyNamesValidaytedCount > 10)
            return false;

        companyNamesValidaytedCount++;

        return companyName != "Google" && companyName != "Amazon";
        /*if(companyName == "Google" || companyName == "Amazon")
            return false;
        return true;*/
    }
}
