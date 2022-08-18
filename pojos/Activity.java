import java.util.Date;
import java.util.Objects;

public class Activity {
    /**
     * Unique id for the Activity
     */
    private Integer id;
    /**
     * Id of the current client assign to the activity (Client 1-M Activity)
     */
    private Integer assignee_id;
    /**
     * Id of the category group to which the activity belongs (Category 1-M Activity)
     */
    private Integer category_id;
    /**
     * Id of the state group to which the activity belongs (Category 1-M State)
     */
    private Integer state_id;
    /**
     * Name of the activity
     */
    private String name;
    /**
     * Start date of the activityu
     */
    private Date start;
    /**
     * End date for the activity
     */
    private Date end;
    /**
     * Projected missing hour to completion
     */
    private Float missingHours;
    /**
     * Decription of the activity
     */
    private String description;
    /**
     * completed hours for the activity
     */
    private Float completedHours;

    /**
     * Activity constructor
     * @param id unique id for the activity
     * @param assignee_id the current id for the client assign to the activity
     * @param category_id the id of the category group
     * @param state_id the id of the current state for the activity
     * @param name name for the activity
     * @param start start date
     * @param end end date
     * @param missingHours missing hours
     * @param description a complementary description for the activity
     * @param completedHours completed hours
     * @throws Exception
     */
    public Activity(Integer id, Integer assignee_id, Integer category_id, Integer state_id, String name, Date start, Date end, Float missingHours, String description, Float completedHours) throws Exception {
        if(id==null) throw new Exception("Id can´t be null");
        if(category_id==null) throw new Exception("Category_id can´t be null");
        if(state_id==null) throw new Exception("State_id can´t be null");
        if(name==null) throw new Exception("name can´t be null");
        if(start==null) throw new Exception("start can´t be null");
        if(end==null) throw new Exception("end can´t be null");
        if(missingHours==null) throw new Exception("missing hours can´t be null");
        if(completedHours==null) throw new Exception("completed hours can´t be null");
        if(start.compareTo(end)<0) throw new Exception("start date can´t be less equals to end");
        Date current=new Date();
        if(start.compareTo(current)<0) throw new Exception("start date no befor today");
        if(missingHours<0) throw new Exception("negative missing hours");
        if(completedHours<0) throw new Exception("negative completed hours");
        this.id = id;
        this.assignee_id = assignee_id;
        this.category_id = category_id;
        this.state_id = state_id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.missingHours = missingHours;
        this.description = description;
        this.completedHours = completedHours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(Integer assignee_id) {
        this.assignee_id = assignee_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getState_id() {
        return state_id;
    }

    public void setState_id(Integer state_id) {
        this.state_id = state_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Float getMissingHours() {
        return missingHours;
    }

    public void setMissingHours(Float missingHours) {
        this.missingHours = missingHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getCompletedHours() {
        return completedHours;
    }

    public void setCompletedHours(Float completedHours) {
        this.completedHours = completedHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id.equals(activity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
