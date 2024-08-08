package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class DeptDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String DEPT_LIST = "SELECT * FROM dept";
	private String DEPT_INSERT = "insert into board(enptno, ename, loc) values(?,?,?)";
	
	//게시판 목록 조회
	public List<DeptDTO> getDeptList() {
		List<DeptDTO> list = new ArrayList<>();
			
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(DEPT_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				DeptDTO dto = new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return list;
	}
	
	//게시판 등록
		public void insertBoard(DeptDTO dto) {
			conn = JDBCUtil.getConnection();
			
			try {
				stmt = conn.prepareStatement(DEPT_INSERT);
				stmt.setInt(1, dto.getDeptno());
				stmt.setString(2, dto.getDname());
				stmt.setString(3, dto.getLoc());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}
	
}
