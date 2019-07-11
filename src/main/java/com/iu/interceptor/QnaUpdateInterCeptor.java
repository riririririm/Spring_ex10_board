package com.iu.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.board.BoardDTO;
import com.iu.board.qna.QnaDTO;
import com.iu.member.MemberDTO;

public class QnaUpdateInterCeptor extends HandlerInterceptorAdapter {

	// 컨트롤러 진입 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String method = request.getMethod();

		if (method.equals("GET")) {
			HttpSession session = request.getSession();
			MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
			Map<String, Object> map = modelAndView.getModel();
			BoardDTO m = (BoardDTO) map.get("dto");

			if (!m.getWriter().equals(memberDTO.getId())) {
				modelAndView.setViewName("common/messageMove");
				modelAndView.addObject("message", "사용자와 작성자가 다름");
				modelAndView.addObject("path", "./" + map.get("board") + "List");
				map.remove("dto");
			}
		}

	}

}
