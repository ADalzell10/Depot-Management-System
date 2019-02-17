package depots;

import java.util.Date;

public class Tanker extends Vehicle {
	
	private int liquidCapacity; // or private int intLiquidCapacity = -1;??
	private String liquidType; // or private String strLiquidType = "Unspecified";??
	
	public Tanker() {
		super();
	}
	
	public Tanker(String make, String model, String regNo, int weight, int liquidCapacity, String liquidType) {
		super(make, model, regNo, weight);
		this.liquidCapacity = liquidCapacity;
		this.liquidType = liquidType;
		
	}
	
	// Getters and Setters
	public int getCapacity() {
		return this.liquidCapacity;
	}
	
	public void setCapacity(int liquidCapacity) {
		this.liquidCapacity = liquidCapacity;
	}

	public String getLiquidType() {
		return this.liquidType;
	}
	
	public void setLiquidType(String liquidType) {
		this.liquidType = liquidType;
	}

	@Override
	public void updateSchedule(WorkSchedule schedule) {
		
	}

	@Override
	public boolean checkOverlapping(Date date) {
		return false;
	}
		
}