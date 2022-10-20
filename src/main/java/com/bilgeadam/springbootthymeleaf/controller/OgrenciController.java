package com.bilgeadam.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.springbootthymeleaf.model.Ogrenci;
import com.bilgeadam.springbootthymeleaf.service.OgrenciService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(path =
{ "ogrenci", "ogrenci.html" })
public class OgrenciController
{
	private OgrenciService ogrenciService;

	@GetMapping(path = "")
	public ModelAndView getAll()
	{
		// ogrenci.html sayfası
		ModelAndView ogrenciView = new ModelAndView("ogrenci");
		ogrenciView.addObject("liste", ogrenciService.getAll());
		return ogrenciView;
	}

	@GetMapping(path = "ekle")
	public ModelAndView kaydet()
	{
		ModelAndView ogrenciView = new ModelAndView("ogrenci_ekle");
		ogrenciView.addObject("ogrenci", new Ogrenci());
		return ogrenciView;
	}

	@PostMapping(path = "ekle")
	public ModelAndView kaydetPost(Ogrenci ogrenci)
	{
		ogrenciService.save(ogrenci);
		// bu yanlış
		// return new ModelAndView("ogrenci");
		return new ModelAndView("redirect:/ogrenci");
	}
}