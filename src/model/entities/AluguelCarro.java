package model.entities;

import java.util.Date;

public class AluguelCarro {
	
	private Date retirada;
	private Date entrega;
	
	//associacao da classe veiculo cada aluguel tem pelo menos 1 veiculo
	private Veiculo veiculo;
	//tambem tem vinculo de 0 ou 1 Fatura
	private Fatura fatura;
	

	public AluguelCarro() {
		
	}
	//no construtor nao tem Fatura pois pode ocorrer de não ter fatura segundo o exercicio
	public AluguelCarro(Date retirada, Date entrega,Veiculo veiculo) {
		this.retirada = retirada;
		this.entrega = entrega;
		this.veiculo = veiculo;
	}
	

	public Date getRetirada() {
		return retirada;
	}

	public void setRetirada(Date retirada) {
		this.retirada = retirada;
	}

	public Date getEntrega() {
		return entrega;
	}

	public void setEntrega(Date entrega) {
		this.entrega = entrega;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Fatura getFatura() {
		return fatura;
	}
	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
	
	
	
	
}
