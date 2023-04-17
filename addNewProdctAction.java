package avenue;

import java.io.IOException;
//import java.sql;
//import java.sql.PreparedStatement;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addNewProdctAction
 */
@WebServlet("/addNewProdctAction")
public class addNewProdctAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String availability = request.getParameter("availability");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		boolean isT;
		
		isT = ProductDButil.product(id, name, category, price, availability);
		
		if(isT== true) {
			//RequestDispatcher req = request.getRequestDispatcher("addNewProduct.jsp?msg=done");
			//req.forward(request, response);
			response.sendRedirect("addNewProduct.jsp?msg=done");
		}
		else {
			
			//RequestDispatcher req = request.getRequestDispatcher("addNewProduct.jsp?msg=wrong");
			//req.forward(request, response);
			response.sendRedirect("addNewProduct.jsp?msg=wrong");
		}
	}

}
