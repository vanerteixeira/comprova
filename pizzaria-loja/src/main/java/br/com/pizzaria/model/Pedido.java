package br.com.pizzaria.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PEDIDO", schema="PUBLIC")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 497074278040529202L;

	private Integer id;
	private Integer ordem;

	private Set<Pizza> pizzas = new HashSet<>();
	private Set<Bebida> bebidas = new HashSet<>();
	private Set<Sobremesa> sobremesas = new HashSet<>();
	
	private Date data;
	private BigDecimal total;
	private Boolean pedidoFechado;

	public Pedido() {
		this.data = new Date(Calendar.getInstance().getTimeInMillis());
		this.pedidoFechado = Boolean.FALSE;
	}
	
	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="ORDEM", nullable=false)
	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(	name="PEDIDO_PIZZA", 
				joinColumns={ @JoinColumn(name="PEDIDO_ID") },
				inverseJoinColumns={ @JoinColumn(name="PIZZA_ID") })
	public Set<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(	name="PEDIDO_BEBIDA", 
				joinColumns={ @JoinColumn(name="PEDIDO_ID") }, 
				inverseJoinColumns={ @JoinColumn(name="BEBIDA_ID") })
	public Set<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(Set<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(	name="PEDIDO_SOBREMESA", 
				joinColumns={ @JoinColumn(name="PEDIDO_ID") }, 
				inverseJoinColumns={ @JoinColumn(name="SOBREMESA_ID") })
	public Set<Sobremesa> getSobremesas() {
		return sobremesas;
	}

	public void setSobremesas(Set<Sobremesa> sobremesas) {
		this.sobremesas = sobremesas;
	}

	@Column(name="DATA")
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(name="TOTAL", nullable=false)
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Column(name="pedido_fechado")
	public Boolean getPedidoFechado() {
		return pedidoFechado;
	}

	public void setPedidoFechado(Boolean pedidoFechado) {
		this.pedidoFechado = pedidoFechado;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", ordem=" + ordem + ", pizzas=" + pizzas + ", bebidas=" + bebidas + ", sobremesas="
				+ sobremesas + ", data=" + data + ", total=" + total + ", pedidoFechado=" + pedidoFechado
				+ "]";
	}

}
