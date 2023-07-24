package edu.springStudy.service;

import edu.springStudy.vo.UserVO;

public interface UserService {
	
	UserVO selectUserByLogin(UserVO vo);
	int selectCntById(String id);
	int insert(UserVO vo);
}
