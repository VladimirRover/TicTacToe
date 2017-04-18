import java.util.Scanner;

public class Field {

    private int playersCell;
    private int computerCell;
    private int maxSteps = 9;
    private Scanner scanner = new Scanner(System.in);
    private boolean isPlayerStep = true;
    private char position[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', };

    void currentBoard()
    {
        System.out.println( position[1] + " | " + position[2] + " | " + position[3]);
        System.out.println("---------");
        System.out.println( position[4] + " | " + position[5] + " | " + position[6]);
        System.out.println("---------");
        System.out.println( position[7] + " | " + position[8] + " | " + position[9]);
    }

    void play()
    {

        while (maxSteps > 0){
            stepOrder();
            currentBoard();
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
                position[playersCell] = 'X';
                isPlayerStep = false;
            } else {
                computerCell = 1 + (int) (Math.random() * 9);
                cellTaken = collisionCheck(computerCell);
                position[computerCell] = 'O';
                isPlayerStep = true;
            }

        }
    }

    private boolean collisionCheck(int step){
        if (position[step] == 'X' || position[step] == 'O'){
            System.out.println("Tge cell is not empty");
            System.out.println("Please choose another cell");
            System.out.println();
            currentBoard();
            stepOrder();
            return true;
        }
        else {
            return false;
        }
    }
}
