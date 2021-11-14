package mainPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardingController")
public class BoardingController extends HttpServlet {

		Boarding boarding = new Boarding();
		BoardingImpl boardingImpl = new BoardingImpl();
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// If the request is to addTask, get taskText and create new task with it
			// then save the task with the taskImpl class and return to main page
			if(request.getParameter("addBoarding")!=null) {
				//String petID = request.getParameter("petIDText");
				int boardingID = Integer.parseInt(request.getParameter("boardingIDText"));
				boarding.setBoardingID(boardingID);
				int petID = Integer.parseInt(request.getParameter("petIDText"));
				boarding.setPetID(petID);
				int ownerID = Integer.parseInt(request.getParameter("ownerIDText"));
				boarding.setOwnerID(ownerID);
				String dropOffDate = request.getParameter("dropOffDateText");
				boarding.setDropOffDate(dropOffDate);
				String pickUpDate = request.getParameter("pickUpDateText");
				boarding.setPickUpDate(pickUpDate);
				String boardingStatusID = request.getParameter("boardingStatusIDText");
				boarding.setBoardingStatusID(boardingStatusID);
				boardingImpl.saveBoarding(boarding);
				
				RequestDispatcher rd = request.getRequestDispatcher("showBoardingInfo.jsp");
				rd.forward(request,  response);	
			}
		}
		
		public static Connection getConnection() throws Exception {
			try {
			
				String url = "jdbc:mysql://localhost:3306/petboardingdb";
				String username = "root";
				String password = "Sqlpassword";
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				//Establish connection with information above
				Connection conn = DriverManager.getConnection(url, username, password);
				return conn;
			} catch(Exception e) {
				System.out.println(e);
			}
		return null;
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			// *** ADD BOARDING ***
			try {
			if(request.getParameter("addBoarding")!=null) {
	
				int boardingID = Integer.parseInt(request.getParameter("boardingIDText"));
				boarding.setBoardingID(boardingID);
				int petID = Integer.parseInt(request.getParameter("petIDText"));
				boarding.setPetID(petID);
				int ownerID = Integer.parseInt(request.getParameter("ownerIDText"));
				boarding.setOwnerID(ownerID);
//				String dropOffDate = request.getParameter("dropOffDateText");
//				boarding.setDropOffDate(dropOffDate);
//				String pickUpDate = request.getParameter("pickUpDateText");
//				boarding.setPickUpDate(pickUpDate);
				String startDateString = request.getParameter("dropOffDateText");
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dropOffDate = LocalDate.parse(startDateString, formatter).format(formatter2);
				String startDateString1 = request.getParameter("pickUpDateText");
				String pickUpDate = LocalDate.parse(startDateString1, formatter).format(formatter2);
				boarding.setDropOffDate(dropOffDate);
				boarding.setPickUpDate(pickUpDate);
				String boardingStatusID = request.getParameter("boardingStatusIDText");
				boarding.setBoardingStatusID(boardingStatusID);
				boardingImpl.saveBoarding(boarding);
				RequestDispatcher rd = request.getRequestDispatcher("showBoardingInfo.jsp");
				rd.forward(request,  response);	
			}
			}catch (Exception e) {
				System.out.println(e);
				RequestDispatcher rd = request.getRequestDispatcher("addBoarding.jsp");
				rd.forward(request,  response);	
			}
			
			// *** EDIT BOARDING ***
			if(request.getParameter("editBoarding")!=null) {
				
				String startDateString = request.getParameter("dropOffDateText");
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dropOffDate = LocalDate.parse(startDateString, formatter).format(formatter2);
				
				String startDateString1 = request.getParameter("pickUpDateText");
				String pickUpDate = LocalDate.parse(startDateString1, formatter).format(formatter2);
				
				int boardingID = Integer.parseInt(request.getParameter("boardingIDText"));
				
				int petID = Integer.parseInt(request.getParameter("petIDText"));
				
				int ownerID = Integer.parseInt(request.getParameter("ownerIDText"));
				

				//String dropOffDate = request.getParameter("dropOffDateText");

				//String pickUpDate = request.getParameter("pickUpDateText");

				String boardingStatusID = request.getParameter("boardingStatusIDText");



	            boardingImpl.editBoarding(boardingID, petID, ownerID, dropOffDate, pickUpDate, boardingStatusID);
	             
	             
				RequestDispatcher rd = request.getRequestDispatcher("showBoardingInfo.jsp");
				rd.forward(request,  response);	
			}
			
			// *** DISPLAY BOARDING ***
			// If the request is to displayTasks, create a list of tasks with the 
			// and display tasks
			if(request.getParameter("displayBoarding")!=null) {
				List<Boarding> listBoarding = boardingImpl.displayBoarding();
				request.setAttribute("listBoarding", listBoarding);
				RequestDispatcher dispatcher = request.getRequestDispatcher("showBoardingInfo.jsp");
				dispatcher.forward(request, response);
			}
			
			/// *** DELETE BOARDING ***
			// If the request is to deleteTask, get taskID and delete task with it
			// then return to main page
			if(request.getParameter("deleteBoarding")!=null) {
				//String id = request.getParameter("petID");
				int boardingID = Integer.parseInt(request.getParameter("boardingID"));
				boarding.setBoardingID(boardingID);
				boardingImpl.deleteBoarding(boarding);
				RequestDispatcher rd = request.getRequestDispatcher("showBoardingInfo.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
}