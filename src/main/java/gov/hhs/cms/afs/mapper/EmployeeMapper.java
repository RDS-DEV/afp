package gov.hhs.cms.afs.mapper;

import gov.hhs.cms.afs.domain.Employee;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jarsen on 1/11/17.
 */
public interface EmployeeMapper {

    @Results({
            @Result(property = "empId", column = "emp_id"),
            @Result(property = "empName", column = "emp_name"),
            @Result(property = "agencyId", column = "agency_id")
    })
    @Select("select * from Employee where emp_id = #{empId}")
    Employee getEmployeeById(int empId);

    // There may be a way to assign an id to the results declaration
    // and then reuse them just by giving the id. Maybe in v.3.4.3?
    @Results({
            @Result(property = "empId", column = "emp_id"),
            @Result(property = "empName", column = "emp_name"),
            @Result(property = "agencyId", column = "agency_id")
    })
    @Select("select * from Employee")
    List<Employee> getAllEmployees();

}
