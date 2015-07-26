package br.com.swapper.controller;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controladora responsável pelo gerenciamento das RNs da entidade Usuário
 * @author Bruno
 *
 */
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
