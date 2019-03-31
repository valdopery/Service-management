public final class Funcionario extends Individuo  {

	public static int qtdFuncionarios = 0;
	private short anoAdmissao;
	private char genero;
	private String nivelAcademico;
	private byte idade;

	public Funcionario(String area, float preco, String tipoServico,
			String codigo, String nome, long contacto, String endereco,
			String bi, short anoAdmissao, char genero, String nivelAcademico,
			byte idade) {

		super(area, preco, tipoServico, codigo, nome, contacto, endereco, bi,
				"Maputo");

		this.anoAdmissao = anoAdmissao;
		this.genero = genero;
		this.idade = idade;
		this.nivelAcademico = nivelAcademico;

		qtdFuncionarios++;
	}

	public Funcionario() {
		this("", 0, "", "", "", (long) 0, " ", "", (short) 0, ' ', "", (byte) 0);
	}

	public short getAnoAdmissao() {
		return anoAdmissao;
	}

	public char getGenero() {
		return genero;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public byte getIdade() {
		return idade;
	}

	public void setIdade(byte idade) {
		this.idade = idade;
	}

	public void setAnoAdmissao(short anoAdmissao) {
		this.anoAdmissao = anoAdmissao;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public float valor(String nivelAcademico, String area) {
		float v = 0;

		final float TAXABACHARELATO = (float) 0.15;
		final float TAXALICENCIADO = (float) 0.20;
		final float TAXATECNICO = (float) 0.10;
		final byte EMPREGADODOMESTICO = 19;
		final byte JARDINEIRO = 19;
		final byte BABA = 19;
		final short COZINHEIRO = 250;
		final short PINTOR = 140;
		final short INSTALACAOELECTRICA = 140;
		final byte MANUTENCAOELECTRICA = 90;
		final byte CANALIZACAO = 80;
		final byte PEDREIROS = 100;
		final short REDES = 300;
		final short MONTAGEMDECOMPUTADORES = 180;
		final short REPARACAODECOMPUTADORES = 180;
		final byte INSTALACAODESOFTWARE = 120;

		if (nivelAcademico.equalsIgnoreCase("Licenciado")) {
			if (tipoServico.equalsIgnoreCase("Instalacao de Software")) {
				v = TAXALICENCIADO * INSTALACAODESOFTWARE * 8 * 30;
			} else {
				if (tipoServico.equalsIgnoreCase("Redes")) {
				} else {
					v = TAXALICENCIADO * REDES * 24 * 8;
					if (tipoServico.equalsIgnoreCase("Instalacao Eletrica")) {
						v = TAXALICENCIADO * INSTALACAOELECTRICA * 8 * 30;
					}
				}
			}

		} else

		if (nivelAcademico.equalsIgnoreCase("Bacharelato")) {
			if (tipoServico.equalsIgnoreCase("Redes")) {
			} else {
				v = TAXABACHARELATO * REDES * 24 * 30;
				if (tipoServico.equalsIgnoreCase("Instalacao de Software")) {
				} else {
					v = TAXABACHARELATO * INSTALACAODESOFTWARE * 8 * 24;
					if (tipoServico.equalsIgnoreCase("Instalacao Eletrica")) {
						v = TAXABACHARELATO * INSTALACAOELECTRICA * 8 * 30;
					}
				}
			}
		} else

		if (nivelAcademico.equalsIgnoreCase("Tecnico")) {

			if (tipoServico.equalsIgnoreCase("Pedreiro")) {
				v = TAXATECNICO * PEDREIROS * 8 * 24;
			} else {
				if (tipoServico.equalsIgnoreCase("Cozinheiro")) {
					v = TAXATECNICO * COZINHEIRO * 8 * 24;
				} else {
					if (tipoServico.equalsIgnoreCase("Baba")) {
						v = TAXATECNICO * BABA * 8 * 24;
					} else {
						if (tipoServico.equalsIgnoreCase("Empregada Domestica")) {
							v = TAXATECNICO * EMPREGADODOMESTICO * 8 * 24;
						} else {
							if (tipoServico.equalsIgnoreCase("Canalizacao")) {
								v = TAXATECNICO * CANALIZACAO * 8 * 24;
							} else {
								if (tipoServico.equalsIgnoreCase("Pintor")) {
									v = TAXATECNICO * PINTOR * 8 * 24;
								} else {
									if (tipoServico
											.equalsIgnoreCase("Montagem de Computador")) {
										v = TAXATECNICO
												* MONTAGEMDECOMPUTADORES * 8
												* 24;
									} else {
										if (tipoServico
												.equalsIgnoreCase("Jardineiro")) {
											v = TAXATECNICO * JARDINEIRO * 8
													* 24;
										} else {
											if (tipoServico
													.equalsIgnoreCase("Manutencao Eletrica")) {
												v = TAXATECNICO
														* MANUTENCAOELECTRICA
														* 8 * 24;
											} else {
												if (tipoServico
														.equalsIgnoreCase("Reparacao de Computador")) {
													v = TAXATECNICO
															* REPARACAODECOMPUTADORES
															* 8 * 24;

												}
											}
										}

									}
								}

							}

						}

					}

				}

			}

		}

		return v;
	}

	public String toString() {
		return super.toString()
				+ String.format("%17d%c%8c%c%17s%c%7d%c\n", anoAdmissao, '|',
						genero, '|', nivelAcademico, '|', idade, '|');
	}

}