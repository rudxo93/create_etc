package com.spring.board.dao;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardDao {

	public List<BoardVO> list() throws Exception; // 게시글 목록
	public void write(BoardVO boardVO) throws Exception;// 게시글 작성
	public BoardVO view(int bno) throws Exception; // 게시글 조회
	public void modify(BoardVO boardVO) throws Exception; // 게시글 수정
	
}
