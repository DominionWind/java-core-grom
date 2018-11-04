package lesson35.DAO;

import java.io.*;
import java.util.ArrayList;

public abstract class DAO<T> {

    public void writerToFile(T t, String path) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path, true))) {
            br.newLine();
            br.write((String) t);
        } catch (IOException e) {
            System.err.println("Can`t save " + t + " to DB");
        }
    }

    public ArrayList<T> readFromFile(String path) throws Exception {
        ArrayList<T> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(convector(line));
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path);
        }

        return list;
    }


    public abstract T convector(String string) throws Exception;

    public void deleteContent(String path) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(path);
        writer.print("");
        writer.close();
    }

}
