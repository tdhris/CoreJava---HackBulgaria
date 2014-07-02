package com.hackbulgaria.pairprogramming;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import javax.imageio.ImageIO;

public class ASCIIViewer {
    private final BufferedImage image;
    private final int timesToRescale;
    private final LinkedHashMap<Integer, Character> asciiIntensityTable;
    
    public ASCIIViewer(File imageFile, int consolePixelSize) throws IOException {
        image = ImageIO.read(imageFile);
        timesToRescale = getResclaeQuotient(consolePixelSize);
        asciiIntensityTable = getASCIIIntensityTable();
    }

    public static void main (String[] args) throws IOException {
        File imageFile = new File(args[0]);
        int consolePixels = Integer.parseInt(args[1]);
        if (imageFile.isFile()) {
            ASCIIViewer viewer = new ASCIIViewer(imageFile, consolePixels);
            viewer.printASCIIArt();
        }
    }

    private void printASCIIArt() throws IOException {
        String asciiImage = getASCIIImage();
        System.out.println(asciiImage);
    }

    private String getASCIIImage() {
        StringBuilder asciiImage = new StringBuilder();
   
        for (int i = 0; i < image.getHeight(); i += timesToRescale) {
            
            StringBuilder row = new StringBuilder();            
            for (int j = 0; j < image.getWidth(); j += timesToRescale) {
                
                int blockIntensity = getBlockIntensity(i, j);
                String symbol = translateToASCII(blockIntensity);
                row.append(symbol);
            }

            asciiImage.append(row.toString());
            asciiImage.append("\n");
        }
        
        return asciiImage.toString();
    }
    
    private int getBlockIntensity(int i, int j) {
        int average = 0;
        for (int x = i; x < i + timesToRescale; x++) {
            for (int y = j; y < j + timesToRescale; y++) {
                if (inBounds(x, y)) {
                    Color color = new Color(image.getRGB(y, x));
                    average += getPixelIntensity(color);
                }
            }
        }
        
        return average / (timesToRescale * timesToRescale);
    }

    private int getPixelIntensity(Color color) {
        return ( color.getBlue() + color.getGreen() + color.getRed() ) / 3;
    }

    private boolean inBounds(int x, int y) {
        boolean xIn = x >= 0 && x < image.getHeight();
        boolean yIn = y >= 0 && y < image.getWidth();
        return xIn && yIn;
    }
    
    
    private LinkedHashMap<Integer, Character> getASCIIIntensityTable() {
        LinkedHashMap<Integer, Character> intensityTable = new LinkedHashMap<>();
        String asciiSymbols = "@%#*+=-:. ";
        int step = (255 / asciiSymbols.length()) + 2;
        int upperBound = step;
        for (int i = 0; i < asciiSymbols.length(); i++) {
            intensityTable.put(upperBound, asciiSymbols.charAt(i));
            upperBound += step;
        }
        return intensityTable;
    }

    
    private String translateToASCII(int pixelIntensity) {
        String symbol = null;
        for (Integer uppedBound: asciiIntensityTable.keySet()) {
            if (pixelIntensity < uppedBound) {
                symbol = asciiIntensityTable.get(uppedBound).toString();
                break;
            }
        }
        return symbol;
    }

    
    private int getResclaeQuotient(int consolePixelSize) {
        int quotient = image.getWidth() / consolePixelSize;
        if (quotient < 1) {
            return 1;
        }
        
        return quotient;
    }
}
