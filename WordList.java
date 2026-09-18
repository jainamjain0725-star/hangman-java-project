package hangman;

import java.util.Random;

public class WordList {
    private String[] easyWords = {"apple", "mango", "kiwi", "pear", "plum"};
    private String[] mediumWords = {"banana", "orange", "grapes", "cherry", "peach"};
    private String[] hardWords = {"strawberry", "pineapple", "watermelon", "blueberry"};
    private Random random = new Random();

    public String getWord(int choice) {
        if (choice == 1) {
            return easyWords[random.nextInt(easyWords.length)];
        } else if (choice == 3) {
            return hardWords[random.nextInt(hardWords.length)];
        } else {
            return mediumWords[random.nextInt(mediumWords.length)];
        }
    }
}
