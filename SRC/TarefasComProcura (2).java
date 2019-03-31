import java.util.Vector;

import javax.swing.JOptionPane;

public class TarefasComProcura {
	public TarefasComProcura() {
	}

	public int procurarCliente(Vector vector, String cliente) {
		int n = -1;
		Servico serv;
		Cliente aux;
		for (int i = 0; i < vector.size(); i++) {
			serv = (Servico) vector.elementAt(i);
			if (serv instanceof Cliente) {
				aux = (Cliente) serv;
				if (aux.getCodigo().equalsIgnoreCase(cliente))
					n = i;
			}
		}
		return n;
	}

	public int procurarFuncionario(Vector vector, String funcionario) {
		int n = -1;
		Servico serv;
		Funcionario aux;
		for (int i = 0; i < vector.size(); i++) {
			serv = (Servico) vector.elementAt(i);
			if (serv instanceof Funcionario) {
				aux = (Funcionario) serv;
				if (aux.getCodigo().equalsIgnoreCase(funcionario))
					n = i;
			}
		}
		return n;
	}

	public int procurarFornecedor(Vector vector, String fornecedor) {
		int n = -1;
		Servico serv;
		Fornecedor aux;
		for (int i = 0; i < vector.size(); i++) {
			serv = (Servico) vector.elementAt(i);
			if (serv instanceof Fornecedor) {
				aux = (Fornecedor) serv;
				if (aux.getCodigo().equalsIgnoreCase(fornecedor))
					n = i;
			}
		}
		return n;
	}

	public void removerCliente(Vector vec, String codigoCliente) {
		int posicao = procurarCliente(vec, codigoCliente);
		if (posicao != -1) {
			vec.removeElementAt(posicao);
			JOptionPane.showMessageDialog(null, "O Cliente com o codigo "
					+ codigoCliente + " foi removido com sucesso do sistema!");
		} else
			JOptionPane.showMessageDialog(null, "O cliente com o codigo "
					+ codigoCliente + " não foi encontrado!");
	}

	public void removerFuncionario(Vector vec, String codigoFuncionario) {
		int posicao = procurarFuncionario(vec, codigoFuncionario);
		if (posicao != -1) {
			vec.removeElementAt(posicao);
			JOptionPane.showMessageDialog(null, "O Funcionario com o codigo "
					+ codigoFuncionario
					+ " foi removido com sucesso do sistema!");
		} else
			JOptionPane.showMessageDialog(null, "O funcionario com o codigo "
					+ codigoFuncionario + " não foi encontrado!");
	}

	public void removerFornecedor(Vector vec, String codigoFornecedor) {
		int posicao = procurarFornecedor(vec, codigoFornecedor);
		if (posicao != -1) {
			vec.removeElementAt(posicao);
			JOptionPane.showMessageDialog(null, "O Funcionario com o codigo " + codigoFornecedor
					+ " foi removido com sucesso do sistema!");
		} else
			JOptionPane.showMessageDialog(null, "O Fornecedor com o codigo " + codigoFornecedor
					+ " não foi encontrado!");
	}
}
