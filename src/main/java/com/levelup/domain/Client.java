package com.levelup.domain;

import java.util.List;

/**
 * Created by Monica.Vadlapudi on 1/3/2017.
 */
public class Client {

    private Integer client_id;
    private String client_name;
    private String client_phone;
    private String city;
    private String state;

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
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
        return "Client{" + "client_id=" + client_id + ", client_name='" + client_name + '\'' + ", client_phone='" + client_phone + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + '}';
    }
}
