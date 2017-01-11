package com.levelup;

import com.levelup.domain.Agency;
import com.levelup.domain.Client;
import com.levelup.domain.Employee;
import com.levelup.domain.Policy;
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
 * Created by Monica.Vadlapudi on 1/9/2017.
 */

public class FinalTest {
    private SqlSession session;
    private SqlSession session2;
    private Client client = new Client();
    private Client newClient = new Client();
    private Policy policy = new Policy();
    private Policy newPolicy = new Policy();
    private Agency agency = new Agency();
    private Agency newAgency = new Agency();
    private Employee employee = new Employee();
    private Employee newEmployee = new Employee();




    @Before
    public void setup() throws IOException, SQLException {
        String resource = "final-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        System.out.println(inputStream.toString());
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream,"aes");
        InputStream inputStream2 = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory2 = new SqlSessionFactoryBuilder().build(inputStream2,"cps");
        session = sqlSessionFactory.openSession();
        session2= sqlSessionFactory2.openSession();

    }

  /*  public SqlSessionFactory getSqlSessionFactory( InputStream inputStream,DataSourceEnvironment environment)

    {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,environment.name());
    return sqlSessionFactory;
    }

    public static enum DataSourceEnvironment {
        aes,
        cps;
    }*/



    @Test
    public void testSelectEmployeJoinResult() {
        List<Employee> employees = session.selectList("selectEmployee");

        for (Employee e : employees) {
            System.out.println(e);
        }
        List<Policy> policies = session2.selectList("selectPolicy");
        for(Policy p: policies)
        {
            System.out.println(p);
        }

    }

}



