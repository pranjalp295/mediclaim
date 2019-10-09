package mediclaim;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Employee_Form_Controller
 */
@WebServlet("/Employee_Form_Controller")
public class Employee_Form_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee_Form_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(true);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediclaim", "root" , "root");                                             
			PreparedStatement ps = con.prepareStatement("Update employee set E_ID=? , E_Fname=? , E_Lname=? , E_Dob=? , E_Doj=? , E_Gender=? , E_address=? , E_Email=? , E_Contact=? , E_Department=? , E_Designation=? , E_Coverage=? where E_ID=?");
			ps.setString(1,request.getParameter("E_ID"));
			ps.setString(2,request.getParameter("E_Fname"));
			ps.setString(3,request.getParameter("E_Lname"));
			ps.setString(4,request.getParameter("E_Dob"));
			ps.setString(5,request.getParameter("E_Doj"));
			ps.setString(6,request.getParameter("E_Gender"));
			ps.setString(7,request.getParameter("E_address"));
			ps.setString(8,request.getParameter("E_Email"));
			ps.setString(9,request.getParameter("E_Contact"));
			ps.setString(10,request.getParameter("E_Department"));
			ps.setString(11,request.getParameter("E_Designation"));
			ps.setString(12,request.getParameter("E_Coverage"));
			ps.setString(13,request.getParameter("E_ID"));
			
			ps.executeUpdate();
			

			RequestDispatcher rd=request.getRequestDispatcher("View_Employee.jsp");
			rd.forward(request,response);
			
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
