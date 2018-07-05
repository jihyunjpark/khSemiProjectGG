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

/**
 * Servlet implementation class ShowSubServlet
 */
@WebServlet("/showSub.do")
public class ShowSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int showCode = Integer.parseInt(request.getParameter("showCode"));
		
		ShowService ss = new ShowService();
		ShowVo show = ss.selectShow(showCode);
		
		if(show != null){
			RequestDispatcher view = request.getRequestDispatcher("views/board/show/showSub.jsp");
			request.setAttribute("show", show);
			view.forward(request, response);
		}
	}

}








