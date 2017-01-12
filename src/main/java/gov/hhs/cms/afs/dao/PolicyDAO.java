package gov.hhs.cms.afs.dao;

import gov.hhs.cms.afs.domain.Policy;
import gov.hhs.cms.afs.mapper.PolicyMapper;
import gov.hhs.cms.afs.session.ConnectionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by jarsen on 1/11/17.
 */
public class PolicyDAO {

    public Policy getPolicyById(Integer policyId) {
        SqlSession session = ConnectionFactory.getCpsSqlSession();
        PolicyMapper mapper = session.getMapper(PolicyMapper.class);
        Policy policy = mapper.getPolicyById(policyId);
        session.close();
        return policy;
    }

    public List<Policy> getAllPolicies() {
        SqlSession session = ConnectionFactory.getCpsSqlSession();
        List<Policy> policies = session.selectList("getAllPolicies");
        return policies;
    }


}
