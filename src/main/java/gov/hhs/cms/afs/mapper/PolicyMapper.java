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
            @Result(property = "number", column = "policy_number")
    })
    @Select("select * from Policy where policy_id = #{id}")
    //@Select("select policy_id, policy_name, policy_type, policy_number, client_id, emp_id from Policy where policy_id = #{id}")
    Policy getPolicyById(int policyId);

}
