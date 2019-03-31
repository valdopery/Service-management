import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Vector;

public class CadastroCliente extends JFrame {
	private Container c;
	JButton btnOk;
	private JButton btnCancelar, btnLimpar;
	private JTextField txtCod, txtNome, txtEndereco, txtContacto, txtBI,
			txtValor;
	private JComboBox cmbArea, cmbTipoServ, serDom, serEle, serInfo, serConstr,
			indisponivel;
	private String[] area = { "Selecione a  Area", "Construção", "Domésticos",
			"Electricos e Hidricos", "Informática" }, serInformatica = {
			"Selecione o Serviço", "Redes", "Manutenção", "Reparação",
			"Montagem" }, serDomestica = { "Selecione o Serviço", "Babá",
			"Empregada", "Jardineiro", "Cozinheiro" }, serElectrico = {
			"Selecione a  Area", "Instalação", "Canalizacao" },
			serConstrucao = { "Selecione o Serviço", "Pedreiro", "Pintor" };
	private String tipoServ[] = { "------------", "Diario", "Semanal", "Mensal" };
	private BorderLayout blyt;
	private Vector vec;
	private JPanel painel1, painel2;
	private JLabel lcode, lcodeErr, lname, lnameErr, lgenero, lendereco,
			lenderecoErr, lcontacto, lcontactoErr, lbi, lbiErr, larea,
			lservico, ltipodeServ, lvalPagar;
	private GridBagLayout g;
	private GridBagConstraints gc;

	public CadastroCliente(Vector v) {
		super("Registro do Cliente");
		setSize(520, 340);
		setVisible(true);
		vec = v;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		c = getContentPane();
		blyt = new BorderLayout();
		c.setLayout(blyt);
		g = new GridBagLayout();

		TrataBotoes tb = new TrataBotoes();
		painel1 = new JPanel();

		btnOk = new JButton("Ok");
		btnCancelar = new JButton("Cancelar");
		btnLimpar = new JButton("Limpar");
		painel1.add(btnOk);
		painel1.add(btnLimpar);
		painel1.add(btnCancelar);
		c.add(painel1, blyt.SOUTH);

		painel2 = new JPanel();
		painel2.setLayout(g);

		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;

		lcode = new JLabel("Código do Cliente:");
		painel2.add(lcode, gc);
		gc.gridy++;
		lname = new JLabel("Nome do Cliente: ");
		painel2.add(lname, gc);
		gc.gridy++;
		lgenero = new JLabel("Genéro: ");
		painel2.add(lgenero, gc);
		gc.gridy++;
		lendereco = new JLabel("Endereço: ");
		painel2.add(lendereco, gc);
		gc.gridy++;

		lcontacto = new JLabel("Contacto: ");
		painel2.add(lcontacto, gc);
		gc.gridy++;

		lbi = new JLabel("BI: ");
		painel2.add(lbi, gc);
		gc.gridy++;

		larea = new JLabel("Área: ");
		painel2.add(larea, gc);
		gc.gridy++;

		lservico = new JLabel("Serviço: ");
		painel2.add(lservico, gc);
		gc.gridy++;

		ltipodeServ = new JLabel("Tipo de Contracto: ");
		painel2.add(ltipodeServ, gc);
		gc.gridy++;

		lvalPagar = new JLabel("Valor a Pagar:");
		painel2.add(lvalPagar, gc);

		gc.gridx = 1;
		gc.gridy = 0;

		gc.anchor = GridBagConstraints.LINE_START;

		txtCod = new JTextField(20);
		txtCod.setToolTipText("Escreva aqui o codigo do cliente (100-999),nao pode ser igual a um dos que ja foram gravados");
		txtCod.setText("");
		painel2.add(txtCod, gc);
		gc.gridy++;

		txtNome = new JTextField(20);
		txtNome.setToolTipText("Escreva aqui o nome do Cliente");
		painel2.add(txtNome, gc);
		gc.gridy++;

		txtEndereco = new JTextField(20);
		txtEndereco.setToolTipText("Escreva aqui o endereço do cliente");
		painel2.add(txtEndereco, gc);
		gc.gridy++;

		txtContacto = new JTextField(20);
		txtContacto
				.setToolTipText("Escreva o seu numero de Telemovel(82/84/86/87)xxxxxxx");
		painel2.add(txtContacto, gc);
		gc.gridy++;

		txtBI = new JTextField(20);
		txtBI.setToolTipText("Escreva aqui o numero do seu Bilhete de Identificação");
		painel2.add(txtBI, gc);
		gc.gridy++;

		cmbArea = new JComboBox(area);
		cmbArea.setToolTipText("Selecione a Area");

		painel2.add(cmbArea, gc);
		gc.gridy++;

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

		painel2.add(indisponivel, gc);
		painel2.add(serConstr, gc);
		painel2.add(serDom, gc);
		painel2.add(serEle, gc);
		painel2.add(serInfo, gc);

		gc.gridy++;

		cmbTipoServ = new JComboBox(tipoServ);
		cmbTipoServ.setToolTipText("Selecione o tipo de Contracto");
		painel2.add(cmbTipoServ, gc);
		gc.gridy++;

		txtValor = new JTextField(20);
		txtValor.setEditable(false);
		txtValor.setText("0.0");
		txtValor.setToolTipText("O Valor a Pagar pelo Cliente.");
		painel2.add(txtValor, gc);

		gc.gridx = 2;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;

		lcodeErr = new JLabel("Codigo Invalido");
		lcodeErr.setForeground(Color.red);
		lcodeErr.setVisible(false);
		painel2.add(lcodeErr, gc);
		gc.gridy++;
		lnameErr = new JLabel("Nome Invalido");
		lnameErr.setForeground(Color.red);
		lnameErr.setVisible(false);
		painel2.add(lnameErr, gc);
		gc.gridy += 2;
		lenderecoErr = new JLabel("Endereco Invalido");
		lenderecoErr.setForeground(Color.red);
		lenderecoErr.setVisible(false);
		painel2.add(lenderecoErr, gc);
		gc.gridy++;
		lcontactoErr = new JLabel("Contacto Invalido");
		lcontactoErr.setForeground(Color.red);
		lcontactoErr.setVisible(false);
		painel2.add(lcontactoErr, gc);
		gc.gridy++;
		lbiErr = new JLabel("Num de Bi Invalido");
		lbiErr.setForeground(Color.red);
		lbiErr.setVisible(false);
		painel2.add(lbiErr, gc);

		c.add(painel2, blyt.WEST);
		btnOk.addActionListener(tb);
		btnLimpar.addActionListener(tb);
		btnCancelar.addActionListener(tb);
		TrataComboBoxes y = new TrataComboBoxes();
		cmbArea.addItemListener(y);

		TrataTexto tT = new TrataTexto();
		txtBI.addFocusListener(tT);
		txtCod.addFocusListener(tT);
		txtContacto.addFocusListener(tT);
		txtEndereco.addFocusListener(tT);
		txtNome.addFocusListener(tT);
	}

	private class TrataTexto implements FocusListener {
		public void focusGained(FocusEvent fG) {
			if (fG.getSource() == txtCod && lcodeErr.isVisible()) {
				txtCod.setBackground(Color.white);
			}
			if (fG.getSource() == txtContacto && lcontactoErr.isVisible()) {
				txtContacto.setBackground(Color.white);
			}
			if (fG.getSource() == txtEndereco && lenderecoErr.isVisible()) {
				txtEndereco.setBackground(Color.white);
			}
			if (fG.getSource() == txtNome && lnameErr.isVisible()) {
				txtNome.setBackground(Color.white);
			}
			if (fG.getSource() == txtBI && lbiErr.isVisible()) {
				txtBI.setBackground(Color.white);
			}
		}

		public void focusLost(FocusEvent fL) {
			try {
				if (fL.getSource() == txtCod) {
					if (Float.parseFloat(txtCod.getText()) < 100
							|| Float.parseFloat(txtCod.getText()) > 999) {
						lcodeErr.setVisible(true);
						txtCod.setBackground(Color.red);
					} else
						lcodeErr.setVisible(false);
				}
				if (fL.getSource() == txtContacto) {
					if (Long.parseLong(txtContacto.getText()) < 820000000
							|| Long.parseLong(txtContacto.getText()) > 879999999) {
						lcontactoErr.setVisible(true);
						txtContacto.setBackground(Color.red);
					} else
						lcontactoErr.setVisible(false);
				}
				if (fL.getSource() == txtEndereco) {
					if (txtEndereco.getText() == ""
							|| txtEndereco.getText().length() < 10
							|| txtEndereco.getText().length() > 50) {
						lenderecoErr.setVisible(true);
						txtEndereco.setBackground(Color.red);
					} else
						lenderecoErr.setVisible(false);
				}

				if (fL.getSource() == txtNome) {
					if (txtNome.getText() == ""
							|| txtNome.getText().length() < 2
							|| txtNome.getText().length() > 40) {
						lnameErr.setVisible(true);
						txtNome.setBackground(Color.red);
					} else
						lnameErr.setVisible(false);
				}
				if (fL.getSource() == txtBI) {
					boolean l = bi();
					if (txtBI.getText() == "" || txtBI.getText().length() != 13
							|| !l) {
						lbiErr.setVisible(true);
						txtBI.setBackground(Color.red);
					} else
						lbiErr.setVisible(false);
				}
			} catch (NumberFormatException nfE) {
				if (fL.getSource() == txtCod) {
					lcodeErr.setVisible(true);
					txtCod.setBackground(Color.red);
				}
				if (fL.getSource() == txtContacto) {
					lcontactoErr.setVisible(true);
					txtContacto.setBackground(Color.red);
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

	private class TrataBotoes implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			if (ae.getSource() == btnCancelar) {
				dispose();
			}
			if (ae.getSource() == btnLimpar) {
				txtBI.setText("");
				txtCod.setText("");
				txtContacto.setText("");
				txtEndereco.setText("");
				txtNome.setText("");
				txtValor.setText("0.0");
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
			}
			if (ae.getSource() == btnOk) {
				if (!lcodeErr.isVisible() && !lcontactoErr.isVisible()
						&& !lenderecoErr.isVisible() && !lnameErr.isVisible()
						&& !lbiErr.isVisible()
						&& cmbArea.getSelectedIndex() != 0
						&& serDom.isVisible() && serDom.getSelectedIndex() != 0
						|| serEle.isVisible() && serEle.getSelectedIndex() != 0
						|| serInfo.isVisible()
						&& serInfo.getSelectedIndex() != 0
						|| serConstr.isVisible()
						&& serConstr.getSelectedIndex() != 0) {
					Cliente cl = new Cliente();
					cl.setArea(cmbArea.getSelectedItem().toString());
					if (serDom.isVisible())
						cl.setTipoServico(serDom.getSelectedItem().toString());
					if (serEle.isVisible())
						cl.setTipoServico(serEle.getSelectedItem().toString());
					if (serInfo.isVisible())
						cl.setTipoServico(serInfo.getSelectedItem().toString());
					if (serConstr.isVisible())
						cl.setTipoServico(serConstr.getSelectedItem()
								.toString());
					cl.setPreco(Float.parseFloat(txtValor.getText()));
					cl.setCodigo("VS-" + txtCod.getText());
					cl.setNome(txtNome.getText());
					cl.setContacto(Long.parseLong(txtContacto.getText()));
					cl.setEndereco(txtEndereco.getText());
					cl.setBi(txtBI.getText());
					cl.setTipoContrato(cmbTipoServ.getSelectedItem().toString());
					vec.add(cl);
					vec.trimToSize();
					Gravacao g = new Gravacao();
					g.gravarUltimo(vec);
					JOptionPane.showMessageDialog(null, "Cliente Registado!");
					dispose();
				} else
					JOptionPane
							.showMessageDialog(null,
									"Por favor preencha todos campos com dados validos");
			}
		}
	}

	private class TrataComboBoxes implements ItemListener {
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
	}
}