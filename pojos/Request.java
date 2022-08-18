import java.util.Objects;

public class Request {
    public static final String KILL_ACTIVITY="KILL";
    public static final String CREATE_ACTIVITY="CREATE";
    private Integer id;
    private Integer client_id;
    private Integer activity_id;
    private String type;

    /**
     * Constructor for a request
     * @param id unique id for the request
     * @param client_id the id of the client that did the request
     * @param activity_id the activity involved
     * @param type the type of request
     * @throws Exception
     */
    public Request(Integer id, Integer client_id, Integer activity_id, String type) throws Exception{
        if(id==null) throw new Exception("Id can´t be null");
        if(client_id==null) throw new Exception("Client_id can´t be null");
        if(activity_id==null) throw new Exception("Activity_id can´t be null");
        if(type==null) throw new Exception("Type can´t be null");
        if(type.trim().length()==0) throw new Exception("type can´t be empty");
        if(!type.equals(KILL_ACTIVITY) && !type.equals(CREATE_ACTIVITY)) throw new Exception("type must be one of the specified types");
        this.id = id;
        this.client_id = client_id;
        this.activity_id = activity_id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCliente_id() {
        return client_id;
    }

    public void setCliente_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id.equals(request.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
