package lesson35.DAO;

import lesson35.model.Order;
import lesson35.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class OrderDAO {

    private UserDAO userDAO = new UserDAO();
    private RoomDAO roomDAO = new RoomDAO();

    public ArrayList<Order> readOrderFromFile() throws Exception {

        ArrayList<Order> orders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("E:\\Games\\java\'Order.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orders.add(stringToOrderConvector(line));
            }
        } catch (IOException e) {
            System.err.println("Reading from file E:\\Games\\java\\Order.txt failed");
        }

        return orders;
    }

    public void saveOrdersToDb(ArrayList<Order> orders){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\Games\\java\'Order.txt"))){
            bufferedWriter.write(String.valueOf(orders));
        } catch (IOException e) {
            System.err.println("Can`t save Users to BD");
        }
    }

    private Order stringToOrderConvector(String string) throws Exception {
        String[] mod = string.split(",");

        Long id = Long.parseLong(mod[0]);
        Long userId = Long.parseLong(mod[1]);
        Long room = Long.parseLong(mod[2]);
        Date dateFrom = stringToDateConvector(mod[3]);
        Date dateTo = stringToDateConvector(mod[4]);
        Double money = Double.parseDouble(mod[5]);

        Order order = new Order(id, userDAO.getUserById(userId), roomDAO.getRoomById(room), dateFrom, dateTo, money);

        return order;
    }

    private Date stringToDateConvector(String string) {
        //todo

        Date date = new Date();
        return date;
    }


}
