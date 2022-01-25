package com.mikola.handler.reader;

import com.mikola.handler.exception.InformationHandlingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public String read(String filePath) throws InformationHandlingException {
        if (filePath == null || filePath.isEmpty()) {
            throw new InformationHandlingException("File path is empty or null");
        }
        StringBuilder text = new StringBuilder();
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);
            lines.forEach(line -> text.append(line).append('\n'));
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("Reading from file is successfully");
        return text.toString().trim();
    }
}
