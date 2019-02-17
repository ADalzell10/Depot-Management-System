package depots;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Driver implements scheduleCheck {
	protected String userName, password;
	protected List <WorkSchedule> schedules = new LinkedList<WorkSchedule>();

	public Driver() {
	
	}
	
	public Driver (String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * Checks if the password entered is correct.
	 * 
	 * @param password
	 * @return true
	 */
	
	public boolean checkPassword(String password){ 
		if(!password.equals(this.password)){
			System.out.println("!!Incorrect Password!!");
			return false;
		}
		return true;
	}
	
	
	public boolean isAvailable(){
	// checks if the vehicle has a current active or pending work schedule
		return true; 
	}
	
	// Getters and Setters
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Assigns a work schedule to a driver.
	 * @param client
	 * @param dateStart
	 * @param dateEnd
	 */
	
	public void setSchedule(String client, String dateStart, String dateEnd){
		schedules.add(new WorkSchedule(client, dateStart, dateEnd));	
	}
	
	/**
	 * Displays a drivers work schedules.
	 * 
	 * @return driver schedule
	 */
	
	public WorkSchedule getDriverSchedule(){
		for (WorkSchedule workSchedule : schedules) {
			System.out.print("Client: " + workSchedule.getClient() + " / Start Date: " + workSchedule.getDateStart() 
			+ " / End Date: " + workSchedule.getDateEnd() + "\n");			
		}
		return null;
	}

	@Override
	public void updateSchedule(WorkSchedule schedule) {
		
	}

	@Override
	public boolean checkOverlapping(Date date) {
		
		return false;
	}
	
}