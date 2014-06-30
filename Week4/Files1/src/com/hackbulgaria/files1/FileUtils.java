package com.hackbulgaria.files1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileUtils {
    
    public static void main(String[] args) throws IOException {
        emptyFile(new File("lala.txt"));
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
    
    public static void backUpFile(Path source) throws IOException {
        String backUpFileName = getBackUpFileName(source);
        Path target = Paths.get(backUpFileName);
        Files.copy(source, target, StandardCopyOption.COPY_ATTRIBUTES);
    }
    
    public static void emptyFile(File file) throws IOException {
        file.delete();
        file.createNewFile();
    }
    
    public static void emptyFile(Path filePath) throws IOException {
        emptyFile(filePath.toFile());
    }
    
    public static void printBrokenLinks(Path folder) throws IOException {
        for (File entry: folder.toFile().listFiles()) {
            if (entry.isDirectory()) {
                printBrokenLinks(entry.toPath());
            }
            
            else {
                if (isBrokenLink(entry)) {
                    printLink(entry);
                }
            }
        }
    }
    
    public static void compress(Path filePath) throws IOException {
        String text = readFrom(filePath);
        HashMap<String, Integer> indexWords = getIndex(text);
        String compressedContent = getCompressedContent(text, indexWords);
        replaceContent(filePath, compressedContent);
    }
    
    public static void replaceContent(Path filePath, String newContent) throws IOException {
        emptyFile(filePath);
        writeTo(filePath, newContent);
    }
    
    public static boolean isBrokenLink(File entry) throws IOException {
        return (Files.isSymbolicLink(entry.toPath())) && !(Files.readSymbolicLink(entry.toPath()).toFile().exists());
    }
    
    
    private static HashMap<String, Integer> getIndex(String text) {
        String[] words = getWords(text);
        HashMap<String, Integer> wordIndexes = new HashMap<>();
        HashMap<String, Integer> uniqueWords = new HashMap<>();
        for (String word: words) {
            int index;
            if (uniqueWords.containsKey(word.toLowerCase())) {
                index = uniqueWords.get(word.toLowerCase());
            }
            
            else {
                index = uniqueWords.size();
                uniqueWords.put(word.toLowerCase(), index);
            }
            
            wordIndexes.put(word, index);
        }
        
        return wordIndexes;
    }
    
    private static String getCompressedContent(String text, HashMap<String, Integer> indexWords) {
        String[] wordInText = getWords(text);
        for (String word: wordInText) {
            text = text.replaceFirst(word, "~" + indexWords.get(word).toString());
        }
        return text;
    }
    
    private static String[] getWords(String text) {
        return text.split("[.,! ]+");
    }

    private static void printLink(File link) {
        System.out.format("Bad Link: %s%n", link.toString());
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
    
    private static String getBackUpFileName(Path source) {
        String fileName = source.toString();
        StringBuilder backUpFileName = new StringBuilder();
        
        int extIndex = fileName.lastIndexOf('.');
        
        backUpFileName.append(fileName.substring(0, extIndex));
        backUpFileName.append("_backup");
        backUpFileName.append(fileName.substring(extIndex));
        
        return backUpFileName.toString();
    }


}
