import Analyse.Analyzer;
import MyReader.MyFileReader;
import MyReader.MyFileReaderImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //String test = new String("ТАКОГО9СЕРДЕЧНОГО9СМЕХА,9И9ПЕСНИ,9И9ПЛЮСКИ9ТАКОЙ9ЗА9ДЕНЫГИ9НЕ9КУПИШЫ.9\"УТЕХА!\"9-9ТВЕРДЮТ9МУЖИКИ9МЕЖ9СОБОЙ.9В9ИГРЕ9ЕЕ9КОННЪЙ9НЕ9СЛОВИТ,9В9БЕДЕ9НЕ9СРОБЕЕТ9-9СПАСЕТ:9КОНЮ9НА9СКАКУ9ОСТАНОВИТ,9В9ГОРЮ3УЭ9ИЗБУ9ВОЙДЕТ!");
        //System.out.print(test.replace("9"," "));
        Analyzer analyzer = new Analyzer();
        analyzer.setAlphabetPath("alphabet.txt");
        analyzer.setAlphabetList();
        analyzer.getProperlyText();


    }
}
