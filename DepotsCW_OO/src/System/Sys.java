package System;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import depots.Depot;
import depots.Driver;
import depots.Manager;
import depots.Vehicle;
import depots.WorkSchedule;

/**
 * Performs all input and output to the console.
 */

public class Sys {
	private final static Scanner S = new Scanner(System.in);
	
	private List<Depot> depots = new LinkedList<Depot>();
	
	private Depot depot;
	private Driver driver;
	private Manager manager;
	
	/**
	 * Addition of two new depots.
	 */
	
	public Sys(){
		depots.add(new Depot("liverpool"));
		depots.add(new Depot("manchester"));				
	}
	
	/**
	 * Displays the starting menu for the system.
	 */
	
	public void entryMenu(){
		String choice = "";
		
				
		do {
			System.out.println("-- Menu --");
			System.out.println("1 - Log On");
			System.out.println("Q - Quit");
			System.out.print("Choice: ");
			choice = S.nextLine().toUpperCase();
			
			System.out.println();
			
			switch(choice) {
				case "1":  {
					logOn();
					break;
				}
			}
		
		} while (!choice.equals("Q"));
		System.out.println("Session Ended.");
	}
	
	/**
	 * Attempts to log the user onto the system.
	 * 
	 * @return menu - either driver menu or manager menu.
	 */
	
	private void logOn(){
		displayDepots();
		System.out.println();
		
		System.out.print("Location: ");
		String location = S.nextLine();
		
		System.out.print("Username: ");
		String userName = S.nextLine();
		
		System.out.print("Password: ");
		String password = S.nextLine();
		
		depot = getDepotByLocation(location);
		if (depot != null) {
	
		}
		
		driver = depot.getDriverByUserName(userName);
		
		if (driver != null) {
			if (driver.checkPassword(password)) {
				if (Manager.class.isInstance(driver)) {
					manager = Manager.class.cast(driver);
					managerMenu();
				}
				else driverMenu();
			}
			else {
				System.out.println("Returning to Log In Screen.");
			}
		}
		
	}
	
	/**
	 * Displays all depots to the user
	 * 
	 * @return list of depots
	 */
	
	private void displayDepots() {
		System.out.println("-- Depots --");
		
		for (Depot depot : depots) {
			System.out.println(depot.getLocation());
		}
		
	}
	
	/**
	 * Gets the depot the user has entered.
	 * 
	 * @param location
	 * @return depot
	 */
	
	private Depot getDepotByLocation(String location) {
		for (Depot depot : depots) {
			if (depot.getLocation().equals(location)) {
				return depot;
			}
		}
		System.out.println("!!Please enter a depot from the list.!!");
		return null;
	}
	
	/**
	 * Displays the manager menu.
	 */
	
	private void managerMenu() {
		String choice = "";
		
		do {
			System.out.println();
			System.out.println("-- Manager Menu --");
			System.out.println("1 - Move Vehicle");
			System.out.println("2 - Setup Schedule");
			System.out.println("3 - Display Vehicles");
			System.out.println("4 - Display Drivers");
			System.out.println("5 - Display Work Schedules");
			System.out.println("6 - View My Work Schedule");
			System.out.println("7 - Add User");
			System.out.println("8 - Add Vehicle");
			System.out.println("Q - Quit");
			System.out.print("Choice: ");
			
			choice = S.nextLine().toUpperCase();
			
			switch(choice) {
				case "1":  {
					moveVehicle();
					break;
				}
				case "2":  {
					setupSchedule();
					break;
				}
				case "3":  {
					displayVehicles();
					break;
				}
				case "4":  {
					displayDrivers();
					break;
				}
				case "5":  {
					displaySchedules();
					break;
				}
				case "6":  {
					viewMyWorkSchedule();
					break;
				}
				case "7":  {
					addUser();
					break;
				}
				case "8":  {
					addVehicle();
					break;
				}
				
			}
			
			
		} while (!choice.equals("Q"));
		System.out.println("Logging Off.");
		
	}
	
	/**
	 * Moves a vehicle from one depot to another.
	 * 
	 * @return Transfer details
	 */
	
	private void moveVehicle() {
		//getting details for work schedule
		System.out.println("-- Vehicle Transfer --");
		System.out.print("Enter Depot: ");
		String depot = S.next();
		
		System.out.print("Specify Transfer Date: ");
		String transferDate = S.next();
		
		System.out.println();
		System.out.print("Vehicles Available for Transfer: \n");
		displayAvailableVehicles();
		System.out.print("Enter Vehicle Reg No: ");
		String regNo = S.next();
		
		System.out.println();
		System.out.println("-- Available Drivers --");
		displayAvailableDrivers();
		System.out.print("Enter Driver Name: ");
		String driver = S.next();
		
		System.out.println();
		System.out.println("Vehicle Transfer Details: \n" + "Transfer Location: " + depot + " / Vehicle Reg No: " + regNo
			+ " / Transfer Date: " + transferDate);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() { 
		   @Override  
		   public void run() {
			   System.out.println();
			   System.out.println("Vehicle transferred successfully."); 
		   }
		},  3000);

		//System.out.println("Vehicle transferred successfully.");
			
	}
	
	//Tried to parse date read from keyboard
	//Kept returning null when adding it to a new schedule
	/*
	private void setupThisSchedule(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		WorkSchedule schedule = new WorkSchedule();
		
		System.out.print("Enter Client Name: ");
		String client = S.next();
		
		System.out.println("Enter Start Date (dd-MM-yy): ");
		String startDate = S.next();
		
		Date dateStart = null;
		try {
			dateStart = sdf.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(sdf.format(dateStart));
		
		
		System.out.println("Enter End Date (dd-MM-yy): ");
		String endDate = S.next();
		
		Date dateEnd = null;
		try {
			dateEnd = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(sdf.format(dateEnd));
		depot.setupWorkSchedule(client, dateStart, dateEnd);
	}*/
	
	/**
	 * Sets up a work schedule for a job.
	 */
	
	private void setupSchedule() {
		//getting details for work schedule
		System.out.println();
		System.out.println("-- Setup Work Schedule --");
		System.out.print("Enter Client Name: ");
		String client = S.next();
		
		System.out.print("Specify Start Date: ");
		String dateStart = S.next();
		
		System.out.print("Specify End Date: ");
		String dateEnd = S.next();
		
		System.out.println();
		System.out.println("-- Available Vehicles --");
		displayAvailableVehicles();
		System.out.print("Enter Vehilce Reg: ");
		String regNo = S.next();
		
		System.out.println();
		System.out.println("-- Available Drivers --");
		displayAvailableDrivers();
		System.out.print("Enter Driver Name: ");
		String driver = S.next();
		
		System.out.println();
		System.out.println("Job Details: \n" + "Client: " + client + " / Start Date: " + dateStart
				+ " / End Date: " + dateEnd + " / Vehicle: " + regNo + " / Driver: " + driver);
		depot.setupWorkSchedule(client, dateStart, dateEnd);
		depot.setupDriverSchedule(driver, client, dateStart, dateEnd);
		
	}
	
	/**
	 * Displays a vehicle menu.
	 */
	
	private void displayVehicles() {
		String choice = "";
		
		do {
			System.out.println();
			System.out.println("-- Vehicle Menu --");
			System.out.println("1 - Show All Vehicles");
			System.out.println("2 - Search for Vehicle using Reg No");
			System.out.println("Q - Quit");
			System.out.print("Choice: ");
			choice = S.nextLine().toUpperCase();
			
			switch(choice) {
				case "1":  {
				displayAllVehicles();
				break;
				}
				case "2":  {
				displayThisVehicle();
				break;
				}
			}
		} while (!choice.equals("Q"));
		System.out.println("Leaving Vehicle Menu.");
			
	}
	
	/**
	 * Displays all vehicles in the depot.
	 * 
	 * @return list of vehicles.
	 */
	
	private void displayAllVehicles() {
		System.out.println("-- Vehicles --");
		depot.getAllVehicles();
	}
	
	/**
	 * Displays a specific vehicle based on the reg No.
	 * 
	 * @return vehicle
	 */
	
	private void displayThisVehicle(){
	    
		System.out.println("Enter Vehicle Reg No: ");
		String regNo = S.nextLine();
		depot.getVehicleByReg(regNo);	
	}
	
	/**
	 * Displays available vehicles
	 * 
	 * @return list of available vehicles.
	 */
	
	private void displayAvailableVehicles() {
		depot.getAllVehicles();
	}
	
	/**
	 * Displays all drivers in the depot.
	 * 
	 * @return list of drivers.
	 */
	
	private void displayDrivers() {
		System.out.println();
		System.out.println("-- Drivers --");
		depot.getAllDrivers();
	}
	
	/**
	 * Displays all available drivers.
	 * 
	 * @return list of available drivers.
	 */
	
	private void displayAvailableDrivers() {
		depot.getAllDrivers();
	}
	
	/**
	 * Displays all current work schedules.
	 * 
	 * @return list of work schedule details.
	 */
	
	private void displaySchedules() {
		System.out.println();
		System.out.println("-- Work Schedules --");
		depot.getAllWorkSchedules();
	}
	
	/**
	 * Adds a user to the system.
	 * 
	 * @return new user.
	 */
	
	private void addUser() {
		//getting details for new user/driver
		System.out.println();
		System.out.println("-- Add a New User --");
		System.out.print("Enter the Type of user you will be adding (Driver/Manager): ");
		String type = S.next();	
		
		if (type.equalsIgnoreCase("driver")) {
		
		System.out.print("Enter Username for Driver: ");
		String userName = S.next();
						
		System.out.print("Enter Password for Driver: ");
		String password = S.next();
				
		System.out.println();
		System.out.println("New User/Driver Details: \n" + "Username: " + userName + " / Password: " + password);
		depot.checkUserExists(userName);
		if (depot.checkUserExists(userName) == true){
			depot.addDriver(userName, password);
			System.out.println("User added successfully!");
			} else {
				System.out.println("User not added! Username already exists!");
			}
		} else if (type.equalsIgnoreCase("manager")) {
			System.out.print("Enter Username for Manager: ");
			String userName = S.next();
							
			System.out.print("Enter Password for Manager: ");
			String password = S.next();
					
			System.out.println();
			System.out.println("New User/Manager Details: \n" + "Username: " + userName + " / Password: " + password);
			if (depot.checkUserExists(userName) == true){
				depot.addManager(userName, password);
				System.out.println("User added successfully!");
				} else {
					System.out.println("User not added! Username already exists!");
				}
		} else {
			System.out.println("Please enter if the user is a Driver or a Manager.");
		}
	}
	
	/**
	 * Adds a new vehicle to the depot.
	 * 
	 * @return new vehicle.
	 */
	
	private void addVehicle() {
		//getting details for new vehicle
		System.out.println();
		System.out.println("-- Add a New Vehicle --");
		System.out.println("Enter the Type of Vehicle you will be adding (Truck/Tanker):");
		String type = S.next();
		
		if (type.equalsIgnoreCase("truck")) {
		
		System.out.print("Enter Vehicle Make: ");
		String make = S.next();
				
		System.out.print("Enter Vehicle Model: ");
		String model = S.next();
				
		System.out.print("Enter Vehicle reg No: ");
		String regNo = S.next();
				
		System.out.print("Enter Vehicle Weight: ");
		int weight = S.nextInt();
		
		System.out.print("Enter Vehicle Cargo Capacity: ");
		int cargoCapacity = S.nextInt();
		
		System.out.println();
		System.out.println("New Vehicle Details: \n" + "Make: " + make + " / Model: " + model
				+ " / Reg No: " + regNo + " / Weight: " + weight + " / Cargo Capacity: " + cargoCapacity);
		depot.checkRegNoExists(regNo);
			if (depot.checkRegNoExists(regNo) == true){
				depot.addTruck(make, model, regNo, weight, cargoCapacity);
				System.out.println("Vehicle added successfully!");
			} else {
				System.out.println("Vehicle not added! Reg No already exists!");
			}
		} else if(type.equalsIgnoreCase("tanker")) {
		
			System.out.print("Enter Vehicle Make: ");
			String make = S.next();
		
			System.out.print("Enter Vehicle Model: ");
			String model = S.next();
				
			System.out.print("Enter Vehicle reg No: ");
			String regNo = S.next();
				
			System.out.print("Enter Vehicle Weight: ");
			int weight = S.nextInt();
		
			System.out.print("Enter Vehicle Liquid Capacity: ");
			int liquidCapacity = S.nextInt();
		
			System.out.print("Enter Vehicle Liquid Type: ");
			String liquidType = S.next();
		
			System.out.println();
			System.out.println("New Vehicle Details: \n" + "Make: " + make + " / Model: " + model
					+ " / Reg No: " + regNo + " / Weight: " + weight + " / Liquid Capcity: " + liquidCapacity
					+ " / Liquid Type: " + liquidType);
			depot.checkRegNoExists(regNo);
				if (depot.checkRegNoExists(regNo) == true){
					depot.addTanker(make, model, regNo, weight, liquidCapacity, liquidType);
					System.out.println("Vehicle added successfully!");
				} else {
					System.out.println("Vehicle not added! Reg No already exists!");
				}
		} else {
			System.out.println("Please choose either Truck or Tanker");
		}
	}
	
	/**
	 * Displays the driver menu.
	 */
	
	private void driverMenu() {
		String choice = "";
		
		do {
			System.out.println();
			System.out.println("-- Driver Menu --");
			System.out.println("1 - View My Work Schedule");
			System.out.println("Q - Quit");
			System.out.print("Choice: ");
			
			choice = S.nextLine().toUpperCase();
			
			switch(choice) {
				case "1":  {
					viewMyWorkSchedule();
					break;
				}
			}
		} while (!choice.equals("Q"));
		System.out.println("Logging Off.");
		
	}
	
	/**
	 * Displays the work schedule for a specific driver.
	 * 
	 * @return driver work schedule.
	 */

	private void viewMyWorkSchedule() {
		System.out.println();
		System.out.println("Please Re-enter your Username for Security: ");
		String userName = S.next();
		
		System.out.println("Your Work Schedule: ");
		depot.getDriverSchedule(userName);
	}
	
}
