package common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.show.controller.ShowListExtXml;
import board.show.model.vo.ShowVo2;

/**
 * Servlet implementation class ShowSearchServlet
 */
@WebServlet("/showSearch.do")
public class ShowSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowListExtXml slext = new ShowListExtXml();
		int page = Integer.parseInt(request.getParameter("page"));
		String word = request.getParameter("word");
		List<ShowVo2> list = slext.getSearchShow(page, word);
		
			String url = "/swp/views/common/showSearch.jsp?page=" + 
					request.getRequestDispatcher(url);
			
		
		
		
		
		
		
	}

}
