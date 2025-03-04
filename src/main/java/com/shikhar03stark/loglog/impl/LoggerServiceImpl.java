package com.shikhar03stark.loglog.impl;

import com.shikhar03stark.loglog.LogLevel;
import com.shikhar03stark.loglog.LoggerService;
import com.shikhar03stark.loglog.sinks.SinkFactory;

public class LoggerServiceImpl implements LoggerService {

    private final SinkFactory sinkFactory;
    private LogLevel logLevel;

    public LoggerServiceImpl(SinkFactory sinkFactory, LogLevel logLevel) {
        this.sinkFactory = sinkFactory;
        this.logLevel = logLevel;
    }

    private boolean shouldLog(LogLevel loglevel) {
        return loglevel.getLevel() <= this.logLevel.getLevel(); 
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (shouldLog(logLevel)) {
            sinkFactory.getWriter().write(logLevel, message);
        }
    }

    @Override
    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public LogLevel getLogLevel() {
        return this.logLevel;
    }

}
