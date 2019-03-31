import java.util.Vector;

public class Ordenacao {

	public Ordenacao() {
	}

	// Ordena a idade dos Funcionarios (ordem crescente)

	private int localizaMaiorPreco(Vector v, int a) {
		int i_max = a;
		Servico s;
		Cliente t1, t2;
		for (int k = a + 1; k < v.size(); k++) {
			s = (Servico) v.elementAt(k);
			if (s instanceof Cliente) {
				t1 = (Cliente) v.elementAt(k);//
				t2 = (Cliente) v.elementAt(i_max);
				if (t1.getPreco() > t2.getPreco())
					i_max = k;
			}
		}
		return i_max;
	}

	public void ordenaCliPreco(Vector v) {
		Servico s;
		Cliente aux1, aux2;
		int i_maior = 9999, numEst = v.size();
		for (int i = 0; i < numEst - 1; i++) {
			s = (Servico) v.elementAt(i);
			if (s instanceof Cliente) {
				i_maior = localizaMaiorPreco(v, i);//
				aux1 = (Cliente) v.elementAt(i);
				aux2 = (Cliente) v.elementAt(i_maior);
				v.setElementAt(aux2, i);
				v.setElementAt(aux1, i_maior);
			}
		}
	}

	public void ordenaFornecedorQuantidade(Vector v) {
		for (int i = 0; i < v.size(); i++) {
			trocaElementos2(i, v);
		}
	}

	public void trocaElementos2(int i, Vector v) {
		Servico s;
		Servico s2;
		Fornecedor aux;
		Fornecedor aux2;
		for (int j = i; j < v.size() - 1; j++) {
			s = (Servico) v.elementAt(i);
			s2 = (Servico) v.elementAt(j + 1);

			if (s instanceof Fornecedor && s2 instanceof Fornecedor) {
				aux = (Fornecedor) s;
				aux2 = (Fornecedor) s2;
				if (aux.getQuantidade() > aux2.getQuantidade()) {
					v.setElementAt(aux2, i);
					v.setElementAt(aux, j + 1);
				}
			}
		}
	}

	public void ordenaFuncionarioIdade(Vector v) {
		for (int i = 0; i < v.size(); i++) {
			trocaElementos2Idade(i, v);
		}
	}

	public void trocaElementos2Idade(int i, Vector v) {
		Servico s;
		Servico s2;
		Funcionario aux;
		Funcionario aux2;
		for (int j = i; j < v.size() - 1; j++) {
			s = (Servico) v.elementAt(i);
			s2 = (Servico) v.elementAt(j + 1);

			if (s instanceof Funcionario && s2 instanceof Funcionario) {
				aux = (Funcionario) s;
				aux2 = (Funcionario) s2;
				if (aux.getIdade() > aux2.getIdade()) {
					v.setElementAt(aux2, i);
					v.setElementAt(aux, j + 1);
				}
			}
		}
	}

}