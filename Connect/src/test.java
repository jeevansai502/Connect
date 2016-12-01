

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//System.out.println(request.getParameter("mac"));		

	    String mac = request.getParameter("mac");
		int bulb = Integer.parseInt(request.getParameter("bulb"));
		int fan = Integer.parseInt(request.getParameter("fan"));
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Control?autoReconnect=true&useSSL=false", "root", "jeevan");

			String query = "insert into status values(?,?,?) on duplicate key update mac=values(mac),bulb=values(bulb),fan=values(fan)";
			PreparedStatement ps = con.prepareStatement(query);		
			ps.setString(1, mac);
			ps.setInt(2, bulb);
			ps.setInt(3, fan);
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}
