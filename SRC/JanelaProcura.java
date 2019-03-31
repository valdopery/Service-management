import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class JanelaProcura {
}

class ProcuraCliente extends JFrame {
	private JButton btnOk, btnLimpar;
	private JTextField txtCodigo;
	private Vector auxVec;
	private Container c;

	public ProcuraCliente(Vector v) {
		super("Procurar Cliente");
		c = getContentPane();
		auxVec = v;
		btnOk = new JButton("OK");
		btnLimpar = new JButton("Limpar");
		txtCodigo = new JTextField();
		c.add(txtCodigo);
		c.add(btnOk);
		c.add(btnLimpar);
		setVisible(true);
		setLocation(36, 60);
		setSize(1300, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private class EventosButoes implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			if (ae.getSource() == btnOk) {
				String cod = "FS-";
				int posicao = -1;
				cod += txtCodigo.getText();
				TarefasComProcura tf = new TarefasComProcura();
				posicao = tf.procurarCliente(auxVec, cod);
				if (posicao != 1) {
					VisCliente vC = new VisCliente(auxVec, posicao);
				} else {
					JOptionPane.showMessageDialog(null, "O código " + cod
							+ " não foi associado a um Fornecedor");
				}
			}
			if (ae.getSource() == btnLimpar) {
				txtCodigo.setText("");
			}
		}
	}
}

class ProcuraFuncionario extends JFrame {
	private JButton btnOk, btnLimpar;
	private JTextField txtCodigo;
	private Vector auxVec;
	private Container c;

	public ProcuraFuncionario(Vector v) {
		super("Procurar Funcionario");
		c = getContentPane();
		auxVec = v;
		btnOk = new JButton("OK");
		btnLimpar = new JButton("Limpar");
		txtCodigo = new JTextField();
	}

	private class EventosButoes implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			if (ae.getSource() == btnOk) {
				String cod = "FS-";
				int posicao = -1;
				cod += txtCodigo.getText();
				TarefasComProcura tf = new TarefasComProcura();
				posicao = tf.procurarFuncionario(auxVec, cod);
				if (posicao != 1) {
					Servico s;
					Funcionario f;
					s = (Servico) auxVec.elementAt(posicao);

				} else {
					JOptionPane.showMessageDialog(null, "O código " + cod
							+ " não foi associado a um Fornecedor");
				}

			}
			if (ae.getSource() == btnLimpar) {
				txtCodigo.setText("");
			}
		}
	}
}

class ProcuraFornecedor extends JFrame {
	private JButton btnOk, btnLimpar;
	private JTextField txtCodigo;
	private Container c;
	private Vector auxVec;

	public ProcuraFornecedor(Vector v) {
		super("Procurar Fornecedor");
		c = getContentPane();
		auxVec = v;
		btnOk = new JButton("OK");
		btnLimpar = new JButton("Limpar");
		txtCodigo = new JTextField();
	}

	private class EventosButoes implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			if (ae.getSource() == btnOk) {
				String cod = "FS-";
				int posicao = -1;
				cod += txtCodigo.getText();
				TarefasComProcura tf = new TarefasComProcura();
				posicao = tf.procurarFornecedor(auxVec, cod);
				if (posicao != 1) {
					Servico s;
					Fornecedor f;
					s = (Servico) auxVec.elementAt(posicao);

				} else {
					JOptionPane.showMessageDialog(null, "O código " + cod
							+ " não foi associado a um Fornecedor");
				}

			}
			if (ae.getSource() == btnLimpar) {
				txtCodigo.setText("");
			}
		}
	}
}