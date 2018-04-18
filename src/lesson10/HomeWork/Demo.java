package lesson10.HomeWork;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Julia", "Днепр", "Женский");
        Customer customer2 = new Customer("Igor", "Любой", "Мужской");
        Customer customer3 = new Customer("Sveta", "Днепр", "Женский");
        Customer customerUltimate = new Customer("Иван Федорович Крузенштерн Человек и Пароход", "Юпитер", "Кот");

        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("TV", new Date(), "Киев", "Одесса", 2000, customer1, 36);
        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("Tetris", new Date(), "Киев", "Днепр", 10, customer2, 32167);

        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Стол", new Date(), "Киев", "Киев", 700, customer3, "322");
        FurnitureOrder furnitureOrderUltimate = new FurnitureOrder("Budka dlia Sharika", new Date(), "Prostokvashino", "Dom miliu Dom", 100500, customerUltimate, "14/88");

        electronicsOrder1.calculatePrice();
        furnitureOrderUltimate.calculatePrice();

        System.out.println(electronicsOrder1.getTotalPrice());
        System.out.println(electronicsOrder2.getTotalPrice());
        System.out.println(furnitureOrder1.getTotalPrice());
        System.out.println(furnitureOrderUltimate.getTotalPrice());

        System.out.println();
        System.out.println("----------------------");
        System.out.println("Test started");
        Customer test1 = new Customer(null, null,null);
        ElectronicsOrder testOrder = new ElectronicsOrder("TV", new Date(), "Киев", "Одесса", 2000, test1, 36);
        System.out.println(test1.getName());
        System.out.println(testOrder.getDateConfirmed());
        ElectronicsOrder testOrder2 = new ElectronicsOrder(null,null,null,null,2000,test1,36);
        System.out.println(testOrder2.getDateConfirmed());
        ElectronicsOrder testOrder3 = new ElectronicsOrder(null,null,null,null,2000,customer1,36);
        System.out.println(testOrder3.getDateConfirmed());
        System.out.println(testOrder.getTotalPrice());
        System.out.println(testOrder2.getTotalPrice());
        System.out.println(testOrder3.getTotalPrice());
        System.out.println(electronicsOrder1.getTotalPrice()+ " EO1 Total Price");
        System.out.println(electronicsOrder2.getTotalPrice() + " EO2 Total Price");
        ElectronicsOrder testOrder4 = new ElectronicsOrder("TV", new Date(), "Киев", "Одесса", 999999999, customer1, 36);
        testOrder4.calculatePrice();//Ура. У нас переполнение. Как лечить ХЗ.
        System.out.println(testOrder4.getTotalPrice()+ " TO4 Total Price");


    }
}
