package com.iu.s10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.mall.product.ProductService;
import com.iu.mall.product.ProductVO;

@Controller
@RequestMapping("/mall/")
public class ProductController {
	
	@Inject
	private ProductService productService;
	
	@ModelAttribute
	public ProductVO getProductVO() throws Exception {
		ProductVO productVO = new ProductVO();
		return productVO;
	}
	
	
	@RequestMapping(value = "productWrite", method = RequestMethod.POST)
	public void productWrite(ProductVO productVO, List<MultipartFile> f1, HttpSession session)throws Exception{
		productVO.setCategory("F");
		
		ModelAndView mv = new ModelAndView();
		
		int result = productService.setWrite(productVO, f1, session);
		String msg = "add fail";
		if(result>0) {
			msg="add success";
		}
		
		mv.addObject("message",msg);
		mv.addObject("path","../");
		mv.setViewName("common/messageMove");
		
	}
	
	
	@RequestMapping(value = "productWrite", method = RequestMethod.GET)
	public void productWrite()throws Exception{
		//ProductVO proVo = new ProductVO();
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("productVO", productVO);
		
	}
}
