
public class LabyrinthB {
	private static char[][] labyrinth = {
		    
			
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },  
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'e' },
		
	};

private static char[] path = new char[labyrinth.length
		* labyrinth[0].length];

private static int position = 0;

private static void findPath(int row, int col, char direction) {

	if ((row < 0) || (col < 0) || (row >= labyrinth.length)
			|| (col >= labyrinth[0].length)) {
		return;
	}

	path[position] = direction;
	position++;

	if (labyrinth[row][col] == 'e') {

		printPath(path, 1, position - 1);
	}

	if (labyrinth[row][col] == ' ') {

		labyrinth[row][col] = 's';

		findPath(row, col - 1, 'L');
		findPath(row - 1, col, 'U');
		findPath(row, col + 1, 'R');
		findPath(row + 1, col, 'D');
		// Delete this source code if you want to treat bigger matrixes like the one up in the field: labyrinth[row][col] = ' ';
		// Without this script the program finds only one path instead all possible paths to the exit of the labyrinth
	}

	position--;
}

private static void printPath(char path[], int startPos, int endPos) {
	System.out.println("Found path to the exit: ");
	for (int pos = startPos; pos <= endPos; pos++) {
		System.out.print(path[pos]);

	}
	System.out.println();
}

/**
 * @param args
 */
public static void main(String[] args) {
	// TODO Auto-generated method stub
	findPath(0, 0, 'S');
}

}