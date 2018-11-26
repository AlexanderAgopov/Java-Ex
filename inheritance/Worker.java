package inheritance;

public class Worker extends Human implements Comparable<Worker> {

	private int salary;
	private int workHours;

	public Worker(String firstName, String lastName, int salary, int workHours) {
		super(firstName, lastName);
		this.salary = salary;
		this.workHours = workHours;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getWorkHours() {
		return workHours;
	}

	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}

	public double calculateHourIncome() {
		return this.salary / this.workHours;
	}

	@Override
	public int compareTo(Worker worker) {
		if (this.salary > worker.salary) {
			return 1;
		}
		if (this.salary < worker.salary) {
			return -1;
		}
		return 0;
	}

}
