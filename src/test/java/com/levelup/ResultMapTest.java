package com.levelup;

import com.levelup.domain.Agency;
import com.levelup.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by jarsen on 12/28/16.
 */
public class ResultMapTest {

    private SqlSession session;

    @Before
    public void setup() throws IOException, SQLException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }

    @Test
    public void testSelectEmployeeResultMap() {
        System.out.println("\nSelect the employee with emp_id = 105 and return the result as a map \n"
        + "where the key is the emp_id and the value is a map of the employee attributes.");
        Employee employee = new Employee();
        employee.setEmpId(105);
        Map<Object, Object> result = session.selectMap("selectEmployeeAsMap", employee, "emp_id");
        System.out.println(result);
    }

    @Test
    public void testSelectEmployeesResultMap() {
        System.out.println("\nSelect all employees and return the result as a map "
                + "where each key \nis an emp_id and each value is a map of the employee attributes.");
        Map<Object, Object> result = session.selectMap("selectEmployeesAsMap", "empId");
        System.out.println(result);

    }

    @Test
    public void testSelectEmployeeObjectsResultMap() {
        System.out.println("\nSelect all employees and return the result as a map "
                + "where each \nkey is an emp_id and each value is an Employee object.");
        Map<Object, Object> result = session.selectMap("selectEmployeesAsObjects", "empId");
        System.out.println(result);

    }

    @Test
    public void testSelectAgencyWithEmployees() {

        Agency agency = session.selectOne("selectAgencyResult", 10);
        System.out.println(agency);

    }


    @Test
    public void testSelectAllAgenciesJoin() {
        System.out.println("\nSelect all agencies and include a list of all the employees "
                + "in the employees attribute of the agency.");
        List<Agency> agencies = session.selectList("selectAllAgenciesJoin");
        System.out.println(agencies);

    }

}
