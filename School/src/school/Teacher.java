package school;

import java.util.ArrayList;

public class Teacher {
	private String teacherName;
	private ArrayList<Discipline> teacherDisciplines;
	
	

	public Teacher(String teacherName, ArrayList<Discipline> teacherDisciplines) {
		super();
		this.teacherName = teacherName;
		this.teacherDisciplines = teacherDisciplines;
	}

	public ArrayList<Discipline> getTeacherDisciplines() {
		return teacherDisciplines;
	}

	public void setTeacherDisciplines(ArrayList<Discipline> teacherDisciplines) {
		this.teacherDisciplines = teacherDisciplines;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
	
	public void printTeacherName() {
		System.out.println(this.teacherName);
	}

}
