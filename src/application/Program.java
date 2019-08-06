package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AluguelCarro;
import model.entities.Veiculo;
import model.services.BrasilImpostoServicos;
import model.services.ServicoDeAluguel;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		Locale.setDefault(Locale.US);//tranforma ponto como padrao de separacao da casas decimais
		//formatacao da data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		try {
		System.out.print("Entre com modelo do Carro: ");
		String modelo = scan.nextLine();
		
		System.out.println("Entre com data da retirada do veiculo: (dd/MM/yyyy");
		Date dataRetirada = sdf.parse(scan.nextLine());
		
		System.out.println("Entre com data de devolucao do veiculo: (dd/MM/yyyy");
		Date dataEntrega = sdf.parse(scan.nextLine());
		
		AluguelCarro aluguel = new AluguelCarro(dataRetirada, dataEntrega, new Veiculo(modelo));
		
		
		System.out.print("Insira o valor do preco por hora:" );
		double precoPorHora = scan.nextDouble();
		System.out.print("Insira o valor do preco por dia: ");
		double precoPorDia = scan.nextDouble();
		
		ServicoDeAluguel servicoDeAluguel =  new ServicoDeAluguel(precoPorHora, precoPorDia, new BrasilImpostoServicos());
		servicoDeAluguel.processaFatura(aluguel);
		
		//imprime resultado
		
		System.out.println("Fatura:");
		System.out.println("Pagamento Basico: "+ String.format("%.2f", aluguel.getFatura().getPagamentoBasico()));
		System.out.println("Imposto "+ String.format("%.2f", aluguel.getFatura().getImposto()));
		System.out.println("Pagamento Total : "+ String.format("%.2f", aluguel.getFatura().pagamentoTotal()));
		
		}catch(ParseException e){
			System.out.println("Erro de entrada de dados "+ e.getMessage());
		}catch(InputMismatchException a) {
			System.out.println("Valor invalido para preco, digite separador com virgula: "+a.getMessage());
		}
		
		
		
		
		
		
		
		
		
		scan.close();
	}

}
