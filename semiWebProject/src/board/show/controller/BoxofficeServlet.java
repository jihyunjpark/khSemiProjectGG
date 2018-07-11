package board.show.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.show.controller.BoxofficeListExtXml;
import board.show.model.vo.BoxofficeShowVo;

/**
 * Servlet implementation class TestAjaxServlet
 */
@WebServlet("/boxofficeAjax.do")
public class BoxofficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoxofficeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoxofficeListExtXml boxExt = new BoxofficeListExtXml();
		String category = request.getParameter("category");
		String type = request.getParameter("type");
		if(category.equals("CCCA")) {
			category = "CCCA|CCCB";
		} else if(category.equals("BBBA")) {
			category = "BBBA|BBBB";
		} else if(category.equals("CCCC")) {
			category = "CCCC|EEEA";
		}
		System.out.println("category parameter: " + category);
		System.out.println("type parameter: " + type);
		List<BoxofficeShowVo> list = boxExt.getXmlDataSAX(category, type);
		
		response.setContentType("application/json; charset=UTF-8"); 
		new Gson().toJson(list, response.getWriter());
		
	}

}
