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

        Employee employee = new Employee();
        employee.setId(105);
        Map<Object, Object> result = session.selectMap("selectEmployeeAsMap", employee, "emp_id");
        System.out.println(result);
    }

    @Test
    public void testSelectEmployeesResultMap() {

        Map<Object, Object> result = session.selectMap("selectEmployeesAsMap", "emp_id");
        System.out.println(result);

    }

    @Test
    public void testSelectEmployeeObjectsResultMap() {

        Map<Object, Object> result = session.selectMap("selectEmployeesAsObjects", "id");
        System.out.println(result);

    }

    @Test
    public void testSelectAgencyWithEmployees() {

        Agency agency = session.selectOne("selectAgencyResult", 10);
        System.out.println(agency);

    }

    @Test
    public void testSelectAllAgenciesAndEmployees() {

        List<Agency> agencies = session.selectList("selectAllAgenciesResult");
        System.out.println(agencies);

    }


    @Test
    public void testSelectAllAgenciesJoin() {

        List<Agency> agencies = session.selectList("selectAllAgenciesJoin");
        System.out.println(agencies);

    }

}
