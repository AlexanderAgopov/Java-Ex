package inheritance;

public class Student extends Human implements Comparable<Student> {
	
	private int mark;
	
	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Student(String firstName, String lastName,int mark) {
		super(firstName, lastName);
		this.mark = mark;
		
	}

	

	@Override
	public int compareTo(Student student) {
		if(this.mark > student.mark) {
			return 1;
		}
		if(this.mark < student.mark) {
			return -1;
		}
		return 0;
	}

}
