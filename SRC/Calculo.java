import java.util.Calendar;
import java.util.Vector;
import java.text.DecimalFormat;

public class Calculo {
	private Visualizacoes o;

	public Calculo() {
		o = new Visualizacoes();
	}

	public double clienteMaisPagou(Vector v) {
		double maior = 0;
		Servico s;
		for (int i = 0; i < v.size(); i++) {
			s = (Servico) v.elementAt(i);
			if (s instanceof Cliente) {
				if (maior < s.getPreco())
					maior = s.getPreco();
			}
		}
		return maior;
	}

	// Determina o serviço mais requisitado pelos clientes
	public String ServMaisRequisitados(Vector v) {
		Cliente c;
		Servico serv;
		int contRedes = 0, contPedreiros = 0, contInstalacao = 0, contManutencao = 0, contEmpregadaD = 0, contBaba = 0, contJardineiro = 0, contPintor = 0;
		int contCozinheiro = 0, contReparacao = 0, contMontagem = 0, contCanalizacao = 0;
		String s = "";
		int maior = 0;
		for (int i = 0; i < v.size(); i++) {
			serv = (Servico) v.elementAt(i);
			if (serv instanceof Cliente) {
				c = (Cliente) serv;
				if (c.getTipoServico().equalsIgnoreCase("Redes")) {
					contRedes++;
					if (maior < contRedes)
						maior = contRedes;
				} else {
					if (c.getTipoServico().equalsIgnoreCase("Pedreiro")) {
						contPedreiros++;
						if (maior < contPedreiros)
							maior = contPedreiros;
					} else {
						if (c.getTipoServico().equalsIgnoreCase("Instalacao")) {
							contInstalacao++;
							if (maior < contInstalacao)
								maior = contInstalacao;
						} else {
							if (c.getTipoServico().equalsIgnoreCase(
									"Manutencao")) {
								contManutencao++;
								if (maior < contManutencao)
									maior = contManutencao;
							} else {
								if (c.getTipoServico().equalsIgnoreCase(
										"Empregada Domestica")) {
									contEmpregadaD++;
									if (maior < contEmpregadaD++)
										maior = contEmpregadaD;
								} else {
									if (c.getTipoServico().equalsIgnoreCase(
											"Baba")) {
										contBaba++;
										if (maior < contBaba)
											maior = contBaba;
									} else {
										if (c.getTipoServico()
												.equalsIgnoreCase("Jardineiro")) {
											contJardineiro++;
											if (maior < contJardineiro)
												maior = contJardineiro;
										} else {
											if (c.getTipoServico()
													.equalsIgnoreCase("Pintor")) {
												contPintor++;
												if (maior < contPintor)
													maior = contPintor;
											} else {
												if (c.getTipoServico()
														.equalsIgnoreCase(
																"Cozinheiro")) {
													contCozinheiro++;
													if (maior < contCozinheiro)
														maior = contCozinheiro;
												} else {
													if (c.getTipoServico()
															.equalsIgnoreCase(
																	"Reparacao")) {
														contReparacao++;
														if (maior < contReparacao)
															maior = contReparacao;
													} else {
														if (c.getTipoServico()
																.equalsIgnoreCase(
																		"Montagem")) {
															contMontagem++;
															if (maior < contMontagem)
																maior = contMontagem;
														} else {
															if (c.getTipoServico()
																	.equalsIgnoreCase(
																			"Canalizacao")) {
																contCanalizacao++;
																if (maior < contCanalizacao)
																	maior = contCanalizacao;
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
				}
			}
		}

		if (maior == contCanalizacao)
			s += "Canalizacao\n";
		if (maior == contMontagem)
			s += "Montagem\n";
		if (maior == contReparacao)
			s += "Reparacao\n";
		if (maior == contCozinheiro)
			s += "Cozinheiro\n";
		if (maior == contPintor)
			s += "Pintor\n";
		if (maior == contJardineiro)
			s += "Jardineiro\n";
		if (maior == contBaba)
			s += "Baba\n";
		if (maior == contEmpregadaD)
			s += "Empregada domestica\n";
		if (maior == contManutencao)
			s += "Manutencao\n";
		if (maior == contInstalacao)
			s += "Instalacao de software\n";
		if (maior == contPedreiros)
			s += "Pedreiro\n";
		if (maior == contRedes)
			s += "Redes";
		return s;
	}

	// Determina o sector com mais funcionários
	public String AreaComMaisFuncionarios(Vector v) {
		Funcionario f;
		Servico serv;
		int maior = 0, contInformatica = 0, contConstrucao = 0, contDomesticos = 0, contEletrica = 0;
		String s = "";
		for (int i = 0; i < v.size(); i++) {
			serv = (Servico) v.elementAt(i);
			if (serv instanceof Funcionario) {
				f = (Funcionario) serv;
				if (f.getArea().equalsIgnoreCase("Informatica")) {
					contInformatica++;
					if (maior < contInformatica)
						maior = contInformatica;
				} else {
					if (f.getArea().equalsIgnoreCase("Construcao")) {
						contConstrucao++;
						if (maior < contConstrucao)
							maior = contConstrucao;
					} else {
						if (f.getArea().equalsIgnoreCase("Domesticos")) {
							contDomesticos++;
							if (maior < contDomesticos)
								maior = contDomesticos;
						} else {
							if (f.getArea().equalsIgnoreCase(
									"Eletrica/Hidricos")) {
								contEletrica++;
								if (maior < contEletrica)
									maior = contEletrica;
							}
						}
					}
				}
			}
		}
		if (contEletrica == maior)
			s += "Electrica/Hidricos\n";
		if (contConstrucao == maior)
			s += "Construcao\n";
		if (contInformatica == maior)
			s += "Informatica\n";
		if (contDomesticos == maior)
			s += "Domestico\n";
		return s;
	}

	// Calcula o valor recebido por serviço(valor pago por todos clientes em
	// cada servico)
	public void valRecibidoPorCadaServico(Vector v) {
		Cliente c;
		Servico serv;
		float somaRedes = 0, somaPedreiros = 0, somaInstalacao = 0, somaManutencao = 0, somaEmpregadaD = 0, somaBaba = 0, somaJardineiro = 0, somaPintor = 0;
		float somaCozinheiro = 0, somaReparacao = 0, somaMontagem = 0, somaCanalizacao = 0;
		String s = "";
		int soma = 0;
		for (int i = 0; i < v.size(); i++) {
			serv = (Servico) v.elementAt(i);
			if (serv instanceof Cliente) {
				c = (Cliente) serv;
				if (c.getTipoServico().equalsIgnoreCase("Redes")) {
					somaRedes += c.valor();

				} else {
					if (c.getTipoServico().equalsIgnoreCase("Pedreiro")) {
						somaPedreiros += c.valor();

					} else {
						if (c.getTipoServico().equalsIgnoreCase("Instalacao")) {
							somaInstalacao += c.valor();

						} else {
							if (c.getTipoServico().equalsIgnoreCase(
									"Manutencao")) {

								somaManutencao += c.valor();

							} else {
								if (c.getTipoServico().equalsIgnoreCase(
										"Empregada Domestica")) {

									somaEmpregadaD += c.valor();

								} else {
									if (c.getTipoServico().equalsIgnoreCase(
											"Baba")) {
										somaBaba += c.valor();

									} else {
										if (c.getTipoServico()
												.equalsIgnoreCase("Jardineiro")) {
											somaJardineiro += c.valor();

										} else {
											if (c.getTipoServico()
													.equalsIgnoreCase("Pintor")) {
												somaPintor += c.valor();

											} else {
												if (c.getTipoServico()
														.equalsIgnoreCase(
																"Cozinheiro")) {

													somaCozinheiro += c.valor();

												} else {
													if (c.getTipoServico()
															.equalsIgnoreCase(
																	"Reparacao")) {

														somaReparacao += c
																.valor();

													} else {
														if (c.getTipoServico()
																.equalsIgnoreCase(
																		"Montagem")) {
															somaMontagem += c
																	.valor();
														} else {
															if (c.getTipoServico()
																	.equalsIgnoreCase(
																			"Canalizacao")) {
																somaCanalizacao += c
																		.valor();
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
				}
			}
		}
		o.VerValores(somaRedes, somaPedreiros, somaInstalacao, somaManutencao,
				somaEmpregadaD, somaBaba, somaJardineiro, somaPintor,
				somaCozinheiro, somaReparacao, somaMontagem, somaCanalizacao);

	}

	// Determina o funcionário com mais anos de trabalho na empresa
	public String funcMaisAnos(Vector v) {
		Calendar c = Calendar.getInstance();
		Servico s;
		Funcionario f;
		String dados = "";
		int maior = 0;
		for (int i = 0; i < v.size(); i++) {
			s = (Servico) v.elementAt(i);
			if (s instanceof Funcionario) {
				f = (Funcionario) s;
				if ((c.get(Calendar.YEAR) - f.getAnoAdmissao()) > maior)
					maior = c.get(Calendar.YEAR) - f.getAnoAdmissao();
			}
		}
		for (int i = 0; i < v.size(); i++) {
			s = (Servico) v.elementAt(i);
			if (s instanceof Funcionario) {
				f = (Funcionario) s;
				if ((c.get(Calendar.YEAR) - f.getAnoAdmissao()) == maior)
					dados += f.toString() + "\n";
			}
		}
		return dados;
	}

	// Determina quantidade de Funcionários de cada género(a é parametro para
	// letra minuscula e b para letra maiuscula)
	public int qtdGenFuncionario(Vector v, char a, char b) {
		Servico s;
		Funcionario f;
		int qtd = 0;
		for (int i = 0; i < v.size(); i++) {
			s = (Servico) v.elementAt(i);
			if (s instanceof Funcionario) {
				f = (Funcionario) s;
				if (f.getGenero() == a || f.getGenero() == b)
					qtd++;
			}
		}
		return qtd;
	}

	// Calcula o valor total recebido
	public float calcValorTotalRecebido(Vector vector) {
		Cliente cli;
		Servico s;
		float valor = 0;
		for (int i = 0; i < vector.size(); i++) {
			s = (Servico) vector.elementAt(i);
			if (s instanceof Cliente) {
				cli = (Cliente) s;
				valor += cli.valor();
			}
		}

		return valor;
	}

	// Calcula o valor recebido por sector
	public float calcValorRecebidoSector(Vector vector, String servico) {
		Cliente cli;
		Servico ser;
		float valor = 0;
		for (int i = 0; i < vector.size(); i++) {
			ser = (Servico) vector.elementAt(i);
			if (ser instanceof Cliente) {
				cli = (Cliente) vector.elementAt(i);
				if (cli.getArea().equalsIgnoreCase(servico))
					valor += cli.valor();
			}
		}

		return valor;
	}

	// Calcular a média do genero em cada sector
	public float calcMediaGen(Vector vector, char a, char b) {
		Funcionario fun;
		Servico s;
		float contM = 0, contF = 0;
		for (int i = 0; i < vector.size(); i++) {
			s = (Servico) vector.elementAt(i);
			if (s instanceof Funcionario) {
				fun = (Funcionario) s;
				contF++;
				if (fun.getGenero() == b || fun.getGenero() == b)
					contM++;
			}
		}
		return (contM / contF * 100);
	}

	// Calcula a média de clientes por serviço
	public float calcMediaClienteServico(Vector vector) {
		Cliente cli;
		Servico ser;
		float contC = 0;
		for (int i = 0; i < vector.size(); i++) {
			ser = (Servico) vector.elementAt(i);
			if (ser instanceof Cliente) {
				cli = (Cliente) ser;
				++contC;
			}
		}
		contC = contC / 4;
		return contC;
	}

	// Calcula a média de funcionários por sector
	public float calcMediaFuncionarioSector(Vector vector) {
		Funcionario fun;
		Servico ser;
		float contF = 0;
		for (int i = 0; i < vector.size(); i++) {
			ser = (Servico) vector.elementAt(i);
			if (ser instanceof Funcionario) {
				fun = (Funcionario) ser;
				++contF;
			}
		}
		contF = contF / 4;
		return contF;
	}

	// Calcula a idade média dos funcionários
	public float calcIdadeMediaFuncio(Vector vv) {
		float media = 0;
		int cont = 0;
		Servico ser;
		Funcionario fr;
		int ndFuncionario = vv.size();
		for (int i = 0; i < ndFuncionario; i++) {
			ser = (Servico) vv.elementAt(i);
			if (ser instanceof Funcionario) {
				fr = (Funcionario) ser;
				media += fr.getIdade();
				cont++;
			}
		}
		return media / cont;
	}

	public void valRecebidoPorArea(Vector v) {
		Cliente cl;
		Servico se;
		float acumInfo = 0, acumElectrica = 0, acumContrucao = 0, acumDomesticos = 0;
		for (int i = 0; i < v.size(); i++) {
			se = (Servico) v.elementAt(i);
			if (se instanceof Cliente) {
				cl = (Cliente) se; // manutencao de computador,redes,montagem de
									// computador,reparacao de computadores
				if (cl.getArea().equalsIgnoreCase("Informatica")) {
					if (cl.getTipoServico().equalsIgnoreCase("Redes"))
						acumInfo += cl.valor();
					else if (cl.getTipoServico().equalsIgnoreCase("Instalacao"))
						acumInfo += cl.valor();
					else if (cl.getTipoServico().equalsIgnoreCase(
							"Manutencao de computador"))
						acumInfo += cl.valor();

				} else if (cl.getArea().equalsIgnoreCase("Domesticos")) {
					if (cl.getTipoServico().equalsIgnoreCase(
							"Empregada Domestica"))
						acumDomesticos += cl.valor();
					else if (cl.getTipoServico().equalsIgnoreCase("Baba"))
						acumDomesticos += cl.valor();
					else if (cl.getTipoServico().equalsIgnoreCase("Cozinheiro"))
						acumDomesticos += cl.valor();
					else if (cl.getTipoServico().equalsIgnoreCase("Jardineiro"))
						acumDomesticos += cl.valor();

				} else if (cl.getArea().equalsIgnoreCase("Construcao")) {
					if (cl.getTipoServico().equalsIgnoreCase("Pedreiro"))
						acumContrucao += cl.valor();
					else if (cl.getTipoServico().equalsIgnoreCase("Pintor"))
						acumContrucao += cl.valor();
					else if (cl.getTipoServico()
							.equalsIgnoreCase("Canalizacao"))
						acumContrucao += cl.valor();
				}
			}
		}
		o.areasValores(acumInfo, acumDomesticos, acumContrucao);
	}

}
