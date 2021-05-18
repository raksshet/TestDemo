package com.newewebsite.user.access;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newewebsite.DBConnection;


/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		PrintWriter out = response.getWriter();
    		out.println("<html><body>");
    		InputStream in  = getServletContext().getResourceAsStream("/WEB-INF/config.properties");;
    		Properties prop = new Properties();
    		prop.load(in);
    		System.out.println("values "+prop.getProperty("url")+" "+prop.getProperty("userid")+" "+prop.getProperty("password"));
    		
    		try {
    			DBConnection connect = new DBConnection(prop.getProperty("url"),prop.getProperty("userid"),prop.getProperty("password"));
    			//DBConnection connect = new DBConnection("jdbc:mysql://localhost:3306/ecommerce", "root","root");
    			//out.println("DB connection initialized.<br>");
    			
    			String filterusername = request.getParameter("username");
    			 String filterpassword = request.getParameter("password");
    			
    			Statement stmt = connect.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    			String sql = "SELECT * FROM userdetails" +
    		            " WHERE username="+"'"+filterusername+"'";
    			System.out.println(sql);
    			
    			ResultSet rst = stmt.executeQuery(sql);
    			
    			while(rst.next()){
    				 String username = rst.getString("username");
    				 String password = rst.getString("userpwd");
    				 filterusername = request.getParameter("username");
    				 filterpassword = request.getParameter("password");
    				 System.out.println(" Before Values are "+filterpassword +" "+filterusername +" "+username +" "+password);
    					
    					if(username.equals(filterusername) && password.equals(filterpassword)) {
    					out.println("<SPAN style='color:red'> Hurray valid Credentilas Supplied </SPAN>");
    					}else {
    						request.getRequestDispatcher("login.html").include(request, response);
    						out.println("<SPAN style='color:red'> Invalid Credentilas Supplied </SPAN>");
    						//System.out.println("Values are "+filterpassword +" "+filterusername);
    					}
    				
    			}
    			
    			stmt.close();
    			connect.colseConnection();
    			//out.println("DB connection closed.<br>");
    			
    		} catch (ClassNotFoundException  e) {
    			
    			e.printStackTrace();
    			
    		} catch (SQLException  e) {
    			
    			e.printStackTrace();
    		} 
    				
    		out.println("</body</html>");		
    		
    		
    		
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
