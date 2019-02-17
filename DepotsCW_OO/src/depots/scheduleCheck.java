package depots;

import java.util.Date;

public interface scheduleCheck {
	
	// not implemented correctly due to issues getting date formatted
	
	public void updateSchedule(WorkSchedule schedule);
	
	public boolean checkOverlapping(Date date);
}