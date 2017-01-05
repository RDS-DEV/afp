package com.levelup;

import com.levelup.domain.Agency;
import com.levelup.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jarsen on 12/22/16.
 */
public class TestCRUDOperations {

    private SqlSession session;
    private Agency agency = new Agency();
    private Agency newAgency = new Agency();
    private Employee employee = new Employee();
    private Employee newEmployee = new Employee();

    @Before
    public void setup() throws IOException, SQLException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();

        newAgency.setAgencyId(30);
        newAgency.setAgencyName("Nationwide Insurance");
        newAgency.setAgencyLocation("West Lafayette, IN");


        newEmployee.setEmpName("James Thurber");
        newEmployee.setAgencyId(20);

    }

    @Test
    public void testSelectOneAgency() {

        System.out.println("\nSelectOneAgency: id = 10");
        Agency agency = session.selectOne("selectAgency", 10);
        System.out.println(agency);

    }

    @Test
    public void testSelectAllAgencies() {
        List<Agency> agencies = session.selectList("selectAllAgencies");
        for (Agency a : agencies) {
            System.out.println(a);
        }
    }

    @Test
    public void testInsertNewAgency() {

        System.out.println("\nInsertNewAgency: id = " + newAgency.getAgencyId());
        session.insert("insertAgency", newAgency);
        session.commit();

    }

    @Test
    public void testUpdateOneAgency() {

        System.out.println("\nUpdateNewAgency: name = Geico Insurance");
        newAgency.setAgencyName("Geico Insurance");
        session.update("updateAgency", newAgency);
        session.commit();

    }

    @Test
    public void testDeleteNewAgency() {

        System.out.println("\nDeleteNewAgency: id = 30");
        session.delete("deleteAgency", newAgency);
        session.commit();

    }

    @Test
    public void testSelectOneEmployee() {

        System.out.println("\nSelectOneEmployee: id = 104");
        employee = session.selectOne("selectEmployee", 104);
        System.out.println(employee);

    }

    @Test
    public void testSelectEmployeeByName() {

        System.out.println("\nSelectEmployeeByName: empName = 'Mel Torme'");
        employee = session.selectOne("selectEmployeeByName", "Mel Torme");
        System.out.println(employee);

    }

    @Test
    public void testSelectAllEmployees() {
        List<Employee> employees = session.selectList("selectAllEmployees");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    @Test
    public void testInsertOneEmployee() {

        System.out.println("\nInsertOneEmployee: empId = " + newEmployee.getEmpId());
        session.insert("insertEmployee", newEmployee);
        newEmployee = session.selectOne("selectEmployeeByName", newEmployee.getEmpName());
        System.out.println(newEmployee);
        session.commit();

    }

    @Test
    public void testUpdateNewEmployee() {

        System.out.println("\nUpdateNewEmployee: agencyId = 10");
        newEmployee.setAgencyId(10);
        session.update("updateEmployee", newEmployee);
        session.commit();

    }

    @Test
    public void testDeleteNewEmployee() {

        System.out.println("\nDeleteNewEmployee: id = " + newEmployee.getEmpId());
        session.delete("deleteEmployee", newEmployee);
        session.commit();

    }

    @After
    public void teardown() {
        session.close();
    }

}

