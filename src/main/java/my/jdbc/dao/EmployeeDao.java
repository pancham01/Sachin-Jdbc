package my.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import my.jdbc.model.Employee;

public interface EmployeeDao {

	public void saveEmployeeByPs(Employee e)throws SQLException;

	public void updateEmployee(Employee e);

	public void deleteAnEmployee(int id);

	public void printAllEmployee() throws SQLException;

	public Employee getEmpById(int id)throws SQLException;
	
	public List<Employee> getAllEmps()throws SQLException;

	public Employee getEmpByName(String name)throws SQLException;
	
	
	public void insertBatch() throws SQLException ;

}
