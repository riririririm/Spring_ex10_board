package com.iu.s10;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView getNull() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/error404");
		return mv;
	}
	@ExceptionHandler(SQLException.class)
	public void getSql() {
		
	}
	@ExceptionHandler(Exception.class)
	public void getExc() {
		
	}

}
