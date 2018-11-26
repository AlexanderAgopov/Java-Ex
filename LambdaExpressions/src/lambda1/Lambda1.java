package lambda1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lambda1 {

	public static void printAllPersonsOverCertainAge(List<Person> personList, int age) {
		for (Person p : personList) {
			if (p.getAge() >= age) {
				System.out.println(p.toString());
			}
		}
	}

	public static void printPersonsWithinAgeRange(List<Person> personList, int low, int high) {
		for (Person p : personList) {
			if (p.getAge() >= low && p.getAge() <= high) {
				System.out.println(p.toString());
			}
		}
	}

	public static void printPersonsSpecifiedByCertainCriteria(List<Person> personList,
			CheckPErsonEligibleTForSelectiveService test) {
		for (Person p : personList) {
			if (test.test(p) == true) {
				System.out.print(p.toString());
			}
		}
	}

	public static void printPersons(List<Person> personList, CheckPerson1 checkPerson) {
		for (Person p : personList) {
			if (checkPerson.test(p) == true) {
				System.out.print(p.toString());
			}
		}
	}

	public static void printPersons2(List<Person> personList) {
		class CheckPersonEligibleForService implements CheckPerson {

			public CheckPersonEligibleForService() {
				super();
				// TODO Auto-generated constructor stub
			}

			public boolean test(Person p) {
				return p.getSex() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
			}
		}

		for (Person p : personList) {
			if (new CheckPersonEligibleForService().test(p) == true) {
				System.out.print(p.toString());
			}
		}
	}

	public static void printPersonsWithPredicate(List<Person> personList, Predicate<Person> tester) {
		for (Person p : personList) {
			if (tester.test(p)) {
				System.out.println(p.toString());
			}
		}
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> personList = new ArrayList<Person>();

		Person p1 = new Person();
		p1.setAge(20);
		p1.setName("Poli");
		p1.setSex(Person.Sex.FEMALE);

		Person p2 = new Person();
		p2.setAge(23);
		p2.setName("Rado");
		p2.setSex(Person.Sex.MALE);

		Person p3 = new Person();
		p3.setAge(15);
		p3.setName("Adi");
		p3.setSex(Person.Sex.FEMALE);

		Person p4 = new Person();
		p4.setAge(41);
		p4.setName("Pepi");
		p4.setSex(Person.Sex.MALE);

		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);

		// Using methods that search for members that match certain characteristic -
		// Level 1
		printAllPersonsOverCertainAge(personList, 18);
		System.out.println();

		// Using more generalized search methods - Level 2
		printPersonsWithinAgeRange(personList, 30, 50);
		System.out.println();
		System.out.println("Using another class that implements an interface");
		// Using another class that implements an interface - Level ~ 0 :) not so smart
		printPersonsSpecifiedByCertainCriteria(personList, new CheckPErsonEligibleTForSelectiveService());

		System.out.println();
		System.out.println("Using local class");
		// Using local class - Level 3
		printPersons2(personList);

		System.out.println();
		System.out.println("Using anonymous class");
		// Using anonymous class - Level 4
		printPersons(personList, new CheckPerson1() {
			@Override
			public boolean test(Person p) {
				return p.getSex() == Person.Sex.MALE && p.getAge() >= 30 && p.getAge() <= 50;
			}
		});

		
		printPersons(personList, new CheckPerson1() {
			(Person p) -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 25
			);
			
		}
			    
		
	}

}
