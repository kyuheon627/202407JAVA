package du.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import du.db.BoardDto;
import du.db.MemberDao;
import du.db.MemberDto;
import du.service.BoardService;

/**
 * Servlet implementation class DuController
 */
@WebServlet("/")
public class DuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DuController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String view = null;

		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		System.out.println(uri);
		System.out.println(conPath);
		System.out.println(com);
		
		if (com.equals("/")) {
			view = "main.jsp";
			
		} else if (com.equals("/loginForm")) {
			view = "/sign-in/loginForm.jsp";
			
		} else if (com.equals("/login")) {
			request.setCharacterEncoding("utf-8");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(email + ", " + password);
			
			MemberDto memberDto = new MemberDto(0, "", email, password, "");
			MemberDao memberDao = new MemberDao();
			int login = memberDao.isMember(memberDto);
			System.out.println("login : " + login);
			
			if(login == 1) {
				System.out.println("로그인 성공!");
				memberDto = memberDao.findMember(memberDto);
				System.out.println(memberDto);			
				HttpSession session = request.getSession();			// 세션 객체 가져오기
				session.setAttribute("customInfo", memberDto);		// 세션에 값 담기
				request.setAttribute("userLoggedIn", true);
			} else {
				System.out.println("로그인 실패!");
			}
			view = "main.jsp";
			
		} else if (com.equals("/logout")) {
			HttpSession session = request.getSession();	
			session.invalidate();
			view = "main.jsp";
			
		} else if (com.equals("/signUpForm")) {
			view = "/sign-in/signUpForm.jsp";
			
		} else if (com.equals("/signUp")) {
			request.setCharacterEncoding("utf-8");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			System.out.println("email : " + email);
			System.out.println("password : " + password);
			System.out.println("name : " + name);
			
			MemberDto memberDto = new MemberDto(0, name, email, password, "");
			MemberDao memberDao = new MemberDao();
			memberDao.insertMember(memberDto);
			
			System.out.println("회원가입 성공!");
			
			view = "main.jsp";
			
		} else if (com.equals("/editForm")) {
			view = "/sign-in/editForm.jsp";
			
		} else if (com.equals("/edit")) {
			request.setCharacterEncoding("utf-8");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String member_id = request.getParameter("member_id");
			System.out.println("email : " + email);
			System.out.println("password : " + password);
			System.out.println("name : " + name);
			System.out.println("member_id : " + member_id);
			int id = Integer.parseInt(member_id);
			MemberDto memberDto = new MemberDto(id, name, email, password, "");
			MemberDao memberDao = new MemberDao();
			memberDao.updateMember(memberDto);
			
			System.out.println("회원정보수정 성공!");
			
			view = "main.jsp";
			
		}  else if (com.equals("/deleteMember")){
            int member_id = Integer.parseInt(request.getParameter("member_id"));

            MemberDto memberDto = new MemberDto(member_id, "", "", "", "");
			MemberDao memberDao = new MemberDao();
			memberDao.deleteMember(memberDto);
			HttpSession session = request.getSession();	
			session.invalidate();
            view = "main.jsp";
            
        }  else if (com.equals("/list")) {
            String tmp = request.getParameter("page");
            int pageNo = (tmp != null && tmp.length() > 0)
                    ? Integer.parseInt(tmp) : 1;

            request.setAttribute("msgList",
                    new BoardService().getMsgList(pageNo));
            request.setAttribute("pgnList",
                    new BoardService().getPagination(pageNo));
            System.out.println(new BoardService().getPagination(pageNo));
            view = "list.jsp";

        } else if (com.equals("/view")){
            int num = Integer.parseInt(request.getParameter("num"));

            request.setAttribute("msg", new BoardService().getMsg(num));
            view = "view.jsp";

        } else if (com.equals("/write")){
            String tmp = request.getParameter("num");
            int num = (tmp != null && tmp.length() > 0)
                    ? Integer.parseInt(tmp) : 0;

            BoardDto dto = new BoardDto();
            String action = "insert";

            if (num > 0) {
                dto = new BoardService().getMsgForWrite(num);
                action = "update?num=" + num;
            }

            request.setAttribute("msg", dto);
            request.setAttribute("action", action);
            view = "write.jsp";

        } else if (com.equals("/insert")){
            request.setCharacterEncoding("utf-8");
            String writer  = request.getParameter("writer" );
            String title   = request.getParameter("title"  );
            String content = request.getParameter("content");

            try {
                new BoardService().writeMsg(writer, title, content);
                view = "redirect:list";

            } catch(Exception e) {
                request.setAttribute("errorMessage", e.getMessage());
                view = "errorBack.jsp";
            }

        } else if (com.equals("/update")){
            request.setCharacterEncoding("utf-8");
            int num = Integer.parseInt(request.getParameter("num"));
            String writer  = request.getParameter("writer" );
            String title   = request.getParameter("title"  );
            String content = request.getParameter("content");

            try {
                new BoardService().updateMsg(writer, title, content, num);
                view = "redirect:list";

            } catch(Exception e) {
                request.setAttribute("errorMessage", e.getMessage());
                view = "errorBack.jsp";
            }

        } else if (com.equals("/delete")){
            int num = Integer.parseInt(request.getParameter("num"));

            new BoardService().deleteMsg(num);
            view = "redirect:list";
            
        } else if (com.equals("/back")) {
        	view = "errorBack.jsp";
        }

		// view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
