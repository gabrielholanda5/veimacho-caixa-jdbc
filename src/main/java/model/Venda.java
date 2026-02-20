package model;

import java.time.LocalDateTime;

public class Venda {
	
	private Integer id;
	private LocalDateTime data;
	private Double valorTotal;
	
	public Venda() {
		
	}

	public Venda(Integer id, LocalDateTime data, Double valorTotal) {
		
		this.id = id;
		this.data = data;
		this.valorTotal = valorTotal;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
