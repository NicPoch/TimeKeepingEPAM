import java.util.Objects;

public class Category {
    /**
     * The id of the category
     */
    private Integer id;
    /**
     * The name of the category
     */
    private String name;
    /**
     * the description of the category
     */
    private String description;

    /**
     * Constructor for class Category
     * @param id the unique identifier of the category, not null
     * @param name a unique name for the category, not null
     * @param description a complementary description for the category, nullable
     * @throws Exception
     */
    public Category(Integer id, String name, String description) throws Exception{
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
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
