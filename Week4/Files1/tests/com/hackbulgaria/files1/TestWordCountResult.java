package com.hackbulgaria.files1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWordCountResult {
    private File file;

    @Before
    public void setUp() throws Exception {
        this.file = new File("myfile.txt");
        this.file.createNewFile();
    }

    @After
    public void tearDown() throws Exception {
        this.file.delete();
    }

    @Test
    public void testWordCountWithASingleLine() throws IOException {
        String line = "The moment you doubt whether you can fly, you cease for ever to be able to do it.";
        int correctWordCount = 18;
        FileUtils.writeTo(file, line);
        
        int wordCountResult = WordCountResult.wordCount(file.toPath());
        assertEquals(correctWordCount, wordCountResult);
    }
    
    @Test
    public void testWordCountWithMultipleLines() throws IOException {
        String text = "It's the questions we can't answer that teach us the most.\nThey teach us how to think.\nIf you give a man an answer, all he gains is a little fact.\nBut give him a question and he'll look for his own answers.";
        int correctWordCount = text.split(" ").length;
        FileUtils.writeTo(file, text);
        
        int wordCountResult = WordCountResult.wordCount(file.toPath());
        assertEquals(correctWordCount, wordCountResult);
        
    }
    
    @Test
    public void testLineCount() throws IOException {
        String text = "Words are pale shadows of forgotten names.\nAs names have power, words have power.\nWords can light fires in the minds of men.\nWords can wring tears from the hardest hearts.";
        int correctLineCount = 4;
        FileUtils.writeTo(file, text);
        
        int lineCount = WordCountResult.getLineCount(file);
        assertEquals(correctLineCount, lineCount);
    }
    
    @Test
    public void testCharacterCount() throws IOException {
        String text = "We understand how dangerous a mask can be. We all become what we pretend to be.";
        int correctCharCount = 79;
        FileUtils.writeTo(file, text);
        
        int charCount = WordCountResult.getCharacterCount(file);
        assertEquals(correctCharCount, charCount);
    }

}
