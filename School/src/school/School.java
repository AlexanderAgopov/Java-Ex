package school;

import java.util.ArrayList;

public class School {
	
	ArrayList<SchoolClass> schoolClasses;

	public School(ArrayList<SchoolClass> schoolClasses) {
		super();
		this.schoolClasses = schoolClasses;
	}

	public ArrayList<SchoolClass> getSchoolClasses() {
		return schoolClasses;
	}

	public void setSchoolClasses(ArrayList<SchoolClass> schoolClasses) {
		this.schoolClasses = schoolClasses;
	}
	
	

}
