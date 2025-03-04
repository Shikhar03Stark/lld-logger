package com.shikhar03stark.loglog.sinks.impl;

import com.shikhar03stark.loglog.LogLevel;
import com.shikhar03stark.loglog.sinks.SinkType;
import com.shikhar03stark.loglog.sinks.SinkWriter;

public class DatabaseSinkWriterImpl implements SinkWriter {

    @Override
    public void close() throws Exception {
    }

    @Override
    public SinkType getSinkType() {
        return SinkType.DATABASE;
    }

    @Override
    public void write(LogLevel logLevel, String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'write'");
    }

}
