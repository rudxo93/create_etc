package com.spring.board.dao;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardDao {

	public List<BoardVO> list() throws Exception; // 게시글 목록
	
}
