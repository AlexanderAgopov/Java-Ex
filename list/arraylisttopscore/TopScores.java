package list.arraylisttopscore;

import java.util.Scanner;
import java.util.ArrayList;

public class TopScores {

	public static void main(String[] args) {
		// This code creates a list with top 3 scores. If the user's score is greater
		// than the last score in the list the user's score is added at the appropriate
		// place

		ArrayList<Integer> listScores = new ArrayList<Integer>();
		listScores.add(500);
		listScores.add(0, 1000);
		listScores.add(250);

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your score: ");
		int score = input.nextInt();

		if (score >= listScores.get(0)) {
			listScores.add(0, score);
			listScores.remove(listScores.get(listScores.size() - 1));
		} else {
			for (int i = 1; i < listScores.size(); i++) {
				if (score >= listScores.get(i)) {
					listScores.add(i, score);
					listScores.remove(listScores.get(listScores.size() - 1));
				}
			}
		}

		System.out.println("The top three scores are:");
		for (Integer result : listScores) {
			System.out.println(result);
		}

	}

}
