package com.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.domain.BoardVO;
import com.spring.board.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	// 게시글 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		
		List<BoardVO> list  = null;
		list = boardService.list();
		
		model.addAttribute("list", list);
		
	}
	
	// 게시글 작성 get
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite() throws Exception {
		
	}
	
	// 게시글 작성 post
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePost(BoardVO boardVO) throws Exception {
		
		boardService.write(boardVO);
		
		return "redirect:/board/list";
	}
	
	// 게시글 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
		
		BoardVO boardVO = boardService.view(bno);
		
		model.addAttribute("view", boardVO);
	}
}
