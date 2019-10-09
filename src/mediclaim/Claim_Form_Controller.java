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
 * Servlet implementation class Claim_Form_Controller
 */
@WebServlet("/Claim_Form_Controller")
public class Claim_Form_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Claim_Form_Controller() {
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
			System.out.println(request.getParameter("Claim_No"));
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediclaim", "root" , "root");                                             
			PreparedStatement ps = con.prepareStatement("Update Claim_Registration set  E_Name=? , E_Relation=? , E_Doa=? , E_Dod=? , Hospital_Name=? , Doctor_Name=? , Hospital_Fees=? , Pathology_Fees=? , Chemist_Fees=? , Miscellaneous_Fees=? , Bill_Count=? , Total_Bill=? where E_ID=? and Claim_Count=?");
		    

			ps.setString(1,request.getParameter("E_Name"));
			
			ps.setString(2,request.getParameter("E_Relation"));
			
			ps.setString(3,request.getParameter("E_Doa"));
			
			ps.setString(4,request.getParameter("E_Dod"));
			
			ps.setString(5,request.getParameter("Hospital_Name"));
			
			ps.setString(6,request.getParameter("Doctor_Name"));
			
			ps.setString(7,request.getParameter("Hospital_Fees"));
			
			ps.setString(8,request.getParameter("Pathology_Fees"));
			
			ps.setString(9,request.getParameter("Chemist_Fees"));
			
			ps.setString(10,request.getParameter("Miscellaneous_Fees"));
			
			ps.setString(11,request.getParameter("Bill_Count"));
			
			ps.setString(12,request.getParameter("Total_Bill"));
			
			ps.setString(13,request.getParameter("Employee_ID"));
			
			ps.setString(14,request.getParameter("Claim_No"));
			
			ps.executeUpdate();
			
			RequestDispatcher rd=request.getRequestDispatcher("Claim_History.jsp");
			rd.forward(request,response);
		
		
	}
       catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
