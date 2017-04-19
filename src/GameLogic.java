import java.util.Scanner;

/**
 * Created by User on 16.04.2017.
 */
public class GameLogic {


    private int playersCell;
    private int computerCell;
    private int maxSteps = 9;
    private Scanner scanner = new Scanner(System.in);
    private boolean isPlayerStep = true;

    Field field = new Field();
    void play()
    {

        char blank = ' ';
        do {

            stepOrder();
            field.currentBoard();
            if (!isPlayerStep){
                System.out.println("That was Players step: cell " + playersCell);
            }
            else {
                System.out.println("That was Computer: cell " + computerCell);
            }
            System.out.println();
            System.out.println();
            maxSteps--;
            if (maxSteps == 0){
                System.out.println("Game over");
            }
        }while (checkWinner() == blank);
    }

    private void stepOrder() {

        boolean cellTaken = true;

        while (cellTaken) {

            if (isPlayerStep) {
                playersCell = scanner.nextInt();
                cellTaken = collisionCheck(playersCell);
                field.position[playersCell] = 'X';
                isPlayerStep = false;
            } else {
                computerCell = 1 + (int) (Math.random() * 9);
                cellTaken = collisionCheck(computerCell);
                field.position[computerCell] = 'O';
                isPlayerStep = true;
            }
        }
    }

    private boolean collisionCheck(int step){
        if (field.position[step] == 'X' ||  field.position[step] == 'O'){
            System.out.println("Tge cell is not empty");
            System.out.println("Please choose another cell");
            System.out.println();
            field.currentBoard();
            stepOrder();
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
        {System.out.println("Player1 wins the game." );
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
            System.out.println( "Player2 wins the game." );
            return Winner; }

        return Winner;
    }
}



