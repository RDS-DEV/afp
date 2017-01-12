package gov.hhs.cms.afs.domain;

import java.util.List;

/**
 * Created by jarsen on 12/22/16.
 */
public class Agency {

    private Integer agencyId;
    private String agencyName;
    private String agencyLocation;
    private List<Employee> employees;

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyLocation() {
        return agencyLocation;
    }

    public void setAgencyLocation(String agencyLocation) {
        this.agencyLocation = agencyLocation;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(
                "Agency [" +
                        "agencyId = " + agencyId +
                        ", agencyName = " + agencyName +
                        ", agencyLocation = " + agencyLocation);
        if (null != employees) {
            sb.append(", employees = [");
            for (Employee e : employees) {
                sb.append(e.toString() + ", ");
            }
            int lastCommaIndex = sb.lastIndexOf(",");
            sb.delete(lastCommaIndex, lastCommaIndex + 2);
        }
        sb.append(']');
        return sb.toString();
    }
}
