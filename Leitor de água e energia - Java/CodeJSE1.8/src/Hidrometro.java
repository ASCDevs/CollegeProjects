
public class Hidrometro extends Leitura {
	
	private double contaFinal;
	private double litros;
	
	Hidrometro(String fornecedor, double vlTarifa){
		super(fornecedor, vlTarifa,"m³","Hidrômetro");
		this.contaFinal=super.getTotalConsumo()*vlTarifa;
		this.litros = (super.getTotalConsumo()/10)*1000;
		
	}
	
	
	public String toString() {
		
		return super.toString()
				+"\nTotal consumo em litros: "+litros+"L"
				+"\nValor total em reais: R$"+contaFinal;
	}


	public double getContaFinal() {
		return contaFinal;
	}
	
	public double getLitros() {
		return litros;
	}
	

}
