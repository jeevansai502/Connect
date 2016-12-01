

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fan_control
 */
@WebServlet("/Fan_control")
public class Fan_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fan_control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
		String change = request.getParameter("val");
		int rno = Integer.parseInt(request.getParameter("id"));
		
		System.out.println(change);
		
		String query;
		PreparedStatement ps;
		ResultSet rs;
		
		System.out.println("dddddddddddddddddd");
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Control", "root", "jeevan");	

		
		query = "select ip from mac_ip inner join room_mac on mac_ip.mac=room_mac.mac where room_mac.room = ?";

		ps = con.prepareStatement(query);
		ps.setInt(1, rno);
		rs=ps.executeQuery();

		String ip = null;
		if(rs.next()){
			ip = rs.getString("ip");
		}	
		

		
		String url = "http://" + ip + "/?FAN=" + change;
		
		String data;
		  try (java.util.Scanner s1 = new java.util.Scanner(new java.net.URL(url).openStream())) {
			  data = s1.useDelimiter("\\A").next();
				s1.close();
		  }  
		  
		  query = "select mac from room_mac where room_mac.room=?";
		  ps = con.prepareStatement(query);
		  ps.setInt(1, rno);
		  rs=ps.executeQuery();
		  
		  String mac = null;
		  if(rs.next()){
			  mac = rs.getString("mac");
		  }
		  
		  System.out.println(data);
		  
		  query = "insert into status values(?,?,?) on duplicate key update mac=values(mac),bulb=values(bulb),fan=values(fan)";
		  ps = con.prepareStatement(query);
		  ps.setString(1, mac);
		  ps.setInt(2, Integer.parseInt(data.substring(0,1)));
		  ps.setInt(3, Integer.parseInt(data.substring(1,2)));
		  
		  ps.executeUpdate();
		  

		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
