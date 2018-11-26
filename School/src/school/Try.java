package school;

import java.util.ArrayList;

public class Try {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Discipline math = new Discipline("Maths", 50, 30);
		Discipline it = new Discipline("Information technologies", 60, 20);
		
		ArrayList<Discipline> disciplines1 = new ArrayList();
		
		disciplines1.add(it);
		disciplines1.add(math);
		
		Teacher teacher1 = new Teacher("Kiril Metodiev", disciplines1);
		
		Student student1 = new Student("Anton Antonov", 1);
		Student student2 = new Student("Borislava Borisova", 2);
		Student student3 = new Student("Dragomir Dragomirov", 3);
		
		ArrayList<Teacher> teachersGroup1 = new ArrayList();
		teachersGroup1.add(teacher1);
		
		ArrayList<Student> studentsClass12A = new ArrayList();
		studentsClass12A.add(student1);
		studentsClass12A.add(student2);
		studentsClass12A.add(student3);
		
		SchoolClass class12A = new SchoolClass(studentsClass12A, teachersGroup1, "12A");
		
		class12A.printSchoolClassInfo(studentsClass12A, teachersGroup1);
		

	}

}
