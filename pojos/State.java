import java.util.Objects;

public class State {
    /**
     * The id of the state
     */
    private Integer id;
    /**
     * The name of the state
     */
    private String name;
    /**
     * the description of the state
     */
    private String description;

    /**
     * Constructor fo class State
     * @param id the unique identifier of the state, not null
     * @param name a unique name for the state, not null
     * @param description a complementary description for the state, nullable
     */
    public State(Integer id, String name, String description) throws Exception{
        if(id==null) throw new Exception("id can´t be null");
        if(name==null) throw new Exception("Name can´t be null");
        if(name.trim().length()==0) throw new Exception("Name can´t be empty");

        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return id == state.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
