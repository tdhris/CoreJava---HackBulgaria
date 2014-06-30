package com.hackbulgaria.files1;

public class NoDirectoryArgumentGiven extends Exception {
    private static final long serialVersionUID = 1L;
    
    NoDirectoryArgumentGiven() {
        super();
    }
    
    NoDirectoryArgumentGiven(String message) {
        super(message);
    }
    
    NoDirectoryArgumentGiven(String message, Throwable cause) {
        super(message, cause);
    }
}
