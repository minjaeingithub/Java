package FindingMine;

interface GameBase {
	int N = 15;
	int num_mine = 40;
	int[][]	  status_board = new int[N][N];
	
	MineBoard mine_map = new MineBoard (N, num_mine);
	HintBoard hint_map = new HintBoard (N, mine_map);
	
	// Just setup Status_board data.
	static void Init_Status () {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				status_board[i][j] = 0;
			}
		}
	}
	
	/*
	 * 
	 * Print (num_mine - num_mark), num_mark
	 * 
	 * Print hint if status board is 1
	 * Print @ if status board is 2
	 * Else, print " " (Empty Space)
	 * 
	 */
	void PrintBoard ();
	
	/*
	 * If action is 1:
	 * 		Set status board as 1 if there's no mine on that position.
	 * 		return true;
	 * 		
	 * 		If there's a mine, return false;
	 * 
	 * If action is 2:
	 * 		Set status board as 2 and increase num_mark
	 * 		if action is 2(Mark that it is mine) and return true;
	 * 
	 */
	boolean UpdateStatus (int i, int j, int action);
	
	// Check all mine is marked.
	boolean GameEnd ();
	
	/* Print following format and end game.
	 * 
	 * Game Over : Number of Mine
	 * 
	 * Print MineBoard only.
	 */
	void GameOver ();
}

public class Game implements GameBase{
	@Override
	public void PrintBoard() {
		/* 
		 * 
		 * Should be print board with given format
		 * You have to implement here.
		 * 
		 */
		
	}

	@Override
	public boolean UpdateStatus(int i, int j, int action) {
		/* Implement Here */
		
		/* You can remove or change below return */
		return false;
	}

	@Override
	public void GameOver() {
		/* Implement Here */	
	}

	@Override
	public boolean GameEnd() {
		/* Implement Here */	

		/* You can remove or change below return */
		return false;
	}

}
