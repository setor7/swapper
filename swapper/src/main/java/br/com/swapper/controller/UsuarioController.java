package br.com.swapper.controller;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Transactional
@RequestMapping("usuario")
public class UsuarioController 
{
	@RequestMapping("/index")
	public String index()
	{
		return "index";
	}
}
