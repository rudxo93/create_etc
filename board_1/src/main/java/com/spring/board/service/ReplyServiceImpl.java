package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.ReplyDao;
import com.spring.board.domain.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao replyDao;
	
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		return replyDao.list(bno);
	}
	
	@Override
	public void write(ReplyVO replyVO) throws Exception {
		replyDao.write(replyVO);
	}
	
	@Override
	public void modify(ReplyVO replyVO) throws Exception {
		replyDao.modify(replyVO);
	}
	
	@Override
	public void delete(ReplyVO replyVO) throws Exception {
		replyDao.delete(replyVO);
	}

}
