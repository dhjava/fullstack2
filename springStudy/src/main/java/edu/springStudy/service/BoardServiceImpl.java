package edu.springStudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springStudy.dao.BoardDAO;
import edu.springStudy.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> list() {
		
		//�Խñ� ��� db���� ��������
		/* BoardDAO boardDAO = new BoardDAO(); */
		
		return boardDAO.list();
	}

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

	@Override
	public int insert(BoardVO vo) {
		return boardDAO.insert(vo);
	}

}
