package school;

import java.util.ArrayList;

public class SchoolClass {

	private String schoolClassName;

	private ArrayList<Student> schoolClassStudents;

	private ArrayList<Teacher> schoolClassTeachers;

	public SchoolClass(ArrayList<Student> schoolCLassStudents, ArrayList<Teacher> schoolClassTeachers,
			String schoolClassName) {
		super();
		this.schoolClassStudents = schoolClassStudents;
		this.schoolClassTeachers = schoolClassTeachers;
		this.schoolClassName = schoolClassName;
	}

	public String getSchoolClassName() {
		return schoolClassName;
	}

	public void setSchoolClassName(String schoolClassName) {
		this.schoolClassName = schoolClassName;
	}

	public ArrayList<Student> getSchoolClassStudents() {
		return schoolClassStudents;
	}

	public void setSchoolClassStudents(ArrayList<Student> schoolClassStudents) {
		this.schoolClassStudents = schoolClassStudents;
	}

	public ArrayList<Teacher> getSchoolClassTeachers() {
		return schoolClassTeachers;
	}

	public void setSchoolClassTeachers(ArrayList<Teacher> schoolClassTeachers) {
		this.schoolClassTeachers = schoolClassTeachers;
	}

	public void printSchoolClassInfo(ArrayList<Student> schoolClassStudents, ArrayList<Teacher> schoolClassTeachers) {
		System.out.println("Name of class: " + this.schoolClassName);
		System.out.printf("%nList of students in class %s:", this.schoolClassName);

		for (Object student : schoolClassStudents.toArray()) {
			System.out.println();
			((Student) student).printStudentNameAndNumber();
		}
		System.out.printf("%n%nList of teachers involved in the educational process of class %s:", this.schoolClassName);
		System.out.println();
		for (Object teacher : schoolClassTeachers.toArray()) {
			((Teacher) teacher).printTeacherName();
		}

	}

}
