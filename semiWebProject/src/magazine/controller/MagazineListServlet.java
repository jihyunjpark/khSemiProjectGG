package magazine.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import magazine.model.service.MagazineService;
import magazine.model.vo.AttachmentVo;

@WebServlet("/magazineList.do")
public class MagazineListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MagazineListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AttachmentVo> list = new MagazineService().selectMagazineList();
		String url = "";
		if(list != null){
			url = "views/magazine/magazineList.jsp";
			request.setAttribute("list", list);
//		}else{
//			url = "views/common/errorPage.jsp";
//			request.setAttribute("msg", "매거진 불러오기 실패");
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
		
	}

}
