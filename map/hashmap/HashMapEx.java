package map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Double> studentsMarks = new HashMap<String, Double>(6);
		studentsMarks.put("Blagoi", 4.57);
		studentsMarks.put("Violeta", 5.70);
		studentsMarks.put("Elena", 3.80);
		studentsMarks.put("Mihail", 5.25);
		studentsMarks.put("Kalin", 2.00);
		studentsMarks.put("Slavina", 6.00);

		System.out.printf("Violeta's mark is %.2f. %n", studentsMarks.get("Violeta"));
		studentsMarks.remove("Kalin");
		System.out.println("Kalin was removed. Kalin will repeat the class.");
		studentsMarks.put("Elena", 4.50);
		System.out.println("Elena's mark was changed.");

		System.out.println("Students and marks:");
		for (Map.Entry<String, Double> studentEntry : studentsMarks.entrySet()) {
			System.out.printf("%n%s - %.2f", studentEntry.getKey(), studentEntry.getValue());
		}

		System.out.printf("%n%nThere are %d students in this class.", studentsMarks.size());

		studentsMarks.clear();
		System.out.println("StudentsMarks hashmap cleared.");
		System.out.printf("%nIs hash map empty: %b.", studentsMarks.isEmpty());

	}

}
