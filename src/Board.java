import java.awt.Point;
        import java.util.*;
        import java.util.ArrayList;

public class Board {
    public  int score;
    private final int[] WIDTHS = {1,2,3,4,13,12,11,10,9,10,11,12,13,4,3,2,1};
    int [] st={12,11,10,9,0,1,2,3,4,3,2,1,0,9,10,11,12};
    final int rows=17;
    final int columns=25;
    public Board(){}
    public int [][] board;

    public Board(Board copy)
    {
        this.initializingTheBoard();
        for(int i=0 ; i<rows  ; i++)
        {
            for(int j=0 ; j<columns ; j++)
                this.board[i][j] =  copy.board[i][j];
        }
    }


    public int isWin(){
        int computer=0;
        for(int i=13; i<17; i++) {
            for(int j=0;j<25;j++)
            {
                if (this.board[i][j]==1)
                {
                    computer++;
                }
            }
        }
        if (computer==10)
            return 1; // pc wins
        int player=0;
        for(int i=0; i<4; i++) {
            for(int j=0;j<25;j++)
            {
                if (this.board[i][j]==2)
                {
                    player++;
                }
            }
        }

        if (player==10)
        {
            return  2; //human wins
        }
        return -1; // Continue the game until someone wins
    }
    public  int calculateDistance(int x1,int y1,int x2,int y2)
    {
        return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
    }
    public int minDistance(int x,int y)
    {
        int ans= Integer.MAX_VALUE;

        if (board[x][y]==1)
        {
            for(int i=13;i<rows;i++)
            {
                for(int j=0;j<25;j++)
                {
                    ans=Math.min(calculateDistance(x,y,17,12),ans);
                }
            }
        }
        else if (board[x][y]==2) {
            for(int i=0;i<4;i++)
            {
                for(int j=0;j<25;j++)
                {
                    ans=Math.min(calculateDistance(x,y,-1,12),ans);
                }
            }
        }
        return ans;
    }


    public void initializingTheBoard()
    {
        board = new int [rows][];
        for (int i = 0; i < rows; i++)
        {
            board[i] = new int[columns];
            for(int j=0;j<columns;j++) {
                board[i][j]=-1;
            }
        }
        for(int i=0;i<rows;i++)
        {
            int count=WIDTHS[i];
            int j=st[i];
            while(count>0)
            {
                if (i<4)
                    board[i][j]=1;
                else if (i>12)
                    board[i][j]=2;
                else
                    board[i][j]=0;

                j+=2;
                count--;
            }
        }
    }
    public void displayBoard()
    {
        for (int i = 0; i < rows; i++)
        {
            for(int j=0;j<columns;j++) {
                if (board[i][j]!=-1)
                {
                    System.out.print(board[i][j]);
                }
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void change(int x,int y,int x1,int y1){
        board[x1][y1]=board[x][y];
        board[x][y]=0;
    }
    int getHeuristic()
    {
        int pc=0;
        int player=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if (board[i][j]==1)
                {
                    pc+=minDistance(i,j);

                }
                else  if (board[i][j]==2)
                {
                    player+=minDistance(i,j);
                }
            }
        }
        return player-pc;
    }


}