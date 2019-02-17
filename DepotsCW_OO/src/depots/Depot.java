package depots;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Stores depot information.
 */

public class Depot {
	
	private String location;
	
	private List<Vehicle> vehicles = new LinkedList<Vehicle>();
	private List<Driver> drivers = new LinkedList<Driver>();
	private List<WorkSchedule> schedules = new LinkedList<WorkSchedule>();
	
	public Depot(String location) {
		this.setLocation(location);
		
		if(location.equals("liverpool")) {
			vehicles.add(new Truck("Ford", "Transit", "TR1234", 100, 200));
	    	vehicles.add(new Tanker("Merc", "Duke", "TA1234", 80, 160, "chemical"));
	    	
			drivers.add(new Driver("bob", "123"));
			drivers.add(new Manager("bill", "123"));
				
		}
		else {
			if(location.equals("manchester")){
				drivers.add(new Driver("ben", "123"));
				drivers.add(new Manager("tom", "123"));
				
				vehicles.add(new Truck("Audi", "Banger", "TR5678", 150, 250));
				vehicles.add(new Tanker("Reo", "Hazard", "TA5678", 90, 180, "normal"));
				vehicles.add(new Truck("Ford", "Transit", "TR1234", 100, 200));
			}
		}
	}
	
	
	/**
	 * Checks username and password entered to test if they are valid.
	 * 
	 * @param userName
	 * @param password
	 * @return driver
	 */

	public Driver logOn(String userName, String password){
		for (Driver driver : drivers) {
			if(driver.getUserName().equals(userName)){
				if(driver.checkPassword(password)){
					return driver;
				}
			}
		}
		return null;		
	}
	
	public Driver getDriverByUserName(String userName) {
		for (Driver driver : drivers) {
			if(driver.getUserName().equals(userName)){		
				return driver;
			} 
		}
		System.out.println("!!Username not found.!!");
		return null;
	}
	
	/*public void setupWorkSchedule(String client, Date dateStart, Date dateEnd){
		schedules.add(new WorkSchedule(client, dateStart, dateEnd));
		
	}*/
	
	/**
	 * Setups up a work schedule.
	 * 
	 * @param client
	 * @param dateStart
	 * @param dateEnd
	 */
	
	public void setupWorkSchedule(String client, String dateStart, String dateEnd){
		schedules.add(new WorkSchedule(client, dateStart, dateEnd));	
	}
	
	/**
	 * Adds a work schedule to the drivers schedule.
	 * 
	 * @param userName
	 * @param client
	 * @param dateStart
	 * @param dateEnd
	 * @return driver
	 */
	
	public Driver setupDriverSchedule(String userName, String client, String dateStart, String dateEnd){
		for (Driver driver : drivers) {
			if(driver.getUserName().equals(userName)){
				driver.setSchedule(client, dateStart, dateEnd);;
				return driver;
			}
		}
		return null;	
	}
	
	/**
	 * Checks if the reg No entered by a user exists already.
	 * 
	 * @param regNo
	 * @return true
	 */
	
	public boolean checkRegNoExists(String regNo) {
		for (Vehicle vehicle : vehicles) {
			if(regNo.equals(vehicle.getRegNo())){
				return false;
			}
		}
		return true;
			
	}
	
	/**
	 * Checks if the user entered by a manager already exists.
	 * 
	 * @param userName
	 * @return true
	 */
	
	public boolean checkUserExists(String userName) {
		for (Driver driver : drivers) {
			if(userName.equals(driver.getUserName())){
				return false;
			}
		}
		return true;		
	}
	
	
	public void addTruck(String make, String model, String regNo, int weight, int cargoCapacity) {
		vehicles.add(new Truck(make, model, regNo, weight, cargoCapacity));
	}
	
	public void addTanker(String make, String model, String regNo, int weight, int liquidCapacity, String liquidType) {
		vehicles.add(new Tanker(make, model, regNo, weight, liquidCapacity, liquidType));
	}
	
	public void addDriver(String userName, String password) {
		drivers.add(new Driver(userName, password));
	}
	
	public void addManager(String userName, String password) {
		drivers.add(new Manager(userName, password));
	}
	
	// Getters and Setters
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Searches for a reg No that has been entered by the user.
	 * 
	 * @param regNo
	 * @return vehicle
	 */
	
	public Vehicle getVehicleByReg(String regNo) {
		for (Vehicle vehicle : vehicles) {
			if(vehicle.getRegNo().equals(regNo)){
				System.out.println("Make: " + vehicle.getMake() + " / Model: " + vehicle.getModel() 
					+ " / Reg No: " + vehicle.getRegNo() + " / Weight: " + vehicle.getWeight());
				return vehicle;
			}
		}
		System.out.println("!!Error, Could not find a vehicle with that Reg No.!!");
		return null;
	}
	
	public Vehicle getAllVehicles(){
		for (Vehicle vehicle : vehicles) {
			System.out.print("Make: " + vehicle.getMake() + " / Model: " + vehicle.getModel() + 
					" / Reg No: " + vehicle.getRegNo() + " / Weight: " + vehicle.getWeight() + "\n");
		}
		return null;	
	}
	
	public Driver getAllDrivers(){
		for (Driver driver : drivers) {
			System.out.print(driver.getUserName() + "\n");			
		}
		return null;
	}
	
	public WorkSchedule getAllWorkSchedules(){
		for (WorkSchedule workSchedule : schedules) {
			System.out.print("Client: " + workSchedule.getClient() + " / Start Date: " + workSchedule.getDateStart() 
			+ " / End Date: " + workSchedule.getDateEnd() + "\n");			
		}
		return null;
	}
	
	public Driver getDriverSchedule(String userName){
		for (Driver driver : drivers) {
			if (userName.equals(driver.getUserName()))	{		
				driver.getDriverSchedule();
			}
		}
		return null;
	}
	
}