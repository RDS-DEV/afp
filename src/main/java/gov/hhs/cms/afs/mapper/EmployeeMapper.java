package gov.hhs.cms.afs.mapper;

import gov.hhs.cms.afs.domain.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jarsen on 1/11/17.
 */
public interface EmployeeMapper {

    @Select("select emp_id as empId, emp_name as empName, agency_id as agencyId from Employee where emp_id = #{empId}")
    Employee getEmployeeById(int empId);

    @Select("select emp_id as empId, emp_name as empName, agency_id as agencyId from Employee")
    List<Employee> getAllEmployees();

}
