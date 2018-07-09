package report.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import report.board.model.service.BoardService;
import report.board.model.vo.BoardVo;

@WebServlet("/selectBoard_r.do")
public class SelectBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectBoardServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//게시글에 대한 정보 조회
		BoardVo board = new BoardService().selectBoard(boardNo);
		//댓글에 대한 정보 조회

		String url = "";
		if(null != board){
			url = "views/board/boardDetail.jsp";
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







