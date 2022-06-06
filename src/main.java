import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String [] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("welcome to the game");
        System.out.println("Choose Your Table \n1- For Console \n2-GUI");
        int c1 = input.nextInt();
        if (c1 == 2)
        {
             //new GUI();
             new checker();
        }
        else
        {
            System.out.println("Choose level Game");
            System.out.println("1-Easy \n2-Medium \n3-Hard");
            int choice = input.nextInt();
            int depth;
            if (choice == 1) depth = 1;
            else if (choice == 2) depth = 3;
            else depth = 5;
            Board b = new Board();
            b.initializingTheBoard();
            alphaBetaPlayer c = new alphaBetaPlayer(b);
            b.displayBoard();
            while (b.isWin() == -1) {
                int x;
                int y;
                System.out.println("Your turn \nPlease enter the marble coordinate");
                x = input.nextInt();
                y = input.nextInt();
                marble mPlayer = new marble(x, y, 2);
                mPlayer.getAvailableMoves(b);
                while (mPlayer.AvailableMarbles.size() == 0) {
                    System.out.println("This marble don't have any available moves!! \nPlease enter another marble coordinate");
                    x = input.nextInt();
                    y = input.nextInt();
                    mPlayer = new marble(x, y, 2);
                    mPlayer.getAvailableMoves(b);
                }
                System.out.println("Your Available Moves is");
                for (int i = 0; i < mPlayer.AvailableMarbles.size(); i++) {
                    System.out.println(mPlayer.AvailableMarbles.get(i).x + " " + mPlayer.AvailableMarbles.get(i).y);
                }
                int choosenX, choosenY;
                choosenX = input.nextInt();
                choosenY = input.nextInt();
                b.change(x, y, choosenX, choosenY);
                System.out.println("GRID UPDATED");
                b.displayBoard();
                System.out.println("===================");
                System.out.println("Computer Turn");
                c.alphaBeta(b, depth, Integer.MIN_VALUE, Integer.MAX_VALUE, 1, true);
                b = c.BestGrid;
                b.displayBoard();
            }
            if (b.isWin() == 1) {
                System.out.println("COMPUTER WINS!");
            } else {
                System.out.println("CONGRATULATIONS, YOU WIN!");
            }
        }
    }
}
