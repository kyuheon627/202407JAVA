package drive;

import java.util.List;

import dept.DeptDAO;
import dept.DeptDTO;

public class Ex2 {

	public static void main(String[] args) {

		DeptDAO dao = new DeptDAO();
		DeptDTO dto = new DeptDTO(50, "영업", "서울");
		dao.insertBoard(dto);

	}

}
