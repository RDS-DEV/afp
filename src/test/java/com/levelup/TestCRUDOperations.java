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

    }

    @Test
    public void testSelectOneAgency() {

        System.out.println("\nSelectOneAgency: id = 10\n------------------------");
        Agency agency = session.selectOne("selectAgency", 10);
        System.out.println(agency);

    }

    @Test
    public void testSelectAllAgencies() {
        List<Agency> agencies = session.selectList("selectAllAgencies");
        System.out.println("\nSelectAllAgencies\n-----------------");
        for (Agency a : agencies) {
            System.out.println(a);
        }
    }

    @Test
    public void testSelectOneEmployee() {

        System.out.println("\nSelectOneEmployee: id = 104\n---------------------------");
        employee = session.selectOne("selectEmployee", 104);
        System.out.println(employee);

    }

    @Test
    public void testSelectEmployeeByName() {

        System.out.println("\nSelectEmployeeByName: empName = 'Mel Torme'\n-------------------------------------------");
        employee = session.selectOne("selectEmployeeByName", "Mel Torme");
        System.out.println(employee);

    }

    @Test
    public void testSelectAllEmployees() {
        List<Employee> employees = session.selectList("selectAllEmployees");
        System.out.println("\nSelectAllEmployees\n------------------");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    @Test
    public void testInsertUpdateDeleteNewAgency() {
        System.out.println("\nInsertUpdateDeleteNewAgency\n---------------------------");

        newAgency.setAgencyId(9999);
        newAgency.setAgencyName("Nationwide Insurance");
        newAgency.setAgencyLocation("West Lafayette, IN");

        System.out.println("\nInsert new agency with id = 9999");
        session.insert("insertAgency", newAgency);

        System.out.println("Retrieve new agency with id = 9999");
        Agency agency = session.selectOne("selectAgency", 9999);
        System.out.println(agency);

        System.out.println("\nUpdate new agency with id = 9999, set name = Geico Insurance");
        newAgency.setAgencyName("Geico Insurance");
        session.update("updateAgency", newAgency);

        System.out.println("Retrieve updated agency with id = 9999");
        agency = session.selectOne("selectAgency", 9999);
        System.out.println(agency);

        System.out.println("\nDelete agency with id = 9999");
        session.delete("deleteAgency", newAgency);

        System.out.println("Retrieve agency with id = 9999");
        agency = session.selectOne("selectAgency", 9999);
        System.out.println(agency);

        session.commit();

    }

    @After
    public void teardown() {
        session.close();
    }

}

