import java.awt.*;
import java.util.Vector;

import javax.swing.*;

public class VisFornecedor extends JFrame {
	private Vector dados, auxDados, titulos;
	private JTable tabela;
	private JButton btnRegistar, btnOk, btnRemover;
	private JPanel pnSul;
	private BorderLayout brlyt;
	private JLabel l;
	private Container c;
	private VectorServico vSer;

	public VisFornecedor(Vector v) {
		super("Dados de Fornecedores");
		c = getContentPane();
		brlyt = new BorderLayout();
		c.setLayout(brlyt);
		btnRegistar = new JButton("Registar Fornecedor");
		btnOk = new JButton("OK");
		btnRemover = new JButton("Remover Fornecedor");
		titulos = new Vector();
		preencherVectorTitulos();
		dados = new Vector();
		preencherVectorDados(v);
		pnSul = new JPanel();
		pnSul.add(btnRegistar);
		pnSul.add(btnOk);
		pnSul.add(btnRemover);
		l = new JLabel("Tabela de Fornecedores");
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

	public VisFornecedor(Vector v, int posicao) {
		super("Dados de Fornecedores");
		c = getContentPane();
		brlyt = new BorderLayout();
		c.setLayout(brlyt);
		btnRegistar = new JButton("Registar Fornecedor");
		btnOk = new JButton("OK");
		btnRemover = new JButton("Remover Fornecedor");
		titulos = new Vector();
		preencherVectorTitulos();
		dados = new Vector();
		preencherVectorDados(v, posicao);
		pnSul = new JPanel();
		pnSul.add(btnRegistar);
		pnSul.add(btnOk);
		pnSul.add(btnRemover);
		l = new JLabel("Tabela de Fornecedores");
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
		Fornecedor f;
		for (int i = 0; i < v.size(); i++) {
			s = (Servico) v.elementAt(i);
			if (s instanceof Fornecedor) {
				f = (Fornecedor) s;
				auxDados = new Vector();
				auxDados.add(f.getArea());
				auxDados.add(f.getTipoServico());
				auxDados.add(f.getPreco());
				auxDados.add(f.getCodigo());
				auxDados.add(f.getNome());
				auxDados.add(f.getContacto());
				auxDados.add(f.getEndereco());
				auxDados.add(f.getEquipamento());
				auxDados.add(f.getQuantidade());
				dados.add(auxDados);
			}
		}
	}

	public void preencherVectorDados(Vector v, int posicao) {
		Servico s;
		Fornecedor f;
		s = (Servico) v.elementAt(posicao);
		f = (Fornecedor) s;
		auxDados = new Vector();
		auxDados.add(f.getArea());
		auxDados.add(f.getTipoServico());
		auxDados.add(f.getPreco());
		auxDados.add(f.getCodigo());
		auxDados.add(f.getNome());
		auxDados.add(f.getContacto());
		auxDados.add(f.getEndereco());
		auxDados.add(f.getEquipamento());
		auxDados.add(f.getQuantidade());
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
		titulos.add("Equipamento");
		titulos.add("Quantidade");
	}

}