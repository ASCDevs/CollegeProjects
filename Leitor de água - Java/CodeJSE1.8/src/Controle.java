import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controle {

	static ArrayList<Residencia> casas;
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Bem-vindo!"
				+"\n\nNesta aplica��o voc� ir� conseguir medir seu con-"
				+"\nsumo de �gua e energia, para isso siga os passos:"
				+"\n\n - Cadastre sua resid�ncia."
				+"\n - Registre as leituras de �gua e energia, dentro"
				+"\nde um per�odo de 1 � 6 meses."
				+"\n - Aplique solu��es sustent�veis baseado no seu"
				+"\nno seu consumo registrado."
				+"\n - Consulte e compare o consumo anterior e ap�s as"
				+"\nsolu��es."
				+"\n - Coloque na pr�tica! Contribua com o uso racional."
				+"\n\nAten��o: as leituras s�o registradas no per�o-"
				+"\ndo de 10 em 10 dias.");
		try {
			casas =  new ArrayList<Residencia>();
			listaMenu();
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro!"+erro.getMessage());
		}
	}
	
	public static void listaMenu() {
		String opcao;
		do {
			opcao =JOptionPane.showInputDialog("Uso Racional de �gua e Energia: "
					+"\n1 - Cadastrar resid�ncia"
					+"\n2 - Listar resid�ncias"
					+"\n3 - Aplicar solu��es de uso sustent�vel"
					+"\n4 - Consultar informa��es de uma resid�ncia"
					+"\n5 - Alterar dados de resid�ncia"
					+"\n6 - Excluir resid�ncia"
					+"\n7 - Sobre a aplica��o"
					+"\n0 - Sair"
			);
			
			if(opcao.equals("1")) {
				String nome,cpf;
				
				nome = JOptionPane.showInputDialog("Digite o nome do propriet�rio: ");
				cpf = JOptionPane.showInputDialog("Digite o CPF do propriet�rio: ");
				casas.add(new Residencia(nome,cpf));
			}
			if(opcao.equals("2")) {
				JOptionPane.showMessageDialog(null,"Resid�ncias cadastradas: \n"+listaResidencias());
			}
			if(opcao.equals("3")) {
				painelSelecaoCasas("Solu��es de uso sustent�vel", "Em qual resid�ncia deseja aplicar medidas\nsustent�veis, digite o n�mero:","3");
			}
			if(opcao.equals("4")) {
				painelSelecaoCasas("Consultar informa��es", "Digite o respectivo n�mero da resid�ncia:","4");
			}
			if(opcao.equals("5")) {
				painelSelecaoCasas("Alterar dados de resid�ncia", "Digite o respectivo n�mero da resid�ncia:","5");
			}
			if(opcao.equals("6")) {
				painelSelecaoCasas("Excluir resid�ncia", "Digite o respectivo n�mero da resid�ncia:","6");
			}
			if(opcao.equals("7")) {
				JOptionPane.showMessageDialog(null,
						"Esta aplica��o tem como intuito conscientizar\n"
						+"o usu�rio em fazer o uso racional da �gua e\n"
						+"energia em sua resid�ncia, cadastrando seu uso\n"
						+"e aplicar medidas sustent�veis para reduzir o\n"
						+"consumo, utilizando de forma mais eficiente dos\n"
						+"recursos de �gua e energia."
						+"\n_________________________________________\n"
						+"Trabalho de APS 3� Semestre 2020 - LPOO - CC\n"
						+"UNIP - Para�so\n"
						+"Alunos:\n"
						+"- Alexandre Cavalcante\n"
						+"- Fabr�cio Oliveira\n"
						+"- Vinicius Alexandre\n"
						+"- Arthur Albuquerque");
			}
			
			
		}while(!opcao.equals("0"));
	}
	
	public static String listaResidencias() {
		String resultado ="";
		if(casas.isEmpty()) {
			resultado+="N�o h� resid�ncias cadastradas.";
		}else {
			int i=1;
			for(Residencia c: casas) {
				resultado+=i+" -  Endere�o: "+c.getLocal()+" - Propriet�rio: "+c.getNomeResponsavel()+"\n";
				i+=1;
			}
		}
		
		return resultado;
	}
	
	public static void detalhaResidencia(int escolha) {
		String opcao="";
		
		do {
			opcao = JOptionPane.showInputDialog("Detalhes da "+casas.get(escolha-1).toString()
					+"\n1 - Ver detalhes de consumo de �gua"
					+"\n2 - Ver detalhes de consumo de energia"
					+"\n3 - Ver solu��es sustent�veis aplicadas"
					+"\n0 - Voltar");
			if(opcao.equals("1")) {
				JOptionPane.showMessageDialog(null, casas.get(escolha-1).getAgua().toString());
			}
			if(opcao.equals("2")) {
				JOptionPane.showMessageDialog(null, casas.get(escolha-1).getEnergia().toString());
			}
			if(opcao.equals("3")) {
				JOptionPane.showMessageDialog(null, casas.get(escolha-1).getSolucoes().medidasTomadas(casas.get(escolha-1).getAgua(), casas.get(escolha-1).getEnergia()));
			}
			
		}while(!opcao.equals("0"));
	}
	
	public static void painelSelecaoCasas(String titleOpcao, String descOpcao, String itemMenu) {
		if(casas.isEmpty()) {
			JOptionPane.showMessageDialog(null, titleOpcao+"\n"+listaResidencias());
		}else {
			String escolha="";
			do {
				try {
					escolha = JOptionPane.showInputDialog(titleOpcao+"\n"+descOpcao+"\n"+listaResidencias()+"\n0 - Voltar");
					if(Integer.parseInt(escolha)>=0&&Integer.parseInt(escolha)<=casas.size()) {
						if(Integer.parseInt(escolha)!=0){
							
							if(itemMenu.equals("3")) {
								casas.get(Integer.parseInt(escolha)-1).aplicaSolucoes();
							}
							if(itemMenu.equals("4")) {
								detalhaResidencia(Integer.parseInt(escolha));
							}
							if(itemMenu.equals("5")) {
								casas.get(Integer.parseInt(escolha)-1).alterarDados();
							}
							if(itemMenu.equals("6")) {
								String detalhes = "\nPropriet�rio: "+casas.get(Integer.parseInt(escolha)-1).getNomeResponsavel()+"\nEndere�o: "+casas.get(Integer.parseInt(escolha)-1).getLocal();
								casas.remove(Integer.parseInt(escolha)-1);
								JOptionPane.showMessageDialog(null,"A resid�ncia foi exclu�da!\n\nDetalhes:"+detalhes);
							}
							
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Digite um n�mero dentre as op��es!");
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "ERRO! N�mero inv�lido!\nDetalhes:\n"+e.getMessage());
				}
				
			}while(!escolha.equals("0"));		
		}
	}
	

}
