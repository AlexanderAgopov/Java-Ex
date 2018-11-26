package student;

import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		// Implementation examples of class Student
		Student student0 = new Student();
		Student student1 = new Student("Evlogi Georgiev", "Sofia University", "International Law", "Law",
				"e.georgiev@aaa.bg", "+359888111222");

		Scanner input = new Scanner(System.in);
		Student student2 = new Student();
		//Gets information for student 2 entered by user
		System.out.println("Three names: ");
		student2.setThreeNames(input.nextLine());
		System.out.println("University: ");
		student2.setUniversity(input.nextLine());
		System.out.println("Course: ");
		student2.setCourse(input.nextLine());
		System.out.println("SubjectArea: ");
		student2.setSubjectArea(input.nextLine());
		System.out.println("Email: ");
		student2.setEmail(input.nextLine());
		System.out.println("Telephone Number: ");
		student2.setTelNumber(input.nextLine());
		input.close();
		
		//Prints full information for all students using array and foreach loop
		Student[] arrStudents = {student0, student1, student2};
		for(Student student: arrStudents) {
			student.printStudentFullInfo();
		}
		System.out.println();
		
		//Prints the number of students, i.e. the number of objects of class Student
		System.out.println("Number of students: " + Student.printNumberOfStudents());

	}

}
