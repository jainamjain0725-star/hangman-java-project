package hangman;

public class Game {
    private String word;
    private String guesses;
    private int turns;
    private boolean won;

    public Game(String word, int maxTurns) {
        this.word = word.toLowerCase();
        this.turns = maxTurns;
        this.guesses = "";
        this.won = false;
    }

    public boolean makeGuess(char letter) {
        letter = Character.toLowerCase(letter);
        guesses += letter;

        if (word.indexOf(letter) != -1) {
            checkWin();
            return true;
        } else {
            turns--;
            return false;
        }
    }

    private void checkWin() {
        for (int i = 0; i < word.length(); i++) {
            if (guesses.indexOf(word.charAt(i)) == -1) {
                return;
            }
        }
        won = true;
    }

    public String getDisplayWord() {
        String display = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (guesses.indexOf(c) != -1) {
                display += c + " ";
            } else {
                display += "_ ";
            }
        }
        return display.trim();
    }

    public boolean isGameOver() {
        return won || turns <= 0;
    }

    public boolean isWon() {
        return won;
    }

    public int getTurns() {
        return turns;
    }

    public String getWord() {
        return word;
    }

    public String getGuesses() {
        return guesses;
    }
}
