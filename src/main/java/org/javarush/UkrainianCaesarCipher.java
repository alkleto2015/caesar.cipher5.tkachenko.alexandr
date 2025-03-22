package org.javarush;
class UkrainianCaesarCipher {       // Украинский алфавит (без учёта символов, не являющихся буквами)
    private static final String ALPHABET = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    private static final int ALPHABET_SIZE = 33; //ALPHABET.length(); // 33 букви

    public String encryptData(String comingFileWithContents, int key) {
        StringBuilder encryptedResult = new StringBuilder();
        key = (key % ALPHABET_SIZE);
        for (int counter = 0; counter < comingFileWithContents.length(); counter++) {
            char charOfSymbolOriginal = comingFileWithContents.charAt(counter);
            char upperChar = Character.toUpperCase(charOfSymbolOriginal);   // переводим символ(букву) в верхний регистр;
            int index = ALPHABET.indexOf(upperChar);   //находим позицию буквы в ALPHABET;
            if (index != -1) {                        // если индекс != -1 ,то это буква украинского алфавита,а не символ;
                int newIndex = (index + key + ALPHABET_SIZE) % ALPHABET_SIZE;
                char newChar = ALPHABET.charAt(newIndex);
                if (Character.isLowerCase(charOfSymbolOriginal)) {    // Сохраняем регистр символа
                    newChar = Character.toLowerCase(newChar);
                }
                encryptedResult.append(newChar);
            } else {
                encryptedResult.append(charOfSymbolOriginal);  // Если символ не найден в алфавите- это не буква, оставляем его без изменений
            }
        }
        return encryptedResult.toString();
    }
    public String decryptData(String comingFileWithContents, int key) {
        StringBuilder decryptedResult = new StringBuilder();
        key = (key % ALPHABET_SIZE);
        for (int counter = 0; counter < comingFileWithContents.length(); counter++) {
            char charOfSymbolOriginal = comingFileWithContents.charAt(counter);
            char upperChar = Character.toUpperCase(charOfSymbolOriginal);
            int index = ALPHABET.indexOf(upperChar);
            if (index != -1) {
                int newIndex = (index - key + ALPHABET_SIZE) % ALPHABET_SIZE;
                char newChar = ALPHABET.charAt(newIndex);
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
        System.out.println("ВОЗМОЖНЫЕ ВАРИАНТЫ РАСШИФРОВКИ:");
        for (int key = 1; key < ALPHABET_SIZE; key++) {
            String possibleDecryption = decryptData(comingFileWithContents, key);
            System.out.println("Ключ " + key + ": " + possibleDecryption);
        }
    }
}





