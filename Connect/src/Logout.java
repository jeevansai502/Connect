

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession(); 

		if(session.isNew()){
			session.invalidate();
		}else{
			String email = (String) session.getAttribute("email"); 
			String session_id = request.getRequestedSessionId();

			try{

				Class.forName("com.mysql.jdbc.Driver");	
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Control", "root", "jeevan");	
				String query = "delete from session where email=? and session_id=?";
				PreparedStatement ps = con.prepareStatement(query); 
				ps.setString(1, email);    
				ps.setString(2, session_id);
				ps.executeUpdate();
				session.invalidate();
				response.sendRedirect("start.html");
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}
    
    
    
}
