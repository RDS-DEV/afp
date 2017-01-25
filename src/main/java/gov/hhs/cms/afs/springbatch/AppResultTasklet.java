package gov.hhs.cms.afs.springbatch;

import gov.hhs.cms.afs.domain.Agency;
import gov.hhs.cms.afs.domain.Client ;
import gov.hhs.cms.afs.domain.Employee ;
import gov.hhs.cms.afs.domain.Policy ;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class AppResultTasklet implements Tasklet
{

    private Client client = new Client();
    private Client newClient = new Client();
    private Policy policy = new Policy();
    private Policy newPolicy = new Policy();
    private Agency agency = new Agency();
    private Agency newAgency = new Agency();
    private Employee employee = new Employee();
    private Employee newEmployee = new Employee();
   static SqlSession  session;
   static SqlSession  session2;




   public RepeatStatus execute(StepContribution contribution,
                               ChunkContext chunkContext) throws Exception {
      System.out.println("1+");
       String resource = "configuration.xml";
       System.out.println("2+");
       InputStream inputStream = Resources.getResourceAsStream(resource);
       System.out.println("3+");
       System.out.println(inputStream.toString());
       System.out.println("4+");
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "aes");
       System.out.println("5+");
       InputStream inputStream2 = Resources.getResourceAsStream(resource);
       System.out.println("6+");
       SqlSessionFactory sqlSessionFactory2 = new SqlSessionFactoryBuilder().build(inputStream2, "cps");
       System.out.println("7+");
       session = sqlSessionFactory.openSession();
       System.out.println("8+");
       session2 = sqlSessionFactory2.openSession();


       System.out.println("Hello World!");
       AppResultTasklet app = new AppResultTasklet();
       String sss= null;

       try {

           // Report example
            sss= app.runReportExample();

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
       return RepeatStatus.FINISHED;
   }










    public String runReportExample() throws Exception{


        String resource = "configuration.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        System.out.println(inputStream.toString());
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream,"aes");
        InputStream inputStream2 = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory2 = new SqlSessionFactoryBuilder().build(inputStream2,"cps");
        session = sqlSessionFactory.openSession();
        session2= sqlSessionFactory2.openSession();


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
        return null;

    }

    private Map<Integer, List<Policy>> mapEmployeesToPolicies() {
        List<Policy> policies;
        Map<Integer, List<Policy>> employeePolicyMap = new HashMap<Integer, List<Policy>>();
        policies = session2.selectList("getAllPolicies");

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

        return session.selectList("getAllAgencies");
    }


    private List<Policy> getPolicies(Employee e) {
        List<Policy> policies = new ArrayList<Policy>();
        Policy policy = session.selectOne("selectPolicy", 107);
        policies.add( policy);
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






