package com.shikhar03stark.loglog;

public interface LoggerService {
    void log(LogLevel logLevel, String message);
    void setLogLevel(LogLevel logLevel);
    LogLevel getLogLevel();
}
