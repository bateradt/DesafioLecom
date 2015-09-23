package br.desafiolecom.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "ordemservico")
@Proxy(lazy = false)
public class OrdemServico extends Persistivel implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_CLI_ID", referencedColumnName = "id", nullable = false, unique = true)
	private Cliente clientes;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_SER_ID", referencedColumnName = "id", nullable = false, unique = true)
	private Servico servicos;

	@Column(name = "os_datainicial")
	private Date dataInicial;

	@Column(name = "os_datafinal")
	private Date dataFinal;

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return clientes;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente clientes) {
		this.clientes = clientes;
	}

	/**
	 * @return the servicos
	 */
	public Servico getServicos() {
		return servicos;
	}

	/**
	 * @param servicos
	 *            the servicos to set
	 */
	public void setServicos(Servico servicos) {
		this.servicos = servicos;
	}

	/**
	 * @return the dataInicial
	 */
	public Date getDataInicial() {
		return dataInicial;
	}

	/**
	 * @param dataInicial
	 *            the dataInicial to set
	 */
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * @return the dataFinal
	 */
	public Date getDataFinal() {
		return dataFinal;
	}

	/**
	 * @param dataFinal
	 *            the dataFinal to set
	 */
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

}
