package model.services;

import model.entities.AluguelCarro;
import model.entities.Fatura;

public class ServicoDeAluguel {
	private Double precoPorHora;
	private Double precoPorDia;
	
	//vinvulo com classe interface Servico imposto
	private ServicoImposto issBrasil;
	
	public ServicoDeAluguel() {
		
	}

	public ServicoDeAluguel(Double precoPorHora, Double precoPorDia,ServicoImposto issBrasil) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.issBrasil = issBrasil;
	}
	
	public void processaFatura(AluguelCarro aluguel) {
		long t1 = aluguel.getRetirada().getTime(); //captura a data de retirada em milisegundos
		long t2 = aluguel.getEntrega().getTime(); // captura data de devolucao em milisegundos
		double horas = (double)(t2- t1) /1000 / 60 /60;
				        //diferenca milisegundos passa para segundos /60 para minutos /60 para horas  
		double pagamentoBasico = 0;
		if(horas<=12) {
			pagamentoBasico = Math.ceil(horas) * precoPorHora;
		}								//arredonta as horas							
		else {
			pagamentoBasico = Math.ceil(horas/24) * precoPorDia;
		}
		double imposto = issBrasil.imposto(pagamentoBasico);
		aluguel.setFatura(new Fatura(pagamentoBasico,imposto));
	}
	
	
}

