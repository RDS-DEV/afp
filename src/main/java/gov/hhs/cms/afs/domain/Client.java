package gov.hhs.cms.afs.domain;

/**
 * Created by Monica.Vadlapudi on 1/3/2017.
 */
public class Client {

    private Integer id;
    private String name;
    private String phone;
    private String city;
    private String state;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Client [" +
                "id = " + id +
                ", name = " + name +
                ", phone = " + phone +
                ", city = " + city +
                ", state = " + state +
                ']';
    }
}
