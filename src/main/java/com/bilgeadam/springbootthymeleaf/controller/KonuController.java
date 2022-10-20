package com.bilgeadam.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.springbootthymeleaf.model.Konu;
import com.bilgeadam.springbootthymeleaf.service.KonuService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(path =
{ "konu", "konu.html" })
public class KonuController
{
	private KonuService konuService;

	@GetMapping(path = "")
	public ModelAndView getAll()
	{
		// konu.html sayfası
		ModelAndView konuView = new ModelAndView("konu");
		konuView.addObject("liste", konuService.getAll());
		return konuView;
	}

	@GetMapping(path = "ekle")
	public ModelAndView kaydet()
	{
		ModelAndView konuView = new ModelAndView("konu_ekle");
		konuView.addObject("konu", new Konu());
		return konuView;
	}

	@PostMapping(path = "ekle")
	public ModelAndView kaydetPost(Konu konu)
	{
		konuService.save(konu);
		// bu yanlış
		// return new ModelAndView("konu");
		return new ModelAndView("redirect:/konu");
	}
}