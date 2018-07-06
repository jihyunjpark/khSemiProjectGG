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

@WebServlet("/noticeDetail.do")
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		NoticeVo notice = new NoticeService().getNotice(notice_no);
		RequestDispatcher view = null;
		if (notice != null){
			request.setAttribute("notice", notice);
			view = request.getRequestDispatcher("views/notice/noticeDetail.jsp");
//		}else{
//			request.setAttribute("msg", "공지사항 상세보기 실패");
//			view = request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		view.forward(request, response);
	}

}
