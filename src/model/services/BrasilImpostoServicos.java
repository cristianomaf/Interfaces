package model.services;

public class BrasilImpostoServicos implements ServicoImposto {
	
	
	//metodo
	public double imposto(double valor) {
		if(valor<= 100.0) {
		return  valor * 0.2;				
	}
	else {
		return valor * 0.15;
	}

	}

}
