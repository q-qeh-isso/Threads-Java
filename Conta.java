public class Conta {
	
	private double saldo;
	
	public synchronized void depositar(double valor){
		double novoSaldo = saldo+valor;
		this.saldo = novoSaldo;
		this.notifyAll(); //notifica condicao de deposito
	}
	
	public synchronized void retirar(double valor){
		if((this.saldo - valor) < 0){
			try {
				this.wait(); //liberar token
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		double novoSaldo = saldo-valor;
		this.saldo = novoSaldo;	
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
