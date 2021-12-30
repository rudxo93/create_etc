package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.BoardDao;
import com.spring.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardVO> list() throws Exception {
		return boardDao.list();
	}
	
	@Override
	public void write(BoardVO boardVO) throws Exception {
		boardDao.write(boardVO);
	}
	
	@Override
	public BoardVO view(int bno) throws Exception {
		return boardDao.view(bno);
	}
	
	@Override
	public void modify(BoardVO boardVO) throws Exception {
		boardDao.modify(boardVO);
	}
	
	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}
	
	@Override
	public int count() throws Exception {
		return boardDao.count();
	}
	
	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
		return boardDao.listPage(displayPost, postNum);
	}
	
	@Override
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		return boardDao.listPageSearch(displayPost, postNum, searchType, keyword);
	}
	
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		return boardDao.searchCount(searchType, keyword);
	}
	
}
