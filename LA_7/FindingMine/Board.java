package FindingMine;

import java.util.Random;

public class Board {
	String[][] board;
	int N;
	
	public Board (int n) {
		this.board = new String[n][n];
		this.N = n;
		InitBoard ();
	}
	
	void InitBoard () {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = " ";
			}
		}
	}
	
	String getPoint (int i, int j) {
		return this.board [i][j];
	}
}

class MineBoard extends Board {
	// You can also add private variable here
	public MineBoard(int n, int num_mine) {
		super(n);
		
		/* You can also edit here */
		
		InitBoard (num_mine);
	}
	
	// Initializes board with randomly created mines. 
	void InitBoard(int num_mine) {
		long seed = System.currentTimeMillis();
		Random rand = new Random ();
		rand.setSeed(seed);
		
		/* Fill here */
	}
	
	/* You can freely add functions below */
}

class HintBoard extends Board {
	public HintBoard(int n, MineBoard mine) {
		super(n);
		
		InitBoard (mine);
	}
	
	// Initialize Hint Board with hint numbers (the number of mines among adjacent tiles.)
	// If there's no mine Set as 0.
	void InitBoard (MineBoard mine) {
		/* Fill here. */
	}
}
