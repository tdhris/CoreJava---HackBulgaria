package com.hackbulgaria.pairprogramming;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ASCIIViewer {
    public static void main (String[] args) throws IOException {
        File imageFile = new File(args[0]);
        if (imageFile.isFile()) {
            printASCIIArt(new File(args[0]));
        }
    }

    private static void printASCIIArt(File imageFile) throws IOException {
        BufferedImage image = ImageIO.read(imageFile);
        String[] asciiImage = getASCIIImage(image);
        for (String row: asciiImage)  {
            System.out.println(row);
        }
    }

    private static String[] getASCIIImage(BufferedImage image) {
        String[] asciiImage = new String[image.getHeight()];
        for (int i = 0; i < image.getHeight(); i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < image.getWidth(); j++) {
                Color pixelColor = new Color(image.getRGB(j, i), false);
                int pixelIntensity = getPixelIntensity(pixelColor);
                String symbol = translateToASCII(pixelIntensity);
                row.append(symbol);
            }
            asciiImage[i] = row.toString();
        }
        
        return asciiImage;
    }

    private static String translateToASCII(int pixelIntensity) {
        String symbol;
        if (pixelIntensity > 240) {
            symbol = " ";
        }
        
        else if (pixelIntensity > 200 && pixelIntensity <= 240) {
            symbol = ".";
        }
        
        else if (pixelIntensity > 160 && pixelIntensity <= 200) {
            symbol = "*";
        }
        
        else if (pixelIntensity > 100 && pixelIntensity <= 160) {
            symbol = "+";
        }
        
        else if (pixelIntensity > 60 && pixelIntensity <= 100) {
            symbol = "#";
        }
        
        else  {
            symbol = "@";
        }
        
        return symbol;
    }

    private static int getPixelIntensity(Color color) {
        return ( color.getBlue() + color.getGreen() + color.getRed() ) / 3;
    }

}
