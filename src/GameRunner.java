import java.util.Scanner;

/**
 * Created by User on 16.04.2017.
 */
public class GameRunner {
    public static void main(String args[]) {
        System.out.println("Welcome to TicTakToe game!");
        System.out.println("Player versus computer.");
        System.out.println("Player start first with letter 'X'");

        System.out.println("Computer will put it's letter 'O' automatically.");
        System.out.println("Have a fun time =)");
        new Field().currentBoard();
        System.out.println("Enter the number where you want to place X");
        new GameLogic().play();
    }
}
