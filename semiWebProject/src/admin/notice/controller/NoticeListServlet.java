package admin.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.notice.model.service.NoticeService;
import admin.notice.model.vo.NoticeVo;

@WebServlet("/noticeList.do")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<NoticeVo> list = new NoticeService().getNoticeList();
		
		RequestDispatcher view = null;
		System.out.println(list.size());
		if(list.size() != 0){
			request.setAttribute("list", list);
			view = request.getRequestDispatcher("views/notice/noticeList.jsp");
//		}else{
//			request.setAttribute("msg", "공지사항 불러오기 실패");
//			view = request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		view.forward(request, response);
		
	}

}
