package gromcode.main.lesson21;

public class Demo {
    public static void main(String[] args) throws Exception {
        Company company = new Company(100, "Nolia");

        Company.setLicence("GTP999");

        System.out.println(company.getLicence());

        Company company1 = new Company(9, "Test");

        System.out.println(company1.getLicence());

        Company.setLicence("TTT11");

        System.out.println(company.getLicence());
        System.out.println(company1.getLicence());

        //Company.validate();

        int min = ArrayUtils.mixElement(new int[]{1, 10, 40});

    }
}
