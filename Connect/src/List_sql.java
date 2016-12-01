

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Servlet implementation class List_sql
 */
@WebServlet("/List_sql")
public class List_sql extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List_sql() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String query,email;
		PreparedStatement ps;
		ResultSet rs;
		HttpSession session; 
		ArrayList<ArrayList<String>> al;
		RequestDispatcher rd;
		int i;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");	
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Control", "root", "jeevan");		

			session = request.getSession();
			email = (String) session.getAttribute("email");
			
			query = "select status.bulb as bulb,status.fan as fan,room_mac.room as room from status inner join room_mac on room_mac.mac=status.mac";	
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			al=new ArrayList<ArrayList<String>>();
			
			for(i=0; i<10 && rs.next() ;i++){	
				
				al.add(new ArrayList<String>());

				al.get(i).add(rs.getString("room"));
				al.get(i).add(rs.getString("bulb"));
				al.get(i).add(String.valueOf(rs.getString("fan")));
			}
			
			request.setAttribute("status", al);
			rd=request.getRequestDispatcher("Enter_w.jsp");

			rd.forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}

	
	}

}
