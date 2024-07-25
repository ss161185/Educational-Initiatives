//Chain of Responsibility Pattern
//Use Case: Handling different levels of logging.

// Handler interface
abstract class Logger {
    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}

// Concrete handlers
class InfoLogger extends Logger {
    public InfoLogger(int level) {
        this.level = level;
    }

    protected void write(String message) {
        System.out.println("InfoLogger: " + message);
    }
}

class ErrorLogger extends Logger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    protected void write(String message) {
        System.out.println("ErrorLogger: " + message);
    }
}