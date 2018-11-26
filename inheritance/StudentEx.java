package inheritance;

public class StudentEx {

	private static Student[] classRoomSelectionSort(Student[] arr) {
		// Implementing Selection Sort algorithm in order to sort the students by their
		// marks
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[index]) < 0) {
					index = j;

				}
				Student worseMarkStudent = arr[index];
				arr[index] = arr[i];
				arr[i] = worseMarkStudent;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student[] classRoom = { new Student("A", "A", 5), new Student("B", "B", 3), new Student("C", "C", 6),
				new Student("D", "D", 4), new Student("E", "E", 4), new Student("Z", "Z", 3) };

		for (int i = 0; i < classRoom.length; i++) {
			System.out.print(classRoom[i].getFirstName() + " " + classRoom[i].getLastName() + " "
					+ classRoom[i].getMark() + "   ");
		}

		System.out.println();

		classRoomSelectionSort(classRoom);

		for (int i = 0; i < classRoom.length; i++) {
			System.out.print(classRoom[i].getFirstName() + " " + classRoom[i].getLastName() + " "
					+ classRoom[i].getMark() + "   ");
		}

	}

}
