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
	
	// 로그인
			public AccountDTO getLogin(String id, String pw) {
				AccountDTO dto = null;
				
				conn = JDBCUtil.getConnection();
				try {
					stmt = conn.prepareStatement(ACCOUNT_LOGIN);
					stmt.setString(1, id);
					rs = stmt.executeQuery();
					
					if (rs.next()) {
						dto = new AccountDTO(rs.getString("id"), rs.getString("pw"), rs.getString("name"));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("아이디가 없습니다.");
				} finally {
					JDBCUtil.close(rs, stmt, conn);
				}
				
				return dto;
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
