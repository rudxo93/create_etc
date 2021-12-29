package com.spring.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession session;
	
	private static final String NAME_SPACE = "com.spring.board.dao.BoardDao.";
	
	@Override
	public List<BoardVO> list() throws Exception {
		return session.selectList(NAME_SPACE + "list");
	}
	
	@Override
	public void write(BoardVO boardVO) throws Exception {
		session.insert(NAME_SPACE + "write", boardVO);
	}
	
	@Override
	public BoardVO view(int bno) throws Exception {
		return session.selectOne(NAME_SPACE + "view", bno);
	}
	
	@Override
	public void modify(BoardVO boardVO) throws Exception {
		session.update(NAME_SPACE + "modify", boardVO);
	}
	
}
