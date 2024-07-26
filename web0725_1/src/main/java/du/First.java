package du;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public First() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String strName = request.getParameter("name");
		String strSsn = request.getParameter("ssn");
		
		response.setContentType("text/html;charset=utf8");

		PrintWriter out = response.getWriter();

		if(strSsn.equals(LoginSession.ssn)) {
			LoginSession.name = strName;
			out.println("<html>");
			out.println("<h1>나온다</h1>");
			out.println("<h1>" + LoginSession.name + "님 환영합니다</h1>");
			out.println("</html>");
		}else {
			out.println("<h1>정보가 틀립니다.</h1>");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
