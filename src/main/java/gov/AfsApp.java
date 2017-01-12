package gov;

import gov.hhs.cms.afs.dao.AgencyDAO;
import gov.hhs.cms.afs.dao.ClientDAO;
import gov.hhs.cms.afs.dao.EmployeeDAO;
import gov.hhs.cms.afs.dao.PolicyDAO;
import gov.hhs.cms.afs.domain.Agency;
import gov.hhs.cms.afs.domain.Client;
import gov.hhs.cms.afs.domain.Employee;
import gov.hhs.cms.afs.domain.Policy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jarsen on 1/11/17.
 */
public class AfsApp {

    public static void main(String[] args) {

        AfsApp afsApp = new AfsApp();

        try {

            // Agency examples
            //afsApp.runAgencyExamples();

            // Employee examples
            //afsApp.runEmployeeExamples();

            // Policy examples
            //afsApp.runPolicyExamples();

            // Client examples
            //afsApp.runClientExamples();

            // Report example
            //afsApp.runReportExample();

            afsApp.getListofPolicies();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void runAgencyExamples() throws Exception {
        // Agency examples
        Agency agency;
        Integer agencyId = 20;
        List<Agency> agencies;

        AgencyDAO agencyDAO = new AgencyDAO();

        System.out.println("\nRetrieve agency data for agencyId = " + agencyId);
        System.out.println("------------------------------------------------------------------------------------");
        agency = agencyDAO.getAgencyById(agencyId);
        System.out.println(agency.toString());
        System.out.println("\nRetrieve all agencies");
        System.out.println("------------------------------------------------------------------------------------");
        agencies = agencyDAO.getAllAgencies();
        for (Agency a : agencies) {
            System.out.println(a.toString());
        }
    }

    private void runEmployeeExamples() {
        // Employee examples
        Employee employee;
        Integer employeeId = 104;
        List<Employee> employees;

        EmployeeDAO employeeDAO = new EmployeeDAO();

        System.out.println("\n\nRetrieve Employee data for EmployeeId = " + employeeId);
        System.out.println("------------------------------------------------------------------------------------");
        employee = employeeDAO.getEmployeeById(employeeId);
        System.out.println(employee.toString());
        System.out.println("\nRetrieve all employees");
        System.out.println("------------------------------------------------------------------------------------");
        employees = employeeDAO.getAllEmployees();
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    private void runPolicyExamples() {
        // Policy examples
        Policy policy;
        Integer policyId = 107;
        List<Policy> policies;

        PolicyDAO policyDAO = new PolicyDAO();

        System.out.println("\n\nRetrieve Policy data for PolicyId = " + policyId);
        System.out.println("------------------------------------------------------------------------------------");
        policy = policyDAO.getPolicyById(policyId);
        System.out.println(policy.toString());
        System.out.println("\nRetrieve all policies");
        System.out.println("------------------------------------------------------------------------------------");
        policies = policyDAO.getAllPolicies();
        for (Policy e : policies) {
            System.out.println(e.toString());
        }
    }

    private void runClientExamples() {
        // Client examples
        Client client;
        Integer clientId = 8;
        List<Client> clients;

        ClientDAO clientDAO = new ClientDAO();

        System.out.println("\n\nRetrieve Client data for ClientId = " + clientId);
        System.out.println("------------------------------------------------------------------------------------");
        client = clientDAO.getClientById(clientId);
        System.out.println(client.toString());
        System.out.println("\nRetrieve all clients");
        System.out.println("------------------------------------------------------------------------------------");
        clients = clientDAO.getAllClients();
        for (Client e : clients) {
            System.out.println(e.toString());
        }
    }

    private void runReportExample() {
        AgencyDAO agencyDAO = new AgencyDAO();
        PolicyDAO policyDAO = new PolicyDAO();
        List<Agency> agencies;
        List<Policy> policies;

        agencies = agencyDAO.getAllAgencies();
        policies = policyDAO.getAllPolicies();

        System.out.println("\n\nAgencies: \n");
        for (Agency a : agencies) {
            System.out.println(a.toString());
        }

        System.out.println("\n\nPolicies:\n");
        for (Policy p : policies) {
            System.out.println(p.toString());
        }

    }

    private void getListofPolicies() {
        List<Policy> policies;
        HashMap<Integer, ArrayList<Policy>> employeePolicyMap = new HashMap<Integer, ArrayList<Policy>>();
        PolicyDAO policyDAO = new PolicyDAO();
        policies = policyDAO.getAllPolicies();

        ArrayList<Policy> policyList;
        for (Policy p : policies) {
            p.getEmp_id();

            if (employeePolicyMap.get(p.getEmp_id()) == null) {
                policyList = new ArrayList<Policy>();
                policyList.add(p);

                employeePolicyMap.put(p.getEmp_id(), policyList);
            } else {
                policyList = employeePolicyMap.get(p.getEmp_id());
                policyList.add(p);
                employeePolicyMap.put(p.getEmp_id(), policyList);
            }
        }
        System.out.println(employeePolicyMap.toString());
    }
}





