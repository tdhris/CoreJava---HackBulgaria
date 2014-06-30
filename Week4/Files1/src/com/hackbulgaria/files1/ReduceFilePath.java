package com.hackbulgaria.files1;

import java.nio.file.Paths;

public class ReduceFilePath {
    public static String reduce(String path) {
        return Paths.get(path).normalize().toString();
    }
}
