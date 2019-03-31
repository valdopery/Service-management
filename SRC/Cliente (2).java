public final class Cliente extends Individuo {

	public static int qtdClientes = 0;
	private String tipoContrato;

	public Cliente(String area, float preco, String tipoServico, String codigo,
			String nome, long contacto, String endereco, String bi,
			String tipoContrato) {
		super(area, preco, tipoServico, codigo, nome, contacto, endereco, bi,
				"Maputo");

		this.tipoContrato = tipoContrato;
		qtdClientes++;
	}

	public Cliente() {
		this("", 0, "", "", "", (long) 0, "", "", "");
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	// Calcula o valor a pagar por serviço
	public float valor() {
		float val = 0;
		final byte EMPREGADODOMESTICO = 19;
		final byte JARDINEIRO = 19;
		final byte BABA = 19;
		final short COZINHEIRO = 250;
		final short PINTOR = 140;
		final short INSTALACAOELECTRICA = 140;
		final byte MANUTENCAOCOMPUTADORES = 90;
		final byte CANALIZACAO = 80;
		final byte PEDREIROS = 100;
		final short REDES = 300;
		final short MONTAGEMDECOMPUTADORES = 180;
		final short REPARACAODECOMPUTADORES = 180;
		final byte INSTALACAODESOFTWARE = 120;

		if (tipoContrato.equalsIgnoreCase("Diario")) {
			if (tipoServico.equalsIgnoreCase("Empregada Domestica"))
				val = EMPREGADODOMESTICO * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("JARDINEIRO"))
				val = JARDINEIRO * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("Baba"))
				val = BABA * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("COZINHEIRO"))
				val = COZINHEIRO * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("PINTOR"))
				val = PINTOR * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("Instalacao Eletrica"))
				val = INSTALACAOELECTRICA * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("Manutencao de Computador"))
				val = MANUTENCAOCOMPUTADORES * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("Canalizacao"))
				val = CANALIZACAO * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("Pedreiros"))
				val = PEDREIROS * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("Redes"))
				val = REDES * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("Montagem de Computador"))
				val = MONTAGEMDECOMPUTADORES * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("Reparacao de Computador"))
				val = REPARACAODECOMPUTADORES * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("Instalacao de Software"))
				val = INSTALACAODESOFTWARE * 8 * TAXACONTRACTO;

		} else if (tipoContrato.equalsIgnoreCase("Semanal")) {
			if (tipoServico.equalsIgnoreCase("Empregada Domestica"))
				val = EMPREGADODOMESTICO * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("JARDINEIRO"))
				val = JARDINEIRO * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("Baba"))
				val = BABA * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("COZINHEIRO"))
				val = COZINHEIRO * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("PINTOR"))
				val = PINTOR * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("Instalacao Eletrica"))
				val = INSTALACAOELECTRICA * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("Manutencao de Computador"))
				val = MANUTENCAOCOMPUTADORES * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("Canalizacao"))
				val = CANALIZACAO * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("Pedreiros"))
				val = PEDREIROS * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("Redes"))
				val = REDES * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("Montagem de Computador"))
				val = MONTAGEMDECOMPUTADORES * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("Reparacao de Computador"))
				val = REPARACAODECOMPUTADORES * 8 * TAXACONTRACTO * 6;
			else if (tipoServico.equalsIgnoreCase("Instalacao de Software"))
				val = INSTALACAODESOFTWARE * 8 * TAXACONTRACTO * 6;

		} else if (tipoContrato.equalsIgnoreCase("Mensal")) {
			if (tipoServico.equalsIgnoreCase("Empregada Domestica"))
				val = EMPREGADODOMESTICO * 8 * TAXACONTRACTO;
			else if (tipoServico.equalsIgnoreCase("JARDINEIRO"))
				val = JARDINEIRO * 8 * TAXACONTRACTO * 24;
			else if (tipoServico.equalsIgnoreCase("Baba"))
				val = BABA * 8 * TAXACONTRACTO * 24;
			else if (tipoServico.equalsIgnoreCase("COZINHEIRO"))
				val = COZINHEIRO * 8 * TAXACONTRACTO * 24;
			else if (tipoServico.equalsIgnoreCase("PINTOR"))
				val = PINTOR * 8 * TAXACONTRACTO * 24;
			else if (tipoServico.equalsIgnoreCase("Instalacao Eletrica"))
				val = INSTALACAOELECTRICA * 8 * TAXACONTRACTO * 24;
			else if (tipoServico.equalsIgnoreCase("Manutencao de Computador"))
				val = MANUTENCAOCOMPUTADORES * 8 * TAXACONTRACTO * 24;
			else if (tipoServico.equalsIgnoreCase("Canalizacao"))
				val = CANALIZACAO * 8 * TAXACONTRACTO * 24;
			else if (tipoServico.equalsIgnoreCase("Pedreiros"))
				val = PEDREIROS * 8 * TAXACONTRACTO * 24;
			else if (tipoServico.equalsIgnoreCase("Redes"))
				val = REDES * 8 * TAXACONTRACTO * 24;
			else if (tipoServico.equalsIgnoreCase("Montagem de Computador"))
				val = MONTAGEMDECOMPUTADORES * 8 * TAXACONTRACTO * 24;
			else if (tipoServico.equalsIgnoreCase("Reparacao de Computador"))
				val = REPARACAODECOMPUTADORES * 8 * TAXACONTRACTO * 24;
			else if (tipoServico.equalsIgnoreCase("Instalacao de Software"))
				val = INSTALACAODESOFTWARE * 8 * TAXACONTRACTO * 24;
		}
		return val;
	}

	public String toString() {
		return super.toString()+String.format("%19s%c\n",tipoContrato,'|');
	}
}