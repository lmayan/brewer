package com.algaworks.brewer.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.algaworks.brewer.validation.SKU;

@Entity
@Table(name = "cerveja")
public class Cerveja implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@SKU
	@NotBlank(message = "SKU não pode estar vazio!")
	private String sku;

	@NotBlank(message = "NOME não pode estar vazio!")
	private String nome;

	@NotBlank(message = "DESCRIÇÃO deve conter entre 1-50 caracteres!")
	@Size(max = 50, message = "DESCRIÇÃO deve conter entre 1-50 caracteres!")
	private String descricao;

	//@NotBlank(message = "VALOR não pode estar vazio!")
	//@Size(max = 7, message = "VALOR não pode ser maior que 9999,99")
	private BigDecimal valor;

	@Column(name = "teor_alcoolico")
	@Max(value = 6, message = "TEOR ALCOOLICO não pode ser maior que 100,00")
	@NotNull(message = "TEOR ALCOOLICO não pode estar vazio!")
	private BigDecimal teorAlcoolico;

	private BigDecimal comissao;

	@Column(name = "quantidade_estoque")
	//@Size(max = 4, message = "QUANTIDADE ESTOQUE deve conter entre 1-4 caracteres!")
	private Integer quantidadeEstoque;

	@Enumerated(EnumType.STRING)
	private Sabor sabor;

	@Enumerated(EnumType.STRING)
	private Origem origem;

	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;

	// GET-SET
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cerveja [id=" + id + ", sku=" + sku + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor
				+ ", teorAlcoolico=" + teorAlcoolico + ", comissao=" + comissao + ", quantidadeEstoque="
				+ quantidadeEstoque + ", sabor=" + sabor + ", origem=" + origem + ", estilo=" + estilo + "]";
	}

}
