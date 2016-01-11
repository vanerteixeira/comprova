package br.com.pizzaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.pizzaria.model.Sabor;

@Component
@Transactional
public class SaborDAOImpl implements SaborDAO {

	@PersistenceContext
	protected EntityManager em;
	
	protected SaborDAOImpl() {
	}

	@Override
	public List<Sabor> findAll() {
		return em.createQuery(" FROM " + Sabor.class.getName(), Sabor.class).getResultList();
	}

	@Override
	public Sabor findById(Integer id) {
		return em.find(Sabor.class, id);
	}

	@Override
	public void save(Sabor obj) {
		em.persist(obj);		
	}
}
