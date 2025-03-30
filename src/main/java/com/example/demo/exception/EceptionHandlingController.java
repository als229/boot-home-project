package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class EceptionHandlingController {

	private ModelAndView createErrorResponse(String errorMsg, Exception e) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("message", errorMsg).setViewName("include/error_page");
		System.out.printf("발생 예외 : %s %s", errorMsg, e);
		return mv;
	}
	
	@ExceptionHandler(NullCheckException.class)
	protected ModelAndView runTimeError(NullCheckException e) {
		return createErrorResponse(e.getMessage(), e);
	}
	
}
