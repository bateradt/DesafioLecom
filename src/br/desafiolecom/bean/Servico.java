package br.desafiolecom.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Table(name = "servico")
public class Servico extends Persistivel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ser_descricao")
	private String descricao;

	@Column(name = "ser_valor")
	private Double valor;

	// @Column(name = "fk_id_servico")
	// @OneToMany(mappedBy = "servicos", targetEntity = OrdemServico.class,
	// fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// private List<OrdemServico> ordemServicos;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return this.descricao;
	}
}
