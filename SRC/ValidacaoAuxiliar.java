import javax.swing.JOptionPane;
import java.util.*;

public class ValidacaoAuxiliar {
	private TarefasComProcura t;
	private Vector vectr;
	private VectorServico vs;
	private Gravacao g;

	public ValidacaoAuxiliar() {

		t = new TarefasComProcura();
		vs = new VectorServico();
		vectr = vs.getVector();
		g = new Gravacao();
	}

	public String valSector(int indice) {
		String s = "";
		if (indice == 0) {
			s = "";
		} else {
			if (indice == 1) {
				s = "Construcao";

			} else {
				if (indice == 2) {
					s = "Domesticos";

				} else {
					if (indice == 3) {
						s = "Eletricos e Hidiricos";
					} else {
						if (indice == 4) {
							s = "Informatica";

						}

					}
				}
			}
		}
		return s;

	}

	public String valTipoContracto(int index) {
		String p = "";
		if (index == 0) {
			p = "Diario";

		} else {
			if (index == 1) {
				p = "Semanal";

			} else {
				if (index == 2) {
					p = "Mensal";

				}
			}

		}

		return p;
	}

	public long valContacto(long contacto) {
		long valor = 0;

		if (contacto < 820000000 || contacto > 870000000) {
			valor = 0;

		} else {
			valor = contacto;

		}

		return valor;

	}

	public String valCod(String codigo) {
		String s = " ";
		boolean letra = false, numeros = false, a = false, b = false, c = false;
		char letter1 = ' ', ifen = ' ', letter2 = ' ', number1 = ' ', number2 = ' ', number3 = ' ';
		char x[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		if (codigo.length() != 6) {
			s = " ";
		} else {

			int h = t.procurarCliente(vectr, codigo);
			if (h == -1) {
				s = codigo;

			} else {

				s = " ";
			}
		}
		return s;
	}

	public String valBi(String id) {
		String s = "";
		char letra = ' ';
		char l[] = { 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f',
				'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l',
				'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r',
				'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x',
				'X', 'y', 'Y', 'z', 'Z' }, x[] = { '0', '1', '2', '3', '4',
				'5', '6', '7', '8', '9' };
		boolean o = false, j = false;

		if (id.length() != 13) {
			s = "";
		} else {
			letra = id.charAt(id.length() - 1);
			for (int i = 0; i < l.length; i++) {
				if (letra == l[i]) {
					o = true;

				}

			}
			for (int p = 0; p < id.length() - 1; p++) {
				j = false;
				for (int k = 0; k < x.length; k++) {
					if (id.charAt(p) == x[k]) {
						j = true;
					}
				}
			}

			if (o == true && j == true) {
				s = id;
			}

		}

		return s;

	}

	public String valServico(int indice, int indiceCons, int indiceDom,
			int indiceEh, int indiceInfo) {
		String s = " ";

		if (indice == 1) {
			if (indiceCons == 0) {
				s = " ";
			} else {
				if (indiceCons == 1) {
					s = "Pedreiro";
				} else {
					if (indiceCons == 2) {
						s = "Pintor";
					}
				}
			}
		} else {

			if (indice == 2) {
				if (indiceDom == 0) {
					s = " ";
				} else {
					if (indiceDom == 1) {
						s = "Baba";
					} else {
						if (indiceDom == 2) {
							s = "Empregada";
						} else {
							if (indiceDom == 3) {
								s = "Jardineiro";
							} else {
								if (indiceDom == 4) {
									s = "Cozinheiro";
								}
							}

						}

					}
				}

			}

			else {

				if (indice == 3) {
					if (indiceEh == 0) {
						s = " ";
					} else {
						if (indiceEh == 1) {
							s = "Instalacao";
						} else {
							if (indiceEh == 2) {
								s = "Canalizacao";
							}
						}
					}

				}

				else {

					if (indice == 4) {
						if (indiceInfo == 0) {
							s = " ";
						} else {
							if (indiceInfo == 1) {
								s = "Redes";
							} else {
								if (indiceInfo == 2) {
									s = "Manutencao";
								} else {
									if (indiceInfo == 3) {
										s = "Reparacao";
									} else {
										if (indiceInfo == 4) {
											s = "Montagem";

										}
									}

								}

							}
						}

					}
				}
			}

		}

		return s;

	}

	public float valorPagando(String cod) {
		float soma = 0;
		Cliente c;
		Servico s;
		vectr = vs.getVector();
		g.gravarUltimo(vectr);
		JOptionPane.showMessageDialog(null, "Gravado com Sucesso");
		vs.lerTxt();
		boolean procura = false;

		for (int i = 0; i < vectr.size(); i++) {
			s = (Servico) vectr.elementAt(i);
			if (s instanceof Cliente) {
				c = (Cliente) s;
				if (cod.equalsIgnoreCase(c.getCodigo())) {
					soma += c.valor();
					procura = true;

				}
			}
		}

		if (!procura) {
			JOptionPane.showMessageDialog(null, "Codigo nao Encontrado");

		} else {
			JOptionPane.showMessageDialog(null, "Codigo Encontrado");
		}

		return soma;
	}

}
