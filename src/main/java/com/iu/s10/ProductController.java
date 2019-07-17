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
import com.iu.util.PageMaker;

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

	@RequestMapping(value = "productSelect", method=RequestMethod.GET)
	public ModelAndView productSelect(ProductVO productVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		productVO = productService.getSelect(productVO);
		if(mv!=null) {
			mv.addObject("product",productVO);
			mv.addObject("mall/productSelect");			
		}else {
			mv.addObject("message", "no product.");
			mv.addObject("path","./productList");
			mv.setViewName("common/messageMove");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "productList", method=RequestMethod.GET)
	public ModelAndView productList(PageMaker pageMaker) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ProductVO> list = productService.getList(pageMaker);
		mv.addObject("productList", list);
		mv.addObject("pager", pageMaker);
		
		return mv;
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
