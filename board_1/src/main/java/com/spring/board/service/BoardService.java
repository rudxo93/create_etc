package com.spring.board.service;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> list() throws Exception; // 게시글 목록
	
}
