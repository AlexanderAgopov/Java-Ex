package student;

public class Student {

	private String threeNames;
	private String course;
	private String subjectArea;
	private String university;
	private String email;
	private String telNumber;

	private static int studentCount;

	public Student() {
		studentCount++;
	}

	public Student(String threeNames, String university) {
		this.threeNames = threeNames;
		this.university = university;
		studentCount++;
	}

	public Student(String threeNames, String university, String course, String subjectArea, String email,
			String telNumber) {
		this(threeNames, university);
		this.course = course;
		this.subjectArea = subjectArea;
		this.email = email;
		this.telNumber = telNumber;
		studentCount++;
	}

	public String getThreeNames() {
		return threeNames;
	}

	public void setThreeNames(String threeNames) {
		this.threeNames = threeNames;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSubjectArea() {
		return subjectArea;
	}

	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public void printStudentFullInfo() {
		System.out.printf(
				"%nName: %s%nUniversity: %s%nSubject Area: %s%nCourse: %s%nEmail: %s%nTelephone Number: %s%n",
				this.threeNames, this.university, this.subjectArea, this.course, this.email, this.telNumber);
	}

	public static int printNumberOfStudents() {
		return studentCount;
	}

}
