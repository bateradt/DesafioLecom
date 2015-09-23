package br.desafiolecom.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "cliente")
@Proxy(lazy = false)
public class Cliente extends Persistivel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "cli_nome")
	private String nome;

	@Column(name = "cli_documento")
	private String documento;

	@Column(name = "cli_email")
	private String email;

	// @Column(name = "fk_id_cliente")
	// @OneToMany(mappedBy = "clientes", targetEntity = OrdemServico.class,
	// fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// private List<OrdemServico> ordemServico;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento
	 *            the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
