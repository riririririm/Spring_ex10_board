package com.iu.mall.thumbnail;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ThumbnailDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="ThumbnailMapper.";
	
	//썸네일등록
	public int setWrite(ThumbnailVO thumbnailVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setWrite",thumbnailVO);
	}
}
