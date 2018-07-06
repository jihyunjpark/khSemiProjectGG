package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.MemberVo;

@WebServlet("/updateMember.au")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMemberServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송 값에 한글이 있는 경우 인코딩 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//2. 전송 값 변수에 저장
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String nickname = request.getParameter("nickname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String genre = String.join(", ", request.getParameterValues("genre"));
		
		MemberVo member = new MemberVo(id, pwd, nickname, gender.charAt(0),
																		 email, genre);
		//3. 비지니스 로직 호출
		MemberService ms = new MemberService();
		int result = ms.setMemberInfo(member);
		//4. 해당 결과에 따른 return 페이지 설정
		if(0 < result){
			//현재 member 정보 session 값 수정
			HttpSession session = request.getSession();
			session.setAttribute("user", member);
			//회원 정보 수정 -> 인덱스
			response.sendRedirect("index.jsp");
		}else{
			//에러 페이지 -> "회원 정보 수정 시 오류 발생"
			RequestDispatcher view 
					= request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "회원 정보 수정 시 오류 발생!!");
			view.forward(request, response);
		}
	}
}






