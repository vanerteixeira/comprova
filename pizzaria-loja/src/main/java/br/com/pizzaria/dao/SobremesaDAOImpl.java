package br.com.pizzaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.pizzaria.model.Sobremesa;

@Component
@Transactional
public class SobremesaDAOImpl implements SobremesaDAO {

	@PersistenceContext
	protected EntityManager em;
	
	protected SobremesaDAOImpl() {
	}

	@Override
	public List<Sobremesa> findAll() {
		return em.createQuery(" FROM " + Sobremesa.class.getName(), Sobremesa.class).getResultList();
	}

	@Override
	public Sobremesa findById(Integer id) {
		return em.find(Sobremesa.class, id);
	}

	@Override
	public void save(Sobremesa obj) {
		em.persist(obj);		
	}
}
