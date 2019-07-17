package com.iu.mall.cart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.iu.member.MemberDTO;

@Service
public class CartService {

	@Inject
	private CartDAO cartDAO;
	
	public int setDelete(Integer[] checkArr) throws Exception {
		/*
		int result=0;
		for(int i=0;i<checkboxs.length;i++) {
			result = cartDAO.setDelete(checkboxs[i]);
		}*/
		
		return cartDAO.setDelete(checkArr);
	}
	public int setUpdate(CartVO cartVO) throws Exception {
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		map.put("amount", amount);
//		map.put("num", num);
		
		return cartDAO.setUpdate(cartVO);
	}
	
	public int setWrite(CartVO cartVO) throws Exception {
		return cartDAO.setWrite(cartVO);
	}
	
	public List<CartListVO> getList(HttpSession session) throws Exception {
		String id= ((MemberDTO)session.getAttribute("member")).getId();
		
		return cartDAO.getList(id);
	}
}
