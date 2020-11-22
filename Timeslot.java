import java.time.*;
import java.io.Serializable;

/**
 * Concrete class to create timeslot objects.
 */

public class Timeslot implements Serializable{

    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;
    private int[] weeks;

    /**
     * Constructor method for timeslot object
     * @param day
     * @param startTime
     * @param endTime
     * @param weeks
     */

    public Timeslot(DayOfWeek day, LocalTime startTime, LocalTime endTime, int[] weeks) {
		// TODO Auto-generated constructor stub
    	this.day = day;
    	this.startTime = startTime;
    	this.endTime = endTime;
        this.weeks = weeks;
	}


	public DayOfWeek getDay() {
        return this.day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int[] getWeeks() {
        return this.weeks;
    }

    public void setWeeks(int[] weeks) {
        this.weeks = weeks;
    }

}