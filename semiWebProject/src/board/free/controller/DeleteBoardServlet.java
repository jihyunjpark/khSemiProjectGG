package board.free.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.free.model.service.FreeService;
import board.free.model.vo.FreeReplyVo;

/**
 * Servlet implementation class DeleteReplyServlet
 */
@WebServlet("/deleteBoardFree.do")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		//비지니스 로직 호출
		int result  = new FreeService().deleteBoard(boardNo);
		
		response.setContentType("application/json; charset=UTF-8"); 
		response.getWriter().print(result);
	}
}
