import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Login extends JFrame {
	private JLabel nomUser, psswrd;
	private JButton btLimpar, btEntrar, btCancelar;
	private JPasswordField campoPassword;
	private Container cont;
	private JPanel panel1;
	private Administrador admin;
	private JComboBox jcb;
	private String[][] dados;
	private Gravacao gra;
	private BemVindo bv;

	public Login() {
		super("Gestao de Servicos - Iniciar Sessao");

		cont = getContentPane();
		cont.setLayout(new FlowLayout());
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 1));

		nomUser = new JLabel("Nome do Utilizador :");
		nomUser.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		panel1.add(nomUser);

		gra = new Gravacao();
		dados = gra.lerContas();
		jcb = new JComboBox();
		preencheComboNome();

		panel1.add(jcb);

		psswrd = new JLabel("Palavra-passe :");
		psswrd.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		panel1.add(psswrd);

		campoPassword = new JPasswordField(15);
		campoPassword
				.setToolTipText("6-16 caracteres, Nao deve conter espaco e nenhum dos sequintes caracteres:  -?/|*#");
		panel1.add(campoPassword);

		btLimpar = new JButton("Limpar");
		btLimpar.setMnemonic('L');
		btLimpar.setToolTipText("Limpar(Alt+L)");

		btEntrar = new JButton("Entrar");
		btEntrar.setMnemonic('E');
		btEntrar.setToolTipText("Entrar(Alt+E)");

		btCancelar = new JButton("Cancelar");
		btCancelar.setMnemonic('C');
		btCancelar.setToolTipText("Entrar(Alt+C)");

		cont.add(panel1, BorderLayout.CENTER);
		cont.add(btEntrar, BorderLayout.SOUTH);
		cont.add(btLimpar, BorderLayout.SOUTH);
		cont.add(btCancelar, BorderLayout.SOUTH);

		setSize(400, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		jcb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				campoPassword.setText("");
			}
		});

		Eventos eventos = new Eventos();
		btEntrar.addActionListener(eventos);
		btLimpar.addActionListener(eventos);
		btCancelar.addActionListener(eventos);
	}

	public void preencheComboNome() {
		for (int i = 0; i < dados.length; i++) {
			if (dados[i][0] != null)
				jcb.addItem(dados[i][0]);
		}
	}

	private class Eventos implements ActionListener {
		boolean existe = false;

		public void actionPerformed(ActionEvent x) {
			String password;
			if (x.getSource() == btEntrar) {
				password = campoPassword.getText();
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
									&& jcb.getSelectedItem().toString()
											.equalsIgnoreCase(dados[i][0])) {
								existe = true;
								dispose();
								admin = new Administrador();
							}
					if (!existe)
						JOptionPane.showMessageDialog(null,
								"Palavra-Passe Invalida! Tente Novamente");
				}
			} else if (x.getSource() == btLimpar) {
				campoPassword.setText(" ");
			} else if (x.getSource() == btCancelar) {
				dispose();
				bv = new BemVindo();
			}
		}
	}

	public static void main(String[] args) {
		Login log = new Login();
	}
}