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

        while (maxSteps > 0){
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
        }
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
}



