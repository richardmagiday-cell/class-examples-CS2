

public class NQueenSkelition {
	public static int N = 8;
	/* A utility function to print solution */
	void printSolution(int board[][])
	{
		System.out.format("Printing in matrix format: \n");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.format(" %d ", board[i][j]);
			System.out.format("\n");
		}
		System.out.format("Printing in Queen format: \n");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				if (board[i][j] == 1)
					System.out.format("Q%d ", i+1);
			// No queen here, so print a blank.
				else
					System.out.format("_ ");
			//System.out.format(" %d ", board[i][j]);
			System.out.format("\n");
		}
	}
	/* check to see if it is save to put the queen in x,y position */
	boolean isSafe(int board[][], int x, int y)
	{
        int XminusY = x - y;
        int XplusY = x + y;

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(i == x || j == y ||(i-j) == XminusY || (i+j) == XplusY)
                {
                    if(board[i][j] == 1)
                        return false;
                }
            }
        }
        return true;
	}
	/* A recursive utility function to solve N
	Queen problem */
	boolean solveNQUtil(int N, int r, int board[][])
	{
        if (r == N)
            return true;

        for (int col = 0; col < N; col++) {
            if (isSafe(board, r, col)) {
                board[r][col] = 1;
                if (solveNQUtil(N, r + 1, board))
                    return true;
                board[r][col] = 0;
            }
        }
        return false;
	}
	public void solveNQ()
	{
		int[][] board = new int[N][N]; //initialize all the positions to 0 by default
		if (solveNQUtil(N, 0, board) == false) {
			System.out.println("Solution does not exist");
		}
		else
			printSolution(board);
	}
	public static void main(String[] args) {
		NQueenSkelition m = new NQueenSkelition();
		m.solveNQ();
	}
}

