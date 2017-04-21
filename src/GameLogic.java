import java.util.Scanner;

/**
 * Created by User on 16.04.2017.
 */
public class GameLogic {

    private Scanner scanner = new Scanner(System.in);
    private boolean isPlayerStep = true;
    private Field field = new Field();

    private int count = 0;  //Count the number of free cells

    //start the game
    void play()
    {
        playerStep();
    }

    //This method allows the player to move and call the computer's method
    private void playerStep(){
        int cellNumber;

        System.out.println("Enter number:");
        cellNumber = scanner.nextInt();

        collision(cellNumber);

        isPlayerStep = false;

        field.position[cellNumber] = 'X';

        System.out.println("Player cellNumber: cell № " + cellNumber);

        field.currentBoard();

        checkWinner();
        count++;
        if (count == 9) {
            System.out.println("Game over");
            System.exit(0);
        }
        comoputerStep();
    }

    //This method allows the computer's progress and the player's method call
    private void comoputerStep(){
        int cellNumber;

        cellNumber = 1 + (int) (Math.random() * 9);

        collision(cellNumber);

        isPlayerStep = true;

        field.position[cellNumber] = 'O';

        System.out.println("Computer cellNumber: cell №" + cellNumber);

        field.currentBoard();

        checkWinner();
        count++;
        playerStep();
    }

    //This method checks whether the cell is free to move or not
    private void collision(int cell){
        if (field.position[cell] == 'X' ||  field.position[cell] == 'O'){

            if (isPlayerStep){
                System.out.println("Player shall retry, because cell № " + cell + " is busy");
                playerStep();
            }
            else {
                System.out.println("Computer shall retry, because cell № " + cell + " is busy");
                comoputerStep();
            }
        }
    }

    private  void checkWinner() {
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
        if (Winner == 'X') {
            System.out.println("Player wins the game.");
            System.exit(0);
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
        if (Winner == 'O') {
            System.out.println("Computer wins the game.");
            System.exit(0);
        }

    }
}



