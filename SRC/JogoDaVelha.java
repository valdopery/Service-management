import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JogoDaVelha extends JFrame {
	private JLabel NumeroDeVitoriasDoJogador1, NumeroDeVitoriasDoJogador2,
			NumeroDeEmpates;
	private JButton novo, sair, B1, B2, B3, B4, B5, B6, B7, B8, B9;
	private Container cont;
	private JPanel east, center;
	boolean Jogador1Ativo = true;
	boolean Jogador2Ativo = false;

	int VitoriaDoJogador1 = 0;
	int VitoriaDoJogador2 = 0;
	int PartidasEmpatadas = 0;

	public JogoDaVelha() {
		super("Jogo da velha");
		east = new JPanel();
		center = new JPanel();
		cont = getContentPane();
		novo = new JButton(" Novo Jogo");
		sair = new JButton("Sair do Jogo");
		TrataEvento x = new TrataEvento();
		B1 = new JButton();
		B1.addActionListener(x);
		B1.setSize(40, 40);
		B2 = new JButton();
		B2.addActionListener(x);
		B3 = new JButton();
		B3.addActionListener(x);
		B4 = new JButton();
		B4.addActionListener(x);
		B5 = new JButton();
		B5.addActionListener(x);
		B6 = new JButton();
		B6.addActionListener(x);
		B7 = new JButton();
		B7.addActionListener(x);
		B8 = new JButton();
		B8.addActionListener(x);
		B9 = new JButton();
		B9.addActionListener(x);
		center.setLayout(new GridLayout(3, 3, 50, 50));
		center.setBorder(javax.swing.BorderFactory.createLineBorder(
				new java.awt.Color(204, 255, 51), 2));
		center.add(B1);
		center.add(B2);
		center.add(B3);
		center.add(B4);
		center.add(B5);
		center.add(B6);
		center.add(B7);
		center.add(B8);
		center.add(B9);
		cont.add(center, BorderLayout.CENTER);
		NumeroDeVitoriasDoJogador1 = new JLabel(
				"Numero de vitorias do Jogador1: ");
		NumeroDeVitoriasDoJogador2 = new JLabel(
				"Numero de vitorias do Jogador2: ");
		NumeroDeEmpates = new JLabel("Numero de empates: ");
		east.setLayout(new BorderLayout(3, 3));
		east.add(NumeroDeVitoriasDoJogador2, BorderLayout.NORTH);
		east.add(NumeroDeEmpates, BorderLayout.SOUTH);
		east.add(NumeroDeVitoriasDoJogador1, BorderLayout.CENTER);
		cont.add(east, BorderLayout.EAST);
		setVisible(true);
		setSize(500, 500);
	}

	public void JogadorAtivo() {
		if (Jogador1Ativo == true) {
			Jogador1Ativo = false;
			Jogador2Ativo = true;
		} else {
			Jogador1Ativo = true;
			Jogador2Ativo = false;
		}
		JogadorVencedor("X");
		JogadorVencedor("0");
	}

	public void JogadorVencedor(String Jogador) {
		/*
		 * **************** Verificando Linhas *******************
		 */
		if (B1.getText().equals(Jogador) && B2.getText().equals(Jogador)
				&& B3.getText().equals(Jogador)) {
			if (B1.getText().equals("X"))
				Vencedor("Jogador 1");
			else
				Vencedor("Jogador 2");
		}
		if (B4.getText().equals(Jogador) && B5.getText().equals(Jogador)
				&& B6.getText().equals(Jogador)) {
			if (B4.getText().equals("X"))
				Vencedor("Jogador 1");
			else
				Vencedor("Jogador 2");
		}
		if (B7.getText().equals(Jogador) && B8.getText().equals(Jogador)
				&& B9.getText().equals(Jogador)) {
			if (B7.getText().equals("X"))
				Vencedor("Jogador 1");
			else
				Vencedor("Jogador 2");
		}
		/*
		 * ***************** Verificando Colunas ********************
		 */
		if (B1.getText().equals(Jogador) && B4.getText().equals(Jogador)
				&& B7.getText().equals(Jogador)) {

			if (B1.getText().equals("X"))
				Vencedor("Jogador 1");
			else
				Vencedor("Jogador 2");
		}
		if (B2.getText().equals(Jogador) && B5.getText().equals(Jogador)
				&& B8.getText().equals(Jogador)) {
			if (B2.getText().equals("X"))
				Vencedor("Jogador 1");
			else
				Vencedor("Jogador 2");
		}
		if (B3.getText().equals(Jogador) && B6.getText().equals(Jogador)
				&& B9.getText().equals(Jogador)) {
			if (B3.getText().equals("X"))
				Vencedor("Jogador 1");
			else
				Vencedor("Jogador 2");
		}
		/******************* Verificando Diagonais *********************/
		if (B1.getText().equals(Jogador) && B5.getText().equals(Jogador)
				&& B9.getText().equals(Jogador)) {

			if (B1.getText().equals("X"))
				Vencedor("Jogador 1");
			else
				Vencedor("Jogador 2");
		}
		if (B3.getText().equals(Jogador) && B5.getText().equals(Jogador)
				&& B7.getText().equals(Jogador)) {
			if (B3.getText().equals("X"))
				Vencedor("Jogador 1");
			else
				Vencedor("Jogador 2");
		}
		/*
		 * ***************** Verificando Empate ********************
		 */
		if (!B1.getText().equals("") && !B2.getText().equals("")
				&& !B3.getText().equals("") && !B4.getText().equals("")
				&& !B5.getText().equals("") && !B6.getText().equals("")
				&& !B7.getText().equals("") && !B8.getText().equals("")
				&& !B9.getText().equals("")) {
			Vencedor("Empate");
		}
	}

	public void Vencedor(String JogadorVencedor) {
		if (JogadorVencedor.equals("Jogador 1")) {
			JOptionPane.showMessageDialog(JogoDaVelha.this,
					"Parab�ns Jogador 1. Voc� venceu o Jogo!");
			VitoriaDoJogador1++;
			NumeroDeVitoriasDoJogador1.setText("N�mero de Vit�rias: "
					+ VitoriaDoJogador1);
			LimparCampos();
		}
		if (JogadorVencedor.equals("Jogador 2")) {
			JOptionPane.showMessageDialog(JogoDaVelha.this,
					"Parab�ns Jogador 2. Voc� venceu o Jogo!");
			VitoriaDoJogador2++;
			NumeroDeVitoriasDoJogador2.setText("N�mero de Vit�rias: "
					+ VitoriaDoJogador2);
			LimparCampos();
		}

		if (JogadorVencedor.equals("Empate")) {
			JOptionPane.showMessageDialog(JogoDaVelha.this,
					"Jogo Empatado! Joguem Novamente!");
			PartidasEmpatadas++;
			NumeroDeEmpates
					.setText("N�mero de Empates: " + PartidasEmpatadas);
			LimparCampos();
		}
	}

	public void LimparCampos() {
		B1.setText("");
		B2.setText("");
		B3.setText("");
		B4.setText("");
		B5.setText("");
		B6.setText("");
		B7.setText("");
		B8.setText("");
		B9.setText("");
		Jogador1Ativo = true;
		Jogador2Ativo = false;
	}

	private class TrataEvento implements ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			if (evt.getSource() == B3) {
				if (Jogador1Ativo == true) {
					if (B3.getText().equals("")) {
						B3.setText("X");
						JogadorAtivo();
					}
				} else {
					if (B3.getText().equals("")) {
						B3.setText("0");
						JogadorAtivo();
					}
				}
			}

			if (evt.getSource() == B1) {
				if (Jogador1Ativo == true) {
					if (B1.getText().equals("")) {
						B1.setText("X");
						JogadorAtivo();
					}
				} else {
					if (B1.getText().equals("")) {
						B1.setText("0");
						JogadorAtivo();
					}
				}
			}

			if (B2 == evt.getSource()) {
				if (Jogador1Ativo == true) {
					if (B2.getText().equals("")) {
						B2.setText("X");
						JogadorAtivo();
					}
				} else {
					if (B2.getText().equals("")) {
						B2.setText("0");
						JogadorAtivo();
					}
				}

			}

			if (B4 == evt.getSource()) {
				if (Jogador1Ativo == true) {
					if (B4.getText().equals("")) {
						B4.setText("X");
						JogadorAtivo();
					}
				} else {
					if (B4.getText().equals("")) {
						B4.setText("0");
						JogadorAtivo();
					}
				}
			}

			if (B5 == evt.getSource())
				if (Jogador1Ativo == true) {
					if (B5.getText().equals("")) {
						B5.setText("X");
						JogadorAtivo();
					}
				} else {
					if (B5.getText().equals("")) {
						B5.setText("0");
						JogadorAtivo();
					}
				}

			if (evt.getSource() == B6) {
				if (Jogador1Ativo == true) {
					if (B6.getText().equals("")) {
						B6.setText("X");
						JogadorAtivo();
					}
				} else {
					if (B6.getText().equals("")) {
						B6.setText("0");
						JogadorAtivo();
					}
				}

			}

			if (evt.getSource() == B7) {
				if (Jogador1Ativo == true) {
					if (B7.getText().equals("")) {
						B7.setText("X");
						JogadorAtivo();
					}
				} else {
					if (B7.getText().equals("")) {
						B7.setText("0");
						JogadorAtivo();
					}
				}

			}

			if (B8 == evt.getSource()) {
				if (Jogador1Ativo == true) {
					if (B8.getText().equals("")) {
						B8.setText("X");
						JogadorAtivo();
					}
				} else {
					if (B8.getText().equals("")) {
						B8.setText("0");
						JogadorAtivo();
					}
				}

			}

			if (evt.getSource() == B9) {
				if (Jogador1Ativo == true) {
					if (B9.getText().equals("")) {
						B9.setText("X");
						JogadorAtivo();
					}
				} else {
					if (B9.getText().equals("")) {
						B9.setText("0");
						JogadorAtivo();
					}
				}
			}

			if (evt.getSource() == novo) {
				LimparCampos();
			}
			if (evt.getSource() == sair) {
				System.exit(0);
			}
		}
	}

	public static void main(String args[]) {
		JogoDaVelha x = new JogoDaVelha();
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}