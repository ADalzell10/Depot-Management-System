package depots;

import java.util.Date;

/**
 * Class used to set work schedules and get information.
 */

public class WorkSchedule {
	
	/**
	 * Enum for the three states a work schedule can be in.
	 */
	
	public static enum ScheduleState {
		PENDING, ACTIVE, ARCHIVED
	}
	
	private String client, dateStart, dateEnd;
	private Date startDate, endDate; 
	
	private ScheduleState state = ScheduleState.PENDING;
	
	private Vehicle vehicle;
	private Driver driver;
	
	public WorkSchedule() {
		
	}
	
	public WorkSchedule(String client, String dateStart, String dateEnd){ 
		this.client = client;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}
	
	/*
	public WorkSchedule(String client, Date startDate, Date endDate){ 
		this.client = client;
		this.startDate = startDate;
		this.endDate = endDate;
	}*/

	// Getters and Setters
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
	public String getDateStart() {
		return dateStart;
	}
	
	public String getDateEnd() {
		return dateEnd;
	}
	
}
