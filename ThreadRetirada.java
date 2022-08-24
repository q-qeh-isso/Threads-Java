public class ThreadRetirada implements Runnable{
	
	private Conta conta;
	private double[] valores;
	
	public ThreadRetirada(Conta conta, double[] valores){
		this.conta = conta;
		this.valores = valores;
	}
	
	@Override
	public void run() {
		for(double valor : valores){
			this.conta.retirar(valor);
		}
	}

}
