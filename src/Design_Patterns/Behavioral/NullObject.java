package Design_Patterns.Behavioral;


interface Logger {
    void log(String message);
}

class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

class NullLogger implements Logger {
    public static final NullLogger INSTANCE = new NullLogger();
    private NullLogger() {}
    public void log(String message) {
    }
}

public class NullObject {
    public static void main(String[] args) {

        boolean isLoggingEnabled = true;

        Logger logger = (isLoggingEnabled) 
                    ? new ConsoleLogger() 
                    : NullLogger.INSTANCE;
        
        logger.log("Message");
        isLoggingEnabled = false;

        logger = (isLoggingEnabled) 
                    ? new ConsoleLogger() 
                    : NullLogger.INSTANCE;

        logger.log("Null Message");
    }
}
