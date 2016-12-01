

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String query,email,session_id,req_uri;
		HttpSession ssn;
		PreparedStatement ps;
		Connection con;
		ResultSet rs;
		ResultSetMetaData rsmd;
		ArrayList<ArrayList<String>> al;
		RequestDispatcher rd;
		int i;

		ssn = request.getSession();
		email=(String) ssn.getAttribute("email");

		try{

			query="select * from user_details where email=?";
			Class.forName("com.mysql.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Control", "root", "jeevan");
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			rsmd = (ResultSetMetaData) rs.getMetaData();

			al=new ArrayList<ArrayList<String>>();
			if(rs.next()){
				for(i=0;i<5;i++){
				
					al.add(new ArrayList<String>());
					al.get(i).add(rsmd.getColumnName(i+1));
					al.get(i).add(rs.getString(i+1));
				}
			}

			request.setAttribute("profile", al);
			rd=request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);

		}catch(Exception e){
			e.printStackTrace();
		}


	
	}

}
