package com.hackbulgaria.files1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFileUtils {
    File myFile;
    File propertiesFile;

    @Before
    public void setUp() throws Exception {
        String fileName = "myFile.txt";
        this.myFile = new File(fileName);
        this.myFile.createNewFile();
        
        String propertiesFileName = "test.properties";
        this.propertiesFile = new File(propertiesFileName);
        this.propertiesFile.createNewFile();
    }

    @Test
    public void testWriteAndReadASingleLine() throws IOException {
        String content = "If a book about failures doesn't sell, is it a success?";
        FileUtils.writeTo(myFile, content);
        String readFile = FileUtils.readFrom(myFile);
        String readPath = FileUtils.readFrom(myFile.toPath());
        assertEquals(content, readFile);
        assertEquals(content, readPath);
    }
    
    @Test
    public void testWriteAndReadMultipleLines() throws IOException {
        String content = "'I hope you're thirsty.'\n'Why?'\n'Cause your dumb and ugly, but I can do something about thirsty.'";
        FileUtils.writeTo(myFile, content);
        String read = FileUtils.readFrom(myFile);
        String readPath = FileUtils.readFrom(myFile.toPath());
        assertEquals(content, read);
        assertEquals(content, readPath);
    }
    
    @Test
    public void testProperties() throws IOException {
        String content = "# this=comment\na1=b1\na2 =b2\n\na3    =    b3\na4 = b4\na5=b6=b7=b8\na6=b9 #comment\n a7==b10";
        FileUtils.writeTo(propertiesFile, content);
        Map<String, String> partedProperties = FileUtils.parseProperties(propertiesFile);
        assertEquals("b1", partedProperties.get("a1"));
        assertEquals("b6=b7=b8", partedProperties.get("a5"));
        assertEquals("b9 #comment", partedProperties.get("a6"));
        assertEquals("=b10", partedProperties.get("a7"));
        assertEquals("b3", partedProperties.get("a3"));
    }
    
    @Test
    public void testParseList() throws IOException {
        FileUtils.writeTo(myFile, "a1=b1\na2==b2 #comment\na3=b3");
        Map<String, String> parted = FileUtils.parseProperties(myFile);
        assertEquals("b1", parted.get("a1"));
        assertEquals("=b2 #comment", parted.get("a2"));
        assertEquals("b3", parted.get("a3"));
    }
    
    @After
    public void tearDown() {
        this.myFile.delete();
        this.propertiesFile.delete();
    }

}
