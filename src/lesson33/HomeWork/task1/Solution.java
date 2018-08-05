package lesson33.HomeWork.task1;

import java.io.*;

public class Solution {


    public void writeToFileFromConsole(String path) {
        if (!new File(path).exists()){
            System.out.println("File with path " + path + " not found");
        }

        writeToFile(path, readFromConsole());
    }

    private void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can`t write to file " + path);
        }
    }

    private StringBuffer readFromConsole() {
        StringBuffer res = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!bufferedReader.readLine().equals("wr")) {
                res.append(bufferedReader.readLine());
            }
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }
        return res;
    }
}
