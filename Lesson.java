import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Concrete lesson class.
 */

public class Lesson implements Serializable {

    private String type;
    private String venue;
    private String groupId;

    private String day, startTime, endTime, weeks;
    
    /**
     * Lesson constructor to create lesson object.
     */
    public Lesson(String type, String venue, String groupId, String day, String startTime, String endTime, String weeks) {
        this.type = type;
        this.venue = venue;
        this.groupId = groupId;;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weeks = weeks;
    }

    /**
     * Accessor method to get Lesson type.
     * @return
     */

    public String getType() {
        return this.type;
    }
    /**
     * Mutator method to set Lesson type.
     * @return
     */

    public void setType(String type) {
        this.type = type;
    }
    /**
     * Accessor method to get Lesson venue.
     * @return
     */

    public String getVenue() {
        return this.venue;
    }
    /**
     * Mutator method to set Lesson venue.
     * @return
     */

    public void setVenue(String venue) {
        this.venue = venue;
    }
    /**
     * Accessor method to get Lesson group id.
     * @return
     */

    public String getGroupId() {
        return this.groupId;
    }
    /**
     * Mutator method to set Lesson group id.
     * @return
     */

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    /**
     * Accessor method to get Lesson day
     * @return
     */

	public String getDay() {
		return day;
	}
    /**
     * Mutator method to set Lesson day
     * @return
     */

	public void setDay(String day) {
		this.day = day;
	}
    /**
     * Accessor method to get start time.
     * @return
     */

	public String getStartTime() {
		return startTime;
	}
    /**
     * Mutator method to set lesson start time.
     * @return
     */

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
    /**
     * Accessor method to get Lesson end time.
     * @return
     */

	public String getEndTime() {
		return endTime;
	}
    /**
     * Mutator method to set end time.
     * @return
     */

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
    /**
     * Accessor method to get Lesson weeks.
     * @return
     */

	public String getWeeks() {
		return weeks;
	}
    /**
     * Mutator method to set lesson weeks.
     * @return
     */

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}




	



}