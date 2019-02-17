package depots;

import java.util.Date;

public class Truck extends Vehicle {
	private int cargoCapacity; 
	
	public Truck() {
		super();
	}
	
	public Truck(String make, String model, String regNo, int weight, int cargoCapacity) {
		super(make, model, regNo, weight);
		this.cargoCapacity = cargoCapacity;
	}
	
	// Getters and Setters
	public int getCargoCapacity() {
		return this.cargoCapacity;
	}
	
	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	@Override
	public void updateSchedule(WorkSchedule schedule) {
		
	}

	@Override
	public boolean checkOverlapping(Date date) {
		return false;
	}

}