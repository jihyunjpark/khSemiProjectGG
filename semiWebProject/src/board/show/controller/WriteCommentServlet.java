package board.show.controller;

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
import board.show.model.service.ShowService;
import report.review.model.vo.ReportVo;
import report.review.model.vo.ReportVo2;

/**
 * Servlet implementation class WriteCommentServlet
 */
@WebServlet("/writeShowComment.do")
public class WriteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteCommentServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송 값에 대한 한글 처리
		request.setCharacterEncoding("utf-8");
		//전송 값 변수에 저장
		String bno = request.getParameter("bno");
		String userId = request.getParameter("userId");
		String content = request.getParameter("comment");
		
		ReportVo2 reply =  new ReportVo2();
		reply.setShowCode(bno);
		reply.setWriter(userId);
		reply.setContent(content);
		
		System.out.println(bno);
		System.out.println(userId);
		System.out.println(content);
		//비지니스 로직 호출
		ArrayList<ReportVo2> list = new ShowService().insertComment(reply);
		
		response.setContentType("application/json; charset=UTF-8"); 
		new Gson().toJson(list, response.getWriter());
	}
}













