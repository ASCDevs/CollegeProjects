import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Leitura {
	
	private String nomeFornecedor,unidadeMedida, leitor;
	private double valorTarifa, totalConsumo;
	private int mesInicial, mesFinal, qtdMeses;
	private ArrayList<String> registroPeriodo = new ArrayList<String>();
	private ArrayList<Double> leitura = new ArrayList<Double>();
	private ArrayList<String> registroLeitura = new ArrayList<String>();
	private ArrayList<Double> consumoPeriodo = new ArrayList<Double>();
	DateFormat formataData = DateFormat.getDateInstance(DateFormat.SHORT);

	public Leitura(String fornecedor, double vlTarifa, String unidadeMedida, String leitor){
		this.nomeFornecedor = fornecedor;
		this.valorTarifa = vlTarifa;
		this.unidadeMedida = unidadeMedida;
		this.leitor = leitor;
		this.fazerLeitura();
		
	}
	
	public void fazerLeitura() {
		String opcao="";
		boolean continuarLoop=true;
		do {

			opcao = JOptionPane.showInputDialog(leitor+"\nVocê irá fazer a leitura de quantos meses?\n1 - Apenas um"+
		"\n2 - De dois até 6 meses");
			
			if(opcao.equals("1")) {
				System.out.println("----------\nOPÇÃO 1 - Apenas um mes");
				
				while(continuarLoop) {
					try {
						do {
							this.mesInicial=Integer.parseInt(JOptionPane.showInputDialog("Digite o número do mês de referência"));
							System.out.println("Mes digitado: "+this.mesInicial);
							if(mesInicial<1||mesInicial>12) {
								JOptionPane.showMessageDialog(null, "Mês "+mesInicial+" Inválido!\nVálidos entre 1 até 12.");
							}
						}while(mesInicial<1||mesInicial>12);
						this.mesFinal = mesInicial;
						continuarLoop=false;
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "ERRO!\n Mês Inválido! Detalhes:\n"+e.getMessage());
					}
				}
				lerMeses(mesInicial,mesFinal);
				
			}
			if(opcao.equals("2")) {
				System.out.println("----------\nOPÇÃO 2 - até 6 meses");
				int periodo;
				do {
					//Pega mês inicial
					try {
						do {
							mesInicial = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do mês inicial"));
							if(mesInicial<1||mesInicial>12) {
								JOptionPane.showMessageDialog(null, "Mês "+mesInicial+" Inválido!\nVálidos entre 1 até 12.");
							}
						}while(mesInicial<1||mesInicial>12);
						continuarLoop=false;
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "ERRO!\n Mês Inválido! Detalhes:\n"+e.getMessage());
					}
					try {
						do {
							mesFinal = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do mês Final"));
							if(mesFinal<1||mesFinal>12) {
								JOptionPane.showMessageDialog(null, "Mês "+mesFinal+" Inválido!\nVálidos entre 1 até 12.");
							}
						}while(mesFinal<1||mesFinal>12);
						continuarLoop=false;
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "ERRO!\n Mês Inválido! Detalhes:\n"+e.getMessage());
					}
					if(mesInicial>mesFinal) {
						int aux = mesInicial;
						mesInicial = mesFinal;
						mesFinal = aux;
					}
					
					periodo = (mesFinal-mesInicial)+1;
					if(mesInicial == mesFinal) {
						JOptionPane.showMessageDialog(null, "Meses Iguais! Digite pelo menos um período de 2 meses");
					}else if((periodo<1)||(periodo>6)) {
						JOptionPane.showMessageDialog(null, "O programa só analisa um período de 6 meses!");
					}else {
						continuarLoop = false;
					}
				}while(continuarLoop);
				
				lerMeses(mesInicial,mesFinal);
				continuarLoop=false;
			}
			
		}while(continuarLoop);
	}
	
	public void lerMeses(int mesComeco, int mesFim) {
		GregorianCalendar dataReferencia = new GregorianCalendar();
		GregorianCalendar dataFinal = new GregorianCalendar();
		
		int meses = (mesFim - mesComeco)+1;
		this.qtdMeses = meses;
		
		dataReferencia.set(Calendar.DAY_OF_MONTH,1);
		dataReferencia.set(Calendar.MONTH,(mesComeco-1));
		dataFinal.set(Calendar.MONTH, mesFim-1);
		dataFinal.set(Calendar.DAY_OF_MONTH,dataFinal.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		System.out.println(meses+" meses");
		System.out.println("Data Inicial: "+formataData.format(dataReferencia.getTime()));
		System.out.println("Data Final: "+formataData.format(dataFinal.getTime()));
		
		registroPeriodo.clear();
		registroLeitura.clear();
		leitura.clear();
		consumoPeriodo.clear();
		
		int contagemLeituras=0;
		double valorAnterior=0;
		int periodos=0;
		
		do{
		
			boolean continuarLoop=true;
			do{
				try {
					leitura.add(contagemLeituras, Double.parseDouble(JOptionPane.showInputDialog((contagemLeituras+1)+"º leitura "+formataData.format(dataReferencia.getTime())+" consumo em "+unidadeMedida)));
					while(leitura.get(contagemLeituras)<valorAnterior) {
						leitura.add(contagemLeituras, Double.parseDouble(JOptionPane.showInputDialog("Valor Inválido! "+leitura.get(contagemLeituras)+unidadeMedida+" é menor que a leitura anterior de "+valorAnterior+"\nDigite a leitura em m³ corretamente: ")));
					}
					continuarLoop=false;
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "ERRO!\n Leitura inválida! Detalhes:\n"+e.getMessage());
				}
			}while(continuarLoop);
			
			if(contagemLeituras==0) {
				consumoPeriodo.add(contagemLeituras,(double)0);	
			}else {
				consumoPeriodo.add(contagemLeituras,(double)leitura.get(contagemLeituras) - valorAnterior);	
			}
			valorAnterior=leitura.get(contagemLeituras);
			System.out.println((contagemLeituras+1)+"º leitura "+formataData.format(dataReferencia.getTime())+" = "+leitura.get(contagemLeituras)+unidadeMedida);
			registroLeitura.add((contagemLeituras+1)+"º leitura "+formataData.format(dataReferencia.getTime())+" = "+leitura.get(contagemLeituras)+unidadeMedida);
			
			GregorianCalendar dataTemp = new GregorianCalendar();
			dataTemp.set(Calendar.MONTH, dataReferencia.get(Calendar.MONTH));
			dataTemp.set(Calendar.DAY_OF_MONTH, dataReferencia.get(Calendar.DAY_OF_MONTH));
			dataTemp.add(Calendar.DAY_OF_MONTH,-10);
			
			if(contagemLeituras>0) {
				
				registroPeriodo.add("Período de "+formataData.format(dataTemp.getTime())+" à "+formataData.format(dataReferencia.getTime())+" "+consumoPeriodo.get(contagemLeituras)+unidadeMedida);
			}
			
			
			dataReferencia.add(Calendar.DAY_OF_MONTH, 10);
			
			contagemLeituras+=1;

			periodos+=10;
		}while(periodos<=(meses*30));
		
		System.out.println("----------");
		for(int x=0;x<registroPeriodo.size();x++) {
			System.out.println(registroPeriodo.get(x));
		}
		
		this.calcularConsumoTotal();
	}
	
	public void calcularConsumoTotal() {
		double somaTotal=0;
		for(int i=0;i<consumoPeriodo.size();i++) {
			somaTotal+=consumoPeriodo.get(i);
		}
		totalConsumo = somaTotal;
	}
	
	@Override
	public String toString() {
		GregorianCalendar dataMesComeco = new GregorianCalendar();
		GregorianCalendar dataMesFim = new GregorianCalendar();
		dataMesComeco.set(Calendar.DAY_OF_MONTH,1);
		dataMesComeco.set(Calendar.MONTH,(mesInicial-1));
		dataMesFim.set(Calendar.MONTH, mesFinal-1);
		dataMesFim.set(Calendar.DAY_OF_MONTH,dataMesFim.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		return	"- "+leitor
				+"\nFornecedor: "+nomeFornecedor
				+"\nValor Tarifa: R$"+valorTarifa
				+ "\nData inicial de leitura: " + formataData.format(dataMesComeco.getTime())
				+ "\nData final de leitura: " + formataData.format(dataMesFim.getTime())
				+ "\nTotal de meses lidos: " + qtdMeses
				+ "\nLeituras: " +  mostraLeitura()
				+ "\nConsumo por período: " + mostraPeriodos()
				+"\nTotal consumo em "+unidadeMedida+": "+totalConsumo+unidadeMedida;
	}
	
	public double getTotalConsumo() {
		return totalConsumo;
	}
	
	public double getTarifa() {
		return this.valorTarifa;
	}

	public void setTotalConsumo(double totalConsumo) {
		this.totalConsumo = totalConsumo;
	}

	public String mostraLeitura() {
		String resultado="\n";
		for(int x = 0; x<registroLeitura.size();x++) {
			resultado+="- "+registroLeitura.get(x)+"\n";
		}
		return resultado;
	}
	
	public String mostraPeriodos() {
		String resultado="\n";
		for(int x = 0; x<registroPeriodo.size();x++) {
			resultado+="- "+registroPeriodo.get(x)+"\n";
		}
		return resultado;
	}

}
