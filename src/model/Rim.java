package model;

public class Rim {
	private int rimID;
	private String rimName;
	private int rimDiameter;
	private int rimWidth;
	private int rimDepth;
	private int rimHole;
	private int rimStockQuant;
	
	public Rim(int rimID, String rimName, int rimDiameter, int rimWidth, int rimDepth, int rimHole, int rimStockQuant) {

		this.rimID = rimID;
		this.rimName = rimName;
		this.rimDiameter = rimDiameter;
		this.rimWidth = rimWidth;
		this.rimDepth = rimDepth;
		this.rimHole = rimHole;
		this.rimStockQuant = rimStockQuant;
		
	}

	public int getRimID() {
		return rimID;
	}

	public void setRimID(int rimID) {
		this.rimID = rimID;
	}

	public String getRimName() {
		return rimName;
	}

	public void setRimName(String rimName) {
		this.rimName = rimName;
	}

	public int getRimDiameter() {
		return rimDiameter;
	}

	public void setRimDiameter(int rimDiameter) {
		this.rimDiameter = rimDiameter;
	}

	public int getRimWidth() {
		return rimWidth;
	}

	public void setRimWidth(int rimWidth) {
		this.rimWidth = rimWidth;
	}

	public int getRimDepth() {
		return rimDepth;
	}

	public void setRimDepth(int rimDepth) {
		this.rimDepth = rimDepth;
	}

	public int getRimHole() {
		return rimHole;
	}

	public void setRimHole(int rimHole) {
		this.rimHole = rimHole;
	}
	
	public int getRimStockQuant(){
		return rimStockQuant;
	}
	
	public void setRimStockQuant(int rimStockQuant){
		this.rimStockQuant = rimStockQuant;
	}
}
