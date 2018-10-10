package gromcode.main.lesson33.HomeWork.task2;

import java.io.*;

public class Solution {

    public void readFileByConsolePath() {

        readFile(readFromConsole());
    }

    private String readFromConsole() {
        String path = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter path");
            path = bufferedReader.readLine();
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }
        return path;
    }

    private void readFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while (bufferedReader.readLine() != null) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can`t read file by path" + path);
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }
    }
}
