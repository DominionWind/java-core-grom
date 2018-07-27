package lesson33.HomeWork;

import lesson19.HomeWork.File;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {

    public static void writeToFileFromConsole(String path) {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Enter file content to write in the file");
        String textFromConsole = null;
        try {
            textFromConsole = br.readLine();
//            while (br.readLine() != "wr,") {
//                textFromConsole = br.readLine();
//            }
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }
        try {
            if (br.readLine().equals("wr,")) {
                writeToFile(path, textFromConsole);
            }
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
    }

    private static void writeToFile(String path, String text) {
        if (text != null) {
            FileWriter writer = null;
            BufferedWriter bufferedWriter = null;
            try {
                writer = new FileWriter(path, true);
                bufferedWriter = new BufferedWriter(writer);

                bufferedWriter.append("\n");
                bufferedWriter.append(text);
                System.out.println("writing done");
            } catch (IOException e) {
                System.err.println("Can`t write to file with path " + path);
            } finally {
                IOUtils.closeQuietly(writer);
                IOUtils.closeQuietly(bufferedWriter);
            }
        }
    }

//=======================================================================================================================================================

    public static void readFileByConsolePath() {
        System.out.println("Please, enter file path to read");

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String text = null;

        try {
            text = br.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }
        try {
            readFile(text);
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
    }

    private static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("Can`t read file by path" + path);
            return;
        }

        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }
}
