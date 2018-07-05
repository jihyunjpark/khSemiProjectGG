package board.show.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.show.model.service.ShowService;
import board.show.model.vo.ShowVo;

@WebServlet("/showList.do")
public class ShowListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShowService ss = new ShowService();
		
		List<ShowVo> list = ss.selectShowList();
		
		if(list != null){
			RequestDispatcher view = request.getRequestDispatcher("views/board/show/showMain.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		}
	}
}
