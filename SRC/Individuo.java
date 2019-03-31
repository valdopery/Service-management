public class Individuo extends Dados {

	protected String bi;
	protected String cidade;

	public Individuo(String area, float preco, String tipoServico,
			String codigo, String nome, long contacto, String endereco,
			String bi, String cidade) {
		super(area, preco, tipoServico, codigo, nome, contacto, endereco);
		this.bi = bi;
		this.cidade = cidade;
	}

	public Individuo() {
		this("", 0, "", "", "", (long) 0, "", "", "");
	}

	public String getBi() {
		return bi;
	}

	public void setBi(String bi) {
		this.bi = bi;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String toString() {
		return super.toString()
				+ String.format("%14s%c%12s%c", bi, '|', cidade, '|');
	}

	public float valor() {
		return 0;
	}

}
