package com.shikhar03stark.loglog.sinks.impl;

import com.shikhar03stark.loglog.LogLevel;
import com.shikhar03stark.loglog.sinks.SinkType;
import com.shikhar03stark.loglog.sinks.SinkWriter;

public class ConsoleSinkWriterImpl implements SinkWriter {

    @Override
    public void close() throws Exception {
    }

    @Override
    public SinkType getSinkType() {
        return SinkType.CONSOLE;
    }

    @Override
    public void write(LogLevel logLevel, String message) {
        final String writeMessage = "[" + logLevel + "] " + message;
        System.out.println(writeMessage);
    }

}
