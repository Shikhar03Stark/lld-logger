package com.shikhar03stark.loglog.sinks.factory;

import java.util.HashMap;
import java.util.Map;

import com.shikhar03stark.loglog.sinks.SinkFactory;
import com.shikhar03stark.loglog.sinks.SinkWriter;
import com.shikhar03stark.loglog.sinks.impl.FileSinkWriterImpl;

public class FileSinkFactory implements SinkFactory {

    private final String filePath;
    private final SinkWriter writer;

    private static Map<String, SinkFactory> sinkFactoryMap = new HashMap<>();

    private FileSinkFactory(String filePath) {
        this.filePath = filePath;
        this.writer = new FileSinkWriterImpl(filePath);
    }

    @Override
    public SinkWriter getWriter() {
        return writer;
    }
    
    public static SinkFactory getInstance(String filePath) {
        if (!sinkFactoryMap.containsKey(filePath)) {
            sinkFactoryMap.put(filePath, new FileSinkFactory(filePath));
        }
        return sinkFactoryMap.get(filePath);
    }

    public String getFilePath() {
        return filePath;
    }
    
}
