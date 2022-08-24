import java.util.ArrayList;
import java.util.Collection;

public class PesquisaArray implements Runnable{
	
	@Override
	public void run(){
		
		Collection<Integer> numeros = new ArrayList<Integer>();
		
		for(int i = 0; i<100000; i++){
			numeros.add(i);
		}
		
		long pontoInicial = System.currentTimeMillis(); //tempo corrente, tempo de maquina, tempo de execução
		
		System.out.println("Pesquisando ... ");
		for(int i = 0; i<100000; i++){
			if(i % 1000 == 0){
				System.out.println(Thread.currentThread().getName() + ": pesquisando " + i);
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			numeros.contains(i);
		}
		
		long pontoFinal = System.currentTimeMillis();
		
		long tempo = pontoFinal - pontoInicial;
		
		System.out.println("Tempo gasto na pesquisa " + tempo);
		
	}

}
