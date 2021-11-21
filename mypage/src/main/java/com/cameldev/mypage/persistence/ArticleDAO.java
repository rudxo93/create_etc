package com.cameldev.mypage.persistence;

import java.util.List;

import com.cameldev.mypage.commons.paging.Criteria;
import com.cameldev.mypage.commons.paging.SearchCriteria;
import com.cameldev.mypage.domain.ArticleVO;

public interface ArticleDAO {
	
	//게시글 생성 - 등록
	void create(ArticleVO articleVO) throws Exception;
	
	// 게시글 자세히 읽기
	ArticleVO read(Integer article_no) throws Exception;
	
	// 게시글 수정
	void update(ArticleVO articleVO) throws Exception;
	
	// 게시글 삭제
	void delete(Integer article_no) throws Exception;
	
	// 게시글 전체 목록 보기
	List<ArticleVO> listAll() throws Exception;
	
	//페이징 처리
	List<ArticleVO> listPaging(int page) throws Exception;

	List<ArticleVO> listCriteria(Criteria criteria) throws Exception;
	
	int countArticles(Criteria criteria) throws Exception;

	List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception;
	
	int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;

	
}
