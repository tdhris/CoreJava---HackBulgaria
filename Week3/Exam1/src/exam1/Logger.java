package exam1;


public class Logger {
    private int level;
    private static final int DEFAULT_LEVEL = 3;
    
    public Logger() {
        this.level = DEFAULT_LEVEL;
    }
    
    public Logger(int level) {
        this.level = level;
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public void setLevel(int newLevel) {
        this.level = newLevel;
    }
    
    public void log(int level, String message) {
        if (isImportant(level)) {
            print(message);
        }
    }
    
    public void log(String message) {
        this.log(DEFAULT_LEVEL, message);
    }

    protected boolean isImportant(int messageLevel) {
        return messageLevel > 0 && messageLevel <= this.level;
    }
    
    protected void print(String message) {
        System.out.println(message);
    }
    
}
