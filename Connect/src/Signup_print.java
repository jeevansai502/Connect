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
 * Servlet implementation class Signup_print
 */
@WebServlet("/Signup_print")
public class Signup_print extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup_print() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session;

		session = request.getSession();		
		String message ,s;
		RequestDispatcher rd;

		PrintWriter out = response.getWriter();

		if((String) session.getAttribute("signup_message") != null){
			message =  (String) session.getAttribute("signup_message") ;
			out.println(message);
			rd = request.getRequestDispatcher("signup_bs.html");
			//session.removeAttribute("signup_message");
			rd.include(request, response);
		}else if((String) session.getAttribute("signup_success") != null){
			message = (String) session.getAttribute("signup_success"); 
			out.println(message);
			rd = request.getRequestDispatcher("login_bs.html");
			//session.removeAttribute("signup_success");
			rd.include(request, response);
		}else{
            
		}
	}

}
