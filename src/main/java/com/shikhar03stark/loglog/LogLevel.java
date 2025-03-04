package com.shikhar03stark.loglog;

public enum LogLevel {
    CRITICAL(0),
    ERROR(1),
    WARNING(2),
    INFO(3),
    DEBUG(4),
    TRACE(5);

    private int level;

    LogLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
