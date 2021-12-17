package Model;

public class data {
    String city;
    String state;
    String country;
    location location;
    current current;

    public data() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Model.location getLocation() {
        return location;
    }

    public void setLocation(Model.location location) {
        this.location = location;
    }

    public Model.current getCurrent() {
        return current;
    }

    public void setCurrent(Model.current current) {
        this.current = current;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
