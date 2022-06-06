import java.util.ArrayList;

public class alphaBetaPlayer {
    ArrayList<marble> myMarbles = new ArrayList<marble>();
    Board BestGrid=new Board() ;
    public alphaBetaPlayer(Board g)
    {
        for (int i = 0; i < 17; i++)
        {
            for (int j = 0; j < 25; j++)
            {
                if (g.board[i][j] == 1)
                {
                    marble m = new marble(i, j, 1);
                    myMarbles.add(m);
                }
            }
        }
    }
    public ArrayList<Board> getAllChildren(Board g) {
        ArrayList<Board> allGrids = new ArrayList<>();
        for (int i = 0; i < myMarbles.size(); i++) {

            ArrayList<Board> g1 = myMarbles.get(i).getAvailableMoves(g);
            for (int j = 0; j < g1.size(); j++) {
                allGrids.add(g1.get(j));
            }
        }
        return allGrids;
    }
    public void updateGrid(Board g)
    {
        int index = 0;
        for (int i = 0; i < 17; i++)
        {
            for (int j = 0; j < 25; j++) {
                if (g.board[i][j] == 1&&index<10) {
                    marble m = new marble(i, j, 1);
                    myMarbles.set(index, m);
                    index++;
                }
            }
        }
    }
    public int alphaBeta(Board b, int currentDepth, int alpha, int beta, int player,boolean isRoot)
    {
        if (currentDepth == 0 || b.isWin() != -1)
        {
            b.score=b.getHeuristic();
            return b.getHeuristic();
        }
        int eval;
        ArrayList<Board> allChildren = getAllChildren(b);
        if (player == 1) { //computer
            int maxEval = Integer.MIN_VALUE;
            for (Board board : allChildren) {
                eval = alphaBeta(board, currentDepth - 1, alpha, beta, 2,false);
                if(eval>maxEval){
                    maxEval=eval;
                    if(isRoot)
                    {
                        BestGrid.board=board.board;
                        BestGrid.score=eval;
                        updateGrid(BestGrid);
                    }
                }
                maxEval = getMax(maxEval, eval);
                alpha = getMax(alpha, eval);
                if (beta <= alpha)
                    break;
            }
            return maxEval;
        }
        else
        {
            int minEval = Integer.MAX_VALUE;
            for (Board board : allChildren) {
                eval = alphaBeta(board, currentDepth - 1, alpha, beta, 1,false);
                minEval = getMin(minEval, eval);
                beta = getMin(beta, eval);
                if (beta <= alpha)
                    break;
            }
            return minEval;
        }

    }
    public int getMin(int minEval, int eval) {
        if (minEval < eval) return minEval;
        return eval;
    }
    public int getMax(int maxEval, int eval) {
        if (maxEval > eval) return maxEval;
        return eval;
    }

}
