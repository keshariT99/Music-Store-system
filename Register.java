package avenue;

import java.io.IOException;

//import java.sql.Connection;
//import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobno = request.getParameter("mobno");
		String address = "";
		String city = "";
		String state = "";
		String country = "";
		
		
		boolean isT;
		
		isT = CustomerDButil.customerdetails(name, uname, password, email, mobno, address, city, state, country);
		
		if(isT== true) {
			response.sendRedirect("signup.jsp?msg=valid");
		}
		else {
			response.sendRedirect("signup.jsp?msg=invalid");
		}
		
	}

}
