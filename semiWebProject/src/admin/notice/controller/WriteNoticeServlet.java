package admin.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.notice.model.service.NoticeService;
import admin.notice.model.vo.NoticeVo;

@WebServlet("/writeNotice.do")
public class WriteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WriteNoticeServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String notice_title = request.getParameter("title");
		String notice_content = request.getParameter("content");

		NoticeVo notice = new NoticeVo(notice_title, notice_content);

		int result = new NoticeService().writeNotice(notice);

		RequestDispatcher view = null;
		if (0 < result) {
			view = request.getRequestDispatcher("views/notice/noticeList.jsp");
			request.setAttribute("list", new NoticeService().getNoticeList());
		} else {
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "공지사항 작성 실패");
		}
		view.forward(request, response);
	}

}
