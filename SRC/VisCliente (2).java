import java.awt.*;
import java.util.Vector;

import javax.swing.*;

public class VisCliente extends JFrame {
	private Vector v,dados, auxDados, titulos;
	private JTable tabela;
	private JButton btnRegistar, btnOk, btnRemover;
	private JPanel pnSul;
	private BorderLayout brlyt;
	private JLabel l;
	private Container c;
	private VectorServico vSer;

	public VisCliente(Vector v) {
		super("Dados de cliente");
		c = getContentPane();
		brlyt = new BorderLayout();
		c.setLayout(brlyt);
		btnRegistar = new JButton("Registar Cliente");
		btnOk = new JButton("OK");
		btnRemover = new JButton("Remover Cliente");

		titulos = new Vector();
		preencherVectorTitulos();

		dados = new Vector();
		preencherVectorDados(v);

		pnSul = new JPanel();
		pnSul.add(btnRegistar);
		pnSul.add(btnOk);
		pnSul.add(btnRemover);
		l = new JLabel("Tabela de Clientes");

		tabela = new JTable(dados, titulos);
		c.add(l, BorderLayout.NORTH);
		c.add(tabela, BorderLayout.CENTER);
		c.add(pnSul, BorderLayout.SOUTH);
		setVisible(true);
		setLocation(36, 60);
		setSize(1300, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public VisCliente( Vector v,int posicao) {
		super("Dados de cliente");
		c = getContentPane();
		brlyt = new BorderLayout();
		c.setLayout(brlyt);
		btnRegistar = new JButton("Registar Cliente");
		btnOk = new JButton("OK");
		btnRemover = new JButton("Remover Cliente");
		titulos = new Vector();
		preencherVectorTitulos();
		dados = new Vector();
		preencherVectorDados(v,posicao);
		pnSul = new JPanel();
		pnSul.add(btnRegistar);
		pnSul.add(btnOk);
		pnSul.add(btnRemover);
		l = new JLabel("Tabela de Clientes");
		tabela = new JTable(dados, titulos);
		c.add(l, BorderLayout.NORTH);
		c.add(tabela, BorderLayout.CENTER);
		c.add(pnSul, BorderLayout.SOUTH);
		setVisible(true);
		setLocation(36, 60);
		setSize(1300, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void preencherVectorDados(Vector v) {
		Servico s;
		Cliente cl;
		for (int i = 0; i < v.size(); i++) {
			s = (Servico) v.elementAt(i);
			if (s instanceof Cliente) {
				cl = (Cliente) s;
				auxDados = new Vector();
				auxDados.add(cl.getArea());
				auxDados.add(cl.getTipoServico());
				auxDados.add(cl.getPreco());
				auxDados.add(cl.getCodigo());
				auxDados.add(cl.getNome());
				auxDados.add(cl.getContacto());
				auxDados.add(cl.getEndereco());
				auxDados.add(cl.getBi());
				auxDados.add(cl.getCidade());
				auxDados.add(cl.getTipoContrato());
				dados.add(auxDados);
			}
		}
	}

	public void preencherVectorDados(Vector v, int posicao) {
		Servico s;
		Cliente cl;
		s = (Servico) v.elementAt(posicao);
		cl = (Cliente) s;
		auxDados = new Vector();
		auxDados.add(cl.getArea());
		auxDados.add(cl.getTipoServico());
		auxDados.add(cl.getPreco());
		auxDados.add(cl.getCodigo());
		auxDados.add(cl.getNome());
		auxDados.add(cl.getContacto());
		auxDados.add(cl.getEndereco());
		auxDados.add(cl.getBi());
		auxDados.add(cl.getCidade());
		auxDados.add(cl.getTipoContrato());
		dados.add(auxDados);
	}

	public void preencherVectorTitulos() {
		titulos.add("Area");
		titulos.add("Tipo de Servico");
		titulos.add("Preco");
		titulos.add("Codigo");
		titulos.add("Nome");
		titulos.add("Contacto");
		titulos.add("Endereco");
		titulos.add("Nº BI");
		titulos.add("Cidade");
		titulos.add("Tipo de contracto");
	}

}