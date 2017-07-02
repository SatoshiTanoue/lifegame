import Cell.Map;

public class LifeGame {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Hello World");

		Map cell = new Map(10,10);
		cell.putCellToMap(1, 2);
		cell.putCellToMap(2, 3);
		cell.putCellToMap(2, 4);
		cell.printMap();

		for (int i=0; i<10; i++) {
			cell.changeStateOfMap();
			cell.printMap();
		}
	}

}
