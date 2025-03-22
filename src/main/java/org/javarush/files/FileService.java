package org.javarush.files;


public class FileService {
    private final FileReadered fileReadered;
    private final FileWritered fileWritered;

    public FileService() {
        this.fileReadered = new FileReadered();
        this.fileWritered = new FileWritered();
    }
    public String readDataFromFile(String filePath) {
        return fileReadered.readDataFromFile(filePath);
    }
    public void writeToFile(String filePath, String content) {
        fileWritered.writeToFile(filePath, content);
    }
}




