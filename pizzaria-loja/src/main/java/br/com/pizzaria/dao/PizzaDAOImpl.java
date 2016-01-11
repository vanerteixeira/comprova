package br.com.pizzaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.pizzaria.model.Pizza;

@Component
@Transactional
class PizzaDAOImpl implements PizzaDAO {

	@PersistenceContext
	protected EntityManager em;
	
	protected PizzaDAOImpl() {
	}

	@Override
	public List<Pizza> findAll() {
		return em.createQuery(" FROM " + Pizza.class.getName(), Pizza.class).getResultList();
	}

	@Override
	public Pizza findById(Integer id) {
		return em.find(Pizza.class, id);
	}

	@Override
	public void save(Pizza obj) {
		em.persist(obj);		
	}
}
