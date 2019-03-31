public final class Fornecedor extends Dados {

	public static int qtdFornecedores = 0;
	private String equipamento;
	private short quantidade;

	public Fornecedor(String area, float preco, String tipoServico,
			String codigo, String nome, long contacto, String endereco,
			String equipamento, short quantidade) {
		super(area, preco, tipoServico, codigo, nome, contacto, endereco);
		this.equipamento = equipamento;
		this.quantidade = quantidade;
		qtdFornecedores++;
	}

	public Fornecedor() {
		this(" ", 0, " ", " ", " ", (long) 0, " ", " ", (short) 0);
	}

	public String getEquipamento() {
		return equipamento;
	}

	public short getQuantidade() {
		return quantidade;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public void setQuantidade(short quantidade) {
		this.quantidade = quantidade;
	}

	public float valor() {
		return quantidade * preco;
	}

	public String toString() {
		return super.toString()
				+ String.format("%17s%c%12d%c\n", equipamento, '|', quantidade,
						'|');
	}
}