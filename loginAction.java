package avenue;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class loginAction
 */
@WebServlet("/loginAction")
public class loginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		
		/*try {
		
		List<Customer>cusDetails = CustomerDButil.validate(uname,password);
		request.setAttribute("cusDetails", cusDetails);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
		dis.forward(request, response)*/
		
		
		if("admin@gmail.com".equals(uname) && "admin".equals(password)) {
			HttpSession session = request.getSession(true);
			
			session.setAttribute("uname",uname);
			response.sendRedirect("admin/adminHome.jsp");
		}
		
		else {
			
			int z=0;
			try {
				Connection con = ConnectionProvider.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from customerdetails where userName='"+uname+"' and password='"+password+"'");
				while(rs.next()) {
					HttpSession session = request.getSession(true);
					
					z=1;
					session.setAttribute("uname",uname);
					response.sendRedirect("home.jsp");
				}
				if(z == 0) {
					response.sendRedirect("login.jsp?msg=notexist");
				}
			}
			
			catch(Exception e) {
				
				System.out.print(e);
				response.sendRedirect("login.jsp?msg=invalid");
				
			}
		}
	}

}
