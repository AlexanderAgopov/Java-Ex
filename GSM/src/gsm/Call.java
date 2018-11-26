package gsm;

import java.util.*;

public class Call {

	private static Date startTime = new Date();
	private long startCall;
	private int callDuration;
	private static ArrayList calls = new ArrayList();

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(int callDuration) {
		this.callDuration = callDuration;
	}

	public Call(long startCall, int callDuration) {
		super();
		this.startCall = startTime.getTime();
		this.callDuration = callDuration;
	}

	public void printCallInfo() {
		System.out.println("The starting time of the call is: " + this.startTime);
		System.out.println("The duration of the call is " + this.callDuration + " minutes.");
	}

	public static ArrayList callHistory() {
		return calls;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Call call1 = new Call(startTime.getTime(), 10);
		Call call2 = new Call(startTime.getTime(), 15);
		Call call3 = new Call(startTime.getTime(), 5);

		calls.add(call1);
		calls.add(call2);
		calls.add(call3);

		System.out.println(callHistory());
		int callTimeSum = 0;
		for(Object call: calls.toArray()) {
			((Call) call).printCallInfo();
			System.out.println();
			callTimeSum += ((Call) call).callDuration;
		}
		
		double pricePerMinute = 0.12;
		double priceCallSum = callTimeSum * pricePerMinute;
		System.out.printf("%nYour bill is: %.2f.%n", priceCallSum);

		calls.remove(call1);

		for (int i = 0; i < calls.size(); i++) {

		}

		calls.removeAll(calls);

	}

}
