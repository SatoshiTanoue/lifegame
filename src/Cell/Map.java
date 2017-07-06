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

	public void printMap() {
		for (int i=0; i<rowSize; i++) {
			for (int j=0; j<columnSize; j++) {
				if (this.map[i][j]) System.out.printf("□");
				else System.out.printf("■");
			}
			System.out.println("");
		}
	}

	public void changeStateOfMap () {
		int up,down,left,right;
		boolean[][] temp=this.map;
		for (int row = 0; row<rowSize; row++) {
			for (int column = 0; column<columnSize; column++) {

				//left = row - 1;して，そのあと if(left < 0) left = rowSize-1; のほうがいいかも？
				//up,down,left,rightの値を設定する．
				if (row == 0) left = rowSize-1;
				else left = row - 1 ;

				if (row == rowSize-1) right = 0;
				else right = row + 1 ;

				if (column == 0) up = columnSize-1;
				else up = column - 1 ;

				if (column == columnSize-1)  down=0;
				else down = column + 1 ;

				int count = countLivingCell(row,column,up,down,left,right);
				//参考にしたURL:http://www.cse.kyoto-su.ac.jp/~oomoto/lecture/program/C/lifegame/index-j.html
				if(count <= 1 ){
					//死
					temp[row][column] = false;
				}else if(count == 2){
				    //維持
					//なにもしない
				}else if(count == 3){
					//誕生
					temp[row][column] = true;
				}else{
					//死
					temp[row][column] = false;
				}
			}
		}
		this.map = temp;
	}

	private int countLivingCell(int row, int column,int up,int down,int left,int right) {

		int count = 0;

		if (this.map[up][left]) count++;
		if (this.map[up][column]) count++;
		if (this.map[up][right]) count++;
		if (this.map[row][left]) count++;
		if (this.map[row][column]) ;
		if (this.map[row][right]) count++;
		if (this.map[down][left]) count++;
		if (this.map[down][column]) count++;
		if (this.map[down][right]) count++;

		return count;
	}


}
