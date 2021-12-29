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
	
}
