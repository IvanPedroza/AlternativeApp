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

@WebServlet("/findModelsByPrice")
public class FindModelsByPrice extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CarModelDao carModelDao;

    @Override
    public void init() {
        carModelDao = CarModelDao.getInstance();
    }

    private void doWork(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<CarModel> carModels = new ArrayList<CarModel>();

        String minPriceString = req.getParameter("minPrice");
        String maxPriceString = req.getParameter("maxPrice");

        if (minPriceString == null || minPriceString.trim().isEmpty() ||
                maxPriceString == null || maxPriceString.trim().isEmpty()) {
            messages.put("success", "Please enter a valid minimum and maximum price.");
        } else {
            try {
                int minPrice = Integer.parseInt(minPriceString);
                int maxPrice = Integer.parseInt(maxPriceString);

                carModels = carModelDao.getModelsByPrice(minPrice, maxPrice);

                req.setAttribute("carModels", carModels);
            } catch (SQLException|NumberFormatException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            messages.put("success", "Displaying results for models with price between " + minPriceString + " and " + maxPriceString + ".");
        }
        req.getRequestDispatcher("/FindCarByPrice.jsp").forward(req, resp);
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
