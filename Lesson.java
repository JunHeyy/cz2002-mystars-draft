import java.io.Serializable;
import java.util.ArrayList;

public class Lesson implements Serializable {

    private String type;
    private String venue;
    private String groupId;
    private ArrayList<Timeslot> timeslots;

    public Lesson(String type, String venue, String groupId, ArrayList<Timeslot> timeslots) {
        this.type = type;
        this.venue = venue;
        this.groupId = groupId;
        this.timeslots = timeslots;
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

    public ArrayList<Timeslot> getTimeslots() {
        return this.timeslots;
    }

    public void setTimeslots(ArrayList<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }
    public String toString() {
    	return this.type +","+ this.venue + "," +this.groupId +","+this.timeslots;
    }
}
