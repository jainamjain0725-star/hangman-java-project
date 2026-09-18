package hangman;

public class Validator {

    public static boolean isValidGuess(String input) {
        if (input == null || input.trim().length() != 1) {
            return false;
        }
        char c = input.trim().charAt(0);
        return Character.isLetter(c);
    }

    public static boolean isAlreadyGuessed(String guess, String allGuesses) {
        return allGuesses.contains(guess.toLowerCase());
    }
}
