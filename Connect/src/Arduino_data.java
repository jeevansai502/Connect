

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Arduino_data
 */
@WebServlet("/Arduino_data")
public class Arduino_data extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Arduino_data() {

		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("aaaaaaaaaaaaa");
				try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Control?autoReconnect=true&useSSL=false", "root", "jeevan");

			BufferedReader br = request.getReader();

			String var="",s;
			while((s = br.readLine()) != null){
				var = var + s;
			}
			String[] variables = var.split("&");  
			Map<String, String> map = new HashMap<String, String>();  
			for (String param : variables)  
			{  
				String name = param.split("=")[0];  
				String value = param.split("=")[1];  
				map.put(name, value);  
			} 
			String ip = map.get("ip");
			String mac = map.get("mac");
			System.out.println(ip + " " + mac);

			String query = "delete from mac_ip where mac=?";
			PreparedStatement ps = con.prepareStatement(query);		
			ps.setString(1, mac);
			ps.executeUpdate();

			query = "insert into mac_ip values(?,?)";
			ps = con.prepareStatement(query);		
			ps.setString(1, mac);
			ps.setString(2, ip);
			ps.executeUpdate();

			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	



	}

}
