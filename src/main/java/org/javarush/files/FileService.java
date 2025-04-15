package org.javarush.files;

public class FileService {
    private final FileReader fileReadered;
    private final FileWriter fileWritered;

    public FileService() {
        this.fileReadered = new FileReader();
        this.fileWritered = new FileWriter();
    }
    String readDataFromFile(String filePath) {
        return fileReadered.readDataFromFile(filePath);
    }
    public void writeToFile(String filePath, String content) {
        fileWritered.writeToFile(filePath, content);
    }
}




