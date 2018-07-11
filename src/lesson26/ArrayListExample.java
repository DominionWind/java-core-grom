package lesson26;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public List useList() {

        ArrayList<Order> list = new ArrayList<>();
        ArrayList<Order> list2 = new ArrayList<>();

        Order order1 = new Order(10, 10, "cur1", "name1", "shop1");
        Order order2 = new Order(20, 20, "cur2", "name2", "shop2");
        Order order3 = new Order(30, 30, "cur3", "name3", "shop3");
        Order order4 = new Order(40, 40, "cur4", "name4", "shop3");
        Order order5 = new Order(50, 50, "cur5", "name5", "shop3");

        int index1 = 1;
        int index2 = 2;

        list2.add(order4);
        list2.add(order5);

        list.add(order1);
        list.add(1, order2);
        list.add(order3);
        list.add(order4);
        list.add(order5);
        list.remove(2);
        list.remove(order1);
        list.addAll(list2);
        list.subList(index1, index2);
        list.set(2, order3);
        list.contains (order1);
        list.toArray ();
        list.clear();

        list.add(order1);
        list.add(order2);
        list.add(order3);
        list.add(order4);
        list.add(order5);

        return list;
    }
}
