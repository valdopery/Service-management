import java.awt.*;
import java.util.Vector;

import javax.swing.*;

public class VisFuncionario extends JFrame {
	private Vector dados, auxDados, titulos;
	private JTable tabela;
	private JButton btnRegistar, btnOk, btnRemover;
	private JPanel pnSul;
	private BorderLayout brlyt;
	private JLabel l;
	private Container c;
	private VectorServico vSer;

	public VisFuncionario(Vector v) {
		super("Dados de funcionario");
		c = getContentPane();
		brlyt = new BorderLayout();
		c.setLayout(brlyt);
		btnRegistar = new JButton("Registar funcionario");
		btnOk = new JButton("OK");
		btnRemover = new JButton("Remover funcionario");
		titulos = new Vector();
		preencherVectorTitulos();
		dados = new Vector();
		preencherVectorDados(v);
		pnSul = new JPanel();
		pnSul.add(btnRegistar);
		pnSul.add(btnOk);
		pnSul.add(btnRemover);
		l = new JLabel("Tabela de Funcionario");
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

	public VisFuncionario(Vector v, int posicao) {
		super("Dados de funcionario");
		c = getContentPane();
		brlyt = new BorderLayout();
		c.setLayout(brlyt);
		btnRegistar = new JButton("Registar funcionario");
		btnOk = new JButton("OK");
		btnRemover = new JButton("Remover funcionario");
		titulos = new Vector();
		preencherVectorTitulos();
		dados = new Vector();
		preencherVectorDados(v, posicao);
		pnSul = new JPanel();
		pnSul.add(btnRegistar);
		pnSul.add(btnOk);
		pnSul.add(btnRemover);
		l = new JLabel("Tabela de Funcionario");
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
		Funcionario fu;
		for (int i = 0; i < v.size(); i++) {
			s = (Servico) v.elementAt(i);
			if (s instanceof Funcionario) {
				fu = (Funcionario) s;
				auxDados = new Vector();
				auxDados.add(fu.getArea());
				auxDados.add(fu.getTipoServico());
				auxDados.add(fu.getPreco());
				auxDados.add(fu.getCodigo());
				auxDados.add(fu.getNome());
				auxDados.add(fu.getContacto());
				auxDados.add(fu.getEndereco());
				auxDados.add(fu.getBi());
				auxDados.add(fu.getCidade());
				auxDados.add(fu.getAnoAdmissao());
				auxDados.add(fu.getGenero());
				auxDados.add(fu.getNivelAcademico());
				auxDados.add(fu.getIdade());
				dados.add(auxDados);
			}
		}
	}

	public void preencherVectorDados(Vector v, int posicao) {
		Servico s;
		Funcionario fu;
		s = (Servico) v.elementAt(posicao);
		fu = (Funcionario) s;
		auxDados = new Vector();
		auxDados.add(fu.getArea());
		auxDados.add(fu.getTipoServico());
		auxDados.add(fu.getPreco());
		auxDados.add(fu.getCodigo());
		auxDados.add(fu.getNome());
		auxDados.add(fu.getContacto());
		auxDados.add(fu.getEndereco());
		auxDados.add(fu.getBi());
		auxDados.add(fu.getCidade());
		auxDados.add(fu.getAnoAdmissao());
		auxDados.add(fu.getGenero());
		auxDados.add(fu.getNivelAcademico());
		auxDados.add(fu.getIdade());
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
		titulos.add("Ano de admissao");
		titulos.add("Genero");
		titulos.add("Nivel academico");
		titulos.add("Idade");
	}
}