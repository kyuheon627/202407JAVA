package com.board.db;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class AccountDao {

	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public AccountDao() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}

	public AccountDto selectAccount(String id, String pwd) {
		
		System.out.println("AccountDao의 id : " + id);
		System.out.println("AccountDao의 pwd : " + pwd);
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		System.out.println("map : " + map);
		
		AccountDto dto = session.selectOne("BoardMapper.selectAccount", map);
		
		System.out.println("dto : " + dto);
		return dto;
	}

}
