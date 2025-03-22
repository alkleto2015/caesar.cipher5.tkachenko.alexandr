package org.javarush;
import org.javarush.files.FileService;
import java.util.Scanner;

class CLI {
    private final Scanner console;
    private final CaesarCipher cipher;
    private final UkrainianCaesarCipher uaCipher;
    public final FileService fileService;

     public CLI() {
        this.console = new Scanner(System.in);
        this.cipher = new CaesarCipher();
        this.uaCipher = new UkrainianCaesarCipher();
        this.fileService = new FileService();
    }
    public void workWithCLI() {
        while (true) {
            System.out.println("SELECT THE OPERATION NUMBER AND ENTER IT:");
            System.out.println("1 - ENCRYPT");
            System.out.println("2 - DECRYPT");
            System.out.println("3 - BRUTEFORCE");
            System.out.println("4 - TO WORK CORRECTLY, PRESS - 4, RESTART THE CLASS");
            System.out.println("5 - ENCRYPT (UKRAINIAN)");
            System.out.println("6 - DECRYPT (UKRAINIAN)");
            System.out.println("7 - BRUTEFORCE (UKRAINIAN)");
            System.out.println("8 - PLEASE PRESS - 8, EXIT");
            String choice = console.nextLine();
            switch (choice) {
                case "1":
                    handleEncryption();
                    break;
                case "2":
                    handleDecryption();
                    break;
                case "3":
                    handleBruteForce();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                case "5" :
                    handleEncryptionUA();
                    break;
                case "6":
                    handleDecryptionUA();
                    break;
                case "7":
                    handleBruteForceUA();
                    break;
                case "8":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
    private void handleEncryption() {
        System.out.println("ENTER THE FILE PATH TO ENCRYPT:");
        System.out.println("EXTRA HELP : FILE PATH TO DECRYPT == C:\\Users\\setusers\\javarush\\caesar.cipher5v.tkachenko.alexandr\\test");
        String filePath = console.nextLine();
        System.out.println("ENTER THE ENCRYPTION KEY:");
        int key = Integer.parseInt(console.nextLine());
        String fileData = fileService.readDataFromFile(filePath);
        String encryptedData = cipher.encryptData(fileData, key);
        fileService.writeToFile(filePath + ".encrypted", encryptedData);
        System.out.println("Encryption complete. SAVED AS: " + filePath + ".encrypted");
        System.out.println(encryptedData);  // не обязательно к выполнению,но работает как индикатор:- если текст отобразился на экране-то корректная работа,правильный путь и правильная папка. если нет- значит ошибка в пути и папку придется искать на диске;
    }
    private void handleDecryption() {
        System.out.println("ENTER THE FILE PATH TO DECRYPT:");
        String filePath = console.nextLine();
        System.out.println("ENTER THE ENCRYPTION KEY:");
        int key = Integer.parseInt(console.nextLine());
        String fileData = fileService.readDataFromFile(filePath);
        String decryptedData = cipher.decryptData(fileData, key);
        fileService.writeToFile(filePath + ".decrypted", decryptedData);
        System.out.println("Decryption complete. SAVED AS : " + filePath + ".decrypted");
        System.out.println(decryptedData);   // не обязательно к выполнению,(дополнит.индикатор)-если текст отобразился на экране,значит правильный путь,правильная папка,без конфликтов,работает корректно;
    }
    private void handleBruteForce() {
        System.out.println("ENTER THE FILE PATH TO BRUTEFORCE DECRYPT :");
        String filePath = console.nextLine();
        String fileData = fileService.readDataFromFile(filePath);
        cipher.bruteForceDecrypt(fileData);
    }

    private void handleEncryptionUA() {
        System.out.println("ENTER THE FILE PATH TO ENCRYPT (UKRAINIAN):");
        System.out.println("EXTRA HELP : FILE PATH TO DECRYPT == C:\\Users\\setusers\\javarush\\caesar.cipher5v.tkachenko.alexandr\\test");
        String filePath = console.nextLine();
        System.out.println("ENTER THE ENCRYPTION KEY:");
        int key = Integer.parseInt(console.nextLine());
        String fileData = fileService.readDataFromFile(filePath);
        String encryptedData = uaCipher.encryptData(fileData, key);
        fileService.writeToFile(filePath + ".ua_encrypted", encryptedData);
        System.out.println("Encryption complete. SAVED AS: " + filePath + ".ua_encrypted");
        System.out.println(encryptedData);   // не обязательно к выполнению,(дополнит.индикатор):- если текст отобразился на экране,значит правильный путь,правильная папка,без конфликтов, работает корректно;
    }
    private void handleDecryptionUA() {
        System.out.println("ENTER THE FILE PATH TO DECRYPT (UKRAINIAN):");
        String filePath = console.nextLine();
        System.out.println("ENTER THE ENCRYPTION KEY:");
        int key = Integer.parseInt(console.nextLine());
        String fileData = fileService.readDataFromFile(filePath);
        String decryptedData = uaCipher.decryptData(fileData, key);
        fileService.writeToFile(filePath + ".ua_decrypted", decryptedData);
        System.out.println("Decryption complete. SAVED AS: " + filePath + ".ua_decrypted");
        System.out.println(decryptedData);    // не обязательно к выполнению,(дополнит.индикатор):- если текст отобразился на экране,значит правильный путь,правильная папка,без конфликтов, работает корректно;
    }
    private void handleBruteForceUA() {
        System.out.println("ENTER THE FILE PATH TO BRUTEFORCE DECRYPT (UKRAINIAN):");
        String filePath = console.nextLine();
        String fileData = fileService.readDataFromFile(filePath);
        uaCipher.bruteForceDecrypt(fileData);
    }
}






