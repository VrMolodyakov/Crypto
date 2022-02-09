package MyReader;

import java.io.IOException;

public interface MyFileReader {
    String getText(String path) throws IOException;
}
