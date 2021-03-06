package board.free.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.free.model.service.FreeService;
import board.free.model.vo.FreeVo;
import common.PageInfo;

@WebServlet("/freeList.do")
public class FreeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		FreeService bs = new FreeService();
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
		int	listCount = bs.selectFreeTotalCount();
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
		
		//페이지 처리 후 게시글 조회
		List<FreeVo> list = bs.selectFreeList(currentPage, limit);
		
		String url = "";
		if(null != list){
			url = "views/board/free/freeList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
//			HttpSession session = request.getSession();
//			session.setAttribute("user", new MemberVo("won", "원"));
		}
//		}else{
//			url = "views/common/errorPage.jsp";
//			request.setAttribute("msg", "게시판 목록 조회 실패!!");
//		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
	}
}