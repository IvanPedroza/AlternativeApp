package demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.dao.CarModelDao;
import demo.model.CarModel;

@WebServlet("/findModelsByCity")
public class FindModelsByCity extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private CarModelDao carModelDao;
	
	@Override
	public void init() {
		carModelDao = CarModelDao.getInstance();
	}

    private void doWork(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<CarModel> carModels = new ArrayList<CarModel>();
        String city = req.getParameter("city");

        if (city == null || city.trim().isEmpty()) {
            messages.put("success", "Please enter a valid City.");
        } else {
            // Retrieve CarModels, and store as a message.
            try {
                carModels = carModelDao.getPopularModelsByCity(city);
                req.setAttribute("carModels", carModels);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
            messages.put("success", "Displaying results for " + city);
            // Save the previous search term, so it can be used as the default
            // in the input box when rendering FindCarByCity.jsp.
            messages.put("previousCity", city);
        }
        req.getRequestDispatcher("/FindCarByCity.jsp").forward(req, resp);
    }
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doWork(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doWork(req, resp);
    }
}
