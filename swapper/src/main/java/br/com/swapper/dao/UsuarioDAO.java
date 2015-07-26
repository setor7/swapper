package br.com.swapper.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.swapper.model.Usuario;

/**
 * DAO para a entidade Usuario
 * @author Bruno Carneiro
 *
 */
@Repository
public class UsuarioDAO 
{
	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * Persiste usuário na base de dados
	 * @param usuario
	 */
	public void save(Usuario usuario)
	{
		manager.persist(usuario);
	}
}
