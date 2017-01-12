package gov.hhs.cms.afs.mapper;

import gov.hhs.cms.afs.domain.Policy;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by jarsen on 1/11/17.
 */
public interface PolicyMapper {

    @Results({
            @Result(property = "id", column = "policy_id"),
            @Result(property = "name", column = "policy_name"),
            @Result(property = "type", column = "policy_type"),
            @Result(property = "number", column = "policy_number"),
            @Result(property = "grossPremium", column = "gross_premium")
    })
    @Select("select * from Policy where policy_id = #{id}")
    Policy getPolicyById(int policyId);

    // The select statement for the method getAllPolicies is mapped
    // in the afs/policy-mapper.xml file. We need to figure out how
    // to incorporate the @ResultMap annotation in these Mapper classes
    // so we don't have to use the XML files any more.


}
