package queue.priorityqueue;

import java.util.PriorityQueue;

public class PriorrityQueueEx {

	static class Person implements Comparable<Person> {

		String name;
		int priority;

		public Person(String name, int priority) {
			this.name = name;
			this.priority = priority;
		}

		@Override
		public int compareTo(Person p) {
			// TODO Auto-generated method stub
			if (this.priority > p.priority) {
				return 1;
			} else {
				if (this.priority < p.priority) {
					return -1;
				} else {
					return 0;
				}
			}

		}
		
		@Override
		public String toString() {
			return "[" + name + " : " + priority + "]";
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Person> pq = new PriorityQueue<Person>();
		pq.add(new Person("Suzy", 3));
		pq.add(new Person("Jenny", 1));
		pq.add(new Person("Steve", 2));
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}

	}

}
