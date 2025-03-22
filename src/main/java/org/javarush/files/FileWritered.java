package org.javarush.files;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWritered {
    public void writeToFile(String filePath, String content) {
        try {
            Files.write(Paths.get(filePath), content.getBytes());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}





