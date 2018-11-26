package queue.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMessages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> queue = new LinkedList<String>();
		queue.offer("Message 1");
		queue.offer("Message 2");
		queue.offer("Message 3");
		queue.offer("Message 4");
		
		while(queue.size() > 0) {
			String msg = queue.poll();
			System.out.println(msg);
		}

	}

}
