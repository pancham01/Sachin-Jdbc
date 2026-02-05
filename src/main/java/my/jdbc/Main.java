package my.jdbc;

import java.sql.SQLException;

import my.jdbc.dao.EmployeeDao;
import my.jdbc.dao.EmployeeDaoImpl;
import my.jdbc.model.Employee;

public class Main {

	public static void main(String[] args) throws SQLException {

		Employee e = new Employee(10, 44444, "Worker singh", "kunal123@gmail.com");

		EmployeeDao empDao = new EmployeeDaoImpl();

//		empDao.saveEmployeeByPs(e);

		System.out.println(empDao.getAllEmps());

//		empDao.insertBatch();
		
//		empDao.printAllEmployee();

		System.out.println("Main.main()");

	}

}
