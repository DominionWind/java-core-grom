package lesson35.DAO;

import lesson35.Login.Utils;
import lesson35.model.Order;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDAO {

    private UserDAO userDAO = new UserDAO();
    private RoomDAO roomDAO = new RoomDAO();
    private Utils utils = new Utils();

    public void addOrder(Order order) throws Exception {
        writeOrderToDB(order);
    }

    public void deleteOrder(long id) throws Exception {
        ArrayList<Order> orders = readOrderFromFile();
        orders.remove(getOrderById(id));
        saveOrdersToDb(orders);
    }

    public Order getOrderById(Long id) throws Exception {
        for (Order o : readOrderFromFile()) {
            if (o.getId() == id) {
                return o;
            }
        }
        throw new Exception("Can`t find Order whit ID " + id);
    }

    private void saveOrdersToDb(ArrayList<Order> orders) throws Exception {
        deleteOrdersFromBD();
        for (Order o : orders) {
            writeOrderToDB(o);
        }
    }

    private ArrayList<Order> readOrderFromFile() throws Exception {

        ArrayList<Order> orders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("E:\\Games\\java\\Order.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orders.add(stringToOrderConvector(line));
            }
        } catch (IOException e) {
            System.err.println("Reading from file E:\\Games\\java\\Order.txt failed");
        }

        return orders;
    }

    private void writeOrderToDB(Order order) throws IOException {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("E:\\Games\\java\\Order.txt", true))) {
            br.newLine();
            br.write(order.toString());
        } catch (IOException e) {
            System.err.println("Can`t save Order to DB");
        }
    }

    private Order stringToOrderConvector(String string) throws Exception {
        String[] mod = string.split(",");

        Long id = Long.parseLong(mod[0]);
        Long userId = Long.parseLong(mod[1]);
        Long room = Long.parseLong(mod[2]);
        LocalDate dateFrom = utils.stringToDateConvector(mod[3]);
        LocalDate dateTo = utils.stringToDateConvector(mod[4]);
        Double money = Double.parseDouble(mod[5]);

        Order order = new Order(id, userDAO.getUserById(userId), roomDAO.getRoomById(room), dateFrom, dateTo, money);

        return order;
    }

    private void deleteOrdersFromBD() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("E:\\Games\\java\\Order.txt");
        writer.print("");
        writer.close();
    }
}
