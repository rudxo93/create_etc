package com.spring.board.dao;

import java.util.List;

import com.spring.board.domain.ReplyVO;

public interface ReplyDao {

	public List<ReplyVO> list(int bno) throws Exception; // 댓글 조회
	public void write(ReplyVO replyVO) throws Exception; // 댓글 조회
	public void modify(ReplyVO replyVO) throws Exception; // 댓글 수정
	public void delete(ReplyVO replyVO) throws Exception; // 댓글 삭제
	
}
