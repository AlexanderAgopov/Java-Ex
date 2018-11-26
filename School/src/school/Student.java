package school;

public class Student {
	
	private String studentName;
	private int studentNum;
	
	public Student(String studentName, int studentNum) {
		super();
		this.studentName = studentName;
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	
	public void printStudentNameAndNumber() {
		System.out.print(this.studentNum);
		System.out.print(" " + this.studentName);
		
	}
	

}
