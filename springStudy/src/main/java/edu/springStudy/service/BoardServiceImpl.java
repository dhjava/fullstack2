package edu.springStudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springStudy.dao.BoardDAO;
import edu.springStudy.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	// BoardService의 구현 클래스
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> list() {
		
		// 게시글 목록 db에서 가져오기
		
		return boardDAO.list();
	}
	
	// DB에서 쿼리 호출
	@Override
	public BoardVO selectOneByBidx(int bidx) {
		// TODO Auto-generated method stub
		return boardDAO.selectOneByBidx(bidx);
	}

	@Override
	public int update(BoardVO vo) {
		return boardDAO.update(vo);
	}

	@Override
	public int delete(int bidx) {
		return boardDAO.delete(bidx);
	}
	
	
}
