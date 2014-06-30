package com.hackbulgaria.files1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DuplicatesFinder {
    public static void main(String[] args) throws NoDirectoryArgumentGiven, FileNotFoundException, NoSuchAlgorithmException, IOException {
        if (! containsDirectoryArguments(args)) {
            throw new NoDirectoryArgumentGiven("No Files Found In: " + args.toString());
        }
        
        Path folder = Paths.get(args[0]);
        printDuplicates(folder);
    }
    

    private static void printDuplicates(Path folder) throws FileNotFoundException, NoSuchAlgorithmException, IOException {
        HashMap<Integer, ArrayList<String>> duplicateGroups = getDuplicates(folder);
        for (Integer groupKey: duplicateGroups.keySet()) {
            printDuplicateGroup(duplicateGroups.get(groupKey));
            printTwoLines();
        }
        printReport(duplicateGroups);
    }


    private static void printDuplicateGroup(ArrayList<String> duplicateGroup) {
        for (String duplicateFile: duplicateGroup) {
            System.out.println(Paths.get(duplicateFile));
        }
    }


    private static HashMap<Integer, ArrayList<String>> getDuplicates(Path folder) throws FileNotFoundException, NoSuchAlgorithmException, IOException {
        return getDuplicates(folder.toFile());
    }


    private static HashMap<Integer, ArrayList<String>> getDuplicates(File folder) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
        HashMap<Integer, ArrayList<String>> duplicates = new HashMap<>();
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(folder.toPath())) {
            for (Path child: dirStream) {
                if (child.toFile().isDirectory()) {
                    duplicates.putAll(getDuplicates(child));
                }
                
                else if (FileUtils.isBrokenLink(child.toFile())) {
                    continue;
                }
                
                else if (Files.isRegularFile(child, LinkOption.values())){
                    try (FileInputStream inputStream = new FileInputStream(child.toFile())) {
                        byte[] content = new byte[(int) child.toFile().length()];
                        inputStream.read(content);
                        Integer hashCode = Arrays.hashCode(content);
                        String path = child.toString();
                        
                        ArrayList<String> sameFiles;
                        if (duplicates.containsKey(hashCode)) {
                            sameFiles = duplicates.get(hashCode);
                            sameFiles.add(path);
                        }
                        
                        else {
                            sameFiles = new ArrayList<>(Arrays.asList(path));
                        }
                        
                        duplicates.put(hashCode, sameFiles);
                    }
                }
            }
        }
        
        return duplicates;
    }


    private static void printReport(HashMap<Integer, ArrayList<String>> duplicateGroups) {
        int numberGroups = duplicateGroups.size();
        int numberFilesCanBeDeleted = 0;
        long diskSpaceToFree = 0;
        for (ArrayList<String> group: duplicateGroups.values()) {
            numberFilesCanBeDeleted += (group.size() - 1);
            String firstFile = group.get(0);
            diskSpaceToFree = numberFilesCanBeDeleted * getDiskSpace(Paths.get(firstFile));
        }
        
        System.out.format("%d groups of duplications found.", numberGroups);
        System.out.println();
        System.out.format("A total of %d duplicate files can be deleted, freeing up %d disk space", numberFilesCanBeDeleted, diskSpaceToFree);
    }
    

    private static long getDiskSpace(Path path) {
        return path.toFile().getTotalSpace();
    }
    
    private static void printTwoLines() {
        System.out.println("\n");
    }


    private static boolean containsDirectoryArguments(String[] args) {
        if (args.length < 1) {
            return false;
        }
        
        return (Paths.get(args[0]).toFile().isDirectory());
    }
}
