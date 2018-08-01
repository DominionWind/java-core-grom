package lesson34.HW;

import java.io.*;

public class Solution {

    public void copyFileContent(String fileFromPath, String fileToPath) throws Exception {

        validate(fileFromPath, fileToPath);

        writeFile(fileToPath, readFromFile(fileFromPath));
    }

    private StringBuffer readFromFile(String path) {

        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }

        return res;
    }

    private void writeFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        }
    }

    private void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permissions to read");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileFrom + " does not have permissions to be written");
        }
    }
}
