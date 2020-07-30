
public class Medidas {
	
	private String titleMedida, descMedida;
	private double consumoAntes, consumoApos;
	
	public Medidas(String titleMedida, String descMedida, double consumoAntes, double consumoApos) {
		this.titleMedida = titleMedida;
		this.descMedida = descMedida;
		this.consumoAntes = consumoAntes;
		this.consumoApos = consumoApos;
	}

	public String getTitleMedida() {
		return titleMedida;
	}

	public void setTitleMedida(String titleMedida) {
		this.titleMedida = titleMedida;
	}

	public String getDescMedida() {
		return descMedida;
	}

	public void setDescMedida(String descMedida) {
		this.descMedida = descMedida;
	}

	public double getConsumoAntes() {
		return consumoAntes;
	}

	public void setConsumoAntes(double consumoAntes) {
		this.consumoAntes = consumoAntes;
	}

	public double getConsumoApos() {
		return consumoApos;
	}

	public void setConsumoApos(double consumoApos) {
		this.consumoApos = consumoApos;
	}


	
}
