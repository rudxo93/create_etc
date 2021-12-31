package com.spring.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.board.domain.ReplyVO;
import com.spring.board.service.ReplyService;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	// 댓글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWirte(ReplyVO replyvo) throws Exception {
				
		replyService.write(replyvo);
				
		return "redirect:/board/view?bno=" + replyvo.getBno();
	}

}
