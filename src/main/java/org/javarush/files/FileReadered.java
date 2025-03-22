package org.javarush.files;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReadered {                 // будет читать значення з файлов.буде повертати або коллекцию,або массив.або файл,
    public String readDataFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return "";
        }
    }
}



