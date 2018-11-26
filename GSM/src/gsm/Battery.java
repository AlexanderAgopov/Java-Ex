package gsm;

public class Battery {
	private String batteryModel;
	private int batteryIdleTime;
	private double batteryHoursTalk;

	public Battery() {

	}

	public Battery(String batteryModel, int batteryIdleTime, double batteryHoursTalk) {
		this.batteryModel = batteryModel;
		this.batteryIdleTime = batteryIdleTime;
		this.batteryHoursTalk = batteryHoursTalk;
	}
	
	public void printBatteryInfo() {
		System.out.printf("%nBattery model: %s%nBattery idle time: %s%nBattery hours talk: %s%n",
				this.batteryModel, this.batteryIdleTime, this.batteryHoursTalk);
	}
}
