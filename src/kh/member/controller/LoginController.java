package kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("login Post");
		// login.jsp 데이터 가ㅕ오기?
		MemberVo vo = new MemberVo();
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
//		String id = request.getParameter("id");
//		String passwd = request.getParameter("passwd");
//	 
		//2.데이터를 Vo에 채워서 이동해준다(DB 다녀오기)
		
		MemberVo result = new MemberService().login(vo);
		if(result != null) {
			System.out.println("login sucess!!");
			request.getSession().setAttribute("lgnss", result);
		}else {
			System.out.println("login faile!!");
		
		}

		//3. 페이지이동 및 데이터 전달(셋 중 하나로 무조건 메소드 끝내야함. 무조건 있어야 한다)
		//3-1 response.sendRedirect(request.getContextPath()+"url");
		//3-3 request.getAttribute("name1", "값");
		//3-2 request.getRequestDispatcher("xxx.jsp").forward(request, response); 페이지없이 데이터만이동
		//out.println("값"); out.flush(); out.close();
		response.sendRedirect(request.getContextPath()+"/");

	}
	

}
