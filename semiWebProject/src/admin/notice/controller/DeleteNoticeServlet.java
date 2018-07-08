package admin.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.notice.model.service.NoticeService;

@WebServlet("/deleteNotice.do")
public class DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteNoticeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		int result = new NoticeService().removeNotice(noticeNo);
		RequestDispatcher view = null;
		if (result > 0) {
			view = request.getRequestDispatcher("views/notice/noticeList.jsp");
			request.setAttribute("list", new NoticeService().getNoticeList());
		} else {
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "공지사항 삭제 실패");
		}
		view.forward(request, response);

	}

}
