package exam1;


public class Logger {
    
    public static void main(String[] args) throws InvalidImportanceException {

        // Logger logger = new Logger();
        Logger logger = new DateLogger();

        logger.log(2, "Somewhat important message");
        logger.log(3, "Less important message");
        logger.log(5, "Not important");
        logger.log("Meh");

        logger.setLevel(2);
        logger.log("My message");

        logger.setLevel(3);
        logger.log("My message");

        logger.log("");
    }

    protected int level;
    protected static final int DEFAULT_LEVEL = 3;
    
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
    
    public void log(int level, String message) throws InvalidImportanceException {
        if (level < 0) {
            throw new InvalidImportanceException("Negative Importance Level: " + level);
        }

        else if (isImportant(level)) {
            print(level, message);
        }
    }
    
    public void log(String message) throws InvalidImportanceException {
        this.log(DEFAULT_LEVEL, message);
    }

    protected boolean isImportant(int messageLevel) {
        return messageLevel <= this.level;
    }
    
    protected void print(int levelMessage, String message) {
        System.out.println(String.format("%d => %s", levelMessage, message));
    }
    
}
