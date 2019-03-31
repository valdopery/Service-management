import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class CadastroFuncionario extends JFrame {
	private JLabel codigo, codigoErr, nome, nomeErr, genero, endereco,
			enderecoErr, contacto, contactoErr, bi, biErr, idade, idadeErr,
			anoAdmissao, anoAdmissaoErr, lArea, servico, nivelacademico,
			salario, m, f;
	private JButton ok, cancelar, limpar;
	private JTextField txtCod, txtNome, txtEndereco, txtContacto, txtBI,
			txtIdade, txtAnoAdmissao, txtValor;
	private JRadioButton masc, fem;
	private JComboBox cmbArea, cmbTipoServ, serDom, serEle, serInfo, serConstr,
			indisponivel, cmbNivel;
	private JPanel painelprincipal, painelformulario, painelsul, painelgen;
	private String[] area = { "Selecione a  Area", "Construção", "Domésticos",
			"Electricos e Hidricos", "Informática" }, serInformatica = {
			"Selecione o Serviço", "Redes", "Manutenção", "Reparação",
			"Montagem" }, serDomestica = { "Selecione o Serviço", "Babá",
			"Empregada", "Jardineiro", "Cozinheiro" }, serElectrico = {
			"Selecione a  Area", "Instalação", "Canalizacao" },
			serConstrucao = { "Selecione o Serviço", "Pedreiro", "Pintor" },
			nivelac = { "Licenciado", "Bacharelato", "Tecnico" };
	private GridBagConstraints c;
	private ButtonGroup bg;
	private Container cont;
	private Vector vec;

	public CadastroFuncionario(Vector v) {
		super("Gestao de Servicos - Registar Funcionario");
		vec = v;
		painelprincipal = new JPanel();
		cont = getContentPane();

		painelformulario = new JPanel(new GridBagLayout());
		painelprincipal.add(painelformulario);

		painelsul = new JPanel();
		painelsul.setLayout(new GridLayout(1, 3));

		painelgen = new JPanel();
		painelgen.setLayout(new GridLayout(1, 4));

		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;

		bg = new ButtonGroup();

		codigo = new JLabel("Codigo :");
		painelformulario.add(codigo, c);
		c.gridy++;

		nome = new JLabel("Nome :");
		painelformulario.add(nome, c);
		c.gridy++;

		genero = new JLabel("Genero :");
		painelformulario.add(genero, c);
		c.gridy++;

		endereco = new JLabel("Endereco :");
		painelformulario.add(endereco, c);
		c.gridy++;

		contacto = new JLabel("Contato");
		painelformulario.add(contacto, c);
		c.gridy++;

		bi = new JLabel("N do BI :");
		painelformulario.add(bi, c);
		c.gridy++;

		idade = new JLabel("Idade :");
		painelformulario.add(idade, c);
		c.gridy++;

		anoAdmissao = new JLabel("Ano de Admissao :");
		painelformulario.add(anoAdmissao, c);
		c.gridy++;

		lArea = new JLabel("Area :");
		painelformulario.add(lArea, c);
		c.gridy++;

		servico = new JLabel("Servico");
		painelformulario.add(servico, c);
		c.gridy++;

		nivelacademico = new JLabel("Nivel Academico :");
		painelformulario.add(nivelacademico, c);
		c.gridy++;

		salario = new JLabel("Salario :");
		painelformulario.add(salario, c);
		c.gridy++;

		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;

		txtCod = new JTextField(8);
		txtCod.setToolTipText("Introduza o Codigo do Funcionario (100-999)");
		painelformulario.add(txtCod, c);
		c.gridy++;

		txtNome = new JTextField(15);
		txtNome.setToolTipText("Introduza o Nome do Funcionario");
		painelformulario.add(txtNome, c);
		c.gridy++;

		f = new JLabel("Femenino");
		painelgen.add(f);
		fem = new JRadioButton();
		painelgen.add(fem);

		m = new JLabel("Masculino");
		painelgen.add(m);
		masc = new JRadioButton();
		painelgen.add(masc);

		bg.add(masc);
		bg.add(fem);
		painelformulario.add(painelgen, c);
		c.gridy++;

		txtEndereco = new JTextField(15);
		txtEndereco.setToolTipText("Introduza o Endereco");
		painelformulario.add(txtEndereco, c);
		c.gridy++;

		txtContacto = new JTextField(15);
		txtContacto
				.setToolTipText("Introduza o Contacto, (9 Digitos) Ex: 827871915");
		painelformulario.add(txtContacto, c);
		c.gridy++;

		txtBI = new JTextField(15);
		txtBI.setToolTipText("Introduza o Nr do Bi, (13 Caracteres) Ex: 123465782918M");
		painelformulario.add(txtBI, c);
		c.gridy++;

		txtIdade = new JTextField(15);
		txtIdade.setToolTipText("Introduza a Idade, 18 - 75");
		painelformulario.add(txtIdade, c);
		c.gridy++;

		txtAnoAdmissao = new JTextField(15);
		txtAnoAdmissao.setToolTipText("Introduza o Ano de Admissao");
		painelformulario.add(txtAnoAdmissao, c);
		c.gridy++;

		cmbArea = new JComboBox(area);
		painelformulario.add(cmbArea, c);
		c.gridy++;
		indisponivel = new JComboBox();
		indisponivel.setVisible(true);
		indisponivel.addItem("Primeiro Selecione a Area");
		serConstr = new JComboBox(serConstrucao);
		serConstr.setVisible(false);
		serConstr.setToolTipText("Selecione o servico de Construcao");
		serDom = new JComboBox(serDomestica);
		serDom.setVisible(false);
		serDom.setToolTipText("Selecione o servico Domestico");
		serEle = new JComboBox(serElectrico);
		serEle.setVisible(false);
		serEle.setToolTipText("Selecione o servico Electrico ou Hidrico");
		serInfo = new JComboBox(serInformatica);
		serInfo.setVisible(false);
		serInfo.setToolTipText("Selecione o servico Informatico");

		painelformulario.add(indisponivel, c);
		painelformulario.add(serConstr, c);
		painelformulario.add(serDom, c);
		painelformulario.add(serEle, c);
		painelformulario.add(serInfo, c);

		c.gridy++;

		cmbNivel = new JComboBox(nivelac);
		painelformulario.add(cmbNivel, c);
		c.gridy++;

		txtValor = new JTextField(10);
		txtValor.setText("0.00");
		txtValor.setEditable(false);
		painelformulario.add(txtValor, c);
		c.gridy++;

		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;

		codigoErr = new JLabel("Codigo Invalido");
		codigoErr.setForeground(Color.red);
		codigoErr.setVisible(false);
		painelformulario.add(codigoErr, c);
		c.gridy++;
		nomeErr = new JLabel("Nome Invalido");
		nomeErr.setForeground(Color.red);
		nomeErr.setVisible(false);
		painelformulario.add(nomeErr, c);
		c.gridy += 2;
		enderecoErr = new JLabel("Endereco Invalido");
		enderecoErr.setForeground(Color.red);
		enderecoErr.setVisible(false);
		painelformulario.add(enderecoErr, c);
		c.gridy++;
		contactoErr = new JLabel("Contacto Invalido");
		contactoErr.setForeground(Color.red);
		contactoErr.setVisible(false);
		painelformulario.add(contactoErr, c);
		c.gridy++;
		biErr = new JLabel("Num de Bi Invalido");
		biErr.setForeground(Color.red);
		biErr.setVisible(false);
		painelformulario.add(biErr, c);
		c.gridy++;
		idadeErr = new JLabel("Idade Invalida");
		idadeErr.setForeground(Color.red);
		idadeErr.setVisible(false);
		painelformulario.add(idadeErr, c);
		c.gridy++;
		anoAdmissaoErr = new JLabel("Ano de admissao Invalido");
		anoAdmissaoErr.setForeground(Color.red);
		anoAdmissaoErr.setVisible(false);
		painelformulario.add(anoAdmissaoErr, c);
		ok = new JButton("Registar");
		ok.setMnemonic('R');
		ok.setToolTipText("Registar Funcionario(Alt+R)");
		painelsul.add(ok);
		limpar = new JButton("Limpar");
		limpar.setMnemonic('L');
		limpar.setToolTipText("Limpar(Alt+L)");
		painelsul.add(limpar);
		cancelar = new JButton("Cancelar");
		cancelar.setMnemonic('C');
		cancelar.setToolTipText("Cancelar(Alt+C)");
		painelsul.add(cancelar);
		cont.add(painelsul, BorderLayout.SOUTH);
		cont.add(painelprincipal, BorderLayout.CENTER);
		cmbArea.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if (ie.getStateChange() == ItemEvent.SELECTED) {
					int i = cmbArea.getSelectedIndex();
					if (i == 0) {
						serDom.setVisible(false);
						serEle.setVisible(false);
						serInfo.setVisible(false);
						serConstr.setVisible(false);
						indisponivel.setVisible(true);
					} else {
						if (i == 1) {
							indisponivel.setVisible(false);
							serConstr.setSelectedIndex(0);
							serDom.setVisible(false);
							serEle.setVisible(false);
							serInfo.setVisible(false);
							serConstr.setVisible(true);
						} else {
							if (i == 2) {
								indisponivel.setVisible(false);
								serDom.setSelectedIndex(0);
								serDom.setVisible(true);
								serEle.setVisible(false);
								serInfo.setVisible(false);
								serConstr.setVisible(false);
							} else {
								if (i == 3) {
									indisponivel.setVisible(false);
									serEle.setSelectedIndex(0);
									serDom.setVisible(false);
									serEle.setVisible(true);
									serInfo.setVisible(false);
									serConstr.setVisible(false);
								} else if (i == 4) {
									indisponivel.setVisible(false);
									serInfo.setSelectedIndex(0);
									serDom.setVisible(false);
									serEle.setVisible(false);
									serInfo.setVisible(true);
									serConstr.setVisible(false);
								}
							}
						}
					}
				}
			}
		});
		TrataTexto tT = new TrataTexto();
		txtAnoAdmissao.addFocusListener(tT);
		txtBI.addFocusListener(tT);
		txtCod.addFocusListener(tT);
		txtContacto.addFocusListener(tT);
		txtEndereco.addFocusListener(tT);
		txtNome.addFocusListener(tT);
		txtIdade.addFocusListener(tT);
		setVisible(true);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Eventos eventos = new Eventos();
		ok.addActionListener(eventos);
		limpar.addActionListener(eventos);
		cancelar.addActionListener(eventos);
	}

	private class TrataTexto implements FocusListener {
		public void focusGained(FocusEvent fG) {
			if (fG.getSource() == txtCod && codigoErr.isVisible())
				txtCod.setBackground(Color.white);
			if (fG.getSource() == txtContacto && contactoErr.isVisible())
				txtContacto.setBackground(Color.white);
			if (fG.getSource() == txtEndereco && enderecoErr.isVisible())
				txtEndereco.setBackground(Color.white);
			if (fG.getSource() == txtNome && nomeErr.isVisible())
				txtNome.setBackground(Color.white);
			if (fG.getSource() == txtBI && biErr.isVisible())
				txtBI.setBackground(Color.white);
			if (fG.getSource() == txtAnoAdmissao && anoAdmissaoErr.isVisible())
				txtAnoAdmissao.setBackground(Color.white);
			if (fG.getSource() == txtIdade && idadeErr.isVisible())
				txtIdade.setBackground(Color.white);
		}

		public void focusLost(FocusEvent fL) {
			try {
				if (fL.getSource() == txtCod) {
					if (Float.parseFloat(txtCod.getText()) < 100
							|| Float.parseFloat(txtCod.getText()) > 999) {
						codigoErr.setVisible(true);
						txtCod.setBackground(Color.red);
					} else
						codigoErr.setVisible(false);
				}
				if (fL.getSource() == txtContacto) {
					if (Long.parseLong(txtContacto.getText()) < 820000000
							|| Long.parseLong(txtContacto.getText()) > 879999999) {
						contactoErr.setVisible(true);
						txtContacto.setBackground(Color.red);
					} else
						contactoErr.setVisible(false);
				}
				if (fL.getSource() == txtIdade) {
					if (Byte.parseByte(txtIdade.getText()) < 18
							|| Byte.parseByte(txtIdade.getText()) > 75) {
						idadeErr.setVisible(true);
						txtIdade.setBackground(Color.red);
					} else
						idadeErr.setVisible(false);
				}
				if (fL.getSource() == txtAnoAdmissao) {
					if (Short.parseShort(txtAnoAdmissao.getText()) < 1949
							|| Short.parseShort(txtAnoAdmissao.getText()) > 1996) {
						anoAdmissaoErr.setVisible(true);
						anoAdmissaoErr.setBackground(Color.red);
					} else
						anoAdmissaoErr.setVisible(false);
				}
				if (fL.getSource() == txtEndereco) {
					if (txtEndereco.getText() == ""
							|| txtEndereco.getText().length() < 10
							|| txtEndereco.getText().length() > 50) {
						enderecoErr.setVisible(true);
						txtEndereco.setBackground(Color.red);
					} else
						enderecoErr.setVisible(false);
				}

				if (fL.getSource() == txtNome) {
					if (txtNome.getText() == ""
							|| txtNome.getText().length() < 2
							|| txtNome.getText().length() > 40) {
						nomeErr.setVisible(true);
						txtNome.setBackground(Color.red);
					} else
						nomeErr.setVisible(false);
				}
				if (fL.getSource() == txtBI) {
					boolean l = bi();
					if (txtBI.getText() == "" || txtBI.getText().length() != 13
							|| !l) {
						biErr.setVisible(true);
						txtBI.setBackground(Color.red);
					} else
						biErr.setVisible(false);
				}
			} catch (NumberFormatException nfE) {
				if (fL.getSource() == txtCod) {
					codigoErr.setVisible(true);
					txtCod.setBackground(Color.red);
				}
				if (fL.getSource() == txtContacto) {
					contactoErr.setVisible(true);
					txtContacto.setBackground(Color.red);
				}
				if (fL.getSource() == txtIdade) {
					idadeErr.setVisible(true);
					txtIdade.setBackground(Color.red);
				}
				if (fL.getSource() == txtAnoAdmissao) {
					anoAdmissaoErr.setVisible(true);
					anoAdmissaoErr.setBackground(Color.red);
				}
			}
		}
	}

	private class Eventos implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == ok) {
				if (!codigoErr.isVisible() && !contactoErr.isVisible()
						&& !enderecoErr.isVisible() && !nomeErr.isVisible()
						&& !biErr.isVisible() && !idade.isVisible()
						&& !anoAdmissaoErr.isVisible()
						&& cmbArea.getSelectedIndex() != 0
						&& serDom.isVisible() && serDom.getSelectedIndex() != 0
						|| serEle.isVisible() && serEle.getSelectedIndex() != 0
						|| serInfo.isVisible()
						&& serInfo.getSelectedIndex() != 0
						|| serConstr.isVisible()
						&& serConstr.getSelectedIndex() != 0) {
					Funcionario fun = new Funcionario();
					fun.setArea(cmbArea.getSelectedItem().toString());
					if (serDom.isVisible())
						fun.setTipoServico(serDom.getSelectedItem().toString());
					if (serEle.isVisible())
						fun.setTipoServico(serEle.getSelectedItem().toString());
					if (serInfo.isVisible())
						fun.setTipoServico(serInfo.getSelectedItem().toString());
					if (serConstr.isVisible())
						fun.setTipoServico(serConstr.getSelectedItem()
								.toString());
					fun.setPreco(Float.parseFloat(txtValor.getText()));
					fun.setCodigo("AS-" + txtCod.getText());
					fun.setNome(txtNome.getText());
					fun.setContacto(Long.parseLong(txtContacto.getText()));
					fun.setEndereco(txtEndereco.getText());
					fun.setBi(txtBI.getText());
					fun.setAnoAdmissao(Short.parseShort(txtAnoAdmissao
							.getText()));
					if (masc.isSelected())
						fun.setGenero('M');
					else
						fun.setGenero('F');
					fun.setIdade(Byte.parseByte(txtIdade.getText()));
					vec.add(fun);
					vec.trimToSize();
					Gravacao g = new Gravacao();
					g.gravarUltimo(vec);
					JOptionPane.showMessageDialog(null,
							"Funcionario Registado!");
					dispose();
				} else
					JOptionPane
							.showMessageDialog(null,
									"Por favor preencha todos campos com dados validos");
			}
			if (ae.getSource() == limpar) {
				txtCod.setText("");
				txtNome.setText("");
				txtContacto.setText("");
				txtEndereco.setText("");
				txtBI.setText("");
				txtIdade.setText("");
				txtAnoAdmissao.setText("");
				txtValor.setText("0.00");
				masc.setSelected(true);
				cmbArea.setSelectedIndex(0);
				indisponivel.setSelectedIndex(0);
				serConstr.setSelectedIndex(0);
				serDom.setSelectedIndex(0);
				serEle.setSelectedIndex(0);
				serInfo.setSelectedIndex(0);
				serDom.setVisible(false);
				serEle.setVisible(false);
				serInfo.setVisible(false);
				serConstr.setVisible(false);
				indisponivel.setVisible(true);
				cmbTipoServ.setSelectedIndex(0);
				if (ae.getSource() == cancelar) {
					dispose();
				}
			}
		}
	}

	private boolean bi() {
		boolean letra = false, number = false;
		char l[] = { 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f',
				'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l',
				'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r',
				'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x',
				'X', 'y', 'Y', 'z', 'Z' }, x[] = { '0', '1', '2', '3', '4',
				'5', '6', '7', '8', '9' };
		try {
			char t = txtBI.getText().charAt(txtBI.getText().length() - 1);
			for (int i = 0; i < l.length && !letra; i++)
				if (t == l[i])
					letra = true;
			if (!letra)
				return false;
			for (int i = 0; i < txtBI.getText().length() - 1; i++) {
				number = false;
				for (int j = 0; j < x.length && !number; j++) {
					if (txtBI.getText().charAt(i) == x[j])
						number = true;
				}
				if (number == false)
					return false;
			}
		} catch (StringIndexOutOfBoundsException si) {
			System.out.println("Campo de BI esta vazio");
		}
		return true;
	}
}