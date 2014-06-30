package com.hackbulgaria.files1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class WordCountResult {
    
    public static int wordCount(Path path) throws IOException {
        String text = FileUtils.readFrom(path);
        String[] wordsInText = text.split(" ");
        return wordsInText.length;
    }
    
    public static int wordCount(File file) throws IOException {
        return wordCount(file.toPath());
    }
    
    public static int getLineCount(File file) throws IOException {
        return FileUtils.getLines(file.toPath()).size();
    }
    
    public static int getCharacterCount(File file) throws FileNotFoundException, IOException {
        String text = FileUtils.readFrom(file);
        char[] charactersInText = text.toCharArray();
        return charactersInText.length;
    }
}
