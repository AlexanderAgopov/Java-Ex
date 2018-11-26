package collections2;

import java.util.Comparator;

public class Student implements Comparable<Student>, Comparator<Student> {
	private String firstName;
	private String lastName;
	private String course;

	public Student(String name, String family, String course) {
		super();
		this.firstName = name;
		this.lastName = family;
		this.course = course;
	}
	
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public int compareTo(Student student) {
		// TODO Auto-generated method stub
		int result = this.course.compareTo(student.course);
		if (result == 0) {
			result = this.firstName.compareTo(student.firstName);
			if (result == 0) {
				result = this.lastName.compareTo(student.lastName);
			}
		}
		return result;
	}

	public String toString() {
		return this.course + " " + this.firstName + " " + this.lastName;
	}

	@Override
	public int compare(Student student1, Student student2) {
		// TODO Auto-generated method stub
		int result = student1.course.compareTo(student2.course);
		if (result == 0) {
			result = student1.firstName.compareTo(student2.firstName);
			if (result == 0) {
				result = student1.lastName.compareTo(student2.lastName);
			}
		}
		return result;
	}

}
