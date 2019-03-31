import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Administrador extends JFrame {
	private JMenuBar barra;
	private JMenu mFicheiro, mEditar, mCriar, mRemover, mVisualizar, mProcurar,
			mOrdenar, mEstatisticas, mConta, mSobre, mSMedias, mSSValores;
	private JMenuItem miFiLer, miFiGravar, miFiSair, miEdCliente,
			miEdFornecedor, miEdFuncionario, miCrCliente, miCrFornecedor,
			miCrFuncionario, miReCliente, miReFornecedor, miReFuncionario,
			miViTudo, miViCliente, miViFornecedor, miViFuncionario,
			miPrCliente, miPrFornecedor, miPrFuncionario, miOrCliente,
			miOrFornecedor, miOrFuncionario, miEsQtdFuncionario, miEsTotalArea,
			miEsTotalEmpresa, miEsAreaMaisFuncionario,
			miEsServicoMaisRequisitado, miEsFuncionarioAntigo,
			miEsTotalServico, miEsMeVaClientePorServico,
			miEsMeVaFuncionarioPorArea, miEsMeIdade, miEsMeFuncionarioPorArea,
			miCoCriar, miCoEliminar, miCoAlterarPass, miCoAlterarNome,
			miCoSair, miSoProgramadores, miSoPrograma, miSoAjuda;
	private VectorServico vecSer;
	// private JLabel fundo;
	private JDesktopPane deskPane;
	private Container c;

	public Administrador() {
		super("GESER");
		c = getContentPane();
		c.setLayout(new FlowLayout());
		// fundo = new JLabel();
		// fundo.setIcon(new ImageIcon("negocio.jpg"));
		// c.add(fundo);

		vecSer = new VectorServico();
		miFiLer = new JMenuItem("Ler...");
		miFiLer.setIcon(new ImageIcon("Ler.png"));
		miFiGravar = new JMenuItem("Gravar...");
		miFiGravar.setIcon(new ImageIcon("Gravar.png"));
		miFiSair = new JMenuItem("Sair");
		miFiSair.setIcon(new ImageIcon("sair.png"));
		miEdCliente = new JMenuItem("Cliente");
		miEdCliente.setIcon(new ImageIcon("Cliente.png"));
		miEdFornecedor = new JMenuItem("Fornecedor");
		miEdFornecedor.setIcon(new ImageIcon("Fornecedor.png"));
		miEdFuncionario = new JMenuItem("Funcionario");
		miEdFuncionario.setIcon(new ImageIcon("Funcionario.png"));
		miCrCliente = new JMenuItem("Cliente");
		miCrCliente.setIcon(new ImageIcon("Cliente.png"));
		miCrFornecedor = new JMenuItem("Fornecedor");
		miCrFornecedor.setIcon(new ImageIcon("Fornecedor.png"));
		miCrFuncionario = new JMenuItem("Funcionário");
		miCrFuncionario.setIcon(new ImageIcon("Funcionario.png"));
		miReCliente = new JMenuItem("Cliente");
		miReCliente.setIcon(new ImageIcon("Cliente.png"));
		miReFornecedor = new JMenuItem("Fornecedor");
		miReFornecedor.setIcon(new ImageIcon("Fornecedor.png"));
		miReFuncionario = new JMenuItem("Funcionário");
		miReFuncionario.setIcon(new ImageIcon("Funcionario.png"));
		miViTudo = new JMenuItem("Todos dados");
		miViTudo.setIcon(new ImageIcon("Todos.png"));
		miViCliente = new JMenuItem("Clientes");
		miViCliente.setIcon(new ImageIcon("Cliente.png"));
		miViFornecedor = new JMenuItem("Fornecedores");
		miViFornecedor.setIcon(new ImageIcon("Fornecedor.png"));
		miViFuncionario = new JMenuItem("Funcionários");
		miViFuncionario.setIcon(new ImageIcon("Funcionario.png"));
		miPrCliente = new JMenuItem("Cliente");
		miPrCliente.setIcon(new ImageIcon("Cliente.png"));
		miPrFornecedor = new JMenuItem("Fornecedor");
		miPrFornecedor.setIcon(new ImageIcon("Fornecedor.png"));
		miPrFuncionario = new JMenuItem("Funcionario");
		miPrFuncionario.setIcon(new ImageIcon("Funcionario.png"));
		miOrCliente = new JMenuItem("Cliente pelo valor pago");
		miOrCliente.setIcon(new ImageIcon("Cliente.png"));
		miOrFornecedor = new JMenuItem("Fornecedor pela quantidade");
		miOrFornecedor.setIcon(new ImageIcon("Fornecedor.png"));
		miOrFuncionario = new JMenuItem("Funcionario pelo ano de Admissão");
		miOrFuncionario.setIcon(new ImageIcon("Funcionario.png"));
		miEsQtdFuncionario = new JMenuItem("Quantidade de funcionarios");
		miEsQtdFuncionario.setIcon(new ImageIcon("Quantidade.png"));
		miEsTotalArea = new JMenuItem("Total recebido por area");
		miEsTotalArea.setIcon(new ImageIcon("Total.png"));
		miEsTotalEmpresa = new JMenuItem("Total recebido pela empresa");
		miEsTotalEmpresa.setIcon(new ImageIcon("Total.png"));
		miEsAreaMaisFuncionario = new JMenuItem("Area com mais funcionários");
		miEsAreaMaisFuncionario.setIcon(new ImageIcon("Maior.jpg"));
		miEsServicoMaisRequisitado = new JMenuItem("Serviço mais requisitados");
		miEsServicoMaisRequisitado.setIcon(new ImageIcon("Maior.jpg"));
		miEsFuncionarioAntigo = new JMenuItem("Funcionario(s) mais antigo(s)");
		miEsFuncionarioAntigo.setIcon(new ImageIcon("Maior.jpg"));
		miEsTotalServico = new JMenuItem("Total por servico");
		miEsTotalServico.setIcon(new ImageIcon("Total.png"));
		miEsMeVaClientePorServico = new JMenuItem("Clientes por area");
		miEsMeVaClientePorServico.setIcon(new ImageIcon("Media.jpg"));
		miEsMeVaFuncionarioPorArea = new JMenuItem("Funcionários por area");
		miEsMeVaFuncionarioPorArea.setIcon(new ImageIcon("Media.jpg"));
		miEsMeIdade = new JMenuItem("Idade");
		miEsMeIdade.setIcon(new ImageIcon("Media.jpg"));
		miEsMeFuncionarioPorArea = new JMenuItem("Funcionarios por area");
		miEsMeFuncionarioPorArea.setIcon(new ImageIcon("Quantidade.png"));
		miCoCriar = new JMenuItem("Criar nova conta");
		miCoCriar.setIcon(new ImageIcon("Criar.png"));
		miCoEliminar = new JMenuItem("Eliminar conta");
		miCoEliminar.setIcon(new ImageIcon("Remover.jpg"));
		miCoAlterarPass = new JMenuItem("Alterar palavra passe");
		miCoAlterarPass.setIcon(new ImageIcon("Editar.jpg"));
		miCoAlterarNome = new JMenuItem("Alterar nome de utilizador");
		miCoAlterarNome.setIcon(new ImageIcon("Editar.jpg"));
		miCoSair = new JMenuItem("Terminar sessao");
		miCoSair.setIcon(new ImageIcon("sair.png"));
		miSoProgramadores = new JMenuItem("Programadores");
		miSoProgramadores.setIcon(new ImageIcon("Programadores.png"));
		miSoPrograma = new JMenuItem("Programa");
		miSoPrograma.setIcon(new ImageIcon("Programa.png"));
		miSoAjuda = new JMenuItem("Ajuda");
		miSoAjuda.setIcon(new ImageIcon("Ajuda.jpg"));

		mFicheiro = new JMenu("Ficheiro");
		mFicheiro.setIcon(new ImageIcon("Ficheiro.png"));

		mEditar = new JMenu("Editar");
		mEditar.setIcon(new ImageIcon("editar.jpg"));

		mCriar = new JMenu("Criar");
		mCriar.setIcon(new ImageIcon("Criar.png"));

		mRemover = new JMenu("Remover");
		mRemover.setIcon(new ImageIcon("Remover.jpg"));

		mVisualizar = new JMenu("Visualizar");
		mVisualizar.setIcon(new ImageIcon("visualizar.png"));

		mProcurar = new JMenu("Procurar");
		mProcurar.setIcon(new ImageIcon("search1.png"));

		mOrdenar = new JMenu("Ordenar");
		mOrdenar.setIcon(new ImageIcon("Ordenar.jpg"));

		mEstatisticas = new JMenu("Estatisticas");
		mEstatisticas.setIcon(new ImageIcon("estatisticas.png"));
		mConta = new JMenu("Conta");
		mConta.setIcon(new ImageIcon("Conta.jpg"));
		mSobre = new JMenu("Sobre");
		mSobre.setIcon(new ImageIcon("sobre.png"));

		mSMedias = new JMenu("Medias");
		mSMedias.setIcon(new ImageIcon("Media.jpg"));
		mSSValores = new JMenu("Valores");
		mSSValores.setIcon(new ImageIcon("Media.jpg"));
		barra = new JMenuBar();

		mFicheiro.add(miFiLer);
		mFicheiro.add(miFiGravar);
		mFicheiro.add(miFiSair);

		mEditar.add(miEdCliente);
		mEditar.add(miEdFornecedor);
		mEditar.add(miEdFuncionario);

		mCriar.add(miCrCliente);
		mCriar.add(miCrFornecedor);
		mCriar.add(miCrFuncionario);

		mRemover.add(miReCliente);
		mRemover.add(miReFornecedor);
		mRemover.add(miReFuncionario);

		mVisualizar.add(miViTudo);
		mVisualizar.add(miViCliente);
		mVisualizar.add(miViFornecedor);
		mVisualizar.add(miViFuncionario);

		mProcurar.add(miPrCliente);
		mProcurar.add(miPrFornecedor);
		mProcurar.add(miPrFuncionario);

		mOrdenar.add(miOrCliente);
		mOrdenar.add(miOrFornecedor);
		mOrdenar.add(miOrFuncionario);

		mEstatisticas.add(miEsQtdFuncionario);
		mEstatisticas.add(mSMedias);
		mSMedias.add(mSSValores);
		mSSValores.add(miEsMeVaClientePorServico);
		mSSValores.add(miEsMeVaFuncionarioPorArea);
		mSMedias.add(miEsMeIdade);
		mSMedias.add(miEsMeFuncionarioPorArea);
		mEstatisticas.add(miEsTotalServico);
		mEstatisticas.add(miEsTotalArea);
		mEstatisticas.add(miEsTotalEmpresa);
		mEstatisticas.add(miEsAreaMaisFuncionario);
		mEstatisticas.add(miEsServicoMaisRequisitado);
		mEstatisticas.add(miEsFuncionarioAntigo);

		mConta.add(miCoCriar);
		mConta.add(miCoEliminar);
		mConta.add(miCoAlterarNome);
		mConta.add(miCoAlterarPass);
		mConta.add(miCoSair);

		mSobre.add(miSoProgramadores);
		mSobre.add(miSoPrograma);
		mSobre.add(miSoAjuda);

		setJMenuBar(barra);
		barra.add(mFicheiro);
		barra.add(mEditar);
		barra.add(mCriar);
		barra.add(mRemover);
		barra.add(mVisualizar);
		barra.add(mProcurar);
		barra.add(mOrdenar);
		barra.add(mEstatisticas);
		barra.add(mConta);
		barra.add(mSobre);

		EventosButoes eb = new EventosButoes();

		miFiLer.addActionListener(eb);
		miFiGravar.addActionListener(eb);
		miFiSair.addActionListener(eb);
		miEdCliente.addActionListener(eb);
		miEdFornecedor.addActionListener(eb);
		miEdFuncionario.addActionListener(eb);
		miCrCliente.addActionListener(eb);
		miCrFornecedor.addActionListener(eb);
		miCrFuncionario.addActionListener(eb);
		miReCliente.addActionListener(eb);
		miReFornecedor.addActionListener(eb);
		miReFuncionario.addActionListener(eb);
		miViTudo.addActionListener(eb);
		miViCliente.addActionListener(eb);
		miViFornecedor.addActionListener(eb);
		miViFuncionario.addActionListener(eb);
		miPrCliente.addActionListener(eb);
		miPrFornecedor.addActionListener(eb);
		miPrFuncionario.addActionListener(eb);
		miOrCliente.addActionListener(eb);
		miOrFornecedor.addActionListener(eb);
		miOrFuncionario.addActionListener(eb);
		miEsTotalArea.addActionListener(eb);
		miEsTotalEmpresa.addActionListener(eb);
		miEsAreaMaisFuncionario.addActionListener(eb);
		miEsServicoMaisRequisitado.addActionListener(eb);
		miEsFuncionarioAntigo.addActionListener(eb);
		miEsTotalServico.addActionListener(eb);
		miEsQtdFuncionario.addActionListener(eb);
		miEsMeVaClientePorServico.addActionListener(eb);
		miEsMeVaFuncionarioPorArea.addActionListener(eb);
		miEsMeIdade.addActionListener(eb);
		miEsMeFuncionarioPorArea.addActionListener(eb);
		miCoCriar.addActionListener(eb);
		miCoEliminar.addActionListener(eb);
		miCoAlterarPass.addActionListener(eb);
		miCoAlterarNome.addActionListener(eb);
		miCoSair.addActionListener(eb);
		miSoProgramadores.addActionListener(eb);
		miSoPrograma.addActionListener(eb);
		miSoAjuda.addActionListener(eb);

		setVisible(true);
		setLocation(36, 60);
		setSize(1000, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class EventosButoes implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == miFiLer) {
				vecSer.lerTxt();
			}
			if (ae.getSource() == miFiGravar) {
				vecSer.adapGravarInfFicheiroTudo();
			}
			if (ae.getSource() == miFiSair) {
				System.exit(0);
			}
			if (ae.getSource() == miEdCliente) {
			}
			if (ae.getSource() == miEdFornecedor) {
			}
			if (ae.getSource() == miEdFuncionario) {
			}
			if (ae.getSource() == miCrCliente) {
				vecSer.lerCliente();
			}
			if (ae.getSource() == miCrFornecedor) {
				vecSer.lerFornecedor();
			}
			if (ae.getSource() == miCrFuncionario) {
				vecSer.lerFuncionario();
			}
			if (ae.getSource() == miReCliente) {
				vecSer.adapRemoverCliente();
			}
			if (ae.getSource() == miReFornecedor) {
				vecSer.adapRemoverFornecedor();
			}
			if (ae.getSource() == miReFuncionario) {
				vecSer.adapRemoverFuncionario();
			}
			if (ae.getSource() == miViTudo) {
				vecSer.adapVisualizarTudo();
			}
			if (ae.getSource() == miViCliente) {
				vecSer.adapVisualCliente();
			}
			if (ae.getSource() == miViFornecedor) {
				vecSer.adapVisualFornecedor();
			}
			if (ae.getSource() == miViFuncionario) {
				vecSer.adapVisualFuncionario();
			}
			if (ae.getSource() == miPrCliente) {
				vecSer.adapPesquisarCliente();
			}
			if (ae.getSource() == miPrFornecedor) {
				vecSer.adapPesquisarFornecedor();
			}
			if (ae.getSource() == miPrFuncionario) {
				vecSer.adapPesquisarFuncionario();
			}
			if (ae.getSource() == miOrCliente) {
				vecSer.adapOrdenaClientePreco();
			}
			if (ae.getSource() == miOrFornecedor) {
				vecSer.adapOrdenaFornecedorQuantidade();
			}
			if (ae.getSource() == miOrFuncionario) {
				vecSer.adapOrdenaFuncionarioIdade();
			}
			if (ae.getSource() == miEsQtdFuncionario) {
				vecSer.adapQtdFun();
			}
			if (ae.getSource() == miEsMeVaClientePorServico) {
				vecSer.adapCalcMediaClienteServico();
			}
			if (ae.getSource() == miEsMeVaFuncionarioPorArea) {
				vecSer.adapCalcMediaFuncionarioSector();
			}
			if (ae.getSource() == miEsMeIdade) {
				vecSer.adpIdadeMediaFuncionario();
			}
			if (ae.getSource() == miEsMeFuncionarioPorArea) {
				vecSer.adapQtdMedFuncGen();
			}
			if (ae.getSource() == miEsTotalServico) {
				vecSer.adapServicPagoPorCliente();
			}
			if (ae.getSource() == miEsTotalArea) {
				vecSer.adapCalcValorRecebidoSector();
			}
			if (ae.getSource() == miEsTotalEmpresa) {
				vecSer.adapCalcValorTotalRecebido();
			}
			if (ae.getSource() == miEsAreaMaisFuncionario) {
				vecSer.adapAreaComMaisFunc();
			}
			if (ae.getSource() == miEsServicoMaisRequisitado) {
				vecSer.adapServMaisRequisitado();
			}
			if (ae.getSource() == miEsFuncionarioAntigo) {
				vecSer.adapFuncMaisAnos();
			}
			if (ae.getSource() == miCoCriar) {
				Conta con = new Conta();
			}
			if (ae.getSource() == miCoEliminar) {
				EliminarConta eCon = new EliminarConta();
			}
			if (ae.getSource() == miCoAlterarNome) {
				AlterarNome aN = new AlterarNome();
			}
			if (ae.getSource() == miCoAlterarPass) {
				AlterarPasse aP = new AlterarPasse();
			}
			if (ae.getSource() == miCoSair) {
				BemVindo bv = new BemVindo();
				dispose();
			}
			if (ae.getSource() == miSoProgramadores) {
				SobreProgramador sP = new SobreProgramador();
			}
			if (ae.getSource() == miSoPrograma) {
			}
			if (ae.getSource() == miSoAjuda) {
			}
		}
	}

	public static void main(String[] args) {
		Administrador jA = new Administrador();
	}
}