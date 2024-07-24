package du;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update.do")
public class JdbcUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JdbcUpdate() {
    	super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strDeptno = request.getParameter("deptno");
		String strDname = request.getParameter("dname");
		String strLoc = request.getParameter("loc");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>서블릿 페이지</h1>");
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO dept(deptno, dname, loc) VALUES(?, ?, ?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩!");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("Mysql 접속 성공!");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strDeptno));
			pstmt.setString(2, strDname);
			pstmt.setString(3, strLoc);
			int ret = pstmt.executeUpdate();
			String str = String.format(ret + "건 insert 완료");
			out.println(str);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
