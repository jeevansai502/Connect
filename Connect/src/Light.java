

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
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
 * Servlet implementation class Light
 */
@WebServlet("/Light")
public class Light extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Light() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Control", "root", "jeevan");	
			
			HttpSession session = request.getSession();
			
			String s = session.getId();
			String query;
			PreparedStatement ps;
			ResultSet rs;
			int rno = -1,lstate;
			
			query = "select room from user_details inner join session on user_details.email = session.email where session.session_id=?";
			
			ps = con.prepareStatement(query);
			ps.setString(1, s);
			rs=ps.executeQuery();
			
			if(rs.next())
			rno = rs.getInt("room");
			
			query = "select ip from mac_ip inner join room_mac on mac_ip.mac=room_mac.mac where room_mac.room = ?";
			
			ps = con.prepareStatement(query);
			ps.setInt(1, rno);
			rs=ps.executeQuery();
			
			String dev_ip = null;
			if(rs.next())
				dev_ip = rs.getString("ip");
				
			dev_ip = dev_ip.trim();
			String url = "http://" + dev_ip + "/?BULB=STATE";

			System.out.println(url);
			
			String data ;
			try (java.util.Scanner s1 = new java.util.Scanner(new java.net.URL(url).openStream())) {
				System.out.println("X");
			        data = s1.useDelimiter("\\A").next();
					s1.close();
					System.out.println("Y");    
			}
			     		
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
