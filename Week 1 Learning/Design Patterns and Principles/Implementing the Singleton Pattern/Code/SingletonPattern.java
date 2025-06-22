// Filename: SingletonPattern.java

class Logger {
    // Step 2: Private static instance
    private static volatile Logger instance = null;

    // Step 2: Private constructor
    private Logger() {
        System.out.println("Logger Initialized");
    }

    // Step 2 & 3: Public method to get the instance with double-checked locking for
    // thread safety
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same.");
        } else {
            System.out.println("Different logger instances exist.");
        }
    }
}
