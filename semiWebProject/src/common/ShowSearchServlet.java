package common;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ShowListExtXml slext = new ShowListExtXml();
		String query = request.getParameter("query");
		System.out.println(query);
		int page = 1;
		String url = "";
		if(null != request.getParameter("page")) {
			page = Integer.parseInt(request.getParameter("page"));
			url = "/views/common/showSearch.jsp?&page=" + page + "&query=" + query;
		} else {
			url = "/views/common/showSearch.jsp?&query=" + query;
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		List<ShowVo2> list = slext.getSearchShow(page, query);
		request.setAttribute("result", list);
		view.forward(request, response);
		
		

	}

}
