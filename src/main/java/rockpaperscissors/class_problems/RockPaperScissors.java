package rockpaperscissors.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int rounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        System.out.println("=== Rock Paper Scissors ===");

        for (int i = 0; i < rounds; i++) {

            System.out.print("Round " + (i + 1) +
                    " - Enter Rock, Paper or Scissors: ");

            String playerMove = scanner.nextLine();

            // Handle invalid input
            if (!playerMove.equalsIgnoreCase("Rock") &&
                !playerMove.equalsIgnoreCase("Paper") &&
                !playerMove.equalsIgnoreCase("Scissors")) {

                System.out.println("Invalid move. Please enter Rock, Paper or Scissors.");
                i--;
                continue;
            }

            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("========== FINAL SUMMARY ==========");
        System.out.printf("%-8s %-15s %-15s %-20s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d %-15s %-15s %-20s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println();
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);

        scanner.close();
    }
}