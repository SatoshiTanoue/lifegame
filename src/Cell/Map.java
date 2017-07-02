package Cell;

public class Map {
	private int rowSize;
	private int columnSize;
	private boolean[][] map;

	public Map() {
		this.rowSize = 0;
		this.columnSize = 0;
	}

	public Map(int rowSize, int columnSize) {
		this.rowSize = rowSize;
		this.columnSize = columnSize;
		this.map = new boolean[rowSize][columnSize];
		for (int i=0; i<rowSize; i++) {
			for (int j=0; j<columnSize; j++) {
				this.map[i][j] = false;
			}
		}
	}

	//生きているセルを追加
	public void putCellToMap(int row, int column) {
		this.map[row][column] = true;
	}

	public void changeStateOfMap () {
		int count = 0;

		for (int i=-1; i<rowSize; i++) {
			for (int j=0; j<columnSize; j++) {

			}
		}
	}

	public void printMap() {
		for (int i=0; i<rowSize; i++) {
			for (int j=0; j<columnSize; j++) {
				if (this.map[i][j]) System.out.printf("□");
				else System.out.printf("■");
			}
			System.out.println("");
		}
	}

	public int countLiveCell(int x, int y) {
		int count = 0;

		if (x < 0) x = rowSize - 1;
		else if (x > rowSize -1 ) x = 0;

		if (y < 0) y = columnSize - 1;
		else if (y > columnSize - 1) y = 0;

		if (this.map[x][y]) count++;

		return count;
	}

	public void checkCountMap(int count) {
		//周りの生の個数を数える
		for (int i=0; i<rowSize; i++) {
			for (int j=0; j<columnSize; j++) {

				//過疎
				if (count <= 1) {
					this.map[i][j] = false;
				}
				//維持
				else if (count == 2) {
					//何もしない
				}
				//誕生
				else if (count == 3) {
					this.map[i][j] = true;
				}
				//過密
				else if (count >= 4) {
					this.map[i][j] = false;
				}
			}
		}
	}
}
