package exam1;

public class InvalidLevelException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InvalidLevelException() {
        super();
    }
    
    public InvalidLevelException(String message) {
        super(message);
    }
    
    public InvalidLevelException(String message, Throwable cause) {
        super(message, cause);
    }
}
