package hangman;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ScoreBoard {
    private String fileName = "scores.txt";

    public void saveScore(String name, int score) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(name + " - " + score + " points\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Could not save score.");
        }
    }

    public void showScores() {
        System.out.println("\n--- High Scores ---");
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("No scores yet.");
                return;
            }
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Could not read scores.");
        }
    }
}
