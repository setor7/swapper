package br.com.swapper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UsuarioController 
{
	@RequestMapping("/index")
	public String index()
	{
		return "index";
	}
}
