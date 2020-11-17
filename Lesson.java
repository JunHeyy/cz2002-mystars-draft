import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lesson implements Serializable {

    private String type;
    private String venue;
    private String groupId;

    private String day, startTime, endTime, weeks;
    

    public Lesson(String type, String venue, String groupId, String day, String startTime, String endTime, String weeks) {
        this.type = type;
        this.venue = venue;
        this.groupId = groupId;;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weeks = weeks;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVenue() {
        return this.venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getWeeks() {
		return weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}




	



}