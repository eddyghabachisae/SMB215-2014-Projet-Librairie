package province;

public class Province {

    private int id;
    private String name;
    private String code;
    private int country;
    private String countryname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getcountry() {
        return country;
    }

    public void setcountry(int country) {
        this.country = country;
    }
    
    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
}
