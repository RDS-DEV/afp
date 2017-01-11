package gov.hhs.cms.afs.dao;

import gov.hhs.cms.afs.domain.Employee;
import gov.hhs.cms.afs.mapper.EmployeeMapper;
import gov.hhs.cms.afs.session.ConnectionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by jarsen on 1/11/17.
 */
public class EmployeeDAO {

    public Employee getEmployeeById(Integer employeeId) {
        SqlSession session = ConnectionFactory.getAesSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmployeeById(employeeId);
        session.close();
        return employee;
    }

    public List<Employee> getAllEmployees() {
        SqlSession session = ConnectionFactory.getAesSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.getAllEmployees();
        session.close();
        return employees;
    }


}
