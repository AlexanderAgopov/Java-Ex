package gsm;

public class GSM {

	private String gsmManufacturer;
	private String gsmModel;
	private int gsmPrice;
	private double displaySize;
	private Battery battery;
	private static String huawei = "new model, price: 100 euro";

	public GSM() {

	}

	public GSM(String gsmManufacturer, String gsmModel, int gsmPrice, double displaySize, Battery baterry) {
		super();
		this.gsmManufacturer = gsmManufacturer;
		this.gsmModel = gsmModel;
		this.gsmPrice = gsmPrice;
		this.displaySize = displaySize;
		this.battery = new Battery();
	}

	public String getGsmManufacturer() {
		return gsmManufacturer;
	}

	public void setGsmManufacturer(String gsmManufacturer) {
		this.gsmManufacturer = gsmManufacturer;
	}

	public String getGsmModel() {
		return gsmModel;
	}

	public void setGsmModel(String gsmModel) {
		this.gsmModel = gsmModel;
	}

	public int getGsmPrice() {
		return gsmPrice;
	}

	public void setGsmPrice(int gsmPrice) {
		this.gsmPrice = gsmPrice;
	}

	public double getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}

	public Battery getBattery() {
		return battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	public void printPhoneFullInfo() {
		System.out.printf("%nManufacturer: %s%nModel: %s%nPrice: %s%nDisplay size: %s%n", this.gsmManufacturer,
				this.gsmModel, this.gsmPrice, this.displaySize);
		
	}
	
	public void printBatInformation() {
		this.battery.printBatteryInfo();
	}

	public static void printHuawei() {
		System.out.println("Information for Huawei: " + huawei);
	}

}
