package gov.hhs.cms.afs.mapper;

import gov.hhs.cms.afs.domain.Agency;
import org.apache.ibatis.annotations.Select;

/**
 * Created by jarsen on 1/11/17.
 */
public interface AgencyMapper {

    @Select("select agency_id as agencyId, agency_name as agencyName from agency where agency_id = #{agencyId}")
    Agency getAgencyById(int agencyId);

    // The select statement for the method getAllAgencies is mapped
    // in the afs/agency-mapper.xml file. We need to figure out how
    // to incorporate the @ResultMap annotation in these Mapper classes
    // so we don't have to use the XML files any more.
}
