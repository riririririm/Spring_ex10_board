package com.iu.s10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;
import com.iu.util.PageMaker;


@Controller
@RequestMapping("/member/")
public class MemberController {

	@Inject
	private MemberService memberService;


	// memberAdmin //delete
	@RequestMapping(value = "memberAdmin", method = RequestMethod.POST)
	public String memberDelete(String[] id) throws Exception {
		int result = memberService.setDelete(id);


		return "redirect:./memberAdmin";
	}

	// memberAdmin
	@RequestMapping(value = "memberAdmin", method = RequestMethod.GET)
	public ModelAndView memberAdmin(PageMaker pageMaker) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<MemberDTO> list = memberService.getList(pageMaker);

		mv.addObject("list", list);
		mv.setViewName("member/memberAdmin");

		return mv;
	}

	// memberPage
	@RequestMapping(value = "memberPage")
	public void memberPage() throws Exception {
	}

	// logout
	@RequestMapping(value = "memberLogout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}

	// 회원가입 처리
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public ModelAndView setWrite(@Valid MemberDTO memberDTO,BindingResult bindingResult, MultipartFile photo, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("controller");
		//검증
		//memberValidate.validate(memberDTO, bindingResult);
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("member/memberJoin");
		}else {			
			int result = memberService.setWrite(memberDTO, photo, session);
			String message = "Join Fail";
			if (result > 0) {
				message = "Join Success";
			}
			
			mv.setViewName("common/messageMove");
			mv.addObject("message", message);
			mv.addObject("path", "../");
		}

		return mv;
	}

	// 회원가입
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void setWrite(@ModelAttribute MemberDTO memberDTO) throws Exception {
	}

	// 로그인
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public void getSelect() throws Exception {
	}

	// 로그인 처리
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView getSelect(MemberDTO memberDTO, HttpSession session) throws Exception {
		memberDTO = memberService.getSelect(memberDTO);
		String message = "Login Fail";
		if (memberDTO != null) {
			session.setAttribute("member", memberDTO);
			message = "Login Success";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/messageMove");
		mv.addObject("message", message);
		mv.addObject("path", "../");
		return mv;
	}

}
