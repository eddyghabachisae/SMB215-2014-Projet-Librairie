package BookCategory;



public class BookCategory {

    private long id;
    private String code;
    private String description;

    @Override
    public String toString() {
        return "BookCategory{" + "id=" + id + ", code=" + code + ", description=" + description + '}';
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   

   

    

}
