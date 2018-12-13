public class Labyrinth {

	private static char[][] labyrinth = {
			{ ' ', ' ', ' ', '*', ' ', ' ', ' ' },
			{ '*', '*', ' ', '*', ' ', '*', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', '*', ' ' },
			{ ' ', '*', '*', '*', ' ', '*', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', 'e' }, };

	private static void findPath(int row, int col) {

		if ((row < 0) || (col < 0) || (row >= labyrinth.length)
				|| (col >= labyrinth[0].length)) {
			return;
		}

		if (labyrinth[row][col] == 'e') {
			System.out.println("You have found the exit!");
		}

		if (labyrinth[row][col] != ' ') {
			return;
		}

		labyrinth[row][col] = 's';

		findPath(row, col - 1);
		findPath(row - 1, col);
		findPath(row, col + 1);
		findPath(row + 1, col);

		labyrinth[row][col] = ' ';
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findPath(0, 0);

	}

}
