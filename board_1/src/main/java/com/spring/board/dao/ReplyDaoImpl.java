package com.spring.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.ReplyVO;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	
	@Autowired
	private SqlSession session;
	
	private static final String NAME_SPACE = "com.spring.board.dao.ReplyDao.";
	
	// 댓글 조회
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		return session.selectList(NAME_SPACE + "replyList", bno);
	}
	
	// 댓글 작성
	@Override
	public void write(ReplyVO replyVO) throws Exception {
		session.insert(NAME_SPACE + "replyWrite", replyVO);
	}
	
	// 댓글 수정
	@Override
	public void modify(ReplyVO replyVO) throws Exception {
		session.update(NAME_SPACE + "replyModify", replyVO);
	}
	
	// 댓글 삭제
	@Override
	public void delete(ReplyVO replyVO) throws Exception {
		session.delete(NAME_SPACE + "replyDelete", replyVO);
	}

}
