package report.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import report.review.model.service.ReportService;
import report.review.model.vo.ReportVo;
import common.PageInfo;


@WebServlet("/reportList.do")
public class ReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReportListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReportService bs = new ReportService();
		//페이징 처리 변수
		int currentPage;	//현재 페이지의 번호
		int limitPage;		//한페이지에 출력할 페이지 갯수
		//1~10
		int maxPage;		//가장 마지막 페이지
		int startPage;		//시작 페이지 변수
		int endPage;		//마지막 페이지 변수
		int limit;				//한페이지에 출력할 글에 갯수
		
		limit = 10;
		limitPage = 10;
		
		if(request.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else{
			currentPage = 1;
		}
		
		//게시글의 총 갯수
		int listCount = bs.selectReportTotalCount();
		//134 -> 14
		maxPage = (int)((double)listCount / limit + 0.9);
		
		//현재 페이지 번호
		//12 - 10
		startPage = (int)(currentPage / limitPage * limitPage) + 1;
		
		//11~20  -> 134 -> 14
		endPage = startPage + limitPage - 1;
		if(maxPage < endPage){
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, limitPage, maxPage,
																startPage, endPage, listCount);
		//==================페이징 처리의 끝===============
		//비지니스 로직 호출
//		BoardService bs = new BoardService();
		//기존 목록 조회 
		//ArrayList<BoardVo> list = bs.selectBoardList();
		
		//페이지 처리 후 게시글 조회
		ArrayList<ReportVo> list = bs.selectReportListPage(currentPage, limit);
		
		String url = "";
		if(null != list){
			url = "views/report/reportList_review.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		}else{
			url = "views/common/errorPage.jsp";
			request.setAttribute("msg", "조회 실패!!");
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
	}

}
