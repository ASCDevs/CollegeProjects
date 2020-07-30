import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controle {

	static ArrayList<Residencia> casas;
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Bem-vindo!"
				+"\n\nNesta aplicação você irá conseguir medir seu con-"
				+"\nsumo de água e energia, para isso siga os passos:"
				+"\n\n - Cadastre sua residência."
				+"\n - Registre as leituras de água e energia, dentro"
				+"\nde um período de 1 à 6 meses."
				+"\n - Aplique soluções sustentáveis baseado no seu"
				+"\nno seu consumo registrado."
				+"\n - Consulte e compare o consumo anterior e após as"
				+"\nsoluções."
				+"\n - Coloque na prática! Contribua com o uso racional."
				+"\n\nAtenção: as leituras são registradas no perío-"
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
			opcao =JOptionPane.showInputDialog("Uso Racional de Água e Energia: "
					+"\n1 - Cadastrar residência"
					+"\n2 - Listar residências"
					+"\n3 - Aplicar soluções de uso sustentável"
					+"\n4 - Consultar informações de uma residência"
					+"\n5 - Alterar dados de residência"
					+"\n6 - Excluir residência"
					+"\n7 - Sobre a aplicação"
					+"\n0 - Sair"
			);
			
			if(opcao.equals("1")) {
				String nome,cpf;
				
				nome = JOptionPane.showInputDialog("Digite o nome do proprietário: ");
				cpf = JOptionPane.showInputDialog("Digite o CPF do proprietário: ");
				casas.add(new Residencia(nome,cpf));
			}
			if(opcao.equals("2")) {
				JOptionPane.showMessageDialog(null,"Residências cadastradas: \n"+listaResidencias());
			}
			if(opcao.equals("3")) {
				painelSelecaoCasas("Soluções de uso sustentável", "Em qual residência deseja aplicar medidas\nsustentáveis, digite o número:","3");
			}
			if(opcao.equals("4")) {
				painelSelecaoCasas("Consultar informações", "Digite o respectivo número da residência:","4");
			}
			if(opcao.equals("5")) {
				painelSelecaoCasas("Alterar dados de residência", "Digite o respectivo número da residência:","5");
			}
			if(opcao.equals("6")) {
				painelSelecaoCasas("Excluir residência", "Digite o respectivo número da residência:","6");
			}
			if(opcao.equals("7")) {
				JOptionPane.showMessageDialog(null,
						"Esta aplicação tem como intuito conscientizar\n"
						+"o usuário em fazer o uso racional da água e\n"
						+"energia em sua residência, cadastrando seu uso\n"
						+"e aplicar medidas sustentáveis para reduzir o\n"
						+"consumo, utilizando de forma mais eficiente dos\n"
						+"recursos de água e energia."
						+"\n_________________________________________\n"
						+"Trabalho de APS 3º Semestre 2020 - LPOO - CC\n"
						+"UNIP - Paraíso\n"
						+"Alunos:\n"
						+"- Alexandre Cavalcante\n"
						+"- Fabrício Oliveira\n"
						+"- Vinicius Alexandre\n"
						+"- Arthur Albuquerque");
			}
			
			
		}while(!opcao.equals("0"));
	}
	
	public static String listaResidencias() {
		String resultado ="";
		if(casas.isEmpty()) {
			resultado+="Não há residências cadastradas.";
		}else {
			int i=1;
			for(Residencia c: casas) {
				resultado+=i+" -  Endereço: "+c.getLocal()+" - Proprietário: "+c.getNomeResponsavel()+"\n";
				i+=1;
			}
		}
		
		return resultado;
	}
	
	public static void detalhaResidencia(int escolha) {
		String opcao="";
		
		do {
			opcao = JOptionPane.showInputDialog("Detalhes da "+casas.get(escolha-1).toString()
					+"\n1 - Ver detalhes de consumo de água"
					+"\n2 - Ver detalhes de consumo de energia"
					+"\n3 - Ver soluções sustentáveis aplicadas"
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
								String detalhes = "\nProprietário: "+casas.get(Integer.parseInt(escolha)-1).getNomeResponsavel()+"\nEndereço: "+casas.get(Integer.parseInt(escolha)-1).getLocal();
								casas.remove(Integer.parseInt(escolha)-1);
								JOptionPane.showMessageDialog(null,"A residência foi excluída!\n\nDetalhes:"+detalhes);
							}
							
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Digite um número dentre as opções!");
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "ERRO! Número inválido!\nDetalhes:\n"+e.getMessage());
				}
				
			}while(!escolha.equals("0"));		
		}
	}
	

}
