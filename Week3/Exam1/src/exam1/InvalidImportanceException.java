package exam1;

public class InvalidImportanceException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InvalidImportanceException() {
        super();
    }
    
    public InvalidImportanceException(String message) {
        super(message);
    }
    
    public InvalidImportanceException(String message, Throwable cause) {
        super(message, cause);
    }
}
