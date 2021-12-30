package com.spring.board.dao;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardDao {

	public List<BoardVO> list() throws Exception; // 게시글 목록
	public void write(BoardVO boardVO) throws Exception;// 게시글 작성
	public BoardVO view(int bno) throws Exception; // 게시글 조회
	public void modify(BoardVO boardVO) throws Exception; // 게시글 수정
	public void delete(int bno) throws Exception; // 게시글 삭제
	public int count() throws Exception; // 게시글 총 갯수
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception; // 게시글 목록 + 페이징
	// 게시글 목록 + 페이징 + 검색
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;
	public int searchCount(String searchType, String keyword) throws Exception; // 게시글 총 갯수 + 검색 적용
	
}
