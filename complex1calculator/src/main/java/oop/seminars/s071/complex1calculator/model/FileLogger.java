package oop.seminars.s071.complex1calculator.model;
import java.io.IOException;
import java.util.logging.*;
public class FileLogger {
    private Logger logger;

    public FileLogger() {
        logger = Logger.getLogger(FileLogger.class.getName());

        // Remove the default console handler
        logger.setUseParentHandlers(false);

        // Create a file handler
        try {
            FileHandler fileHandler = new FileHandler("logCalculaction.txt", true);
            fileHandler.setLevel(Level.ALL);

            // Create a simple formatter
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            // Add the file handler to the logger
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logEvent(String eventDescription) {
        logger.log(Level.INFO, eventDescription);
    }
}
