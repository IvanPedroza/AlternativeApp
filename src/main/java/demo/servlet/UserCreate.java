package demo.servlet;

import demo.dao.*;
import demo.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/usercreate")
public class UserCreate extends HttpServlet {
	
	protected UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = UserDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String userName = req.getParameter("userName");
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Invalid UserName");
        } else {
        	// Create the User.
        	String password = req.getParameter("password");
        	String firstName = req.getParameter("firstname");
        	String lastName = req.getParameter("lastname");
        	String email = req.getParameter("email");
        	String phoneNumber = req.getParameter("phoneNumber");
        	String addressLine1 = req.getParameter("addressLine1");
        	String addressLine2 = req.getParameter("addressLine2");
        	String county = req.getParameter("county");
        	String city = req.getParameter("city");
        	String state = req.getParameter("state");
        	String country = req.getParameter("country");
        	String zipCode = req.getParameter("zipCode");
        	Location location = new Location(county, city, state, country, zipCode);
        	
	        try {
	        	User user = new User(userName, password, firstName, lastName, email, phoneNumber, addressLine1, addressLine2, location);
	        	user = userDao.create(user);
	        	messages.put("success", "Successfully created " + userName);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
    }
}
