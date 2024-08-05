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
		
		private String ACCOUNT_LOGIN = "SELECT * FROM account WHERE username=?";
		private String ACCOUNT_REGISTER = "INSERT INTO account(username, password) VALUES(?,?)";
		
		// 회원가입
		public void getRegister(AccountDTO dto) {
			conn = JDBCUtil.getConnection();
			
			try {
				stmt = conn.prepareStatement(ACCOUNT_REGISTER);
				stmt.setString(1, dto.getUsername());
				stmt.setString(2, dto.getPassword());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}
		
		// 로그인
		public AccountDTO getLogin(String username, String password) {
			AccountDTO dto = null;
			
			conn = JDBCUtil.getConnection();
			try {
				stmt = conn.prepareStatement(ACCOUNT_LOGIN);
				stmt.setString(1, username);
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					dto = new AccountDTO(rs.getInt("num"), rs.getString("username"), rs.getString("password"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("아이디가 없습니다.");
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			
			return dto;
		}

}
