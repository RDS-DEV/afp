package com.levelup.domain;

import java.util.List;

/**
 * Created by jarsen on 12/22/16.
 */
public class Agency {

    private Integer id;
    private String name;
    private String location;
    private List<Employee> employees;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Agency [id = " + id + ", name = " + name + ", employees = " + employees + "]";
    }
}
