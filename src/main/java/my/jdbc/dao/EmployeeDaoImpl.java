package my.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import my.jdbc.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public static final String UPDATE_QUERY = "update employee set name = '%s' , email = '%s', salary = %d where empId = %d";
	public static final String DELETE_QUERY = "DELETE FROM employee where empId = %d";
	public static final String SELECT_BY_NAME_QUERY = "SELECT * FROM employee where name = '%s'";
//	public static final String SELECT_BY_NAME_QUERY = "SELECT * FROM employee where name = 'tddud' or '1 = 1'";

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

	}

	@Override
	public void updateEmployee(Employee e) {


	}

	@Override
	public void deleteAnEmployee(int id) {
		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(String.format(DELETE_QUERY, id));

			System.out.println(String.format(DELETE_QUERY, id));

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void printAllEmployee() throws SQLException {

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

		while (resultSet.next()) {
			System.out.println("Id = " + resultSet.getInt(1) + "\t Name = " + resultSet.getString(2) + "\t Email = "
					+ resultSet.getString(3) + "\t Salary = " + resultSet.getInt(4));

		}

		System.out.println("SELECT * FROM employee");

	}

	@Override
	public Employee getEmpById(int id) throws SQLException {

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("SELECT * FROM employee WHERE empid = " + id);
		Employee e = new Employee();

		while (resultSet.next()) {

			e.setId(id);
			e.setName(resultSet.getString(2));
			e.setEmail(resultSet.getString(3));
			e.setSalary(resultSet.getInt(4));
		}
		System.out.println("SELECT * FROM employee WHERE empid = " + id);
		return e;
	}

	@Override
	public List<Employee> getAllEmps() throws SQLException {

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
		ArrayList<Employee> listOfEmps = new ArrayList<>();

		while (resultSet.next()) {

			Employee e = new Employee();
			e.setId(resultSet.getInt(1));
			e.setName(resultSet.getString(2));
			e.setEmail(resultSet.getString(3));
			e.setSalary(resultSet.getInt(4));

			listOfEmps.add(e);

		}
		return listOfEmps;
	}

	@Override
	public Employee getEmpByName(String name) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format(SELECT_BY_NAME_QUERY, name));
		Employee e = new Employee();
		while (resultSet.next()) {
			System.out.println("Id = " + resultSet.getInt(1) + "\t Name = " + resultSet.getString(2) + "\t Email = "
					+ resultSet.getString(3) + "\t Salary = " + resultSet.getInt(4));

			e.setId(resultSet.getInt(1));
			e.setName(resultSet.getString(2));
			e.setEmail(resultSet.getString(3));
			e.setSalary(resultSet.getInt(4));
		}
		System.out.println(String.format(SELECT_BY_NAME_QUERY, name));
		return e;
	}

}
