public class ThreadDeposito implements Runnable {

	private Conta conta;
	private double[] valores;
	
	public ThreadDeposito(Conta conta, double[] valores){
		this.conta = conta;
		this.valores = valores;
	}
	
	@Override
	public void run() {
		for(double valor : valores){
			this.conta.depositar(valor);
		}
	}
	

}
