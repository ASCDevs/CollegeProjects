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
			escolha = JOptionPane.showInputDialog("Medidas para reduzir consumo em água"
					+"\n1 - Arejador de vazão constante - torneira."
					+"\n2 - Reduzir tempo de tomar banho."
					+"\n3 - Uso consciente ao lavar louça."
					+"\n4 - Uso consciente ao escovar os dentes."
					+"\n5 - Conscientização ao lavar calçada e quintal."
					+"\n0 - Voltar");
			if(escolha.equals("1")){
				addMedida(agua,new Medidas("Arejador de torneira","Instalar na saída de água da torneira, diminui a vazão de água.",(water.getLitros()*0.299),water.getLitros()*(0.299-0.12)),"Arejador de torneira");
				JOptionPane.showMessageDialog(null,"Arejador de torneira\n"+"- Instalar na saída de água da torneira, diminui a vazão de água pela metade."
						+"\n\nConusmo de torneira antes: "+df.format(water.getLitros()*0.299)+"L"
						+"\nConsumo de torneira após arejador: "+df.format(water.getLitros()*(0.299-0.12))+"L"
						+"\nEconomizará: "+df.format(water.getLitros()*0.12)+"L"
						+"\n\nObs: Leva-se em consideração as torneiras de pia, lavatório, vazão "
						+ "\npara máquina de lavar, torneiras de tanque, tanquinho, "
						+ "\nconsome aproximadamente 29,9% do consumo total da residência em um mês");
			}
			if(escolha.equals("2")){
				addMedida(agua,new Medidas("Reduzir tempo de banho","O tempo que levamos ao tomar banho pode\r\n" + 
						"	influenciar em muito nosso uso racional da água.",water.getLitros()*0.139,water.getLitros()*(0.139-0.0347)),"Reduzir tempo de banho");
				JOptionPane.showMessageDialog(null,
						"Reduzir tempo de banho"
						+"\n- O tempo que levamos ao tomar pode influenciar\nem muito nosso uso racional da água."
						+"\n- Consumo do banho de 20 min: 120L"
						+"\n- Consumo do banho em 5 min: 30L"
						+"\n\nConsumo antes: "+df.format(water.getLitros()*0.139)+"L"
						+"\nConsumo depois será de: "+df.format(water.getLitros()*(0.139-0.0347))+"L"
						+"\nEconomizará: "+df.format(water.getLitros()*0.0347)+"L"
						+"\n\nObs: Banho estipulado em um dia, e considerando-se que"
						+ "\no consumo do chuveiro representa 13,9% em um mês.");
			}
			if(escolha.equals("3")) {
				addMedida(agua,new Medidas("Uso consciente ao lavar louça","\nAdotar uso consciente da torneira na hora de\nlavar a louça também irá impactar o consumo final do mês\nou período.\n",water.getLitros()*0.256,water.getLitros()*(0.256-0.0746)),"Uso consciente ao lavar louça");
				JOptionPane.showMessageDialog(null, "Uso consciente ao lavar louça"
						+"\n- Adotar uso consciente da torneira na hora de\nlavar a louça também irá impactar o consumo final do mês\nou período."
						+"\n- Consumo com tornerira aberta: 240L"
						+"\n- Consumo abrindo e fechando torneira: 70L"
						+"\n\nConsumo antes: "+df.format(water.getLitros()*0.256)+"L"
						+"\nConsumo depois será de: "+df.format(water.getLitros()*(0.256-0.0746))+"L"
						+"\nEconomizará: "+df.format(water.getLitros()*0.0746)+"L"
						+"\n\nObs: Lavar louça representa um cálculo na média de 25,6% do\nconsumo total de água em um mês");
			}
			if(escolha.equals("4")) {
				addMedida(agua,new Medidas("Uso consciente ao escovar os dentes","\nAdotar o uso consciente da torneira quando escovar os\ndentes também irá impactar o consumo de água",water.getLitros()*0.106,water.getLitros()*(0.106-0.038)),"Uso consciente ao escovar os dentes");
				JOptionPane.showMessageDialog(null, "Uso consciente ao escovar os dentes"
						+"\nAdotar o uso consciente da torneira quando escovar os\ndentes também irá impactar o consumo de água."
						+"\n- Torneira aberta continuamente: 12L"
						+"\n- Torneira aberta quando necessário: 0,5L"
						+"\n\nConsumo antes: "+df.format(water.getLitros()*0.106)+"L"
						+"\nConsumo depois será de: "+df.format(water.getLitros()*(0.106-0.038))+"L"
						+"\nEconomizará: "+df.format(water.getLitros()*0.038)+"L"
						+"\nObs: Considera-se por dia o gasto de água nessa situação.");
			}
			if(escolha.equals("5")) {
				addMedida(agua,new Medidas("Conscientização ao lavar calçada e quintal","\nLavar calçada com a mangueira é um hábito\ncomum e que traz grandes prejuízos. Por isso, deve-se\nusar a vassoura para limpar a calçada e o quintal",water.getLitros()*0.20,water.getLitros()*(0.20-0.20)),"Conscientização ao lavar calçada e quintal");
				JOptionPane.showMessageDialog(null, "Conscientização ao lavar calçada e quintal"
						+"\n- Lavar a calçada com a mangueira é um hábito\ncomum e que traz grandes prejuízos. Por isso, deve-se\nusar a vassoura para limpar a calçada e o quintal"
						+"\n- 15 minutos de mangueira aberta: 279L"
						+"\n- Varrer a calçada e o quintal: 0L"
						+"\n\nConsumo antes: "+df.format(water.getLitros()*0.20)+"L"
						+"\nConsumo depois será de: "+df.format(water.getLitros()*(0.20-0.20))+"L"
						+"\nEconomizará: "+df.format(water.getLitros()*0.20)+"L"
						+"\nObs: Considera-se esse ato uma vez por mês");
			}
			
		}while(!escolha.equals("0"));
		
	}

	public void menuEnergia(MedidorEnergia energy) {
		String escolha="";
		do {
			escolha = JOptionPane.showInputDialog("Medidas para reduzir consumo em energia"
					+"\n1 - Uso consciente do chuveiro."
					+"\n2 - Cuidados na iluminação."
					+"\n3 - Cuidados com a geladeira."
					+"\n4 - Cuidados com ar condicionado."
					+"\n5 - Outros consumos elétricos na residência."
					+"\n0 - Voltar");
			if(escolha.equals("1")){
				addMedida(energia,new Medidas("Uso consciente do chuveiro","",energy.getTotalConsumo()*0.24,energy.getTotalConsumo()*(0.24-0.072)),"Uso consciente do chuveiro");
				JOptionPane.showMessageDialog(null, "Uso consciente do chuveiro\n\n- Nos dias quentes, coloque o chuveiro na posição Verão.\n- Deixe o chuveiro ligado apenas o tempo necessário.\n- Adotando hábitos simples o consumo será 30% menor"
						+ "\n\nConsumo antes: "+df.format(energy.getTotalConsumo()*0.24)+"kWh"
						+ "\nConsumo depois será de: "+df.format(energy.getTotalConsumo()*(0.24-0.072))+"kWh"
						+ "\nEconomizará: "+df.format(energy.getTotalConsumo()*0.072)+"kWh"
						+ "\nObs: O uso do chuveiro em média representa 24% do consumo da residência.");
			}
			if(escolha.equals("2")){
				addMedida(energia,new Medidas("Cuidados na iluminação","",energy.getTotalConsumo()*0.14,energy.getTotalConsumo()*(0.14-0.07)),"Cuidados na iluminação");
				JOptionPane.showMessageDialog(null, "Cuidados na iluminação\n\n- Dê preferência às lâmpadas de LED. Elas consomem, em média, 50% menos de energia elétrica.\n- Evite acender lâmpadas durante o dia. Aproveite a luz natural.\n- Sempre apague as lâmpadas dos ambientes desocupados."
						+ "\n\nConsumo antes: "+df.format(energy.getTotalConsumo()*0.14)+"kWh"
						+ "\nConsumo depois será de: "+df.format(energy.getTotalConsumo()*(0.14-0.07))+"kWh"
						+ "\nEconomizará: "+df.format(energy.getTotalConsumo()*0.07)+"kWh"
						+ "\nObs: a iluminação representa em média 14% do consumo.");
			}
			if(escolha.equals("3")) {
				addMedida(energia,new Medidas("Cuidados com a geladeira","",energy.getTotalConsumo()*0.22,energy.getTotalConsumo()*(0.22-0.1)),"Cuidados com a geladeira");
				JOptionPane.showMessageDialog(null, "Cuidados com a geladeira\n\n- Instale a geladeira em local bem ventilado, longe de fontes de calor.\n- Nunca coloque alimentos quentes ou recipientes com líquidos destampados,\nisso exigirá um esforço maior do motor.\n- Não deixar a porta da geladeira aberta por muito tempo.\n"
						+ "\n\nConsumo antes: "+df.format(energy.getTotalConsumo()*0.22)+"kWh"
						+ "\nConsumo depois será de: "+df.format(energy.getTotalConsumo()*(0.22-0.1))+"kWh"
						+ "\nEconomizará: "+df.format(energy.getTotalConsumo()*0.1)+"kWh"
						+ "\nObs: o consumo da geladeira em uma residência representa 22% do total.");
				
			}
			if(escolha.equals("4")) {
				addMedida(energia,new Medidas("Cuidados com ar condicionado","",energy.getTotalConsumo()*0.20,energy.getTotalConsumo()*(0.20-0.05)),"Cuidados com ar condicionado");
				JOptionPane.showMessageDialog(null, "Cuidados com ar condicionado\n\n- O ar condicionado é um grande consumidor de energia elétrica.\nNo verão os custos podem representar 30% do valor da conta.\n-  Na hora de escolher o modelo do equipamento, dar preferência\naos que possuem o selo PROCEL; eles consome de 12% a 26% menos energia."
						+ "\n\nConsumo antes: "+df.format(energy.getTotalConsumo()*0.20)+"kWh"
						+ "\nConsumo depois será de: "+df.format(energy.getTotalConsumo()*(0.20-0.05))+"kWh"
						+ "\nEconomizará: "+df.format(energy.getTotalConsumo()*0.05)+"kWh"
						+ "\nObs: O consumo do ar condicionado em uma residência representa 20% do total.");
			}
			if(escolha.equals("5")) {
				addMedida(energia,new Medidas("consumos elétricos","",energy.getTotalConsumo()*0.20,energy.getTotalConsumo()*(0.20-0.03)),"consumos elétricos");
				JOptionPane.showMessageDialog(null, "Outros consumos elétricos na residência\n\n- Nessa medida encaixam-se por exemplo Freezer, televisores, microondas, \nsom, ferro de passar, lava roupas e etc.\n- Adote hábitos conscientes no uso eletrônico.\n- Desligar a TV quando ninguém estiver assistindo, o mesmo vale para aparelhos de SOM.\n- Não deixe aparelhos eletrônicos em repouso \"stand-by\".\n- O ferro elétrico tem regulagem de temperatura, o que pode torná-lo mais econômico.\n - Não deixe equipamentos eletrônicos (celulares, notebooks, câmeras) ‘dormirem’ carregando." 
						+ "\n\nConsumo antes: "+df.format(energy.getTotalConsumo()*0.20)+"kWh"
						+ "\nConsumo depois será de: "+df.format(energy.getTotalConsumo()*(0.20-0.03))+"kWh"
						+ "\nEconomizará: "+df.format(energy.getTotalConsumo()*0.03)+"kWh"
						+ "\nObs: O consumo dos equipamentos eletrônicos representam aproximadamente 20% do total.");
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
			JOptionPane.showMessageDialog(null, "Medida sustentável adicionada");
		}else {
			JOptionPane.showMessageDialog(null, "Medida sustentável já tomada");
		}
	}
	
	public String agrupaMedidas(ArrayList<Medidas> tipoMedida) {
		String resultado ="";
		if(tipoMedida.isEmpty()) {
			resultado+="Não há medidas adotadas ainda.";
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
		resultado+="Água\n";
		resultado+=agrupaMedidas(this.agua);
		resultado+="\nEnergia\n";
		resultado+=agrupaMedidas(this.energia);
		calculaUsoRacional(water,energy);
		return resultado
				+"\n________________________"
				+"\nConsumo de água antes: "+df.format(water.getLitros())+"L - R$"+df.format(water.getContaFinal())
				+"\nConsumo após economias: "+df.format(consumoRacionalAgua)+"L - R$"+df.format(((consumoRacionalAgua*10)/1000)*water.getTarifa())
				+"\nÁgua economizada: "+df.format(aguaEconomizada)+"L - R$"+df.format(((aguaEconomizada*10)/1000)*water.getTarifa())
				+"\n________________________"
				+"\nConsumo de energia antes: "+df.format(energy.getTotalConsumo())+"kWh - R$"+df.format(energy.getContaFinal())
				+"\nConsumo após economias: "+df.format(consumoRacionalEnergia)+"kWh - R$"+df.format(consumoRacionalEnergia*energy.getTarifa())
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
