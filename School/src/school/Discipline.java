package school;

public class Discipline {
	
	private String disciplineName;
	private int disciplineLectureNum;
	private int disciplineExcerciseNum;
	
	public Discipline(String disciplineName, int disciplineLectureNum, int disciplineExcerciseNum) {
		super();
		this.disciplineName = disciplineName;
		this.disciplineLectureNum = disciplineLectureNum;
		this.disciplineExcerciseNum = disciplineExcerciseNum;
	}

	public String getDisciplineName() {
		return disciplineName;
	}

	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	public int getDisciplineLectureNum() {
		return disciplineLectureNum;
	}

	public void setDisciplineLectureNum(int disciplineLectureNum) {
		this.disciplineLectureNum = disciplineLectureNum;
	}

	public int getDisciplineExcerciseNum() {
		return disciplineExcerciseNum;
	}

	public void setDisciplineExcerciseNum(int disciplineExcerciseNum) {
		this.disciplineExcerciseNum = disciplineExcerciseNum;
	}
	
	

}
