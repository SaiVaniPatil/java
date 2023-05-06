package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FP05Files {


    public static void main(String[] args) throws IOException {

        Files.lines(Paths.get("src/filestest.txt")).forEach(System.out::println);;
        

      //  Files.lines(Paths.get("src/filestest.txt")).forEach(System.out::println);;
        
    }
    
    
}
