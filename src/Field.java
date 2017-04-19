import java.util.Scanner;

public class Field {

    char position[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', };

    void currentBoard()
    {
        System.out.println( position[1] + " | " + position[2] + " | " + position[3]);
        System.out.println("---------");
        System.out.println( position[4] + " | " + position[5] + " | " + position[6]);
        System.out.println("---------");
        System.out.println( position[7] + " | " + position[8] + " | " + position[9]);
    }
}
