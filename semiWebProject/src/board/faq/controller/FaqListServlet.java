package board.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.faq.model.service.FaqService;
import board.faq.model.vo.FaqVo;

@WebServlet("/faqList.do")
public class FaqListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FaqListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<FaqVo> list = new FaqService().getFaqList();

		RequestDispatcher view = null;
		if (list.size() != 0) {
			request.setAttribute("list", list);
			view = request.getRequestDispatcher("views/faq/faqList.jsp");
//		} else {
//			request.setAttribute("msg", "FAQ 불러오기 실패");
//			
//			
//			view = request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		view.forward(request, response);
	}

}
