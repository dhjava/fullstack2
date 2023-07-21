package edu.springStudy.service;

import java.util.List;

import edu.springStudy.vo.BoardVO;
import edu.springStudy.vo.SearchVO;

public interface BoardService {
	List<BoardVO> list(SearchVO searchVO);
	BoardVO selectOneByBidx(int bidx);
	int update(BoardVO vo);
	int delete(int bidx);
	int insert(BoardVO vo);
}
