/**
 * 
 */
package com.baxter.idc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.baxter.idc.exception.SpringException;

/**
 * @author guptas9
 *
 */
@ControllerAdvice
class ExceptionControllerAdvice {
	
	@ExceptionHandler(SpringException.class)
	public ModelAndView handleException(SpringException ex, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errorId", ex.getErrCode());
        modelAndView.addObject("message", ex.getExceptionMsg()); 
        modelAndView.addObject("exceptionPrintStack", ex.getExceptionPrintStack()); 
        
	    modelAndView.setViewName("exception");
	    
		return modelAndView;
	}
}
