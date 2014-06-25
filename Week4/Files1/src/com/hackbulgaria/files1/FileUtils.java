package com.hackbulgaria.files1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileUtils {
    private FileUtils() {}
    
    public static void main(String[] args) {
        System.out.println(validKeyValue("a1=b1"));
        System.out.println(validKeyValue("a1=b1=b2   #cakjshajshjashj"));
        System.out.println("a1==b1=b2   #cakjshajshjashj".substring(2 + 1));
    }
    
    public static String readFrom(File file) throws FileNotFoundException, IOException {
        String newLine = "\n";
        StringBuilder content = new StringBuilder();
        List<String> lines = getLines(file.toPath());
        for (String line: lines) {
            content.append(newLine);
            content.append(line);
        }
        return content.toString().trim();
    }
    
    public static List<String> getLines(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return lines;
    }
    
    public static String readFrom(Path path) throws IOException {
        return readFrom(path.toFile());
    }
    
    public static void writeTo(File file, String content) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }   
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content);
        writer.close();
    }
    
    public static void writeTo(Path path, String content) throws IOException {
        writeTo(path.toFile(), content);
    }
    
    public static Map<String, String> parseProperties (File file) throws IOException {
        List<String> lines = getLines(file.toPath());
        return parseList(lines);
    }

    private static Map<String, String> parseList(List<String> lines) {
        Map<String, String> parsed = new HashMap<>();
        for (String line: lines) {
            if (notComment(line) && validKeyValue(line)) {
                int intdexOfEqualSign = line.indexOf("=");
                String key = line.substring(0, intdexOfEqualSign).trim();
                String value = line.substring(intdexOfEqualSign + 1).trim();
                parsed.put(key, value);
            }
        }
        return parsed;
    }

    private static boolean validKeyValue(String line) {
        return line.matches("^( )*a[\\d]+( )*=(( )*(=)?b[\\d]+( )*(#[\\w\\W]*)?)+");
    }

    private static boolean notComment(String line) {
        return !line.startsWith("#");
    }
}
