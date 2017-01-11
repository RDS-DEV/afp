package gov.hhs.cms.afs.dao;

import gov.hhs.cms.afs.domain.Agency;
import gov.hhs.cms.afs.mapper.AgencyMapper;
import gov.hhs.cms.afs.session.ConnectionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by jarsen on 1/11/17.
 */
public class AgencyDAO {

    public Agency getAgencyById(Integer agencyId) {
        SqlSession session = ConnectionFactory.getAesSqlSession();
        AgencyMapper mapper = session.getMapper(AgencyMapper.class);
        Agency agency = mapper.getAgencyById(agencyId);
        session.close();
        return agency;
    }

    public List<Agency> getAllAgencies() {
        SqlSession session = ConnectionFactory.getAesSqlSession();
        AgencyMapper mapper = session.getMapper(AgencyMapper.class);
        List<Agency> agencies = mapper.getAllAgencies();
        session.close();
        return agencies;
    }


}
