package lesson34.HW.task2;

import java.io.*;

public class Solution {

    public void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {

        validateFile(fileFromPath, fileToPath);

        writeFile(fileToPath, textToAppend(readFromFile(fileFromPath), word));
        writeRemainingContent(fileFromPath, remainingSentences(readFromFile(fileFromPath), word));
    }


    private StringBuffer readFromFile(String path) {

        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\r\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }

        return res;
    }

    private StringBuilder textToAppend(StringBuffer res, String word) {

        if (res == null || word == null) {
            return null;
        }

        String[] splitText = res.toString().split(".");
        StringBuilder textToAppend = null;
        for (int i = 0; i < splitText.length; i++) {
            if (splitText[i].toCharArray().length > 9) {
                if (splitText[i].contains(word)) {
                    textToAppend.append(splitText[i]);
                    textToAppend.append(". ");
                }
            }
        }

        return textToAppend;
    }

    private StringBuilder remainingSentences(StringBuffer res, String word) {

        if (res == null || word == null) {
            return null;
        }

        String[] splitText = res.toString().split(".");
        StringBuilder remainingSentences = null;
        for (int i = 0; i < splitText.length; i++) {
            if (splitText[i].toCharArray().length > 9) {
                if (!splitText[i].contains(word)) {
                    remainingSentences.append(splitText[i]);
                    remainingSentences.append(". ");
                }
            }
        }

        return remainingSentences;

    }

    private void writeRemainingContent(String path, StringBuilder remainingContent) {
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.print(remainingContent);
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.printf("File " + path + " does not exist");
        }
    }


    private void writeFile(String path, StringBuilder contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        }
    }

    private void validateFile(String fileFromPath, String fileToPath) throws Exception {
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
