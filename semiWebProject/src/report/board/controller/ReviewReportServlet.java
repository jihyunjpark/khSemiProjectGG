package report.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewReportServlet
 */
@WebServlet("/reportReview.do")
public class ReviewReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = -1;
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		ReviewService rs = new ReviewService();
		result = rs.reportReview(reviewId);
		response.getWriter().print(result);

	}
}
