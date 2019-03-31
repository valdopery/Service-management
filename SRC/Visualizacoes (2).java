import java.util.Vector;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Visualizacoes {
	DecimalFormat mt;

	public Visualizacoes() {
		mt = new DecimalFormat("###,###.00 Mt");
	}

	public String visServico() {
		return "\nConstrucoes\tDomesticos\tEletrica/Hidricos\tInformatica\nPedreiro\tBaba\t\tInstalacao\t\tRedes\nPintor\t\tEmpregada\tCanalizacao\t\tManutencao\n\t\tJardineiro\t\t\t\tReparacao\n\t\t\t\t\t\t\tMontagem";
	}

	public String cabecalhoCliente() {
		String c = "";
		c += "=============================================================================================================================================================================================================================\n";
		c += "|==================================================================================Dados de Cliente==========================================================================================================================|\n";
		c += "|============================================================================================================================================================================================================================|\n";
		c += "|         Area      |      Tipo de Servico      |    Preco   | Codigo |              Nome do Cliente           | Contacto |                    Endereco                      | Numero de BI |   Cidade   | Tipo de Contracto |\n";
		c += "|============================================================================================================================================================================================================================|\n";
		return c;
	}

	public String cabecalhoFuncionario() {
		String f = "";
		f += "==============================================================================================================================================================================================================================================================\n";
		f += "|======================================================================================Dados de Funcionario===================================================================================================================================================|\n";
		f += "|=============================================================================================================================================================================================================================================================|\n";
		f += "|         Area      |      Tipo de Servico      |    Preco   | Codigo |            Nome do Funcionario         | Contacto |                    Endereco                      | Numero de BI |   Cidade   | Ano de Admissao | Genero | Nivel Academico | Idade |\n";
		f += "|=============================================================================================================================================================================================================================================================|\n";
		return f;
	}

	public String cabecalhoFornecedor() {
		String fo = "";
		fo += "============================================================================================================================================================================================================\n";
		fo += "|==================================================================================Dados de Fornecedor======================================================================================================|\n";
		fo += "|===========================================================================================================================================================================================================|\n";
		fo += "|         Area      |      Tipo de Servico      |    Preco   | Codigo |            Nome do Fornecedor          | Contacto |                    Endereco                      |   Equipamento   | Quantidade |\n";
		fo += "|===========================================================================================================================================================================================================|\n";
		return fo;
	}

	public String toString(Vector vec) {
		String s = "", sC = cabecalhoCliente(), sF = cabecalhoFuncionario(), sFo = cabecalhoFornecedor();
		Servico d;
		Cliente c;
		Funcionario f;
		Fornecedor fo;
		for (int i = 0; i < vec.size(); i++) {
			d = (Servico) vec.elementAt(i);
			if (d instanceof Cliente) {
				c = (Cliente) d;
				sC += c.toString();
			} else if (d instanceof Funcionario) {
				f = (Funcionario) d;
				sF += f.toString();
			} else if (d instanceof Fornecedor) {
				fo = (Fornecedor) d;
				sFo += fo.toString();
			}
		}
		sC += "==============================================================================================================================================================================================================================\n";
		sF += "===============================================================================================================================================================================================================================================================\n";
		sFo += "=============================================================================================================================================================================================================\n";

		s += sC + "\n" + sF + "\n" + sFo;
		return s;
	}

	public void VerValores(float redes, float pedre, float instalacao,
			float manute, float eDomestica, float baba, float jardine,
			float pintor, float cozi, float reparacao, float mont, float canaliz) {
		JOptionPane
				.showMessageDialog(null,
						"Valor recebido por cada servico:\n" + "Redes: "
								+ redes
								+ "\nPedreiro: "
								+ pedre
								+ "\nInstalacao: "
								+ instalacao
								+ "\nManutencao: "
								+ manute
								+ "\nDomestica: "
								+ eDomestica
								+ "\nBaba: "
								+ baba
								+ "\nJardineiro: "
								+ jardine
								+ "\nPintor: "
								+ pintor
								+ "\nConzinheiro: "
								+ cozi
								+ "\nReparacao: "
								+ reparacao
								+ "\nCanalizacao: "
								+ canaliz
								+ "\n\nTotal: "
								+ (redes + pedre + instalacao + manute
										+ eDomestica + baba + jardine + pintor
										+ cozi + reparacao + canaliz));
	}

	public String vizualizarFornecedores(Vector v) {
		String p = cabecalhoFornecedor();
		Servico k;
		Fornecedor f;
		for (int i = 0; i < v.size(); i++) {
			k = (Servico) v.elementAt(i);
			if (k instanceof Fornecedor) {
				f = (Fornecedor) k;
				p += f.toString();
			}
		}
		p += "=============================================================================================================================================================================================================\n";
		return p;
	}

	public String vizualizarFuncionarios(Vector l) {
		String s = cabecalhoFuncionario();
		Servico d;
		Funcionario fn;

		for (int i = 0; i < l.size(); i++) {
			d = (Servico) l.elementAt(i);
			if (d instanceof Funcionario) {
				fn = (Funcionario) d;
				s += fn.toString();
			}
		}
		s += "===============================================================================================================================================================================================================================================================\n";

		return s;
	}

	public String vizualizarClientes(Vector v) {
		String k = cabecalhoCliente();
		Servico s;
		Cliente c;
		for (int i = 0; i < v.size(); i++) {
			s = (Servico) v.elementAt(i);
			if (s instanceof Cliente) {
				c = (Cliente) s;
				k += c.toString();
			}
		}
		k += "==============================================================================================================================================================================================================================\n";
		return k;
	}

	public String vizualizarFuncPesquisado(Vector v, String funcionario) {

		Funcionario f;
		Servico se;
		boolean j = false;
		String s = "";
		for (int i = 0; i < v.size(); i++) {
			se = (Servico) v.elementAt(i);
			if (se instanceof Funcionario) {
				f = (Funcionario) se;
				if (f.getCodigo().equalsIgnoreCase(funcionario)) {
					s = cabecalhoFuncionario();
					j = true;
					s += f.toString();
					s += "===============================================================================================================================================================================================================================================================\n";

				}
			}
		}
		if (!j) {
			s = "Funcionario de Codigo:" + funcionario + " nao encontrado";
		}
		return s;

	}

	public void areasValores(float inf, float domestico, float construa) {
		System.out.println("Valor pago pelos Clientes em info:"
				+ mt.format(inf));
		System.out.println("Valor pago pelos Clientes em domesticos:"
				+ mt.format(domestico));
		System.out.println("Valor pago pelos Clientes em construcao:"
				+ mt.format(construa));
	}

	public String vizualizarFornPesquisado(Vector z, String fornecedor) {
		Fornecedor k;
		boolean j = false;
		String s = "";
		Servico ser;
		for (int i = 0; i < z.size(); i++) {
			ser = (Servico) z.elementAt(i);
			if (ser instanceof Fornecedor) {
				k = (Fornecedor) ser;

				if (k.getCodigo().equalsIgnoreCase(fornecedor)) {
					s = cabecalhoFornecedor();
					s += k.toString();
					j = true;
					s += "=============================================================================================================================================================================================================\n";
				}
			}
		}
		if (!j) {
			s = "Fornecedor de Codigo:" + fornecedor + " nao encontrado";
		}
		return s;
	}

	public void vizualizarClientePesquisado(Vector z, int posicao) {
		Cliente c;
		Servico sw;
		sw = (Servico) z.elementAt(posicao);
		c = (Cliente) sw;

	}
}