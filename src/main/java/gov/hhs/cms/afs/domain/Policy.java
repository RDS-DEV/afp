package gov.hhs.cms.afs.domain;


/**
 * Created by Monica.Vadlapudi on 1/3/2017.
 */
public class Policy {
    private int id;
    private String name;
    private String type;
    private int number;
    private int client_id;
    private Client client;
    private int emp_id;
    private int grossPremium;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getGrossPremium() {
        return grossPremium;
    }

    public void setGrossPremium(int grossPremium) {
        this.grossPremium = grossPremium;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(
        "Policy[" +
                "id = " + id +
                ", name = " + name +
                ", type = " + type +
                ", number = " + number +
                ", client_id = " + client_id +
                ", emp_id = " + emp_id +
                ", grossPremium = " + grossPremium );
        if (null != client) {
            sb.append(", client = " + client.toString());
        }
        sb.append(']');
        return sb.toString();
    }
}




