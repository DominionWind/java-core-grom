package lesson35.DAO;

import lesson35.Login.Utils;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDAO {

    private UserDAO userDAO = new UserDAO();
    private RoomDAO roomDAO = new RoomDAO();
    private Utils utils = new Utils();

    private DAO<Order> dao = new DAO<Order>() {
        @Override
        public Order convector(String string) throws Exception {
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
    };

    private static String path = "E:\\Games\\java\\Order.txt";

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

    public ArrayList<Order> readOrderFromFile() throws Exception {
        return dao.readFromFile(path);
    }

    private void writeOrderToDB(Order order) throws IOException {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("E:\\Games\\java\\Order.txt", true))) {
            br.newLine();
            br.write(order.getId() + "," + order.getUser().getId() + "," + order.getRoom().getId() + "," +
                    order.getDateFrom() + "," + order.getDateTo() + "," + order.getMoneyPaid());
        } catch (IOException e) {
            System.err.println("Can`t save Order to DB");
        }
    }

    private void deleteOrdersFromBD() throws FileNotFoundException {
        dao.deleteContent(path);
    }
}
