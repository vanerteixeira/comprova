package br.com.pizzaria.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
@Table(name="PIZZA", schema="PUBLIC")
public class Pizza implements Serializable {

	private static final long serialVersionUID = 4110332283443201472L;

	private Integer id;
	private Set<Sabor> sabores = new HashSet<>();

	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(	name="PIZZA_SABOR", 
				joinColumns={ @JoinColumn(name="PIZZA_ID") }, 
				inverseJoinColumns={ @JoinColumn(name="SABOR_ID") })
	public Set<Sabor> getSabores() {
		return sabores;
	}

	public void setSabores(Set<Sabor> sabores) {
		this.sabores = sabores;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", sabores=" + sabores + "]";
	}

}
