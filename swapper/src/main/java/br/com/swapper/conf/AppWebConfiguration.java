package br.com.swapper.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Classe de configurações gerais para a servlet do SpringMVC
 * @author Bruno Carneiro
 *
 */
@EnableWebMvc
@ComponentScan(basePackages={"br.com.swapper.controller"})
public class AppWebConfiguration 
{
	/**
	 * Método que configura prefixo e sufixo dos diretórios/arquivos, 
	 * concatenando-os à URL da requisição
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
}
