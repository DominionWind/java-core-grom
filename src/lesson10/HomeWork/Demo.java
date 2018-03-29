package lesson10.HomeWork;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Julia", "Днепр", "Женский");
        Customer customer2 = new Customer("Igor", "Любой", "Мужской");
        Customer customer3 = new Customer("Sveta", "Днепр", "Женский");
        Customer customerUltimate = new Customer("Иван Федорович Крузенштерн Человек и Пароход", "Юпитер", "Кот");

        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("TV", new Date(), "Киев", "Днепр", 2000, customer1, 36);
        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("Tetris", new Date(), "Киев", "Днепр", 10, customer2, 32167);

        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Стол", new Date(), "Киев", "Киев", 700, customer3, "322");
        FurnitureOrder furnitureOrderUltimate = new FurnitureOrder("Budka dlia Sharika and stoilo dlia bud4ka", new Date(), "Prostokvashino", "Dom miliu Dom", 100500, customerUltimate, "14/88");

        System.out.println(furnitureOrderUltimate.getItemName());
    }
}
