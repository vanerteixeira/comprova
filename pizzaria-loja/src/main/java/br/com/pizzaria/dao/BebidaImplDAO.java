package br.com.pizzaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.pizzaria.model.Bebida;

@Component
@Transactional
class BebidaImplDAO implements BebidaDAO {

	@PersistenceContext
	protected EntityManager em;
	
	protected BebidaImplDAO() {
	}

	@Override
	public List<Bebida> findAll() {
		return em.createQuery(" FROM " + Bebida.class.getName(), Bebida.class).getResultList();
	}

	@Override
	public Bebida findById(Integer id) {
		return em.find(Bebida.class, id);
	}

	@Override
	public void save(Bebida obj) {
		em.persist(obj);		
	}

}
