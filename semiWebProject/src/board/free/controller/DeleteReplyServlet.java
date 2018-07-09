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
@WebServlet("/deleteReply.do")
public class DeleteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int boardNo = Integer.parseInt(request.getParameter("bNo"));
		
		FreeReplyVo reply = new FreeReplyVo();
		reply.setReply_no(replyNo);
		reply.setBoard_no(boardNo);
		
		//비지니스 로직 호출
		ArrayList<FreeReplyVo> list = new FreeService().deleteComment(reply);
		
		response.setContentType("application/json; charset=UTF-8"); 
		new Gson().toJson(list, response.getWriter());
	}
}
