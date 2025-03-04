package com.shikhar03stark.loglog.sinks;

import com.shikhar03stark.loglog.LogLevel;

public interface SinkWriter extends AutoCloseable {
    SinkType getSinkType();
    void write(LogLevel logLevel, String message);
}
