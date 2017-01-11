package com.levelup;


import com.levelup.domain.Client;
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
 * Created by Monica.Vadlapudi on 1/3/2017.
 */

public class TestCPSOperations {

    private SqlSession session;
    private Client client = new Client();
    private Client newClient = new Client();
    private Policy policy = new Policy();
    private Policy newPolicy = new Policy();

    @Before
    public void setup() throws IOException, SQLException {

        String resource = "mybatiscps-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();

    }

    @Test
    public void testSelectOnePolicy() {

        System.out.println("\nSelectOnePolicy: id = 108 ");
        Policy policy = session.selectOne("selectPolicy", 108);
        System.out.println(policy);

    }

    @Test
    public void testSelectAllPolicies() {
        List<Policy> policies = session.selectList("selectAllPolicies");
        for (Policy p : policies) {
            System.out.println(p);
        }
    }




    @Test
    public void testSelectAllClients() {
        List<Client> clients = session.selectList("selectAllClients");
        for (Client c : clients) {
            System.out.println(c);
        }
    }

    @After
    public void teardown() {
        session.close();
    }

}
