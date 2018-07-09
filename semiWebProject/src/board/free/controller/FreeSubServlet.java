package board.free.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.free.model.service.FreeService;
import board.free.model.vo.FreeVo;

@WebServlet("/freeSub.do")
public class FreeSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeSubServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//게시글에 대한 정보 조회
		FreeVo board = new FreeService().selectFree(boardNo);
		//댓글에 대한 정보 조회
		//ArrayList<CommentVo> cList = new CommentService().selectCommentList(boardNo);
		//board.setCount(board.getCount() + 1);

		String url = "";
		if(null != board){
			url = "views/board/free/freeDetail.jsp";
			request.setAttribute("board", board);
			//request.setAttribute("cList", cList);
			request.setAttribute("currentPage", currentPage);
		}else{
			url = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세조회에 실패하였습니다.");
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
	}
}







