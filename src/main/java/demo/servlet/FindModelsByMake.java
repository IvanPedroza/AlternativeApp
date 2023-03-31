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

@WebServlet("/findModelsByMake")
public class FindModelsByMake extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CarModelDao carModelDao;

    @Override
    public void init() {
        carModelDao = CarModelDao.getInstance();
    }

    private void doWork(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        List<CarModel> carModels;
        String makeName = req.getParameter("makeName");

        if (makeName == null || makeName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Make Name.");
        } else {
            // Retrieve CarModels, and store as a message.
            try {
                carModels = carModelDao.getCarModelsByMake(makeName);
                req.setAttribute("carModels", carModels);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            messages.put("success", "Displaying results for " + makeName);
        }
        req.getRequestDispatcher("/FindCarByMake.jsp").forward(req, resp);
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
