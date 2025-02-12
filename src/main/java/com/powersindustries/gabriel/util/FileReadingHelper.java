package com.powersindustries.gabriel.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReadingHelper {

    /**
     * Read a file, then returns an array of the content line by line.
     *
     * @param fileName the name of the file to be read, located in the classpath.
     * @return a list of strings, where each string represents a line in the file.
     * @throws NullPointerException when file is not found.
     */
    public List<String> getFileLines(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName),
                StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }
}