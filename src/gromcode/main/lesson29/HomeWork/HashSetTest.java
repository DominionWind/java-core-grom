package gromcode.main.lesson29.HomeWork;

import gromcode.main.lesson29.File;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
    public Set<Order> useHashSet() {
        Set<Order> orderSet1 = new HashSet<>();
        Set<Order> orderSet2 = new HashSet<>();

        Order order1 = new Order(111, 100, "first", "I", "bazar");
        Order order2 = new Order(222, 200, "second", "II", "shop");
        Order order3 = new Order(333, 300, "third", "III", "bazar");
        Order order4 = new Order(444, 400, "fourght", "IV", "magaz");
        Order order5 = new Order(555, 500, "fifth", "V", "bazar");

        orderSet2.add(order1);
        orderSet2.add(order2);

        orderSet1.add(order1);
        orderSet1.add(order2);
        orderSet1.add(order3);
        orderSet1.add(order4);
        orderSet1.add(order5);

        orderSet1.remove(order3);
        orderSet1.retainAll(orderSet2);

        orderSet1.toArray();
        orderSet1.size();

        System.out.println(orderSet1);
        System.out.println(orderSet2);

        return orderSet1;

//        Iterator<Order> orderIterator = orderSet1.iterator();

    }

}
