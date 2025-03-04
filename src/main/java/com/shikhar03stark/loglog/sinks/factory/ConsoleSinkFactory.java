package com.shikhar03stark.loglog.sinks.factory;

import com.shikhar03stark.loglog.sinks.SinkFactory;
import com.shikhar03stark.loglog.sinks.SinkWriter;
import com.shikhar03stark.loglog.sinks.impl.ConsoleSinkWriterImpl;

public class ConsoleSinkFactory implements SinkFactory {

    private static SinkFactory sinkFactory;

    @Override
    public SinkWriter getWriter() {
        return new ConsoleSinkWriterImpl();
    }


    private ConsoleSinkFactory() {
    }

    public static SinkFactory getInstance() {
        if (sinkFactory == null) {
            sinkFactory = new ConsoleSinkFactory();
        }
        return sinkFactory;
    }

    
}
