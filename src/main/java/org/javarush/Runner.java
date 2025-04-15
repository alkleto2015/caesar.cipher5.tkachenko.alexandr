package org.javarush;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        if (args.length == 2 || args.length == 3) {
            String command = args[0];
            String filePath = args[1];
            int key = 0;
            if (args.length == 3) {
                try {
                    key = Integer.parseInt(args[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid key format. Please enter an integer.");
                    return;
                }
            }

            CaesarCipher cipher = new CaesarCipher();
            try {
                String comingFileWithContents = new String(Files.readAllBytes(Paths.get(filePath)));  // читаем содержимое файла
                if ("ENCRYPT".equalsIgnoreCase(command)) {
                    String encryptData = cipher.encryptData(comingFileWithContents, key);
                    System.out.println("Encrypt data:\n" + encryptData);
                } else if ("DECRYPT".equalsIgnoreCase(command)) {
                    String decryptData = cipher.decryptData(comingFileWithContents, key);
                    System.out.println("Decrypt data:\n" + decryptData);
                } else if ("BRUTEFORCE".equalsIgnoreCase(command)) {
                    cipher.bruteForceDecrypt(comingFileWithContents);
                } else if ("ENCRYPT_UA".equalsIgnoreCase(command)) {
                    UkrainianCaesarCipher uaCipher = new UkrainianCaesarCipher();
                    String result = uaCipher.encryptData(comingFileWithContents , key);
                    System.out.println("Encrypt data:\n" + result);
                } else if ("DECRYPT_UA".equalsIgnoreCase(command)) {
                    UkrainianCaesarCipher uaCipher = new UkrainianCaesarCipher();
                    String result = uaCipher.decryptData(comingFileWithContents, key);
                    System.out.println("Decrypt data:\n" + result);
                } else if ("BRUTEFORCE_UA".equalsIgnoreCase(command)) {
                    UkrainianCaesarCipher uaCipher = new UkrainianCaesarCipher();
                    uaCipher.bruteForceDecrypt(comingFileWithContents);

                } else {
                    System.out.println("Unknown command: " + command);
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            new CLI().workWithCLI();
        }

    }
}








