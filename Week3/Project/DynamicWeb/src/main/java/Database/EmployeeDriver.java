package Database;

import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;

public class EmployeeDriver {

	public static void main(String[] args) {

		EmployeeDAO dao = new EmployeeDAOImpl();
		
		EmployeePOJO usr = new EmployeePOJO(
				5,
				"Samir",
				"Nagheenanajar",
				"",
				"",
				"",
				"",
				"",
				"nagheenana@initech.com",
				1,
				"snagheenana",
				"getmynameright"
			);
		
		dao.AddEmployee(usr);

	}

}
