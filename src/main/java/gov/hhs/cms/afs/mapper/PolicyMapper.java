package gov.hhs.cms.afs.mapper;

import gov.hhs.cms.afs.domain.Policy;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jarsen on 1/11/17.
 */
public interface PolicyMapper {

    @Select("select policy_id  as id , policy_name as name , policy_type as type , policy_number as number from Policy where policy_id = #{id}")
    Policy getPolicyById(int policyId);

    @Select("select policy_id as id, policy_name as name, policy_type as type, policy_number as number, client_id, emp_id from Policy")
    List<Policy> getAllPolicies();

}
