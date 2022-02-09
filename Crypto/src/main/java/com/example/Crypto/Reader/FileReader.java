package com.example.Crypto.Reader;

import java.io.IOException;
import java.nio.file.Path;

public interface FileReader {
    String getText() throws IOException;
}
