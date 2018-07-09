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

@WebServlet("/updateFree.do")
public class UpdateFreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateFreeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userId = request.getParameter("userid");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		FreeVo free = new FreeVo();
		free.setMember_id(userId);
		free.setBoard_content(content);
		free.setTitle(title);
		free.setBoard_no(bno);
		
		//비지니스 호출
		int result = new FreeService().updateFree(free);
		
		if(0 < result){
			response.sendRedirect("/swp/freeSub.do?bno=" + bno + "&currentPage=1");
		}else{
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "게시글 작성에 실패하였습니다.");
			view.forward(request, response);
		}
		
		
	}

}
