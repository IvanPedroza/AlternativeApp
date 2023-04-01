package demo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.dao.UserReviewDao;
import demo.model.UserReview;

@WebServlet("/createReview")
public class CreateReview extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserReviewDao userReviewDao;

    @Override
    public void init() {
        userReviewDao = UserReviewDao.getInstance();
    }

    private void doWork(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Retrieve data from form
        String modelId = request.getParameter("modelId");
        String rating = request.getParameter("rating");
        Integer model = 0;
        Float rated = 0.0F;
        String message = "Please leave a valid review.";

        if (modelId == null || modelId.isEmpty()
            || rating == null || rating.isEmpty()) {
        } else {
            model = Integer.parseInt(modelId);
            String userName = request.getParameter("userName");
            String reviewTitle = request.getParameter("reviewTitle");
            rated = Float.valueOf(Float.parseFloat(rating));
            String reviewComment = request.getParameter("reviewComment");

            // Create a new UserReview object
            UserReview review = new UserReview(model, userName, rated, reviewTitle, reviewComment);

            try {
                review = userReviewDao.create(review);
                System.out.println(review);
                request.setAttribute("review", review);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("message", message);
            }
        }
            // Redirect back to the model details page
        request.getRequestDispatcher("/CreateReview.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doWork(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doWork(request, response);
    }
}
