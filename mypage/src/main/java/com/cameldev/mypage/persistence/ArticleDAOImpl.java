package com.cameldev.mypage.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cameldev.mypage.domain.ArticleVO;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	private static final String NAME_SPACE = "com.cameldev.mypage.mappers.article.articleMapper";
	
	private final SqlSession session;
	
	@Inject
	public ArticleDAOImpl(SqlSession session) {
		this.session = session;
	}

	@Override
	public void create(ArticleVO articleVO) throws Exception {
		session.insert(NAME_SPACE + ".create", articleVO);
	}

	@Override
	public ArticleVO read(Integer article_no) throws Exception {
		return session.selectOne(NAME_SPACE + ".read", article_no);
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
		session.update(NAME_SPACE + ".update", articleVO);
	}

	@Override
	public void delete(Integer article_no) throws Exception {
		session.delete(NAME_SPACE + ".delete", article_no);
	}

	@Override
	public List<ArticleVO> listAll() throws Exception {
		return session.selectList(NAME_SPACE + ".listAll");
	}
	
}
