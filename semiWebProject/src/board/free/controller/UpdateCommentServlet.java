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
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet("/updateComment.do")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송 값에 대한 한글 처리
		request.setCharacterEncoding("utf-8");
		//전송 값 변수에 저장
		int bno = Integer.parseInt(request.getParameter("bno"));
		int cno = Integer.parseInt(request.getParameter("cno"));
		String content = request.getParameter("comment");
		
		FreeReplyVo reply =  new FreeReplyVo();
		reply.setBoard_no(bno);
		reply.setReply_content(content);
		reply.setReply_no(cno);
		
		
		//비지니스 로직 호출
		ArrayList<FreeReplyVo> list = new FreeService().updateComment(reply);
		
		response.setContentType("application/json; charset=UTF-8"); 
		new Gson().toJson(list, response.getWriter());
	}

}
