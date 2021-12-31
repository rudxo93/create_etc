package com.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.domain.BoardVO;
import com.spring.board.domain.Page;
import com.spring.board.domain.ReplyVO;
import com.spring.board.service.BoardService;
import com.spring.board.service.ReplyService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;

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
		
		// 댓글 조회
		List<ReplyVO> reply = null;
		reply = replyService.list(bno);
		model.addAttribute("reply", reply);
	}
	
	//게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
		
		BoardVO boardVO = boardService.view(bno);
		
		model.addAttribute("view", boardVO);
	}
	
	//게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO boardVO) throws Exception {
			
		boardService.modify(boardVO);
			
		return "redirect:/board/view?bno=" + boardVO.getBno();
	}
	
	// 게시글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno) throws Exception {
		
		boardService.delete(bno);
		
		return "redirect:/board/list";
	}
	
	// 게시글 목록 + 페이징 추가
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception {
		
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(boardService.count());
				
		List<BoardVO> list = null;
		list = boardService.listPage(page.getDisplayPost(), page.getPostNum());
		model.addAttribute("list", list);
		model.addAttribute("page", page);		
		//현재 페이지
		model.addAttribute("select", num);
	}
	
	// 게시글 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/listPageSearch", method = RequestMethod.GET)
	public void getListPageSearch(Model model, @RequestParam("num") int num,
													@RequestParam(value = "searchType" ,required = false, defaultValue = "title") String searchType,
													@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword ) throws Exception {
		
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(boardService.searchCount(searchType, keyword));
		// 검색 타입과 검색어
		page.setSearchType(searchType);
		page.setKeyword(keyword);
				
		List<BoardVO> list = null;
		list = boardService.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);		
		//현재 페이지
		model.addAttribute("select", num);
		
	}
	
}
