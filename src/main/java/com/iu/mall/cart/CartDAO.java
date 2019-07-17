package com.iu.mall.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="CartMapper.";
	
	/*
	public int setDelete(int checkbox) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", checkbox);
	}*/
	public int setDelete(Integer [] checkArr)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", checkArr);
	}
	
	
	public int setUpdate(CartVO cartVO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", cartVO);
	}
	
	public int setWrite(CartVO cartVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setWrite", cartVO);
	}
	
	public List<CartListVO> getList(String id) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", id);
	}
}
