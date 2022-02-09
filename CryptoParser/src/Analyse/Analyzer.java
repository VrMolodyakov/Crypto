package Analyse;

import MyReader.MyFileReader;
import MyReader.MyFileReaderImpl;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import java.util.stream.Collectors;

public class Analyzer {
    private List<Character> alphabetList = new LinkedList<>();
    private String path;
    private MyFileReader fileReader = new MyFileReaderImpl();

    public void setAlphabetPath(String path){
        this.path = path;
    }

    public void setAlphabetList() throws IOException {

        String testing = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8).
                replaceAll("(\\r\\n){2}", " " ).
                replaceAll("(\\r\\n){1}", "");
        alphabetList = testing.chars().mapToObj(i -> (char)i).collect(Collectors.toList());


    }

    public void printList(){
        alphabetList.stream().forEachOrdered(i -> System.out.println(i));
    }

    private LinkedList<Character> getTextAsArray(String text){
        return text.chars()
                .mapToObj(i -> (char)i)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public String getProperlyText() throws IOException {

        String text = fileReader.getText("crypt.txt");
        List<Character> characters = new LinkedList<>();

        PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
        int k = 1;
        int index ;

        while(k<alphabetList.size()) {
            characters =  text.chars().mapToObj(i -> (char)i).collect(Collectors.toCollection(LinkedList::new));
            for(int i = 0 ; i < characters.size();++i){
                index = alphabetList.indexOf(characters.get(i));

                index = k + index;
                if (index >= alphabetList.size())
                    index = index - alphabetList.size();
                characters.set(i, alphabetList.get(index));
            }
            writer.print(k + " = ");
            for (Character e : characters) {
                writer.print(e);
            }
            writer.print("\r\n");
            writer.print("\r\n");

            ++k;

        }
        writer.close();
        return null;
    }
}

