import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class SobreProgramador extends JFrame {
	private String nomes[] = { "AdÃ©rito Mafundza", "FÃ¡usio Paco",
			"Ildovanda Alumene", "MÃ¡rcio Ngulube", "Valdo Perry" };
	private JList lista;
	private JLabel sobre, cabecalho;
	private JLabel nome, apelido, data, filiacao, email, localdeNascimento,
			firstStage, secondStage, thirdStage, last, aux1, aux2;
	private JPanel painel1;
	private JPanel painel2, painel3, painel0;
	private JButton cancelar;
	private JLabel fundo;
	private JList list;
	private Container c;
	private BorderLayout bl;
	private JRadioButton aderito, fausio, ildovanda, valdo, marcio;
	private Font letra, boldItalicFont;
	private ButtonGroup grupo1;

	public SobreProgramador() {
		super("Dados sobre o Programador");
		setVisible(true);
		setSize(1200, 800);
		TrataBotao b = new TrataBotao();
		c = getContentPane();
		bl = new BorderLayout();
		letra = new Font("Serif", Font.PLAIN, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 20);
		list = new JList(nomes);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (nomes[list.getSelectedIndex()].equalsIgnoreCase(nomes[0])) {
					fundo.setIcon(new ImageIcon("Aderito.jpg"));
					c.add(fundo, bl.CENTER);
					cabecalho.setText("Adérito Silvestre");
					cabecalho.setFont(boldItalicFont);
					nome.setText("Nome:Adérito Silvestre");
					nome.setFont(letra);

					apelido.setText("Apelido:Mafundza");
					apelido.setFont(letra);

					data.setText("Data:05/08/1995");

					data.setFont(letra);
					filiacao.setText("Filiação:Silvestre Xavier Mafundza e Aventina Domingos Matsimbe");
					filiacao.setFont(letra);

					email.setText("Email:aderitosky@hotmail.com");
					email.setFont(letra);

					localdeNascimento.setText("Maputo-Maputo");
					localdeNascimento.setFont(letra);

					firstStage
							.setText("1ª-7ªclasse -Estudou na Escola Primária completa 16 de Junho(Maputo)(2001-2007)");
					firstStage.setFont(letra);

					secondStage
							.setText("8ª-11ªclasse -Estudou na Escola Secundária Josina Machel(Maputo)(2008-2010)");
					secondStage.setFont(letra);

					thirdStage
							.setText("1-3-o ano -Estudou no instituto de Transportes e Comunicações(2011-2013)");
					thirdStage.setFont(letra);

					last.setText("Actualmente-1ᵒ ano de Eng. Informática no ISCTEM");

					last.setFont(letra);
					aux1.setText(" ");
					aux2.setText("");

					painel1.add(cabecalho);
					painel1.add(nome);
					painel1.add(apelido);
					painel1.add(data);
					painel1.add(filiacao);
					painel1.add(email);
					painel1.add(localdeNascimento);
					painel1.add(firstStage);
					painel1.add(secondStage);
					painel1.add(thirdStage);
					painel1.add(aux1);
					painel1.add(aux2);
					painel1.add(last);
					c.add(painel1, bl.WEST);
				}
				if (nomes[list.getSelectedIndex()].equalsIgnoreCase(nomes[1])) {
					fundo.setIcon(new ImageIcon("Fausio.JPG"));
					cabecalho.setText("Fáusio Paco");
					cabecalho.setFont(boldItalicFont);
					nome.setText("Nome:Fáusio Heber Moisés");
					nome.setFont(letra);
					apelido.setText("Apelido:Paco");
					apelido.setFont(letra);
					data.setText("Data:18/01/1997");
					data.setFont(letra);
					filiacao.setText("Filiação:Moisés Paco e Otilia Salvador Mazivila");
					filiacao.setFont(letra);
					email.setText("Email:fausio18.paco@gmail.com");
					email.setFont(letra);
					localdeNascimento.setText("Maputo-Maputo");
					localdeNascimento.setFont(letra);

					firstStage
							.setText("1ª-5ª classe -Estudou na Escola Primária da Bê-a-Bá(Maputo)(2001-2006)");
					firstStage.setFont(letra);
					secondStage
							.setText("6ª-7ª classe -Estudou na Escola Primária do Alto Maé(Maputo)(2007-2008)");
					secondStage.setFont(letra);
					thirdStage
							.setText("8ª-12ª classe-Estudou na Escola Secundária Francisco Manyanga(Maputo)(2009-2013)");
					thirdStage.setFont(letra);
					last.setText("Actualmente- 1-o  ano de Eng. Informática no ISCTEM");
					last.setFont(letra);
					aux1.setText("");
					aux2.setText("");

					painel1.add(cabecalho);
					painel1.add(nome);
					painel1.add(apelido);
					painel1.add(data);
					painel1.add(filiacao);
					painel1.add(email);
					painel1.add(localdeNascimento);
					painel1.add(firstStage);
					painel1.add(secondStage);
					painel1.add(thirdStage);
					painel1.add(aux1);
					painel1.add(aux2);
					painel1.add(last);
					c.add(painel1, bl.WEST);
				}
				if (nomes[list.getSelectedIndex()].equalsIgnoreCase(nomes[2])) {
					fundo.setIcon(new ImageIcon("Wanda.JPG"));
					c.add(fundo, bl.CENTER);
					cabecalho.setText("Ildovanda Alumene");
					cabecalho.setFont(boldItalicFont);
					nome.setText("Nome:Ildovanda Assalane");
					nome.setFont(letra);
					apelido.setText("Apelido:Alumene");
					apelido.setFont(letra);
					data.setText("Data:26/11/1996");
					data.setFont(letra);
					filiacao.setText("Filiação:Assalane Alumene e Abiba Amade");
					filiacao.setFont(letra);
					email.setText("Email:vanda.assalane@gmail.com");
					email.setFont(letra);
					localdeNascimento.setText("Maputo-Maputo");
					localdeNascimento.setFont(letra);

					firstStage
							.setText("1ª-5ª classe -Estudou na Escola Primária Filipe Samuel Magaia(Maputo)(2002-2006)");
					firstStage.setFont(letra);
					secondStage
							.setText("6ª classe -Estudou na Escola Primária e Secundária Miniarte(Tete)(2007)");
					secondStage.setFont(letra);
					thirdStage
							.setText("7ªclasse-Estudou na Escola Primária e Completa da Liberdade(Tete)(2008)");
					thirdStage.setFont(letra);
					aux1.setText("8ª-11ª classe- Estudou na Escola Secundária do Songo(Tete)(2009-2012)");
					aux1.setFont(letra);
					aux2.setText("12ª classe- Estudou na Escola da Hidroelétrica de Cahora Bassa(Tete)(2013)");
					aux2.setFont(letra);
					last.setText("Actualmente- 1-o ano de Eng. Informática no ISCTEM");
					last.setFont(letra);

					painel1.add(nome);
					painel1.add(apelido);
					painel1.add(data);
					painel1.add(filiacao);
					painel1.add(email);
					painel1.add(localdeNascimento);
					painel1.add(firstStage);
					painel1.add(secondStage);
					painel1.add(thirdStage);
					painel1.add(aux1);
					painel1.add(aux2);
					painel1.add(last);
					c.add(painel1, bl.CENTER);
				}
				if (nomes[list.getSelectedIndex()].equalsIgnoreCase(nomes[3])) {
					fundo.setIcon(new ImageIcon("Marcio.jpg"));
					c.add(fundo, bl.CENTER);
					cabecalho.setText("Márcio Ngulube");
					cabecalho.setFont(boldItalicFont);
					nome.setText("Nome:Márcio Armando Rolando");
					nome.setFont(letra);
					apelido.setText("Apelido:Ngulube");
					apelido.setFont(letra);
					data.setText("Data:25/01/1997");
					data.setFont(letra);
					filiacao.setFont(letra);
					email.setText("Email:marcio411@live.com");
					filiacao.setText("Filiação:Rolando Ngulube e Rosa Manuela Joao");
					email.setFont(letra);
					localdeNascimento.setText("Maputo-Maputo");
					localdeNascimento.setFont(letra);

					firstStage
							.setText("1ª-classe -Estudou no Externato Illundy (Maputo)(2002)");
					firstStage.setFont(letra);
					secondStage
							.setText("2ª-7ª classe -Estudou no colegio Nyamunda(Maputo)(2003-2008)");
					secondStage.setFont(letra);
					thirdStage
							.setText("8ª-12ªclasse-Estudou na Escola Secundária Francisco Manyanga(Maputo)(2009-2013)");
					thirdStage.setFont(letra);
					aux1.setText("");
					aux2.setText("");

					last.setText("Actualmente-1-o ano de Eng. Informática no ISCTEM");
					last.setFont(letra);

					painel1.add(nome);
					painel1.add(apelido);
					painel1.add(data);
					painel1.add(filiacao);
					painel1.add(email);
					painel1.add(localdeNascimento);
					painel1.add(firstStage);
					painel1.add(secondStage);
					painel1.add(thirdStage);
					painel1.add(aux1);
					painel1.add(aux2);
					painel1.add(last);
					c.add(painel1, bl.CENTER);
				}
				if (nomes[list.getSelectedIndex()].equalsIgnoreCase(nomes[4])) {
					fundo.setIcon(new ImageIcon("Valdo.jpg"));
					c.add(fundo, bl.CENTER);
					cabecalho.setText("Valdo Tivane");
					cabecalho.setFont(boldItalicFont);
					nome.setText("Nome:Valdo Paulo Pery Tivane");
					nome.setFont(letra);
					apelido.setText("Apelido:Tivane");
					apelido.setFont(letra);
					data.setText("Data:07/11/1996");
					data.setFont(letra);
					filiacao.setFont(letra);
					email.setText("Email:valdopierre032@gmail.com");
					filiacao.setText("Filiação:Manuel Pery Tivane & Angelina Paulo");
					email.setFont(letra);
					localdeNascimento.setText("Maputo-Maputo");
					localdeNascimento.setFont(letra);

					firstStage
							.setText("1ª-7ªclasse -Estudou na Escola primaria 3 de fevereiro (Maputo)(2002-2008)");
					firstStage.setFont(letra);
					secondStage
							.setText("8ª-12ªclasse-Estudou na Escola Secundária Josina Machel(Maputo)(2009-2013)");
					secondStage.setFont(letra);
					thirdStage.setText("");
					thirdStage.setFont(letra);
					aux1.setText("");
					aux2.setText("");

					last.setText("Actualmente- 1-o ano de Eng. Informática no ISCTEM");
					last.setFont(letra);

					painel1.add(nome);
					painel1.add(apelido);
					painel1.add(data);
					painel1.add(filiacao);
					painel1.add(email);
					painel1.add(localdeNascimento);
					painel1.add(firstStage);
					painel1.add(secondStage);
					painel1.add(thirdStage);
					painel1.add(aux1);
					painel1.add(aux2);
					painel1.add(last);
					c.add(painel1, bl.CENTER);
				}
			}
		});
		// Tratando parte de cima
		painel1 = new JPanel();
		sobre = new JLabel("Selecione o Programador:");
		painel1.add(sobre);
		painel1.setBackground(Color.gray);
		c.setLayout(bl);
		c.add(painel1, bl.NORTH);
		// Tratando a parte do BackGround
		fundo = new JLabel();
		fundo.setIcon(new ImageIcon("Aderito.jpg"));
		c.add(fundo, bl.CENTER);
		// Tratando do Botao de Baixo
		painel3 = new JPanel();
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(b);

		cancelar.setIcon(new ImageIcon("cancelar.gif"));
		painel3.add(cancelar);
		painel3.setBackground(Color.GRAY);

		c.add(painel3, bl.SOUTH);

		painel0 = new JPanel();
		painel0.setLayout(new BoxLayout(painel0, BoxLayout.Y_AXIS));
		painel0.add(list);
		c.add(painel0, bl.EAST);

		painel1 = new JPanel();
		painel1.setBackground(Color.lightGray);
		painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
		cabecalho = new JLabel("Adérito Silvestre");
		cabecalho.setFont(boldItalicFont);
		nome = new JLabel("Nome:Adérito Silvestre");
		nome.setFont(letra);

		apelido = new JLabel("Apelido:Mafundza");
		apelido.setFont(letra);

		data = new JLabel("Data:05/08/1995");

		data.setFont(letra);
		filiacao = new JLabel(
				"Filiação:Silvestre Xavier Mafundza e Aventina Domingos Matsimbe");
		filiacao.setFont(letra);

		email = new JLabel("Email:aderitosky@hotmail.com");
		email.setFont(letra);

		localdeNascimento = new JLabel("Maputo-Maputo");
		localdeNascimento.setFont(letra);

		firstStage = new JLabel(
				"1ª-7ªclasse -Estudou na Escola Primária completa 16 de Junho(Maputo)(2001-2007)");
		firstStage.setFont(letra);

		secondStage = new JLabel(
				"8ª-11ªclasse -Estudou na Escola Secundária Josina Machel(Maputo)(2008-2010)");
		secondStage.setFont(letra);

		thirdStage = new JLabel(
				"1ᵒ-3ᵒ ano -Estudou no instituto de Transportes e Comunicações(2011-2013)");
		thirdStage.setFont(letra);

		last = new JLabel("Actualmente-1ᵒ ano de Eng. Informática no ISCTEM");

		aux1 = new JLabel("");
		aux2 = new JLabel("");
		last.setFont(letra);

		painel1.add(cabecalho);
		painel1.add(nome);
		painel1.add(apelido);
		painel1.add(data);
		painel1.add(filiacao);
		painel1.add(email);
		painel1.add(localdeNascimento);
		painel1.add(firstStage);
		painel1.add(secondStage);
		painel1.add(thirdStage);
		painel1.add(aux1);
		painel1.add(aux2);
		painel1.add(last);
		c.add(painel1, bl.WEST);
		c.validate();
		c.repaint();
	}

	private class TrataBotao implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == cancelar) {
				dispose();
			}
		}
	}

	public static void main(String args[]) {
		SobreProgramador s = new SobreProgramador();
		s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
