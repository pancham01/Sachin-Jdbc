package my.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import my.jdbc.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	
	public static final String UPDATE_QUERY = "update employee set name = '%s' , email = '%s', salary = %d where empId = %d";

	private static Connection connection = null;

	static {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveEmployee(Employee e) throws SQLException {

		Statement statement = connection.createStatement();
//		statement.executeUpdate("insert into employee (empId,name,email,salary) values(8,'Puneet','john@gmail.com',88888)");
		statement.executeUpdate("insert into employee (empId,name,email,salary) values(" + e.getId() + ",'"+ e.getName() + "','" + e.getEmail() + "'," + e.getSalary() + ")");
		System.out.println("insert into employee (empId,name,email,salary) values(" + e.getId() + ",'" + e.getName()+ "','" + e.getEmail() + "'," + e.getSalary() + ")");
	}

	@Override
	public void updateEmployee(Employee e) {
		
		
		try(Statement statement = connection.createStatement()) {
			
			statement.executeUpdate(String.format(UPDATE_QUERY, e.getName(),e.getEmail(),e.getSalary(),e.getId()));
			
			System.out.println(String.format(UPDATE_QUERY, e.getName(),e.getEmail(),e.getSalary(),e.getId()));
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		

	}

	@Override
	public void deleteAnEmployee(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printAllEmployee() {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmpByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
