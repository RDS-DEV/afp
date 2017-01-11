package gov.hhs.cms.afs.mapper;

import gov.hhs.cms.afs.domain.Agency;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jarsen on 1/11/17.
 */
public interface AgencyMapper {

    @Select("select agency_id as agencyId, agency_name as agencyName from agency where agency_id = #{agencyId}")
    Agency getAgencyById(int agencyId);

    @Select("select agency_id as agencyId, agency_name as agencyName, agency_location as agencyLocation from Agency")
    List<Agency> getAllAgencies();

}
