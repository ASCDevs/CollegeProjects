import javax.swing.JOptionPane;

public class Endereco {
	private String rua,cidade,uf,nrResidencia;

	public Endereco(String nomeResponsavel) {
		String cabecalho="Cadastro endereço - "+nomeResponsavel;
		this.rua = JOptionPane.showInputDialog(cabecalho+"\nRua: ");
		this.nrResidencia = JOptionPane.showInputDialog(cabecalho+"\nNúmero do endereço: ");
		this.cidade = JOptionPane.showInputDialog(cabecalho+"\nCidade: ");
		this.uf = JOptionPane.showInputDialog(cabecalho+"\nUF: ");
		toString();
	}

	@Override
	public String toString() {
		return  rua + ", " + nrResidencia + ", " + cidade + ", " + uf;
	}

	public String getRua() {
		return rua;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getNrResidencia() {
		return nrResidencia;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setNrResidencia(String nrResidencia) {
		this.nrResidencia = nrResidencia;
	}
	
	
	
}
