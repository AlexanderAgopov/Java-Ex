package inheritance;

public class WorkerEx {

	private static Worker[] workersSelectionSort(Worker[] arr) {
		// Implementing Selection Sort algorithm in order to sort the
		// workers by their salary
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[index]) < 0) {
					index = j;

				}
				Worker worseMarkStudent = arr[index];
				arr[index] = arr[i];
				arr[i] = worseMarkStudent;
			}
		}
		return arr;
	}

	public static void main(String[] args) {

		Worker[] workers = { new Worker("A", "A", 500, 40), new Worker("B", "B", 300, 40),
				new Worker("C", "C", 600, 45), new Worker("D", "D", 400, 40), new Worker("E", "E", 400, 35),
				new Worker("Z", "Z", 300, 55) };

		workersSelectionSort(workers);

		for (int i = workers.length - 1; i >= 0; i--) {
			System.out.println(
					workers[i].getFirstName() + " " + workers[i].getLastName() + " " + workers[i].getSalary() + "   ");
		}

	}

}
