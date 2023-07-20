package edu.springStudy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.springStudy.vo.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public UserVO selectUserByLogin(UserVO vo) {
		return sqlSession.selectOne("edu.springStudy.mapper.userMapper.selectUserByLogin", vo);
	}
	
}
