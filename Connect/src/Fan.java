

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Fan
 */
@WebServlet("/Fan")
public class Fan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Control", "root", "jeevan");	
			
			HttpSession session = request.getSession();
			
			String s = session.getId();
			String query;
			PreparedStatement ps;
			ResultSet rs;
			int rno = -1,bstate;
			
			query = "select room from user_details inner join session on user_details.email = session.email where session.session_id=?";

			
			ps = con.prepareStatement(query);
			ps.setString(1, s);
			rs=ps.executeQuery();
			
			if(rs.next())
			rno = rs.getInt("room");
			
			/*
			query = "select fan from state inner join room_mac on state.mac=room_mac.mac where room_mac.room = ?";
			
			ps = con.prepareStatement(query);
			ps.setInt(1, rno);
			rs=ps.executeQuery();
			
			int l=-1;
			if(rs.next())
				l = rs.getInt("fan");
		*/	
			query = "select ip from mac_ip inner join room_mac on mac_ip.mac=room_mac.mac where room_mac.room = ?";
			
			ps = con.prepareStatement(query);
			ps.setInt(1, rno);
			rs=ps.executeQuery();
			
			String dev_ip = null;
			if(rs.next())
				dev_ip = rs.getString("ip");
				
			dev_ip = dev_ip.trim();
			String url = "http://" + dev_ip + "/?FAN=STATE";

			String data ;
			  try (java.util.Scanner s1 = new java.util.Scanner(new java.net.URL(url).openStream())) {
			      data = s1.useDelimiter("\\A").next();
			      s1.close();
			    }
			
			System.out.println(url);
					
			PrintWriter pw = response.getWriter();
			System.out.println(data);
			System.out.println("A");
			if(data.equals("1")){
				pw.println("ON");
			}else if(data.equals("0")){
				pw.println("OFF");
			}
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	

}
