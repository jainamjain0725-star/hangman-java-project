package hangman;

public class Player {
    private String name;
    private int score;

    public Player(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Player";
        } else {
            this.name = name.trim();
        }
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        this.score += points;
    }
}
