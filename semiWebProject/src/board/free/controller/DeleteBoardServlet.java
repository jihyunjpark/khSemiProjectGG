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

@WebServlet("/deleteBoardFree.do")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		int result  = new FreeService().deleteBoard(boardNo);
		
		response.setContentType("application/json; charset=UTF-8"); 
		response.getWriter().print(result);
	}
}
