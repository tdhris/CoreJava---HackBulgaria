package exam1;


public class Logger {
    protected int level;
    protected static final int DEFAULT_LEVEL = 3;
    
    public Logger() {
        this.level = DEFAULT_LEVEL;
    }
    
    public Logger(int level) throws InvalidLevelException {
        if (validLevel(level)) {
            this.level = level;
        }
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public void setLevel(int newLevel) throws InvalidLevelException {
        if (validLevel(newLevel)) {
            this.level = newLevel;
        }
    }
    
    public void log(int level, String message) throws InvalidLevelException {
        if (validLevel(level) && isImportant(level)) {
            print(level, message);
        }
    }
    
    public void log(String message) throws InvalidLevelException {
        this.log(DEFAULT_LEVEL, message);
    }

    protected boolean isImportant(int messageLevel) {
        return messageLevel <= this.level;
    }
    
    protected void print(int levelMessage, String message) {
        System.out.println(String.format("%d => %s", levelMessage, message));
    }
    
    protected boolean validLevel(int level) throws InvalidLevelException {
        if (level < 0) {
            throw new InvalidLevelException("Negative Level: " + level);
        }
        return true;
    }
    
}
