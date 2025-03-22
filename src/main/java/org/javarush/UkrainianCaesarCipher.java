package org.javarush;

public class UkrainianCaesarCipher {       // Украинский алфавит (без учёта символов, не являющихся буквами)
    private static final String ALPHABET = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    private static final int ALPHABET_SIZE = 33; //ALPHABET.length(); // 33 букви

    public String encryptData(String comingFileWithContents, int key) {
        StringBuffer encryptedResult = new StringBuffer();
        key = (key % ALPHABET_SIZE);
        for (int counter = 0; counter < comingFileWithContents.length(); counter++) {
            char charOfSymbolOriginal = comingFileWithContents.charAt(counter);
            char upperChar = Character.toUpperCase(charOfSymbolOriginal);
            int index = ALPHABET.indexOf(upperChar);
            if (index != -1) {
                int newIndex = (index + key + ALPHABET_SIZE) % ALPHABET_SIZE;
                char newChar = ALPHABET.charAt(newIndex);
                // Сохраняем регистр символа
                if (Character.isLowerCase(charOfSymbolOriginal)) {
                    newChar = Character.toLowerCase(newChar);
                }
                encryptedResult.append(newChar);
            } else {
                // Если символ не найден в алфавите, оставляем его без изменений
                encryptedResult.append(charOfSymbolOriginal);
            }
        }
        return encryptedResult.toString();
    }
    public String decryptData(String comingFileWithContents, int key) {
        StringBuffer decryptedResult = new StringBuffer();
        key = (key % ALPHABET_SIZE);
        for (int counter = 0; counter < comingFileWithContents.length(); counter++) {
            char charOfSymbolOriginal = comingFileWithContents.charAt(counter);
            char upperChar = Character.toUpperCase(charOfSymbolOriginal);
            int index = ALPHABET.indexOf(upperChar);
            if (index != -1) {
                int newIndex = (index - key + ALPHABET_SIZE) % ALPHABET_SIZE;
                char newChar = ALPHABET.charAt(newIndex);
                // Сохраняем регистр символа
                if (Character.isLowerCase(charOfSymbolOriginal)) {
                    newChar = Character.toLowerCase(newChar);
                }
                decryptedResult.append(newChar);
            } else {
                decryptedResult.append(charOfSymbolOriginal);
            }
        }
        return decryptedResult.toString();
    }
    public void bruteForceDecrypt(String comingFileWithContents) {
        System.out.println("Возможные варианты расшифровки:");
        for (int key = 1; key < ALPHABET_SIZE; key++) {
            String possibleDecryption = decryptData(comingFileWithContents, key);
            System.out.println("Ключ " + key + ": " + possibleDecryption);
        }
    }
}





