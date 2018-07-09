package board.free.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.free.model.service.FreeService;
import board.free.model.vo.FreeReplyVo;
import board.free.model.vo.FreeVo;

@WebServlet("/updateFreeForm.do")
public class UpdateFreeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateFreeFormServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//게시글에 대한 정보 조회
		FreeVo board = new FreeService().selectFree(boardNo);
		//댓글에 대한 정보 조회
		String url = "";
		if(null != board){
			url = "views/board/free/freeUpdateForm.jsp";
			request.setAttribute("board", board);
			request.setAttribute("currentPage", currentPage);
		}else{
			url = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세조회에 실패하였습니다.");
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
	}
}







