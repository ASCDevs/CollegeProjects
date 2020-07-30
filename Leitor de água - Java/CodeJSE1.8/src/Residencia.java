import javax.swing.JOptionPane;

public class Residencia {
	private String nomeResponsavel;
	private String cpf;
	private Hidrometro agua;
	private MedidorEnergia energia;
	private double valorConsumoGeral;
	private Endereco local;
	private Solucoes solucoes;
	
	public Residencia(String nomeResponsavel, String cpf) {
		solucoes = new Solucoes();
		this.nomeResponsavel = nomeResponsavel;
		this.cpf = cpf;
		local = new Endereco(nomeResponsavel);
		this.cadastraLeituraAgua();
		this.cadastraLeituraEnergia();
		this.valorConsumoGeral=agua.getContaFinal()+energia.getContaFinal();
	}
	
	public void aplicaSolucoes() {
		String escolha="";
		do {
			escolha = JOptionPane.showInputDialog("Aplicar soluções - residência de "+nomeResponsavel
					+"\n1 - Medidas para reduzir consumo em água"
					+"\n2 - Medidas para reduzir consumo em energia"
					+"\n3 - Medidas já adotadas"
					+"\n4 - Limpar medidas adotadas"
					+"\n0 - Voltar");
			if(escolha.equals("1")){
				solucoes.menuAgua(agua);
			}
			if(escolha.equals("2")){
				solucoes.menuEnergia(energia);
			}
			
			if(escolha.equals("3")){
				JOptionPane.showMessageDialog(null, solucoes.medidasTomadas(agua,energia));	
			}
			if(escolha.equals("4")) {
				solucoes.getAgua().clear();
				solucoes.getEnergia().clear();
				JOptionPane.showMessageDialog(null, "Medidas tomadas foi zerada, adicione medidas para vê-las.");
			}
			
		}while(!escolha.equals("0"));
	}

	public void cadastraLeituraAgua() {
		boolean continuarLoop=true;
		String nome;
		double vlTarifa=0;
		nome = JOptionPane.showInputDialog("- Cadastro leitura de água -\nDigite o fornecedor: ");
		do {
			try {
				vlTarifa = Double.parseDouble(JOptionPane.showInputDialog("- Cadastro leitura de água -\nDigite o valor de tarifa por m³ consumido: "));
				if(vlTarifa<=0) {
					JOptionPane.showMessageDialog(null, "ERRO!\n Valor de tarifa inválido! Menor ou igual a 0.");
				}
				continuarLoop=false;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ERRO!\n Valor de tarifa inválido! Detalhes:\n"+e.getMessage());
			}
		}while(continuarLoop||vlTarifa<=0);
		agua = new Hidrometro(nome, vlTarifa);

	}
	
	public void cadastraLeituraEnergia() {
		boolean continuarLoop=true;
		String nome;
		double vlTarifa=0;
		nome = JOptionPane.showInputDialog("- Cadastro leitura de energia -\nDigite o fornecedor: ");
		do {
			try {
				vlTarifa = Double.parseDouble(JOptionPane.showInputDialog("- Cadastro leitura de energia -\nDigite o valor de tarifa por kWh consumido: "));
				if(vlTarifa<=0) {
					JOptionPane.showMessageDialog(null, "ERRO!\n Valor de tarifa inválido! Menor ou igual a 0.");
				}
				continuarLoop=false;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ERRO!\n Valor de tarifa inválido! Detalhes:\n"+e.getMessage());
			}
		}while(continuarLoop||vlTarifa<=0);
		energia = new MedidorEnergia(nome, vlTarifa);
	}
	
	
	public void alterarDados() {
		String escolha="";
		do {
			escolha = JOptionPane.showInputDialog("Alterar dados - residência de "+nomeResponsavel
					+"\n1 - Alterar nome"
					+"\n2 - Alterar CPF"
					+"\n3 - Alterar Endereço"
					+"\n4 - Fazer nova leitura de água"
					+"\n5 - Fazer nova leitura de energia"
					+"\n0 - Voltar");
			if(escolha.equals("1")){
				this.nomeResponsavel = JOptionPane.showInputDialog("Digite a alteração de nome: ");
				JOptionPane.showMessageDialog(null, "Nome alterado para: "+this.nomeResponsavel);
			}
			if(escolha.equals("2")){
				this.cpf = JOptionPane.showInputDialog("Digite a alteração de CPF: ");
				JOptionPane.showMessageDialog(null, "CPF alterado para: "+this.cpf);
			}
			
			if(escolha.equals("3")){
				String opcao="";
				do {
					opcao = JOptionPane.showInputDialog("Alterar endereco - residência de "+nomeResponsavel
							+"\n1 - Alterar logradouro/rua"
							+"\n2 - Alterar número da residência"
							+"\n3 - Alterar Cidade"
							+"\n4 - Alterar UF"
							+"\n0 - Voltar");
					if(opcao.equals("1")){
						local.setRua(JOptionPane.showInputDialog("Digite a alteração do logradouro/rua: "));
						JOptionPane.showMessageDialog(null, "Logradouro/rua alterado para: "+local.getRua());
					}
					if(opcao.equals("2")){
						local.setNrResidencia(JOptionPane.showInputDialog("Digite a alteração do Nº da residência: "));
						JOptionPane.showMessageDialog(null, "Nº da residência alterado para: "+local.getNrResidencia());
					}
					if(opcao.equals("3")){
						local.setCidade(JOptionPane.showInputDialog("Digite a alteração do nome da cidade: "));
						JOptionPane.showMessageDialog(null, "Cidade alterado para: "+local.getCidade());
					}
					
					if(opcao.equals("4")){
						local.setUf(JOptionPane.showInputDialog("Digite a alteração da Unidade Federal: "));
						JOptionPane.showMessageDialog(null, "Unidade Federal alterado para: "+local.getUf());
					}
					
				}while(!opcao.equals("0"));
				
			}
			if(escolha.equals("4")){
				this.cadastraLeituraAgua();
			}
			if(escolha.equals("5")){
				this.cadastraLeituraEnergia();
			}
			
		}while(!escolha.equals("0"));
	}

	@Override
	public String toString() {
		return "Residencia "
				+"\nProprietário: " + nomeResponsavel 
				+"\nCPF:" + cpf 
				+"\nConsumo em água: "+agua.getLitros()+"L = R$"+agua.getContaFinal()
				+"\nConsumo em energia: "+energia.getTotalConsumo()+"kWh = R$"+energia.getContaFinal()
				+"\nTotal geral de consumo em reais: R$" + valorConsumoGeral 
				+"\nLocal:"
				+"\n- Rua: "+local.getRua()
				+"\n- Nº: "+local.getNrResidencia()
				+"\n- Cidade: "+local.getCidade()
				+"\n- UF: "+local.getUf();
	}
	
	public void setAgua(Hidrometro agua) {
		this.agua = agua;
	}

	public void setEnergia(MedidorEnergia energia) {
		this.energia = energia;
	}

	public void setLocal(Endereco local) {
		this.local = local;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public Endereco getLocal() {
		return local;
	}

	public Hidrometro getAgua() {
		return agua;
	}

	public MedidorEnergia getEnergia() {
		return energia;
	}
	
	public Solucoes getSolucoes() {
		return this.solucoes;
	}
	
}
