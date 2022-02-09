package com.example.Crypto.Reader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@PropertySource("classpath:file.properties")
@Service
public class FileReaderImpl implements FileReader {

    @Value("${crypt.path}")
    String filePath;

    @Override
    public String getText() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)),StandardCharsets.UTF_8);
    }
}
