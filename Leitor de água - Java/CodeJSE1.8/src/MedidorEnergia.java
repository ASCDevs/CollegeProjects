public class MedidorEnergia extends Leitura {
	
	private double contaFinal;
	
	MedidorEnergia(String fornecedor,double vlTarifa){
		super(fornecedor, vlTarifa,"kWh","Medidor de Energia");
		this.contaFinal=super.getTotalConsumo()*vlTarifa;
		
	}
	
	public String toString() {
		
		return super.toString()
				+"\nValor total em reais: R$"+contaFinal;
	}
	
	public double getContaFinal() {
		return contaFinal;
	}
}
