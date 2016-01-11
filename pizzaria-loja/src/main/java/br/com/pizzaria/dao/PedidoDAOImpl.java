package br.com.pizzaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.pizzaria.model.Pedido;

@Component
@Transactional
class PedidoDAOImpl implements PedidoDAO {

	@PersistenceContext
	protected EntityManager em;
	
	protected PedidoDAOImpl() {
	}

	@Override
	public Integer gerarNovoPedido() {
		StringBuilder query = new StringBuilder();
		query.append(" SELECT MAX(ordem) FROM ").append(Pedido.class.getName());
		Integer maxOrdem = em.createQuery(query.toString(), Integer.class).getSingleResult();
		maxOrdem = (maxOrdem == null) ? 0 : maxOrdem;
		return (++maxOrdem);
	}

	@Override
	public List<Pedido> findAll() {
		return em.createQuery(" FROM " + Pedido.class.getName(), Pedido.class).getResultList();
	}

	@Override
	public Pedido findById(Integer id) {
		return em.find(Pedido.class, id);
	}

	@Override
	public void save(Pedido obj) {
		em.persist(obj);		
	}

	@Override
	public void fecharPedido(Integer ordem) {
		StringBuilder query = new StringBuilder();
		query.append(" UPDATE ").append(Pedido.class.getName())
				.append(" SET ")
				.append(" pedidoFechado = true ")
				.append(" WHERE ordem = :ordem ");
		
		em.createQuery(query.toString())
			.setParameter("ordem", ordem)
			.executeUpdate();
	}

}
