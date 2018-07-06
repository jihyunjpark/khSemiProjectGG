package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.MemberVo;

@WebServlet("/join.au")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JoinServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송 값에 한글이 있을 경우
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String nickname = request.getParameter("nickname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String genre = String.join(", ", request.getParameterValues("genre"));
		
		MemberVo member = new MemberVo(id, pwd, nickname, gender.charAt(0),
																		email, genre);
		
		//서비스(비지니스 로직) 호출
		MemberService ms = new MemberService();
		RequestDispatcher view = null;
		//아이디 중복 체크 확인
		if(ms.getMemberId(id) != null){
			//아이디 중복
			request.setAttribute("msg", "회원 가입 중 아이디가 중복 되었습니다.");
			view 
				= request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			return;
		} 
		
		int result = ms.joinMember(member);
		if(0 < result){
			System.out.println("회원가입 완료!!");
			response.sendRedirect("index.jsp");
		}else{
			System.out.println("회원가입 실패!!");
			request.setAttribute("msg", "회원 가입 중 에러가 발생하였습니다.");
			view 
				= request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}
}



















