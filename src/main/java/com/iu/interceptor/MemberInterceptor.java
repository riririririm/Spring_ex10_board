package com.iu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.member.MemberDTO;


public class MemberInterceptor extends HandlerInterceptorAdapter {

	//컨트롤러 진입 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		MemberDTO member = (MemberDTO)obj;
		boolean result=false;
		if(obj != null && member.getId().equals("admin")) {
			result=true;
		}else {
			response.sendRedirect("../member/memberLogin");
		}
		
		//return이 true면 다음 컨트롤러로 진행
		//return이 false면 컨트롤러 진입 안됌.
		return result;
	}

	

}
