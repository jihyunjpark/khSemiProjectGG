package report.review.controller;

import javax.servlet.RequestDispatcher;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import report.review.model.service.ReportService;

@WebServlet("/deleteReview.do")
public class DeleteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteReviewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		int result = new ReportService().deleteReport(reviewNo);
		
		if(0 < result){
			response.sendRedirect("/swp/ReportList.do");
		}else{
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "게시글 수정에 실패하였습니다.");
			view.forward(request, response);
		}
	}

}
