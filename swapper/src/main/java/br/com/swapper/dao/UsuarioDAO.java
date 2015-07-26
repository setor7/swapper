package br.com.swapper.dao;

import java.util.List;

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
	
	/**
	 * Remove usuário
	 * @param usuario
	 */
	public void delete(Usuario usuario)
	{
		manager.remove(usuario);
	}
	
	/**
	 * Atualiza dados do usuário
	 * @param usuario
	 */
	public void update(Usuario usuario)
	{
		manager.merge(usuario);
	}
	
	/**
	 * Lista todos os usuários cadastrados
	 * @return
	 */
	public List<Usuario> list()
	{
		return manager.createQuery("Select p From Usuario p", Usuario.class).getResultList();
	}
}
