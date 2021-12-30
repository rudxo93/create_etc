package com.spring.board.service;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> list() throws Exception; // 게시글 목록
	public void write(BoardVO boardVO) throws Exception;// 게시글 작성
	public BoardVO view(int bno) throws Exception; // 게시글 조회
	public void modify(BoardVO boardVO) throws Exception; // 게시글 수정
	public void delete(int bno) throws Exception; // 게시글 삭제
	public int count() throws Exception; // 게시글 총 갯수
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception; // 게시글 목록 + 페이징
	
}
