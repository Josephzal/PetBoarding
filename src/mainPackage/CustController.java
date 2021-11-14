package mainPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustController")
public class CustController extends HttpServlet {

	Customer customer = new Customer();
	CustImpl custImpl = new CustImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// If the request is to addTask, get taskText and create new task with it
		// then save the task with the taskImpl class and return to main page
		if (request.getParameter("addCustomer") != null) {

			int customerID = Integer.parseInt(request.getParameter("custIDText"));
			customer.setCustomerID(customerID);
			String custFirstName = request.getParameter("custFirstNameText");
			customer.setCustFirstName(custFirstName);
			String custLastName = request.getParameter("custLastNameText");
			customer.setCustLastName(custLastName);
			String custPhone = request.getParameter("custPhoneText");
			customer.setCustPhone(custPhone);
			String custEmail = request.getParameter("custEmailText");
			customer.setCustEmail(custEmail);
			String custAddress = request.getParameter("custAddressText");
			customer.setCustAddress(custAddress);

			custImpl.saveCustomer(customer);

			RequestDispatcher rd = request.getRequestDispatcher("showCustomers.jsp");
			rd.forward(request, response);
		}
	}

	public static Connection getConnection() throws Exception {
		try {

			String url = "jdbc:mysql://localhost:3306/petboardingdb";
			String username = "root";
			String password = "Sqlpassword";
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish connection with information above
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
		if (request.getParameter("addCustomer") != null) {

			int customerID = Integer.parseInt(request.getParameter("customerIDText"));
			customer.setCustomerID(customerID);
			String custFirstName = request.getParameter("custFirstNameText");
			customer.setCustFirstName(custFirstName);
			String custLastName = request.getParameter("custLastNameText");
			customer.setCustLastName(custLastName);
			String custPhone = request.getParameter("customerPhoneText");
			customer.setCustPhone(custPhone);
			String custEmail = request.getParameter("customerEmailText");
			customer.setCustEmail(custEmail);
			String custAddress = request.getParameter("customerAddressText");
			customer.setCustAddress(custAddress);

			custImpl.saveCustomer(customer);

			RequestDispatcher rd = request.getRequestDispatcher("showCustomers.jsp");
			rd.forward(request, response);
		}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("addCustomer.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("editCustomer") != null) {

			int customerID = Integer.parseInt(request.getParameter("customerIDText"));
			
			String custFirstName = request.getParameter("customerFirstNameText");

			String custLastName = request.getParameter("customerLastNameText");

			String customerPhone = request.getParameter("customerPhoneText");

			String customerEmail = request.getParameter("customerEmailText");

			String customerAddress = request.getParameter("customerAddressText");

	
			

			custImpl.editCustomer(customerID, custFirstName, custLastName, customerPhone, customerEmail, customerAddress);

			RequestDispatcher rd = request.getRequestDispatcher("showCustomers.jsp");
			rd.forward(request, response);
		}

		// If the request is to displayTasks, create a list of tasks with the
		// and display tasks
		if (request.getParameter("displayCustomers") != null) {
			List<Customer> listCustomers = custImpl.displayCustomers();
			request.setAttribute("listCustomers", listCustomers);
			RequestDispatcher dispatcher = request.getRequestDispatcher("showCustomers.jsp");
			dispatcher.forward(request, response);
		}

		// If the request is to deleteTask, get taskID and delete task with it
		// then return to main page
		if (request.getParameter("deleteCustomer") != null) {
			// String id = request.getParameter("petID");
			int customerID = Integer.parseInt(request.getParameter("customerID"));
			System.out.println(customerID);
			customer.setCustomerID(customerID);
			custImpl.deleteCustomer(customer);
			RequestDispatcher rd = request.getRequestDispatcher("showCustomers.jsp");
			rd.forward(request, response);
		}
	}

}