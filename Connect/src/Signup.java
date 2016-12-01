import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signup
 **/
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//response.setContentType("text/html");		
		//PrintWriter out = response.getWriter();

		String email_id,mobile,password,confirm_password;
		HttpSession session;

		session = request.getSession();

		email_id = request.getParameter("email");
		boolean valid = (email_id != "") &&  (email_id.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"));
		if(!valid){
			//out.println("<p style='margin-left:30%;margin-top:7%;color:red;'>Please check your details.</p>");
			session.setAttribute("signup_message", "<p style='margin-left:30%;margin-top:7%;color:red;'>Please check your details.</p>");
            response.sendRedirect("Signup_print"); 
			//	RequestDispatcher rd = request.getRequestDispatcher("signup_bs.html");
			//rd.include(request, response);
		}

		mobile = request.getParameter("mobile");
		valid = (mobile != "") && (mobile.matches("^\\d{10}$"));
		if(!valid){
			//out.println("<p style='margin-left:30%;margin-top:7%;color:red;'>Please check your details.</p>");
			session.setAttribute("signup_message", "<p style='margin-left:30%;margin-top:7%;color:red;'>Please check your details.</p>");
            response.sendRedirect("Signup_print");
			//	RequestDispatcher rd = request.getRequestDispatcher("signup_bs.html");
			//	rd.include(request, response);
		}

		password = request.getParameter("password");
		confirm_password = request.getParameter("confirm_password");
		valid = (password != "") && (confirm_password != "") && (password.equals(confirm_password));
		if(!valid){
			//out.println("<p style='margin-left:30%;margin-top:7%;color:red;'>Please check your details.</p>");
			session.setAttribute("signup_message", "<p style='margin-left:30%;margin-top:7%;color:red;'>Please check your details.</p>");
			response.sendRedirect("Signup_print");
			//	RequestDispatcher rd = request.getRequestDispatcher("signup_bs.html");
			//	rd.include(request, response);
		}

		//RequestDispatcher mail = request.getRequestDispatcher("Email");
		//mail.forward(request, response);

		RequestDispatcher create_table = request.getRequestDispatcher("Signup_sql");
		create_table.forward(request, response);
        
	}

}
