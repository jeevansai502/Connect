

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Enter_print
 */
@WebServlet("/Enter_print")
public class Enter_print extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enter_print() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
		Cookie ck[] = request.getCookies();
		String x;
		int co=0;
		
		for(Cookie c : ck){	
			if("check".equals(c.getName())){
				x = c.getValue();
				co = 1;
			    Cookie ce = new Cookie("check","");
			    ce.setMaxAge(0);
			    response.addCookie(ce);
			}
		}
		
		
		if(co==1){
			
			PrintWriter pw = response.getWriter();
			pw.println("Please enter valid details.");
			RequestDispatcher rd = request.getRequestDispatcher("login_bs.html");
			rd.include(request, response);
		}else{	
			
	    RequestDispatcher rd = request.getRequestDispatcher("Enter_s.jsp");
		rd.include(request, response);
		}
	}

}
