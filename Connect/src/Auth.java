

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class Auth
 */
@WebFilter("/Auth")
public class Auth implements Filter {

    /**
     * Default constructor. 
     */
    public Auth() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
				// place your code here

				Connection con;
				ResultSet check,rs;
				String query,email,session_id,req_uri,privi;
				HttpServletRequest httprequest;
				PreparedStatement ps;
				HttpSession ssn;
				RequestDispatcher rd; 
				int n=1;
				long time;
				

				HttpServletResponse http_response = (HttpServletResponse) response;

				http_response.setHeader("Cache-Control","no-cache"); 
				http_response.setHeader("Pragma","no-cache"); 
				http_response.setDateHeader ("Expires", 0);

				httprequest = (HttpServletRequest) request;
				ssn = httprequest.getSession();
				req_uri = httprequest.getRequestURI();

				PrintWriter pw = response.getWriter();

				if(ssn.isNew()){

					Cookie ck = new Cookie("url",".."+req_uri);
					http_response.addCookie(ck);

					http_response.sendRedirect("login_bs.html");

				}else{
					try{
						Class.forName("com.mysql.jdbc.Driver");	
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Control", "root", "jeevan");	
						email = (String) ssn.getAttribute("email");
						session_id = ssn.getId();
						time = ssn.getCreationTime();

						query = "select count(*) from session where email=? and session_id=? and time=?";
						ps = con.prepareStatement(query);
						ps.setString(1, email);
						ps.setString(2, session_id);		
						ps.setLong(3, time);

						check = ps.executeQuery();
						if(check.next()){
							n=check.getInt(1);
						}
						
						query = "select privilege from permissions where email = ?";
						
						ps = con.prepareStatement(query);
						ps.setString(1, email);
						rs = ps.executeQuery();
						
						privi = null;
						if(rs.next()){
							privi = rs.getString(1);
						}
						privi.trim();
							

						if( n == 0){		

							if(req_uri.toLowerCase().endsWith("login_bs.html")){

								chain.doFilter(request, response);
							}
							else{
								PrintWriter out = response.getWriter();
								out.println(email + session_id +" "+ time);
								Cookie ck = new Cookie("url",".."+req_uri);
								http_response.addCookie(ck);
								http_response.sendRedirect("login_bs.html");

							}	
						}
						else{

							if(req_uri.toLowerCase().endsWith("login_bs.html")){
								//	rd = request.getRequestDispatcher("Enter_print");
								//	rd.forward(request, response);
								
								if(privi.equals("admin")){
									http_response.sendRedirect("List_sql");
								}else{
									http_response.sendRedirect("Enter_print");
								}
							}else{
								chain.doFilter(request, response);
							} 
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
