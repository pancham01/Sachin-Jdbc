package my.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import my.jdbc.model.Employee;

public interface EmployeeDao {

	public void saveEmployee(Employee e)throws SQLException;

	public void updateEmployee(Employee e);

	public void deleteAnEmployee(int id);

	public void printAllEmployee();

	public Employee getEmpById(int id);
	
	public List<Employee> getAllEmps();

	public Employee getEmpByName(String name);

}
