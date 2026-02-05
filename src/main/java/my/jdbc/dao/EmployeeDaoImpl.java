package my.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import my.jdbc.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static Connection connection = null;

	static {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveEmployeeByPs(Employee e) throws SQLException {

		PreparedStatement ps = connection
				.prepareStatement("insert into employee (empId,name,email,salary) values(?,?,?,?)");

		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setString(3, e.getEmail());
		ps.setInt(4, e.getSalary());

		ps.executeUpdate();

		System.out.println("insert into employee (empId,name,email,salary) values(?,?,?,?)");

	}

	@Override
	public void updateEmployee(Employee e) {

	}

	@Override
	public void deleteAnEmployee(int id) {
	}

	@Override
	public void printAllEmployee() throws SQLException {

	}

	@Override
	public Employee getEmpById(int id) throws SQLException {
		return null;
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
		ResultSet resultSet = statement.executeQuery(String.format("", name));
		Employee e = new Employee();
		while (resultSet.next()) {
			System.out.println("Id = " + resultSet.getInt(1) + "\t Name = " + resultSet.getString(2) + "\t Email = "
					+ resultSet.getString(3) + "\t Salary = " + resultSet.getInt(4));

			e.setId(resultSet.getInt(1));
			e.setName(resultSet.getString(2));
			e.setEmail(resultSet.getString(3));
			e.setSalary(resultSet.getInt(4));
		}
		System.out.println(String.format("", name));
		return e;
	}

	@Override
	public void insertBatch() throws SQLException {

		connection.setAutoCommit(false);
		PreparedStatement ps = connection
				.prepareStatement("insert into employee (empId,name,email,salary) values(?,?,?,?)");

		for (int i = 1; i <= 100; i++) {
			ps.setInt(1, 10 + i);
			ps.setString(2, "Pancham " + i);
			ps.setString(3, "Pancham" + i + "@gmail.com");
			ps.setInt(4, 50_000);
			ps.addBatch();

			if (i % 100 == 0) {
				ps.executeBatch();
				connection.commit();
			}

		}
	}

}
