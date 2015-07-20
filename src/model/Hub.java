package model;

public class Hub {

	private int hubID;
	private String hubName;
	private int flangeDiameterDrive;
	private int flangeDiameterNonDrive;
	private int flangeDistance;
	private boolean isDished;
	private WheelType hubType;
	private int hubHole;
	private int hubStockQuant;

	public Hub() {

	}

	public Hub(int hubID, String hubName, int flangeDiameterDrive, int flangeDiameterNonDrive, int flangeDistance, boolean isDished, WheelType hubType, int hubHole, int hubStockQuant) {
		this.hubID = hubID;
		this.hubName = hubName;
		this.flangeDiameterDrive = flangeDiameterDrive;
		this.flangeDiameterNonDrive = flangeDiameterNonDrive;
		this.flangeDistance = flangeDistance;
		this.isDished = isDished;
		this.hubType = hubType;
		this.hubHole = hubHole;
	}

	public int getHubID() {
		return hubID;
	}

	public void setHubID(int hubID) {
		this.hubID = hubID;
	}

	public String getHubName() {
		return hubName;
	}

	public void setHubName(String hubName) {
		this.hubName = hubName;
	}

	public int getFlangeDiameterDrive() {
		return flangeDiameterDrive;
	}

	public void setFlangeDiameterDrive(int flangeDiameterDrive) {
		this.flangeDiameterDrive = flangeDiameterDrive;
	}

	public int getFlangeDiameterNonDrive() {
		return flangeDiameterNonDrive;
	}

	public void setFlangeDiameterNonDrive(int flangeDiameterNonDrive) {
		this.flangeDiameterNonDrive = flangeDiameterNonDrive;
	}

	public int getFlangeDistance() {
		return flangeDistance;
	}

	public void setFlangeDistance(int flangeDistance) {
		this.flangeDistance = flangeDistance;
	}

	public boolean isDished() {
		return isDished;
	}

	public void setDished(boolean isDished) {
		this.isDished = isDished;
	}

	public WheelType getHubType() {
		return hubType;
	}

	public void setHubType(WheelType hubType) {
		this.hubType = hubType;
	}

	public int getHubHole() {
		return hubHole;
	}

	public void setHubHole(int hubHole) {
		this.hubHole = hubHole;
	}

	public int getHubStockQuant() {
		return hubStockQuant;
	}

	public void setHubStockQuant(int hubStockQuant) {
		this.hubStockQuant = hubStockQuant;
	}
}
