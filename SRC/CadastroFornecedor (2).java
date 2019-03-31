import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class CadastroFornecedor extends JFrame {
	private Container c;
	private JButton btnOk, btnCancelar, btnLimpar;
	private JTextField txtCod, txtNome, txtEndereco, txtContacto,
			txtEquipamento, txtQuantidade, txtValor;
	private JComboBox cmbArea, serDom, serEle, serInfo, serConstr,
			indisponivel;
	private String[] area = { "Selecione a  Área ", "Construção", "Domésticos",
			"Eléctricos e Hidricos", "Informática" }, serInformatica = {
			"Selecione o Serviço ", "Redes", "Manutenção", "Reparação",
			"Montagem" }, serDomestica = { "Selecione o Serviço ", "Baba",
			"Empregada", "Jardineiro" }, serElectrico = {
			"Selecione o Serviço", "Instalação", "Canalização" },
			serConstrucao = { "Selecione o Serviço ", "Pedreiro", "Pintor" };
	private BorderLayout blyt;
	private JPanel painel1, painel2;
	private JLabel lcode, lcodeErr, lname, lnameErr, lendereco, lenderecoErr,
			lcontacto, lcontactoErr, larea, lareaErr, lquantidade,
			lquantidadeErr, lservico, lservicoErr, ltipodeServ, ltipodeServErr,
			lvalPagar, lvalPagarErr, ltipoEquipamento, ltipoEquipamentoErr;
	private GridBagLayout g;
	private GridBagConstraints gc;
	private Vector vec;

	public CadastroFornecedor(Vector v) {
		super("Registro do Fornecedor");
		setSize(500, 300);
		setVisible(true);
		vec = v;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		VectorServico s = new VectorServico();
		c = getContentPane();
		blyt = new BorderLayout();
		c.setLayout(blyt);
		g = new GridBagLayout();
		TrataBotoes tb = new TrataBotoes();
		painel1 = new JPanel();
		btnOk = new JButton("Ok");
		btnOk.setToolTipText("Pressione para registar");
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setToolTipText("Pressione para cancelar o registo");
		btnLimpar = new JButton("Limpar");
		btnLimpar.setToolTipText("Pressione para limpar todos campos");
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
		lcode = new JLabel("Código do Fornecedor:");
		painel2.add(lcode, gc);
		gc.gridy++;
		lname = new JLabel("Nome: ");
		painel2.add(lname, gc);
		gc.gridy++;
		lendereco = new JLabel("Endereço: ");
		painel2.add(lendereco, gc);
		gc.gridy++;
		lcontacto = new JLabel("Contacto: ");
		painel2.add(lcontacto, gc);
		gc.gridy++;
		lquantidade = new JLabel("Quantidade: ");
		painel2.add(lquantidade, gc);
		gc.gridy++;
		ltipoEquipamento = new JLabel("Tipo de Equipamento");
		painel2.add(ltipoEquipamento, gc);
		gc.gridy++;
		larea = new JLabel("Área: ");
		painel2.add(larea, gc);
		gc.gridy++;
		lservico = new JLabel("Serviço: ");
		painel2.add(lservico, gc);
		gc.gridy++;
		lvalPagar = new JLabel("Valor a Pagar:");
		painel2.add(lvalPagar, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		txtCod = new JTextField(20);
		txtCod.setToolTipText("Escreva aqui o codigo do Fornecedor,nao pode ser igual a um dos que já foram gravados");
		painel2.add(txtCod, gc);
		gc.gridy++;
		txtNome = new JTextField(20);
		txtNome.setToolTipText("Escreva aqui o nome do Fornecedor");
		painel2.add(txtNome, gc);
		gc.gridy++;
		txtEndereco = new JTextField(20);
		txtEndereco.setToolTipText("Escreva aqui o endereço do cliente");
		painel2.add(txtEndereco, gc);
		gc.gridy++;
		txtContacto = new JTextField(20);
		txtContacto
				.setToolTipText("Escreva o seu Telemovel(82/84/86/87)xxxxxxx");
		painel2.add(txtContacto, gc);
		gc.gridy++;
		txtQuantidade = new JTextField(20);
		txtQuantidade.setToolTipText("Escreva aqui a Quantiade de Equipamento");
		painel2.add(txtQuantidade, gc);
		gc.gridy++;
		txtEquipamento = new JTextField(20);
		txtEquipamento.setToolTipText("Escreva o nome do equipamento");
		painel2.add(txtEquipamento, gc);
		gc.gridy++;
		cmbArea = new JComboBox(area);
		cmbArea.setToolTipText("Selecione a area");
		painel2.add(cmbArea, gc);
		gc.gridy++;
		indisponivel = new JComboBox();
		indisponivel.setVisible(true);
		indisponivel.addItem("Primeiro Selecione a Área");
		indisponivel.setToolTipText("Por favor primeiro selecione a area");
		serConstr = new JComboBox(serConstrucao);
		serConstr.setToolTipText("Selecione o servico de construcao");
		serConstr.setVisible(false);
		serDom = new JComboBox(serDomestica);
		serDom.setToolTipText("Selecione o servico domestico");
		serDom.setVisible(false);
		serEle = new JComboBox(serElectrico);
		serEle.setToolTipText("Selecione o servico electrico ou hidrico");
		serEle.setVisible(false);
		serInfo = new JComboBox(serInformatica);
		serInfo.setToolTipText("Selecione o servico informatico");
		serInfo.setVisible(false);
		painel2.add(indisponivel, gc);
		painel2.add(serConstr, gc);
		painel2.add(serDom, gc);
		painel2.add(serEle, gc);
		painel2.add(serInfo, gc);
		gc.gridy++;
		txtValor = new JTextField(20);
		txtValor.setToolTipText("O valor a pagar pelo equipamento");
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
		gc.gridy++;
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
		lquantidadeErr = new JLabel("Quantidade Invalida");
		lquantidadeErr.setForeground(Color.red);
		lquantidadeErr.setVisible(false);
		painel2.add(lquantidadeErr, gc);
		gc.gridy++;

		ltipoEquipamentoErr = new JLabel("Equipamento Invalido");
		ltipoEquipamentoErr.setForeground(Color.red);
		ltipoEquipamentoErr.setVisible(false);
		painel2.add(ltipoEquipamentoErr, gc);
		gc.gridy += 3;
		lvalPagarErr = new JLabel("Valor Invalido");
		lvalPagarErr.setForeground(Color.red);
		lvalPagarErr.setVisible(false);
		painel2.add(lvalPagarErr, gc);
		c.add(painel2, blyt.WEST);
		btnOk.addActionListener(tb);
		btnLimpar.addActionListener(tb);
		btnCancelar.addActionListener(tb);
		TrataComboBoxes y = new TrataComboBoxes();
		cmbArea.addItemListener(y);
		TrataTexto tT = new TrataTexto();
		txtCod.addFocusListener(tT);
		txtContacto.addFocusListener(tT);
		txtEndereco.addFocusListener(tT);
		txtEquipamento.addFocusListener(tT);
		txtNome.addFocusListener(tT);
		txtQuantidade.addFocusListener(tT);
		txtValor.addFocusListener(tT);
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
			if (fG.getSource() == txtEquipamento && txtEquipamento.isVisible()) {
				txtEquipamento.setBackground(Color.white);
			}
			if (fG.getSource() == txtNome && lnameErr.isVisible()) {
				txtNome.setBackground(Color.white);
			}
			if (fG.getSource() == txtQuantidade && lquantidadeErr.isVisible()) {
				txtQuantidade.setBackground(Color.white);
			}
			if (fG.getSource() == txtValor && lvalPagarErr.isVisible()) {
				txtValor.setBackground(Color.white);
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
				if (fL.getSource() == txtEquipamento) {
					if (txtEquipamento.getText() == ""
							|| txtEquipamento.getText().length() < 2
							|| txtEquipamento.getText().length() > 20) {
						ltipoEquipamentoErr.setVisible(true);
						txtEquipamento.setBackground(Color.red);
					} else
						ltipoEquipamentoErr.setVisible(false);
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
				if (fL.getSource() == txtQuantidade) {
					if (Short.parseShort(txtQuantidade.getText()) < 5
							|| Short.parseShort(txtQuantidade.getText()) > 1000) {
						lquantidadeErr.setVisible(true);
						txtQuantidade.setBackground(Color.red);
					} else
						lquantidadeErr.setVisible(false);
				}
				if (fL.getSource() == txtValor) {
					if (Float.parseFloat(txtValor.getText()) < 10
							|| Float.parseFloat(txtValor.getText()) > 10000) {
						lvalPagarErr.setVisible(true);
						txtValor.setBackground(Color.red);
					} else
						lvalPagarErr.setVisible(false);
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
				if (fL.getSource() == txtQuantidade) {
					lquantidadeErr.setVisible(true);
					txtQuantidade.setBackground(Color.red);
				}
				if (fL.getSource() == txtValor) {
					lvalPagarErr.setVisible(true);
					txtValor.setBackground(Color.red);
				}
			}
		}
	}

	private class TrataBotoes implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == btnCancelar) {
				dispose();
			}
			if (ae.getSource() == btnLimpar) {
				txtCod.setText("");
				txtContacto.setText("");
				txtEndereco.setText("");
				txtEquipamento.setText("");
				txtNome.setText("");
				txtQuantidade.setText("");
				txtValor.setText("");
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
			}
			if (ae.getSource() == btnOk) {
				if (!lcodeErr.isVisible() && !lcontactoErr.isVisible()
						&& !lenderecoErr.isVisible() && !lnameErr.isVisible()
						&& !lquantidadeErr.isVisible()
						&& !ltipoEquipamentoErr.isVisible()
						&& !lvalPagarErr.isVisible()
						&& cmbArea.getSelectedIndex() != 0
						&& serDom.isVisible() && serDom.getSelectedIndex() != 0
						|| serEle.isVisible() && serEle.getSelectedIndex() != 0
						|| serInfo.isVisible()
						&& serInfo.getSelectedIndex() != 0
						|| serConstr.isVisible()
						&& serConstr.getSelectedIndex() != 0) {
					Fornecedor forn = new Fornecedor();
					forn.setArea(cmbArea.getSelectedItem().toString());
					forn.setPreco(Float.parseFloat(txtValor.getText()));
					if (serDom.isVisible())
						forn.setTipoServico(serDom.getSelectedItem().toString());
					if (serEle.isVisible())
						forn.setTipoServico(serEle.getSelectedItem().toString());
					if (serInfo.isVisible())
						forn.setTipoServico(serInfo.getSelectedItem()
								.toString());
					if (serConstr.isVisible())
						forn.setTipoServico(serConstr.getSelectedItem()
								.toString());
					forn.setCodigo("FS-" + txtCod.getText());
					forn.setNome(txtNome.getText());
					forn.setContacto(Long.parseLong(txtContacto.getText()));
					forn.setEndereco(txtEndereco.getText());
					forn.setEquipamento(txtEquipamento.getText());
					forn.setQuantidade(Short.parseShort(txtQuantidade.getText()));
					vec.add(forn);
					vec.trimToSize();
					Gravacao g = new Gravacao();
					g.gravarUltimo(vec);
					JOptionPane.showMessageDialog(null, "Fornecedor registado!");
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