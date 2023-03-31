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

@WebServlet("/FindModelByElectricRange")
public class FindModelByElectricRange extends HttpServlet {

    private CarModelDao carModelDao;

    @Override
    public void init() {
        carModelDao = CarModelDao.getInstance();
    }

    private void doWork(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);

        List<CarModel> carModels = new ArrayList<>();
        String minRangeStr = req.getParameter("minRange");

        if (minRangeStr == null || minRangeStr.trim().isEmpty()){
            messages.put("success", "Please enter valid minimum and maximum electric ranges.");
        } else {
            int minRange = Integer.parseInt(minRangeStr);
            carModels = carModelDao.getModelsByElectricRange(minRange);
            messages.put("success", "Displaying results for electric ranges up to: " + minRange);
            req.setAttribute("carModels", carModels);
        }
        req.getRequestDispatcher("/FindModelByElectricRange.jsp").forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req, resp);
    }
}
