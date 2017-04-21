import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 16.04.2017.
 */
public class GameLogic {

    private Field field = new Field();
    private Scanner scanner = new Scanner(System.in);

    private boolean isPlayer = true;
    private int maxTeps = 9;

    void play() {
        int step;

        do {

            boolean cellNotEmpty = true;

            while (cellNotEmpty) {
                if (isPlayer) {
                    System.out.println("\nPlayer step");
                    step = scanner.nextInt();

                    cellNotEmpty = collisionCheck(step);

                    field.position[step] = 'X';

                    System.out.println("\nthat was Player step. Cell number: " + step + "\n");

                    field.currentBoard();

                    if (checkWinner() == 'X') {
                        System.exit(0);
                    }
                    isPlayer = false;
                } else {
                    step = 1 + (int) (Math.random() * 9);

                    cellNotEmpty = collisionCheck(step);

                    field.position[step] = 'O';

                    checkWinner();

                    System.out.println("\nthat was Computer step. Cell number: " + step + "\n");
                    field.currentBoard();
                    if (checkWinner() == 'O') {
                        System.exit(0);
                    }
                    isPlayer = true;
                }

                maxTeps--;
                if (maxTeps == 0) {
                    System.out.println("Game over");
                } else {
                    System.out.println("Осталось ходов " + maxTeps);
                }
            }

        }while (maxTeps > 0);
    }



    boolean collisionCheck(int step){
        if (field.position[step] == 'X' || field.position[step] == 'O'){
            System.out.println("Cell is not empty. Retry");
            return true;
        }
        else {
            return false;
        }
    }

    public  char checkWinner()
    {
        char Winner = ' ';

        // Check if X wins
        if (field.position[1] == 'X' && field.position[2] == 'X' && field.position[3] == 'X') Winner = 'X';
        if (field.position[4] == 'X' && field.position[5] == 'X' && field.position[6] == 'X') Winner = 'X';
        if (field.position[7] == 'X' && field.position[8] == 'X' && field.position[9] == 'X') Winner = 'X';
        if (field.position[1] == 'X' && field.position[4] == 'X' && field.position[7] == 'X') Winner = 'X';
        if (field.position[2] == 'X' && field.position[5] == 'X' && field.position[8] == 'X') Winner = 'X';
        if (field.position[3] == 'X' && field.position[6] == 'X' && field.position[9] == 'X') Winner = 'X';
        if (field.position[1] == 'X' && field.position[5] == 'X' && field.position[9] == 'X') Winner = 'X';
        if (field.position[3] == 'X' && field.position[5] == 'X' && field.position[7] == 'X') Winner = 'X';
        if (Winner == 'X' )
        {
            System.out.println("Player wins the game." );
            return Winner;
        }

        // Check if O wins
        if (field.position[1] == 'O' && field.position[2] == 'O' && field.position[3] == 'O') Winner = 'O';
        if (field.position[4] == 'O' && field.position[5] == 'O' && field.position[6] == 'O') Winner = 'O';
        if (field.position[7] == 'O' && field.position[8] == 'O' && field.position[9] == 'O') Winner = 'O';
        if (field.position[1] == 'O' && field.position[4] == 'O' && field.position[7] == 'O') Winner = 'O';
        if (field.position[2] == 'O' && field.position[5] == 'O' && field.position[8] == 'O') Winner = 'O';
        if (field.position[3] == 'O' && field.position[6] == 'O' && field.position[9] == 'O') Winner = 'O';
        if (field.position[1] == 'O' && field.position[5] == 'O' && field.position[9] == 'O') Winner = 'O';
        if (field.position[3] == 'O' && field.position[5] == 'O' && field.position[7] == 'O') Winner = 'O';
        if (Winner == 'O' )
        {
            System.out.println( "Computer wins the game." );
            return Winner; }

        return Winner;
    }
}



