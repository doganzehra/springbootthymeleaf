package com.bilgeadam.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path =
{ "index", "index.html" })
public class IndexController
{
//	@GetMapping
//	public String index()
//	{
//		return "index";
//	}

	@GetMapping
	public ModelAndView index()
	{
		ModelAndView indexView = new ModelAndView("index");
		// değişken
		indexView.addObject("username", "hasan");
		return indexView;
	}
}
