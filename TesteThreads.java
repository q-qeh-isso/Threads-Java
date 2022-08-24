import java.util.ArrayList;
import java.util.Collection;

public class TesteThreads {
	
	public static void main(String[] args) {
		
		System.out.println("Iniciando metodo main");
		System.out.println("chamando metodo 1");
		metodo1();
		System.out.println("retornou metodo 1");
		System.out.println("Iniciando pesquisa no array");
		
		Thread pesquisa1 = new Thread(new PesquisaArray(), "T-1");
		Thread pesquisa2 = new Thread(new PesquisaArray(), "T-2");
		Thread pesquisa3 = new Thread(new PesquisaArray(), "T-3");
		
		pesquisa1.setPriority(Thread.MAX_PRIORITY);
		pesquisa3.setPriority(Thread.MIN_PRIORITY);
		
		//pesquisa.run(); //executa de forma SINCRONA
		pesquisa1.start(); //executa de forma ASSINCRONA
		pesquisa2.start();
		pesquisa3.start();
		
		
		
		System.out.println("retornou da pesquisa");
		
		System.out.println("Metodo main chegou ao final");	
		
	}

	private static void metodo1() {
		System.out.println("Executando o metodo 1...");
	}

}
