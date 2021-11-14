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

@WebServlet("/PetController")
public class PetController extends HttpServlet {
		/**
	 * 
	 */
		Pet pet = new Pet();
		PetImpl petImpl = new PetImpl();
		
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// If the request is to addTask, get taskText and create new task with it
			// then save the task with the taskImpl class and return to main page
			if(request.getParameter("addPet")!=null) {
				//String petID = request.getParameter("petIDText");
				int petID = Integer.parseInt(request.getParameter("petIDText"));
				pet.setPetID(petID);
				int petOwnerID = Integer.parseInt(request.getParameter("petOwnerIDText"));
				pet.setPetOwnerID(petOwnerID);
				String petName = request.getParameter("petNameText");
				pet.setPetName(petName);
				String petSpecies = request.getParameter("petSpeciesText");
				pet.setSpeciesID(petSpecies);
				String petBreed = request.getParameter("petBreedText");
				pet.setBreedID(petBreed);
				String petAge = request.getParameter("petAgeText");
				pet.setPetName(petAge);
				String petGender = request.getParameter("petGenderText");
				pet.setSexID(petGender);
				petImpl.savePet(pet, petOwnerID);
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
			
			// *** ADD PET ***
			try {
			if(request.getParameter("addPet")!=null) {
				//String petID = request.getParameter("petIDText");
				int petID = Integer.parseInt(request.getParameter("petIDText"));
				pet.setPetID(petID);
				int petOwnerID = Integer.parseInt(request.getParameter("petOwnerIDText"));
				pet.setPetOwnerID(petOwnerID);
				String petName = request.getParameter("petNameText");
				pet.setPetName(petName);
				String petSpecies = request.getParameter("petSpeciesText");
				pet.setSpeciesID(petSpecies);
				String petBreed = request.getParameter("petBreedText");
				pet.setBreedID(petBreed);
				String petAge = request.getParameter("petAgeText");
				pet.setPetAge(petAge);
				String petGender = request.getParameter("petGenderText");
				pet.setSexID(petGender);
				//String petBoardingStatus = request.getParameter("petBoardingText");
				//pet.setPetBoardingStatusID(petBoardingStatus);
				petImpl.savePet(pet, petOwnerID);
				RequestDispatcher rd = request.getRequestDispatcher("showPets.jsp");
				rd.forward(request,  response);	
			}
			} catch (Exception e) {
				RequestDispatcher rd = request.getRequestDispatcher("addPet.jsp");
				rd.forward(request, response);
			}
			
			// *** EDIT PET ***
			if(request.getParameter("editPet")!=null) {


				int petOwnerID = Integer.parseInt(request.getParameter("petOwnerIDText"));
				String petName = request.getParameter("petNameText");

				String petSpecies = request.getParameter("petSpeciesText");

				String petBreed = request.getParameter("petBreedText");

				String petAge = request.getParameter("petAgeText");

				String petGender = request.getParameter("petGenderText");

				Integer petID = Integer.parseInt((request.getParameter("petIDText")));
				System.out.println(petID);

	            petImpl.editPet(petID, petOwnerID, petName, petSpecies, petBreed, petAge, petGender);
	             
	             
				RequestDispatcher rd = request.getRequestDispatcher("showPets.jsp");
				rd.forward(request,  response);	
			}
			
			// *** DISPLAY PETS ***
			// If the request is to displayTasks, create a list of tasks with the 
			// and display tasks
			if(request.getParameter("displayPets")!=null) {
				List<Pet> listPets = petImpl.displayPets();
				request.setAttribute("listPets", listPets);
				RequestDispatcher dispatcher = request.getRequestDispatcher("showPets.jsp");
				dispatcher.forward(request, response);
			}
			
			/// *** DELETE PET ***
			// If the request is to deleteTask, get taskID and delete task with it
			// then return to main page
			if(request.getParameter("deletePet")!=null) {
				//String id = request.getParameter("petID");
				int petID = Integer.parseInt(request.getParameter("petID"));
				pet.setPetID(petID);
				petImpl.deletePet(pet);
				RequestDispatcher rd = request.getRequestDispatcher("showPets.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
}