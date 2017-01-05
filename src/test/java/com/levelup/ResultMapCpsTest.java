package com.levelup;


import com.levelup.domain.Policy;
import com.levelup.domain.Client;
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
 * Created by Monica.Vadlapudi on 1/5/2017.
 */
public class ResultMapCpsTest {

    private SqlSession session;

    @Before
    public void setup() throws IOException, SQLException {
        String resource = "mybatiscps-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }



    @Test
    public void testSelectAllPoliciesResult() {

        Policy policy = session.selectOne("selectAllPoliciesResult",  "id");
        System.out.println(policy);

    }


    @Test
    public void testSelectPoliciesResult() {

        Map<Object, Object> result = session.selectMap("selectPolicyResult", "id");
        System.out.println(result);

    }


    @Test
    public void testSelectAllPoliciesJoin() {

        List<Policy> policies = session.selectList("selectAllPoliciesJoin");
        System.out.println(policies);

    }

}
