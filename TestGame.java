package hangman;

public class TestGame {
    public static void main(String[] args) {
        Game game = new Game("apple", 5);

        if (game.getDisplayWord().equals("_ _ _ _ _")) {
            System.out.println("Test 1 Passed: Initial display is correct");
        } else {
            System.out.println("Test 1 Failed");
        }

        game.makeGuess('p');
        if (game.getDisplayWord().equals("_ p p _ _")) {
            System.out.println("Test 2 Passed: Revealed letter is correct");
        } else {
            System.out.println("Test 2 Failed");
        }

        int before = game.getTurns();
        game.makeGuess('z');
        if (game.getTurns() == before - 1) {
            System.out.println("Test 3 Passed: Wrong guess decreases turn");
        } else {
            System.out.println("Test 3 Failed");
        }

        if (Validator.isValidGuess("a") && !Validator.isValidGuess("12")) {
            System.out.println("Test 4 Passed: Input validator works");
        } else {
            System.out.println("Test 4 Failed");
        }
    }
}
