package hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        WordList wordList = new WordList();
        ScoreBoard scoreBoard = new ScoreBoard();

        System.out.print("What's your name? ");
        String name = scanner.nextLine();
        Player player = new Player(name);
        System.out.println("Hello " + player.getName() + " it's time to play Hangman!");
        Thread.sleep(1000);

        boolean running = true;
        while (running) {
            System.out.println("\n1. Game Time");
            System.out.println("2. See Scores");
            System.out.println("3. Exit Game");
            System.out.print("Make a choice: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                System.out.println("\nSet difficulty:");
                System.out.println("1. Easy Level - 7 Attempts");
                System.out.println("2. Medium Level - 5 Attempts");
                System.out.println("3. Hard Level. 4 Attempts");
                System.out.print("Choice: ");

                int difficulty = 2;
                try {
                    difficulty = Integer.parseInt(scanner.nextLine().trim());
                } catch (Exception e) {
                    difficulty = 2;
                }

                int turns = 5;
                if (difficulty == 1) {
                    turns = 7;
                } else if (difficulty == 3) {
                    turns = 4;
                }

                String word = wordList.getWord(difficulty);
                Game game = new Game(word, turns);

                System.out.println("Make your guess.\n");
                Thread.sleep(500);

                while (!game.isGameOver()) {
                    System.out.println("\nWord: " + game.getDisplayWord());
                    System.out.println("Guesses: " + game.getGuesses());
                    System.out.println("Attempts left: " + game.getTurns());

                    System.out.print("\nGuess a letter: ");
                    String input = scanner.nextLine().trim();

                    if (!Validator.isValidGuess(input)) {
                        System.out.println("Please enter one letter in order to continue.");
                        continue;
                    }

                    if (Validator.isAlreadyGuessed(input, game.getGuesses())) {
                        System.out.println("Oops! You've already guessed that one.");
                        continue;
                    }

                    char guess = input.charAt(0);
                    boolean correct = game.makeGuess(guess);

                    if (!correct) {
                        System.out.println("\nTake another guess");
                        System.out.println("Continue playing " + game.getTurns() + " Attempts left");
                    }
                }

                if (game.isWon()) {
                    System.out.println("\nWord: " + game.getWord());
                    System.out.println("\nYou did it");
                    int points = game.getTurns() * 10;
                    player.addScore(points);
                    scoreBoard.saveScore(player.getName(), points);
                    System.out.println("Score achieved: " + points);
                } else {
                    System.out.println("\nThe game is over");
                    System.out.println("The correct word was: " + game.getWord());
                }

            } else if (choice.equals("2")) {
                scoreBoard.showScores();
            } else if (choice.equals("3")) {
                System.out.println("See you later! " + player.getName() + "!");
                running = false;
            } else {
                System.out.println("Oops! Choose again.");
            }
        }

        scanner.close();
    }
}
