package gov;

import gov.hhs.cms.afs.dao.AgencyDAO;
import gov.hhs.cms.afs.dao.ClientDAO;
import gov.hhs.cms.afs.dao.EmployeeDAO;
import gov.hhs.cms.afs.dao.PolicyDAO;
import gov.hhs.cms.afs.domain.Agency;
import gov.hhs.cms.afs.domain.Client;
import gov.hhs.cms.afs.domain.Employee;
import gov.hhs.cms.afs.domain.Policy;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jarsen on 1/11/17.
 */
public class AfsApp {

    public static void main(String[] args) {

        AfsApp afsApp = new AfsApp();

        try {

            // Report example
            afsApp.runReportExample();

            // Agency examples
            //afsApp.runAgencyExamples();

            // Employee examples
            //afsApp.runEmployeeExamples();

            // Policy examples
            //afsApp.runPolicyExamples();

            // Client examples
            //afsApp.runClientExamples();

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
        List<Agency> agencies = getAgencies();
        List<Policy> policies;

        Map<Integer, List<Policy>> employeePolicyMap = mapEmployeesToPolicies();

        System.out.println("\n\n2016 End-of-Year Premium Report\n");

        String policyLine;
        int policyPremium;
        int agencyPremium;
        int companyPremium = 0;
        for (Agency a : agencies) {
            agencyPremium = 0;
            System.out.println("\nAgency: " + a.getAgencyName() + ", " + a.getAgencyLocation());
            for (Employee e : a.getEmployees()) {
                policyPremium = 0;
                policies = employeePolicyMap.get(e.getEmpId());
                if (!(null == policies) && !policies.isEmpty()) {
                    System.out.println("\n\tEmployee: " + e.getEmpName());
                    System.out.println("\t\tPolicies sold:");
                    for (Policy policy : policies) {
                        policyLine = getPolicyLine(policy);
                        System.out.println("\t\t\t" + policyLine);
                        policyPremium += policy.getGrossPremium();
                    }
                    System.out.println("\t\tEmployee premium subtotal: " + formatMoneyValue(policyPremium));
                }
                agencyPremium += policyPremium;
            }
            System.out.println("\n\tAgency premium subtotal: " + formatMoneyValue(agencyPremium) + '\n');
            companyPremium += agencyPremium;
        }
        System.out.println("\nCompany premium subtotal: " + formatMoneyValue(companyPremium));

    }

    private Map<Integer, List<Policy>> mapEmployeesToPolicies() {
        List<Policy> policies;
        Map<Integer, List<Policy>> employeePolicyMap = new HashMap<Integer, List<Policy>>();
        PolicyDAO policyDAO = new PolicyDAO();
        policies = policyDAO.getAllPolicies();

        List<Policy> policyList;
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

        return employeePolicyMap;
    }

    private List<Agency> getAgencies() {
        AgencyDAO agencyDAO = new AgencyDAO();
        return agencyDAO.getAllAgencies();
    }


    private List<Policy> getPolicies(Employee e) {
        PolicyDAO policyDAO = new PolicyDAO();
        List<Policy> policies = new ArrayList<Policy>();
        policies.add(policyDAO.getPolicyById(107));
        return policies;
    }

    private int getEmployeePremiumTotal(List<Policy> policyList) {
        int amt = 0;
        for (Policy p : policyList) {
            amt = amt + p.getGrossPremium();
        }
        return amt;
    }

    private String getPolicyLine(Policy policy) {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + setFieldWidth(String.valueOf(policy.getId()), 5));
        sb.append("Name: " + setFieldWidth(policy.getName(), 5));
        sb.append("Type: " + setFieldWidth(policy.getType(), 23));
        sb.append("Premium: " + setFieldWidth(formatMoneyValue(policy.getGrossPremium()), 12));
        sb.append("Client: " + setFieldWidth(policy.getClient().getName(), 11));
        sb.append("Client phone: " + setFieldWidth(policy.getClient().getPhone(), 11));
        sb.append("City: " + setFieldWidth(policy.getClient().getCity(), 13));
        sb.append("State: " + setFieldWidth(policy.getClient().getState(), 2));
        return sb.toString();
    }

    private String setFieldWidth(String contents, int width) {

        if (contents.length() > width) {
            return contents.substring(0, width);
        }

        StringBuffer paddedContents = new StringBuffer(contents);
        int paddingAmount = width - contents.length();
        for (int i = 0; i <= paddingAmount; i++ ) {
            paddedContents.append(" ");
        }

        return paddedContents.toString();
    }

    private String formatMoneyValue(int money) {
        String moneyValue;

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        moneyValue = currencyFormatter.format(money);

        return moneyValue;
    }

}

