package com.iu.mall.options;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class OptionsDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="OptionsMapper.";
	
	//썸네일등록
	public int setWrite(OptionsVO optionsVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setWrite",optionsVO);
	}
}
