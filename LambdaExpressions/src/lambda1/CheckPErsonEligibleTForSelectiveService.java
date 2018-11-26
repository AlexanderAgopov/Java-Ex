package lambda1;

public class CheckPErsonEligibleTForSelectiveService implements CheckPerson {
	
	

	public CheckPErsonEligibleTForSelectiveService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean test(Person p) {
		// TODO Auto-generated method stub
		return p.getSex() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
	}

}
