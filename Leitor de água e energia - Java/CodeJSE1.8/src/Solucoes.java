import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Solucoes {
	
	private double aguaEconomizada,energiaEconomizada,consumoRacionalAgua,consumoRacionalEnergia;
	private ArrayList<Medidas> agua;
	private ArrayList<Medidas> energia;
	DecimalFormat df = new DecimalFormat("#.##");
	
	
	Solucoes(){
		agua = new ArrayList<Medidas>();
		energia = new ArrayList<Medidas>();
	}
	
	public void menuAgua(Hidrometro water) {
		String escolha="";
		do {
			escolha = JOptionPane.showInputDialog("Medidas para reduzir consumo em �gua"
					+"\n1 - Arejador de vaz�o constante - torneira."
					+"\n2 - Reduzir tempo de tomar banho."
					+"\n3 - Uso consciente ao lavar lou�a."
					+"\n4 - Uso consciente ao escovar os dentes."
					+"\n5 - Conscientiza��o ao lavar cal�ada e quintal."
					+"\n0 - Voltar");
			if(escolha.equals("1")){
				addMedida(agua,new Medidas("Arejador de torneira","Instalar na sa�da de �gua da torneira, diminui a vaz�o de �gua.",(water.getLitros()*0.299),water.getLitros()*(0.299-0.12)),"Arejador de torneira");
				JOptionPane.showMessageDialog(null,"Arejador de torneira\n"+"- Instalar na sa�da de �gua da torneira, diminui a vaz�o de �gua pela metade."
						+"\n\nConusmo de torneira antes: "+df.format(water.getLitros()*0.299)+"L"
						+"\nConsumo de torneira ap�s arejador: "+df.format(water.getLitros()*(0.299-0.12))+"L"
						+"\nEconomizar�: "+df.format(water.getLitros()*0.12)+"L"
						+"\n\nObs: Leva-se em considera��o as torneiras de pia, lavat�rio, vaz�o "
						+ "\npara m�quina de lavar, torneiras de tanque, tanquinho, "
						+ "\nconsome aproximadamente 29,9% do consumo total da resid�ncia em um m�s");
			}
			if(escolha.equals("2")){
				addMedida(agua,new Medidas("Reduzir tempo de banho","O tempo que levamos ao tomar banho pode\r\n" + 
						"	influenciar em muito nosso uso racional da �gua.",water.getLitros()*0.139,water.getLitros()*(0.139-0.0347)),"Reduzir tempo de banho");
				JOptionPane.showMessageDialog(null,
						"Reduzir tempo de banho"
						+"\n- O tempo que levamos ao tomar pode influenciar\nem muito nosso uso racional da �gua."
						+"\n- Consumo do banho de 20 min: 120L"
						+"\n- Consumo do banho em 5 min: 30L"
						+"\n\nConsumo antes: "+df.format(water.getLitros()*0.139)+"L"
						+"\nConsumo depois ser� de: "+df.format(water.getLitros()*(0.139-0.0347))+"L"
						+"\nEconomizar�: "+df.format(water.getLitros()*0.0347)+"L"
						+"\n\nObs: Banho estipulado em um dia, e considerando-se que"
						+ "\no consumo do chuveiro representa 13,9% em um m�s.");
			}
			if(escolha.equals("3")) {
				addMedida(agua,new Medidas("Uso consciente ao lavar lou�a","\nAdotar uso consciente da torneira na hora de\nlavar a lou�a tamb�m ir� impactar o consumo final do m�s\nou per�odo.\n",water.getLitros()*0.256,water.getLitros()*(0.256-0.0746)),"Uso consciente ao lavar lou�a");
				JOptionPane.showMessageDialog(null, "Uso consciente ao lavar lou�a"
						+"\n- Adotar uso consciente da torneira na hora de\nlavar a lou�a tamb�m ir� impactar o consumo final do m�s\nou per�odo."
						+"\n- Consumo com tornerira aberta: 240L"
						+"\n- Consumo abrindo e fechando torneira: 70L"
						+"\n\nConsumo antes: "+df.format(water.getLitros()*0.256)+"L"
						+"\nConsumo depois ser� de: "+df.format(water.getLitros()*(0.256-0.0746))+"L"
						+"\nEconomizar�: "+df.format(water.getLitros()*0.0746)+"L"
						+"\n\nObs: Lavar lou�a representa um c�lculo na m�dia de 25,6% do\nconsumo total de �gua em um m�s");
			}
			if(escolha.equals("4")) {
				addMedida(agua,new Medidas("Uso consciente ao escovar os dentes","\nAdotar o uso consciente da torneira quando escovar os\ndentes tamb�m ir� impactar o consumo de �gua",water.getLitros()*0.106,water.getLitros()*(0.106-0.038)),"Uso consciente ao escovar os dentes");
				JOptionPane.showMessageDialog(null, "Uso consciente ao escovar os dentes"
						+"\nAdotar o uso consciente da torneira quando escovar os\ndentes tamb�m ir� impactar o consumo de �gua."
						+"\n- Torneira aberta continuamente: 12L"
						+"\n- Torneira aberta quando necess�rio: 0,5L"
						+"\n\nConsumo antes: "+df.format(water.getLitros()*0.106)+"L"
						+"\nConsumo depois ser� de: "+df.format(water.getLitros()*(0.106-0.038))+"L"
						+"\nEconomizar�: "+df.format(water.getLitros()*0.038)+"L"
						+"\nObs: Considera-se por dia o gasto de �gua nessa situa��o.");
			}
			if(escolha.equals("5")) {
				addMedida(agua,new Medidas("Conscientiza��o ao lavar cal�ada e quintal","\nLavar cal�ada com a mangueira � um h�bito\ncomum e que traz grandes preju�zos. Por isso, deve-se\nusar a vassoura para limpar a cal�ada e o quintal",water.getLitros()*0.20,water.getLitros()*(0.20-0.20)),"Conscientiza��o ao lavar cal�ada e quintal");
				JOptionPane.showMessageDialog(null, "Conscientiza��o ao lavar cal�ada e quintal"
						+"\n- Lavar a cal�ada com a mangueira � um h�bito\ncomum e que traz grandes preju�zos. Por isso, deve-se\nusar a vassoura para limpar a cal�ada e o quintal"
						+"\n- 15 minutos de mangueira aberta: 279L"
						+"\n- Varrer a cal�ada e o quintal: 0L"
						+"\n\nConsumo antes: "+df.format(water.getLitros()*0.20)+"L"
						+"\nConsumo depois ser� de: "+df.format(water.getLitros()*(0.20-0.20))+"L"
						+"\nEconomizar�: "+df.format(water.getLitros()*0.20)+"L"
						+"\nObs: Considera-se esse ato uma vez por m�s");
			}
			
		}while(!escolha.equals("0"));
		
	}

	public void menuEnergia(MedidorEnergia energy) {
		String escolha="";
		do {
			escolha = JOptionPane.showInputDialog("Medidas para reduzir consumo em energia"
					+"\n1 - Uso consciente do chuveiro."
					+"\n2 - Cuidados na ilumina��o."
					+"\n3 - Cuidados com a geladeira."
					+"\n4 - Cuidados com ar condicionado."
					+"\n5 - Outros consumos el�tricos na resid�ncia."
					+"\n0 - Voltar");
			if(escolha.equals("1")){
				addMedida(energia,new Medidas("Uso consciente do chuveiro","",energy.getTotalConsumo()*0.24,energy.getTotalConsumo()*(0.24-0.072)),"Uso consciente do chuveiro");
				JOptionPane.showMessageDialog(null, "Uso consciente do chuveiro\n\n- Nos dias quentes, coloque o chuveiro na posi��o Ver�o.\n- Deixe o chuveiro ligado apenas o tempo necess�rio.\n- Adotando h�bitos simples o consumo ser� 30% menor"
						+ "\n\nConsumo antes: "+df.format(energy.getTotalConsumo()*0.24)+"kWh"
						+ "\nConsumo depois ser� de: "+df.format(energy.getTotalConsumo()*(0.24-0.072))+"kWh"
						+ "\nEconomizar�: "+df.format(energy.getTotalConsumo()*0.072)+"kWh"
						+ "\nObs: O uso do chuveiro em m�dia representa 24% do consumo da resid�ncia.");
			}
			if(escolha.equals("2")){
				addMedida(energia,new Medidas("Cuidados na ilumina��o","",energy.getTotalConsumo()*0.14,energy.getTotalConsumo()*(0.14-0.07)),"Cuidados na ilumina��o");
				JOptionPane.showMessageDialog(null, "Cuidados na ilumina��o\n\n- D� prefer�ncia �s l�mpadas de LED. Elas consomem, em m�dia, 50% menos de energia el�trica.\n- Evite acender l�mpadas durante o dia. Aproveite a luz natural.\n- Sempre apague as l�mpadas dos ambientes desocupados."
						+ "\n\nConsumo antes: "+df.format(energy.getTotalConsumo()*0.14)+"kWh"
						+ "\nConsumo depois ser� de: "+df.format(energy.getTotalConsumo()*(0.14-0.07))+"kWh"
						+ "\nEconomizar�: "+df.format(energy.getTotalConsumo()*0.07)+"kWh"
						+ "\nObs: a ilumina��o representa em m�dia 14% do consumo.");
			}
			if(escolha.equals("3")) {
				addMedida(energia,new Medidas("Cuidados com a geladeira","",energy.getTotalConsumo()*0.22,energy.getTotalConsumo()*(0.22-0.1)),"Cuidados com a geladeira");
				JOptionPane.showMessageDialog(null, "Cuidados com a geladeira\n\n- Instale a geladeira em local bem ventilado, longe de fontes de calor.\n- Nunca coloque alimentos quentes ou recipientes com l�quidos destampados,\nisso exigir� um esfor�o maior do motor.\n- N�o deixar a porta da geladeira aberta por muito tempo.\n"
						+ "\n\nConsumo antes: "+df.format(energy.getTotalConsumo()*0.22)+"kWh"
						+ "\nConsumo depois ser� de: "+df.format(energy.getTotalConsumo()*(0.22-0.1))+"kWh"
						+ "\nEconomizar�: "+df.format(energy.getTotalConsumo()*0.1)+"kWh"
						+ "\nObs: o consumo da geladeira em uma resid�ncia representa 22% do total.");
				
			}
			if(escolha.equals("4")) {
				addMedida(energia,new Medidas("Cuidados com ar condicionado","",energy.getTotalConsumo()*0.20,energy.getTotalConsumo()*(0.20-0.05)),"Cuidados com ar condicionado");
				JOptionPane.showMessageDialog(null, "Cuidados com ar condicionado\n\n- O ar condicionado � um grande consumidor de energia el�trica.\nNo ver�o os custos podem representar 30% do valor da conta.\n-  Na hora de escolher o modelo do equipamento, dar prefer�ncia\naos que possuem o selo PROCEL; eles consome de 12% a 26% menos energia."
						+ "\n\nConsumo antes: "+df.format(energy.getTotalConsumo()*0.20)+"kWh"
						+ "\nConsumo depois ser� de: "+df.format(energy.getTotalConsumo()*(0.20-0.05))+"kWh"
						+ "\nEconomizar�: "+df.format(energy.getTotalConsumo()*0.05)+"kWh"
						+ "\nObs: O consumo do ar condicionado em uma resid�ncia representa 20% do total.");
			}
			if(escolha.equals("5")) {
				addMedida(energia,new Medidas("consumos el�tricos","",energy.getTotalConsumo()*0.20,energy.getTotalConsumo()*(0.20-0.03)),"consumos el�tricos");
				JOptionPane.showMessageDialog(null, "Outros consumos el�tricos na resid�ncia\n\n- Nessa medida encaixam-se por exemplo Freezer, televisores, microondas, \nsom, ferro de passar, lava roupas e etc.\n- Adote h�bitos conscientes no uso eletr�nico.\n- Desligar a TV quando ningu�m estiver assistindo, o mesmo vale para aparelhos de SOM.\n- N�o deixe aparelhos eletr�nicos em repouso \"stand-by\".\n- O ferro el�trico tem regulagem de temperatura, o que pode torn�-lo mais econ�mico.\n - N�o deixe equipamentos eletr�nicos (celulares, notebooks, c�meras) �dormirem� carregando." 
						+ "\n\nConsumo antes: "+df.format(energy.getTotalConsumo()*0.20)+"kWh"
						+ "\nConsumo depois ser� de: "+df.format(energy.getTotalConsumo()*(0.20-0.03))+"kWh"
						+ "\nEconomizar�: "+df.format(energy.getTotalConsumo()*0.03)+"kWh"
						+ "\nObs: O consumo dos equipamentos eletr�nicos representam aproximadamente 20% do total.");
			}
			
		}while(!escolha.equals("0"));
	}
	
	public static void addMedida(ArrayList<Medidas> vetor, Medidas m,String title) {
		boolean flag=true;
		if(vetor.isEmpty()) {
			flag=true;
		}else{
			for(int i = 0;i<vetor.size();i++) {
				if(vetor.get(i).getTitleMedida().equals(title)) {
					flag = false;
				}
			}
		}
		if(flag) {
			vetor.add(m);
			JOptionPane.showMessageDialog(null, "Medida sustent�vel adicionada");
		}else {
			JOptionPane.showMessageDialog(null, "Medida sustent�vel j� tomada");
		}
	}
	
	public String agrupaMedidas(ArrayList<Medidas> tipoMedida) {
		String resultado ="";
		if(tipoMedida.isEmpty()) {
			resultado+="N�o h� medidas adotadas ainda.";
		}else {
			int i=1;
			for(Medidas m: tipoMedida) {
				resultado+=i+" - "+m.getTitleMedida()+"\n";
				i+=1;
			}
		}
		
		return resultado;
	}

	public String medidasTomadas(Hidrometro water, MedidorEnergia energy) {
		String resultado="";
		resultado+="�gua\n";
		resultado+=agrupaMedidas(this.agua);
		resultado+="\nEnergia\n";
		resultado+=agrupaMedidas(this.energia);
		calculaUsoRacional(water,energy);
		return resultado
				+"\n________________________"
				+"\nConsumo de �gua antes: "+df.format(water.getLitros())+"L - R$"+df.format(water.getContaFinal())
				+"\nConsumo ap�s economias: "+df.format(consumoRacionalAgua)+"L - R$"+df.format(((consumoRacionalAgua*10)/1000)*water.getTarifa())
				+"\n�gua economizada: "+df.format(aguaEconomizada)+"L - R$"+df.format(((aguaEconomizada*10)/1000)*water.getTarifa())
				+"\n________________________"
				+"\nConsumo de energia antes: "+df.format(energy.getTotalConsumo())+"kWh - R$"+df.format(energy.getContaFinal())
				+"\nConsumo ap�s economias: "+df.format(consumoRacionalEnergia)+"kWh - R$"+df.format(consumoRacionalEnergia*energy.getTarifa())
				+"\nEnergia economizada: "+df.format(energiaEconomizada)+"kWh - R$"+df.format(energiaEconomizada*energy.getTarifa());
		
	}
	
	public double somaEconomia(ArrayList<Medidas> medida) {
		double totalEconomia=0;
		for(Medidas m: medida) {
			totalEconomia+=(m.getConsumoAntes()-m.getConsumoApos());
		}
		return totalEconomia;
	}
	
	public void calculaUsoRacional(Hidrometro water, MedidorEnergia energy) {
		consumoRacionalAgua = water.getLitros()-somaEconomia(agua);
		aguaEconomizada = somaEconomia(agua);
		consumoRacionalEnergia = energy.getTotalConsumo()-somaEconomia(energia);
		energiaEconomizada = somaEconomia(energia);
		
	}

	public ArrayList<Medidas> getAgua() {
		return agua;
	}

	public ArrayList<Medidas> getEnergia() {
		return energia;
	}

	
	
	
}
