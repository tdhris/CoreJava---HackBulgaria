package com.hackbulgaria.files1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;

public class EncodingFixer {    
    public static void fixEncoding(Path path) throws IOException {
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        
        byte[] textInBytes = getBytes(path);
        byte[] decodedText = decode(textInBytes, windows1251, utf8);  
        
        FileUtils.emptyFile(path.toFile());
        FileOutputStream outputStream = new FileOutputStream(path.toFile());
        outputStream.write(decodedText);
        outputStream.close();
    }

    private static byte[] decode(byte[] textInBytes, Charset from, Charset to) {
        ByteBuffer inputBuffer = ByteBuffer.wrap(textInBytes);
        CharBuffer decoded = from.decode(inputBuffer);
        ByteBuffer output = to.encode(decoded);
        return output.array();
    }

    private static byte[] getBytes(Path path) throws IOException {
        ArrayList<Integer> bytes = new ArrayList<>();
        FileInputStream input = new FileInputStream(path.toFile());
        int b;
        while ((b = input.read()) != -1) {
            bytes.add(b);
        }
        
       input.close();
       
       byte[] data = new byte[bytes.size()];
       for (int i = 0; i < data.length; i++) {
           data[i] = bytes.get(i).byteValue();
       }
       return data;
    }
}