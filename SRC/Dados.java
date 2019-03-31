public class Dados extends Servico implements ContratoInterface {
	protected String codigo, nome, endereco;
	protected long contacto;

	public Dados(String area, float preco, String tipoServico, String codigo,
			String nome, long contacto, String endereco) {
		super(area, preco, tipoServico);
		this.codigo = codigo;
		this.nome = nome;
		this.contacto = contacto;
		this.endereco = endereco;
	}

	public Dados() {
		this("", 0, "", "", "", (long) 0, "");
	}

	public float valor() {
		return 0;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getContacto() {
		return contacto;
	}

	public void setContacto(long contacto) {
		this.contacto = contacto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String toString() {
		return super.toString()
				+ String.format("%8s%c%40s%c%10d%c%50s%c", codigo, '|', nome,
						'|', contacto, '|', endereco,'|');
	}

}