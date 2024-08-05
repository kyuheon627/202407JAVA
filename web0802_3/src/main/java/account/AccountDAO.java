package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;

public class AccountDAO {

	// JDBC 관련 변수 
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String ACCOUNT_REGISTER = "INSERT INTO member(id, pw, name) VALUES(?,?,?)";
	private String ACCOUNT_CHECK = "select count(*) from member where id= ? ";
			
	// 회원가입
	public void getRegister(AccountDTO dto) {
		conn = JDBCUtil.getConnection();
				
		try {
			stmt = conn.prepareStatement(ACCOUNT_REGISTER);
			stmt.setString(1, dto.getId());
			stmt.setString(2, dto.getPw());
			stmt.setString(3, dto.getName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 회원가입시 아이디 중복 확인
	public int checkRegister(AccountDTO dto) {
		conn = JDBCUtil.getConnection();
		int count = 0;
		
		try {
			stmt = conn.prepareStatement(ACCOUNT_CHECK);
			stmt.setString(1, dto.getId());
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return count;
	}
	
}
