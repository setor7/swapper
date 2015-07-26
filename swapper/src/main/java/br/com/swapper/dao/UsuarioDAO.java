package br.com.swapper.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.swapper.model.Usuario;

@Repository
public class UsuarioDAO 
{
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Usuario usuario)
	{
		manager.persist(usuario);
	}
}
