package avenue;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class EditProductAction
 */
@WebServlet("/EditProductAction")
public class EditProductAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String availability= request.getParameter("availability");
		
		
		boolean isT;
		
		isT = ProductDButil.updatecus(id, name, category, price, availability);
		
		if(isT == true) {
			RequestDispatcher dis = request.getRequestDispatcher("allProductEditProduct.jsp?msg = done");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("allProductEditProduct.jsp?msg = wrong");
			dis.forward(request, response);
		}
		
		
	}

}
