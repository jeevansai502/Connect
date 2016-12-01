

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Enter_values
 */
@WebServlet("/Enter_values")
public class Enter_values extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Enter_values() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		System.out.println("vvvvvvvvvvvvvvvvv");		

/*
		try {  
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Control", "root", "jeevan");

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

			String bulb = map.get("bulb");
			String fan = map.get("fan");
			String mac = map.get("mac");
			System.out.println(bulb + " " + fan + " " + mac);

			String query= "insert into status values(?,?,?) on duplicate key update bulb=values(bulb),fan=values(fan)";

			PreparedStatement ps = con.prepareStatement(query);		

			ps.setString(1, mac);
			ps.setString(2, bulb);
			ps.setString(3, fan);

			ps.executeUpdate();


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

*/

	}

}
