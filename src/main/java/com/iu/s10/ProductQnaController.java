package com.iu.s10;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.productQna.ProductQnaService;
import com.iu.board.productQna.ProductQnaVO;
import com.iu.mall.cart.CartListVO;
import com.iu.mall.cart.CartService;
import com.iu.mall.cart.CartVO;
import com.iu.util.PageMaker;

@RestController
@RequestMapping("/productQna/")

public class ProductQnaController {
	//service
	@Inject
	private ProductQnaService productQnaService;
	
	@RequestMapping(value = "productQnaList/{pid}", method = RequestMethod.GET)
	public List<ProductQnaVO> getList(PageMaker pageMaker, @PathVariable String pid)throws Exception{
		return productQnaService.getList(pageMaker, pid);
	}
	/*public String getList(PageMaker pageMaker, String pid)throws Exception{
		JSONArray ar = new JSONArray();
		List<ProductQnaVO> list = productQnaService.getList(pageMaker, pid);
		System.out.println(list.size());
		for(ProductQnaVO p:list) {
			JSONObject js = new JSONObject();
			js.put("writer", p.getWriter());
			js.put("contents", p.getContents());
			ar.add(js);
		}

		return ar.toJSONString();
	}*/
	
	@RequestMapping(value = "productQnaWrite", method = RequestMethod.POST)
	public int setWrite(ProductQnaVO productQnaVO)throws Exception{
		
		return productQnaService.setWrite(productQnaVO);
	}

	@RequestMapping(value = "productQnaSelect", method = RequestMethod.GET)
	public ProductQnaVO getSelect(int num)throws Exception{
		ProductQnaVO productQnaVO =productQnaService.getSelect(num);
		
		
		return productQnaVO;
	}
	/*public String getSelect(int num)throws Exception{
		ProductQnaVO productQnaVO =productQnaService.getSelect(num);
		JSONObject js = new JSONObject(); // { }
		js.put("writer", productQnaVO.getWriter());
		js.put("contents", productQnaVO.getContents());
		
		return js.toJSONString();
	}*/
}
