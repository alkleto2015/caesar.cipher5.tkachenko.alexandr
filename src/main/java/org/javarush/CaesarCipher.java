package org.javarush;

class CaesarCipher {
    private static final int ALPHABET_LETTERS = 26;

    public String encryptData(String comingFileWithContents, int key) {
        StringBuilder encryptedResult = new StringBuilder();
        key = key % ALPHABET_LETTERS;                                              // деление по модулю-оператор-modulo- (%N); ограничитель диапазона сдвига до 26-(колличество букв латинского алфавита);
        for (int counter = 0; counter < comingFileWithContents.length(); counter++) {
            char charOfSymbol = comingFileWithContents.charAt(counter);
            if (Character.isLetter(charOfSymbol)) {
                char mainSymbol = Character.isUpperCase(charOfSymbol) ? 'A' : 'a';
                //формула шифрования Цезаря с модульной арифметикой  C =((P−A+K)%modN)+ A;  P = charOfSymbol; A = mainSymbol; C =((charOfSymbol - mainSymbol + key) % ALPHABET_LETTERS) + mainSymbol;//
                int displaceSymbolFromMainValue = charOfSymbol - mainSymbol;      //смещение символа от начала алфавита- от основного значения;
                int shiftPlusKey = displaceSymbolFromMainValue + key;             //  добавляем КЛЮЧ,к смещению от начала алфавита,и получаем смещение с ключом ;
                int moduleOperation = shiftPlusKey % ALPHABET_LETTERS;            // операция по модулю (деление с остатком на 26 -( 26-это колличество букв латинского алфавита)- чтобы двигаться удобнее по алфавиту
                char encryptedChar = (char) (moduleOperation + mainSymbol);         // преобразуем обратно в char символ, двигаем символ в пределах латинского алфавита;
                encryptedResult.append(encryptedChar);
            } else {
                encryptedResult.append(charOfSymbol);
            }
        }
        return encryptedResult.toString();
    }

    public String decryptData(String comingFileWithContents, int key) {
        StringBuilder decryptedResult = new StringBuilder();
        key = (key % ALPHABET_LETTERS);                                                       // деление по модулю ; ограничиваем диапазон сдвига 26-ю буквами алфавита
        for (int counter = 0; counter < comingFileWithContents.length(); counter++) {
            char charOfSymbol = comingFileWithContents.charAt(counter);
            if (Character.isLetter(charOfSymbol)) {
                char mainSymbol = Character.isUpperCase(charOfSymbol) ? 'A' : 'a';
                //модульная арифметика, формула расшифрования Цезаря P=((C−A−K+N)%modN)+A; С = charOfSymbol; A = mainSymbol; P =((charOfSymbol - mainSymbol - key + ALPHABET_LETTERS) % ALPHABET_LETTERS) + mainSymbol;
                int displaceSymbolFromMainValue = charOfSymbol - mainSymbol;
                int shiftMinusKey = (displaceSymbolFromMainValue - key + ALPHABET_LETTERS) % ALPHABET_LETTERS; // Вычитаем ключ, избегаем отрицательных значений
                char decryptedChar = (char) (shiftMinusKey + mainSymbol);  //преобразуем опять в char символ, и двигаем символ в пределах латинского алфавита.
                decryptedResult.append(decryptedChar);
            } else {
                decryptedResult.append(charOfSymbol);                     // Оставляем небуквенные символы без изменений
            }
        }
        return decryptedResult.toString();
    }

    public void bruteForceDecrypt(String comingFileWithContents) {
        System.out.println("Possible decoding option by Brute-force:");
        for (int count = 1; count < ALPHABET_LETTERS; count++) {
            String decryptedText = encryptData(comingFileWithContents, count);
            System.out.println("Key " + count + ": " + decryptedText);

        }
    }
}





