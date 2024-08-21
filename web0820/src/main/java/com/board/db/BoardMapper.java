package com.board.db;

import org.apache.ibatis.annotations.Select;

public interface BoardMapper {
	@Select("select count(*) from board")
	int countBoard();
}
