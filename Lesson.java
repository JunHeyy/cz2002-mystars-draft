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
     * Lesson constructor for lesson object
     * @param type String variable, type of
     * @param venue String variable, Venue of the lesson.
     * @param groupId String variable, Group id of the lesson.
     * @param day String variable, day of the lesson.
     * @param startTime String variable, start time of the lesson.
     * @param endTime String variable, end time of the lesson.
     * @param weeks String variable, week of the lesson.
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
     * @return the Type of the lesson
     */

    public String getType() {
        return this.type;
    }

    /**
     * Mutator method to set
     * @param type String variable
     */

    public void setType(String type) {
        this.type = type;
    }
    /**
     * Accessor method to get Lesson venue.
     * @return Venue of the lesson
     */

    public String getVenue() {
        return this.venue;
    }
    /**
     * Mutator method to set the venue of the lesson.
     * @param venue String variable
     */

    public void setVenue(String venue) {
        this.venue = venue;
    }
    /**
     * Accessor method to get Lesson group id.
     * @return group id of the lesson
     */

    public String getGroupId() {
        return this.groupId;
    }
    /**
     * Mutator method to set group id of the lesson.
     * @param groupId String variable, group id of the lesson
     */


    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    /**
     * Accessor method to get Lesson day.
     * @return Day of the lesson
     */

	public String getDay() {
		return day;
	}
    /**
     * Mutator method to set.
     * @param day String variable
     */


	public void setDay(String day) {
		this.day = day;
	}
    /**
     * Accessor method to get start time.
     * @return start time of the lesson.
     */

	public String getStartTime() {
		return startTime;
	}
    /**
     * Mutator method to set the start time of the lesson.
     * @param startTime String variable, start time of the lesson.
     */


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
    /**
     * Accessor method to get Lesson end time.
     * @return String variable, end time of the lesson.
     */

	public String getEndTime() {
		return endTime;
	}
    /**
     * Mutator method to set the end time of the lesson.
     * @param endTime String variable
     */


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
    /**
     * Accessor method to get Lesson weeks.
     * @return Weeks of the lesson
     */

	public String getWeeks() {
		return weeks;
	}
    /**
     * Mutator method to set.
     * @param weeks String variable
     */

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}




	



}