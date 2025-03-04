package com.shikhar03stark;

import com.shikhar03stark.loglog.LogLevel;
import com.shikhar03stark.loglog.LoggerService;
import com.shikhar03stark.loglog.impl.LoggerServiceImpl;
import com.shikhar03stark.loglog.sinks.SinkFactory;
import com.shikhar03stark.loglog.sinks.factory.ConsoleSinkFactory;
import com.shikhar03stark.loglog.sinks.factory.FileSinkFactory;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        final SinkFactory sinkFactory = ConsoleSinkFactory.getInstance();
        final LoggerService consoleLogger = new LoggerServiceImpl(sinkFactory, LogLevel.INFO);
        consoleLogger.log(LogLevel.INFO, "Hello World!");
        consoleLogger.log(LogLevel.ERROR, "Some error log");
        consoleLogger.log(LogLevel.TRACE, "Some trace log");

        consoleLogger.setLogLevel(LogLevel.DEBUG);
        consoleLogger.log(LogLevel.INFO, "Hello World!");
        consoleLogger.log(LogLevel.DEBUG, "Debug service");

        final SinkFactory fileSinkFactory = FileSinkFactory.getInstance("temp.log");
        final LoggerService fileLogger = new LoggerServiceImpl(fileSinkFactory, LogLevel.INFO);
        fileLogger.log(LogLevel.INFO, "Hello World!");
        fileLogger.log(LogLevel.ERROR, "Some error log");
        fileLogger.log(LogLevel.TRACE, "Some trace log");

        fileLogger.setLogLevel(LogLevel.DEBUG);
        fileLogger.log(LogLevel.INFO, "Hello World!");
        fileLogger.log(LogLevel.DEBUG, "Debug service");
        
    }
}
