package my.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import my.jdbc.dao.EmployeeDao;
import my.jdbc.dao.EmployeeDaoImpl;
import my.jdbc.model.Employee;

/*

1st :- Create the Connection.

Connection conn = DriverManager.getConnection("URL","username","password");
Connection conn = DriverManager.getConnection("jdbc:mysql//localhost:3306/testdb","root","root");


*/
public class Main {

	public static void main(String[] args) throws SQLException {

		Employee e = new Employee(9, 44444, "Kunal singh", "kunal123@gmail.com");
		String str="Ducat";

		EmployeeDao empDao = new EmployeeDaoImpl();
//		empDao.saveEmployee(e);
		
		empDao.updateEmployee(e);
	
	}

}
