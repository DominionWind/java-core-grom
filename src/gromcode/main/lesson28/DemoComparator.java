package gromcode.main.lesson28;

import java.util.ArrayList;
import java.util.Date;

public class DemoComparator {
    public static void main(String[] args) throws InterruptedException {
        Capability capability2 = new Capability(1005, null, "rrrr", false, null);
        Thread.sleep(1000);
        Capability capability4 = new Capability(900, "test4", "rrrr", false, null);
        Thread.sleep(1000);
        Capability capability3 = new Capability(900, "test3", "rrrr", true, new Date());
        Thread.sleep(1000);
        Capability capability1 = new Capability(1001, "test1", "rrrr", true, new Date());

        ArrayList<Capability> capabilities = new ArrayList<>();

        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);

        System.out.println(capabilities);

        capabilities.sort(new DateComparator());

        System.out.println(capabilities);

        capabilities.sort(new FullComparator());

        System.out.println(capabilities);
    }
}
