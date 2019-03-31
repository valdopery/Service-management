import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Conta extends JFrame {
	private JLabel lbNome, lbPasse, lbPergunta;
	private JTextField txtNome, txtResposta;
	private JPasswordField txtPasse;
	private JButton btnCriar, btnLimpar, btnCancelar;
	private String[] pergunta = { "Selecione uma Pergunta",
			"Primeiro nome do pai?", "Primeiro nome da mae?", "Cor preferida?",
			"Nome do animal de estimacao?", "Artista favorito?",
			"Desporto favorito" };
	private JComboBox cmbPergunta;
	private Container c;
	private GridBagLayout grlyt;
	private BorderLayout brlyt;
	private JPanel pnCentro, pnSul;
	GridBagConstraints gbCon;

	public Conta() {
		super("Registo de Conta");
		c = getContentPane();
		brlyt = new BorderLayout();
		grlyt = new GridBagLayout();
		gbCon = new GridBagConstraints();
		c.setLayout(brlyt);
		pnCentro = new JPanel();
		pnSul = new JPanel();

		pnCentro.setLayout(grlyt);

		lbNome = new JLabel("Nome do utilizador");
		lbPasse = new JLabel("Palavra passe");
		lbPergunta = new JLabel("Pergunta para recuperar palavra passe");
		txtNome = new JTextField(15);
		txtPasse = new JPasswordField(15);
		txtResposta = new JTextField(15);
		cmbPergunta = new JComboBox(pergunta);
		btnCriar = new JButton("Criar");
		btnLimpar = new JButton("Limpar");
		btnCancelar = new JButton("Cancelar");

		gbCon.gridx = 0;
		gbCon.gridy = 0;
		gbCon.anchor = GridBagConstraints.LINE_START;

		pnCentro.add(lbNome, gbCon);
		gbCon.gridy++;
		pnCentro.add(lbPasse, gbCon);
		gbCon.gridy++;
		pnCentro.add(lbPergunta, gbCon);
		gbCon.gridx = 1;
		gbCon.gridy = 0;
		pnCentro.add(txtNome, gbCon);
		gbCon.gridy++;
		pnCentro.add(txtPasse, gbCon);
		gbCon.gridy++;
		pnCentro.add(cmbPergunta, gbCon);
		gbCon.gridy++;
		pnCentro.add(txtResposta, gbCon);

		pnSul.add(btnCriar);
		pnSul.add(btnLimpar);
		pnSul.add(btnCancelar);
		c.add(pnCentro, BorderLayout.CENTER);
		c.add(pnSul, BorderLayout.SOUTH);
		cmbPergunta.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Gravacao g = new Gravacao();
				g.gravarNovaConta(txtNome.getText(), txtPasse.getText(),
						cmbPergunta.getSelectedItem().toString(),
						txtResposta.getText());
				JOptionPane.showMessageDialog(null, "Novo utilizador criado!");
			}
		});
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				txtNome.setText("");
				txtPasse.setText("");
				txtResposta.setText("");
				cmbPergunta.setSelectedIndex(0);
			}
		});
		setVisible(true);
		setLocation(36, 60);
		setSize(450, 250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		Conta con = new Conta();
	}
}

class EliminarConta extends JFrame {
	private JTextField txtNome;
	private JPasswordField txtPasse;
	private JButton btnEliminar, btnCancelar, btnLimpar;
	private JPanel pnCentro, pnSul;
	private Container c;
	private GridBagLayout grlyt;
	private BorderLayout brlyt;
	GridBagConstraints gbCon;
	private JLabel lbNome, lbPasse;
	private String[][] dados;
	private Gravacao gra;

	public EliminarConta() {
		super("Eliminar Conta");
		c = getContentPane();
		brlyt = new BorderLayout();
		grlyt = new GridBagLayout();
		gbCon = new GridBagConstraints();
		c.setLayout(brlyt);

		gra = new Gravacao();
		dados = gra.lerContas();

		pnCentro = new JPanel();
		pnSul = new JPanel();

		pnCentro.setLayout(grlyt);
		lbNome = new JLabel("Nome do utilizador");
		lbPasse = new JLabel("Palavra passe");
		txtNome = new JTextField(15);
		txtPasse = new JPasswordField(15);

		btnEliminar = new JButton("Eliminar");
		btnLimpar = new JButton("Limpar");
		btnCancelar = new JButton("Cancelar");
		gbCon.gridx = 0;
		gbCon.gridy = 0;
		gbCon.anchor = GridBagConstraints.LINE_START;

		pnCentro.add(lbNome, gbCon);
		gbCon.gridy++;
		pnCentro.add(lbPasse, gbCon);
		gbCon.gridx = 1;
		gbCon.gridy = 0;
		pnCentro.add(txtNome, gbCon);
		gbCon.gridy++;
		pnCentro.add(txtPasse, gbCon);
		pnSul.add(btnEliminar);
		pnSul.add(btnLimpar);
		pnSul.add(btnCancelar);
		c.add(pnCentro, BorderLayout.CENTER);
		c.add(pnSul, BorderLayout.SOUTH);
		btnEliminar.addActionListener(new ActionListener() {
			boolean existe = false;

			public void actionPerformed(ActionEvent ae) {
				String password = txtPasse.getText();
				if (password.equalsIgnoreCase("") || password.length() < 6
						|| password.length() > 16
						|| password.indexOf("?") != -1
						|| password.indexOf("-") != -1
						|| password.indexOf("/") != -1
						|| password.indexOf("|") != -1
						|| password.indexOf("*") != -1
						|| password.indexOf("#") != -1
						|| password.indexOf(" ") != -1) {
					JOptionPane.showMessageDialog(null,
							"Palavra-Passe Invalida! Tente Novamente");
				} else {
					for (int i = 0; i < dados.length; i++)
						if (dados[i][1] != null)
							if (password.equalsIgnoreCase(dados[i][1])
									&& txtNome.getText().equalsIgnoreCase(
											dados[i][0])) {
								existe = true;
								// dados[i][0] = null;
								// dados[i][1] = null;
								// dados[i][2] = null;
								// dados[i][3] = null;
								// try {
								// for (int pos = 0; pos < dados.length; pos++)
								// {
								// if (dados[pos][0] == null) {
								// for (int j = pos + 1; j < dados.length;
								// pos++) {
								// System.out
								// .println("Cheguei - 2");
								// if (dados[j][0] != null) {
								// dados[pos][0] = dados[j][0];
								// dados[pos][1] = dados[j][1];
								// dados[pos][2] = dados[j][2];
								// dados[pos][3] = dados[j][3];
								// pos = j - 1;
								// break;
								// }
								// }
								// }
								// }
								// } catch (ArrayIndexOutOfBoundsException ai) {
								// System.out.println("dados organizado!");
								// }
								eliminar(i);
								System.out.println("Cheguei aki");
								gra.gravarTodasContas(dados);
								JOptionPane.showMessageDialog(null,
										"Conta eliminada!");
								dispose();
								break;
							}
					if (!existe)
						JOptionPane.showMessageDialog(null,
								"Palavra-Passe Invalida! Tente Novamente");
				}
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				txtNome.setText("");
				txtPasse.setText("");
			}
		});
		setVisible(true);
		setLocation(36, 60);
		setSize(450, 250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void eliminar(int linha) {
		try {
			System.out.println("1");
			for (int j = linha + 1; j < dados.length; j++)
				if (dados[j + 1][0] == null) {
					dados[linha][0] = dados[j][0];
					dados[linha][1] = dados[j][1];
					dados[linha][2] = dados[j][2];
					dados[linha][3] = dados[j][3];
					dados[j][0]=null;
					dados[j][1]=null;
					dados[j][2]=null;
					dados[j][3]=null;
					break;
				}
		} catch (ArrayIndexOutOfBoundsException ai) {
			System.out.println("dados organizado!");
		}
	}
}

class AlterarNome extends JFrame {
	private JTextField txtNome, txtNovoNome;
	private JPasswordField txtPasse;
	private JButton btnAlterar, btnCancelar, btnLimpar;
	private JPanel pnCentro, pnSul;
	private Container c;
	private GridBagLayout grlyt;
	private BorderLayout brlyt;
	GridBagConstraints gbCon;
	private JLabel lbNome, lbPasse, lbNovoNome;
	private Gravacao gra;
	private String dados[][];

	public AlterarNome() {
		super("Alterar Nome do utilizador");
		c = getContentPane();
		brlyt = new BorderLayout();
		grlyt = new GridBagLayout();
		gbCon = new GridBagConstraints();
		c.setLayout(brlyt);
		pnCentro = new JPanel();
		pnSul = new JPanel();

		gra = new Gravacao();
		dados = gra.lerContas();

		pnCentro.setLayout(grlyt);
		lbNome = new JLabel("Nome do utilizador");
		lbNovoNome = new JLabel("Novo nome do utilizador");
		lbPasse = new JLabel("Palavra passe");
		txtNome = new JTextField(15);
		txtNovoNome = new JTextField(15);
		txtPasse = new JPasswordField(15);
		btnCancelar = new JButton("Cancelar");
		btnAlterar = new JButton("Alterar");
		btnLimpar = new JButton("Limpar");
		gbCon.gridx = 0;
		gbCon.gridy = 0;
		gbCon.anchor = GridBagConstraints.LINE_START;

		pnCentro.add(lbNome, gbCon);
		gbCon.gridy++;
		pnCentro.add(lbNovoNome, gbCon);
		gbCon.gridy++;
		pnCentro.add(lbPasse, gbCon);
		gbCon.gridx = 1;
		gbCon.gridy = 0;
		pnCentro.add(txtNome, gbCon);
		gbCon.gridy++;
		pnCentro.add(txtNovoNome, gbCon);
		gbCon.gridy++;
		pnCentro.add(txtPasse, gbCon);
		pnSul.add(btnAlterar);
		pnSul.add(btnLimpar);
		pnSul.add(btnCancelar);
		c.add(pnCentro, BorderLayout.CENTER);
		c.add(pnSul, BorderLayout.SOUTH);

		btnAlterar.addActionListener(new ActionListener() {
			boolean existe = false;

			public void actionPerformed(ActionEvent ae) {
				String password = txtPasse.getText();
				if (password.equalsIgnoreCase("") || password.length() < 6
						|| password.length() > 16
						|| password.indexOf("?") != -1
						|| password.indexOf("-") != -1
						|| password.indexOf("/") != -1
						|| password.indexOf("|") != -1
						|| password.indexOf("*") != -1
						|| password.indexOf("#") != -1
						|| password.indexOf(" ") != -1) {
					JOptionPane.showMessageDialog(null,
							"Palavra-Passe Invalida! Tente Novamente");
				} else {
					for (int i = 0; i < dados.length; i++)
						if (dados[i][1] != null)
							if (password.equalsIgnoreCase(dados[i][1])
									&& txtNome.getText().equalsIgnoreCase(
											dados[i][0])) {
								existe = true;
								dados[i][0] = txtNovoNome.getText();
								gra.gravarTodasContas(dados);
								JOptionPane.showMessageDialog(null,
										"Nome alterado!");
								dispose();
							}
					if (!existe)
						JOptionPane
								.showMessageDialog(null,
										"Palavra-Passe e/ou nome de utilizador incorrecto(s)! Tente Novamente");
				}
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				txtNome.setText("");
				txtNovoNome.setText("");
				txtPasse.setText("");
			}
		});

		setVisible(true);
		setLocation(36, 60);
		setSize(450, 250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

class AlterarPasse extends JFrame {
	private JTextField txtNome;
	private JPasswordField txtPasse, txtNovaPasse, txtConfNovaPasse;
	private JButton btnAlterar, btnCancelar, btnLimpar;
	private JPanel pnCentro, pnSul;
	private Container c;
	private GridBagLayout grlyt;
	private BorderLayout brlyt;
	GridBagConstraints gbCon;
	private JLabel lbNome, lbPasse, lbNovaPasse, lbConfNovaPasse;
	private String[][] dados;

	private Gravacao gra;

	public AlterarPasse() {
		super("Alterar Palavra Passe");
		c = getContentPane();
		brlyt = new BorderLayout();
		grlyt = new GridBagLayout();
		gbCon = new GridBagConstraints();
		c.setLayout(brlyt);

		gra = new Gravacao();
		dados = gra.lerContas();

		pnCentro = new JPanel();
		pnSul = new JPanel();

		pnCentro.setLayout(grlyt);
		lbNome = new JLabel("Nome do utilizador");
		lbPasse = new JLabel("Palavra passe");
		lbNovaPasse = new JLabel("Nova Palavra passe");
		lbConfNovaPasse = new JLabel("Confirmacao da Nova Palavra passe");
		txtNome = new JTextField(15);
		txtPasse = new JPasswordField(15);
		txtNovaPasse = new JPasswordField(15);
		txtConfNovaPasse = new JPasswordField(15);

		btnAlterar = new JButton("Alterar");
		btnLimpar = new JButton("Limpar");
		btnCancelar = new JButton("Cancelar");
		gbCon.gridx = 0;
		gbCon.gridy = 0;
		gbCon.anchor = GridBagConstraints.LINE_START;

		pnCentro.add(lbNome, gbCon);
		gbCon.gridy++;
		pnCentro.add(lbPasse, gbCon);
		gbCon.gridy++;
		pnCentro.add(lbNovaPasse, gbCon);
		gbCon.gridy++;
		pnCentro.add(lbConfNovaPasse, gbCon);
		gbCon.gridx = 1;
		gbCon.gridy = 0;
		pnCentro.add(txtNome, gbCon);
		gbCon.gridy++;
		pnCentro.add(txtPasse, gbCon);
		gbCon.gridy++;
		pnCentro.add(txtNovaPasse, gbCon);
		gbCon.gridy++;
		pnCentro.add(txtConfNovaPasse, gbCon);
		pnSul.add(btnAlterar);
		pnSul.add(btnLimpar);
		pnSul.add(btnCancelar);
		c.add(pnCentro, BorderLayout.CENTER);
		c.add(pnSul, BorderLayout.SOUTH);

		btnAlterar.addActionListener(new ActionListener() {
			boolean existe = false;

			public void actionPerformed(ActionEvent ae) {
				String password = txtPasse.getText();
				if (password.equalsIgnoreCase("") || password.length() < 6
						|| password.length() > 16
						|| password.indexOf("?") != -1
						|| password.indexOf("-") != -1
						|| password.indexOf("/") != -1
						|| password.indexOf("|") != -1
						|| password.indexOf("*") != -1
						|| password.indexOf("#") != -1
						|| password.indexOf(" ") != -1) {
					JOptionPane.showMessageDialog(null,
							"Palavra-Passe Invalida! Tente Novamente");
				} else {
					for (int i = 0; i < dados.length; i++)
						if (dados[i][1] != null)
							if (password.equalsIgnoreCase(dados[i][1])
									&& txtNome.getText().equalsIgnoreCase(
											dados[i][0])
									&& txtNovaPasse.getText().equalsIgnoreCase(
											txtNovaPasse.getText())
									&& txtNovaPasse.getText().length() > 5
									&& txtNovaPasse.getText().length() < 17) {
								existe = true;
								dados[i][1] = txtNovaPasse.getText();
								gra.gravarTodasContas(dados);
								JOptionPane.showMessageDialog(null,
										"Palavra passe alterada!");
								dispose();
							}
					if (!existe)
						JOptionPane
								.showMessageDialog(null,
										"Palavra-Passe e/ou nome de utilizador incorrecto(s)! Tente Novamente");
				}
			}

		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				txtNome.setText("");
				txtPasse.setText("");
				txtNovaPasse.setText("");
				txtConfNovaPasse.setText("");
			}
		});
		setVisible(true);
		setLocation(36, 60);
		setSize(450, 250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}