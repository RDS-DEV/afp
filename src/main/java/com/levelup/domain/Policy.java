package com.levelup.domain;

/**
 * Created by Monica.Vadlapudi on 1/3/2017.
 */
public class Policy {
    private int policy_id;
    private String policy_name;
    private String policy_type;
    private int policy_number;
    private int client_id;
    private int emp_id;

    public int getPolicy_id() {
        return policy_id;
    }

    public void setPolicy_id(int policy_id) {
        this.policy_id = policy_id;
    }

    public String getPolicy_name() {
        return policy_name;
    }

    public void setPolicy_name(String policy_name) {
        this.policy_name = policy_name;
    }

    public String getPolicy_type() {
        return policy_type;
    }

    public void setPolicy_type(String policy_type) {
        this.policy_type = policy_type;
    }

    public int getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(int policy_number) {
        this.policy_number = policy_number;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public String toString() {
        return "Policy{" + "policy_id=" + policy_id + ", policy_name='" + policy_name + '\'' + ", policy_type='" + policy_type + '\'' + ", policy_number=" + policy_number + ", client_id=" + client_id + ", emp_id=" + emp_id + '}';
    }
}


