package com.levelup.domain;

/**
 * Created by jarsen on 12/28/16.
 */
public class Employee {

    private Integer id;
    private String name;
    private Integer agencyId;

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

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public String toString() {
        return "Employee [id = " + id + ", name = " + name + ", agencyId = " + agencyId + "]";
    }

}
