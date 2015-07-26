package br.com.swapper.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Classe que configura programaticamente a servlet do Spring para
 * atender as requisições do cliente (browser)
 * @author Bruno Carneiro
 *
 */
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer 
{
	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		return null;
	}

	/**
	 * Inicia configurações
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return new Class[] 
		{
			AppWebConfiguration.class, // Configurações adicionais
			JPAConfiguration.class     // Configurações de DataSource
		};
	}

	/**
	 * Especifica quais requisições serão interceptadas pela servlet.
	 * No caso, todas as requisições ("/") serão interceptadas
	 */
	@Override
	protected String[] getServletMappings() 
	{
		return new String[]{"/"};
	}

}
