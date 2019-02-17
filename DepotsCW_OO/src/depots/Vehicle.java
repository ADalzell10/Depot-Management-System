package depots;

import java.util.LinkedList;
import java.util.List;

public abstract class Vehicle implements scheduleCheck {
	
	protected String make, model, regNo;
	protected int weight;
	protected List <WorkSchedule> schedules = new LinkedList<WorkSchedule>();
	
	
	//not used yet
	protected WorkSchedule scheduleActive;
	
	
	public Vehicle(){
		
	}
		
	public Vehicle(String make, String model, String regNo, int weight){
		this.make = make;
		this.model = model;
		this.regNo = regNo;
		this.weight = weight;
	}
	
	public boolean isAvailable(){
		// checks if the vehicle has a current active or pending work schedule
		return true;	
	}
	
	// Getters and Setters
	
	public String getMake() {
		return this.make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getRegNo() {
		return this.regNo;
	}
	
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * Assigns a work schedule to a vehicle.
	 * 
	 * @param client
	 * @param dateStart
	 * @param dateEnd
	 */
	
	public void setSchedule(String client, String dateStart, String dateEnd){
		schedules.add(new WorkSchedule(client, dateStart, dateEnd));	
	}
	
}
