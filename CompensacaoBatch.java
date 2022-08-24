public class CompensacaoBatch {
	
	public static void main(String[] args) {
		
		double[] depositos = {1500,500,300,200};
		double[] retiradas = {1500,500,300,200};
		
		Conta conta = new Conta();
		conta.setSaldo(500); //saldo inicial
		
		Thread tp = new Thread(new ThreadDeposito(conta, depositos));
		Thread tc = new Thread(new ThreadRetirada(conta, retiradas));
		
		System.out.printf("Saldo inicial é R$ %.2f \n", conta.getSaldo());		
		System.out.printf("Saldo Final esperado é R$ %.2f \n", 500.0);
		
		tp.start();
		tc.start();
		
		try {
			tp.join();
			tc.join();
		} catch (InterruptedException e) {
		}
		
		System.out.printf("Saldo final foi de R$ %.2f \n", conta.getSaldo());
		
		
		
	}

}
