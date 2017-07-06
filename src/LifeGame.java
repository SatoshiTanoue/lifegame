import Cell.Map;

public class LifeGame {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Map cell = new Map(10,10);
		cell.putCellToMap(2, 2);
		cell.putCellToMap(2, 3);
		cell.putCellToMap(2, 4);
		cell.printMap();
        System.out.println("");

		for (int i=0; i<10; i++) {
			cell.changeStateOfMap();
			cell.printMap();
            System.out.println("");
		}
	}

}
