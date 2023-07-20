package edu.springStudy.service;

import java.util.List;

import edu.springStudy.vo.BoardVO;

public interface BoardService {
	List<BoardVO> list();
	BoardVO selectOneByBidx(int bidx);
	int update(BoardVO vo);
	int delete(int bidx);
	int insert(BoardVO vo);
}
