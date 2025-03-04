package com.shikhar03stark.loglog.sinks.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.shikhar03stark.loglog.LogLevel;
import com.shikhar03stark.loglog.sinks.SinkType;
import com.shikhar03stark.loglog.sinks.SinkWriter;

public class FileSinkWriterImpl implements SinkWriter {

    private final String filePath;

    public FileSinkWriterImpl(String filePath) {
        this.filePath = filePath;
        if (!isFileExists()) {
            createFile();
        }
        clearFileContent();   
    }

    private void clearFileContent() {
        try {
            Files.write(Paths.get(filePath), "".getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error clearing file content: " + filePath, e);
        }
    }

    private void createFile() {
        try {
            Files.createFile(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error creating file: " + filePath, e);
        }
    }

    private boolean isFileExists() {
        return Files.exists(Paths.get(filePath));
    }

    @Override
    public void close() throws Exception {
        return;
    }

    @Override
    public SinkType getSinkType() {
        return SinkType.FILE;
    }

    @Override
    public void write(LogLevel logLevel, String message) {
        try {
            final String appendMessage = "[" + logLevel + "] " + message + System.lineSeparator();
            Files.write(Paths.get(filePath), appendMessage.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            throw new RuntimeException("Error writing to file: " + filePath, ex);
        }
    }

}
