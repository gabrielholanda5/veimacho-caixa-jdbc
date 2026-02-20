package model;

public class ItemVenda {
	
	private Integer id;
	private Integer vendaId;
	private Integer produtoId;
	private Integer quantidade;
	private Double precoUnitario;
	private Double subtotal;
	
	public ItemVenda() {
		
	}

	public ItemVenda(Integer id, Integer vendaId, Integer produtoId, Integer quantidade, Double precoUnitario,
			Double subtotal) {
		
		this.id = id;
		this.vendaId = vendaId;
		this.produtoId = produtoId;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.subtotal = subtotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVendaId() {
		return vendaId;
	}

	public void setVendaId(Integer vendaId) {
		this.vendaId = vendaId;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
}
