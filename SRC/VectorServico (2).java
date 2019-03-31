import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VectorServico extends JFrame {
	Vector v;
	Validacoes val;
	Calculo calc;
	Cliente cli;
	Visualizacoes vis;
	TarefasComProcura tarf;
	Funcionario fun;
	Ordenacao ord;
	Gravacao g;
	Fornecedor forn;
	DecimalFormat mt;

	public VectorServico() {
		v = new Vector();
		val = new Validacoes();
		calc = new Calculo();
		cli = new Cliente();
		vis = new Visualizacoes();
		tarf = new TarefasComProcura();
		fun = new Funcionario();
		ord = new Ordenacao();
		g = new Gravacao();
		forn = new Fornecedor();
		mt = new DecimalFormat("###,###.00 Mt");
	}

	public File obterFicheiro() {
		JFileChooser fC = new JFileChooser();
		fC.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fC.setDialogTitle("Abrir");
		fC.setApproveButtonText("Abrir");
		fC.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter texto = new FileNameExtensionFilter(
				"texto .txt", "txt");
		fC.setFileFilter(texto);
		File ficheiro = null;
		boolean avancar = false;
		do {
			if (fC.showOpenDialog(getComponent(0)) == JFileChooser.APPROVE_OPTION) {
				ficheiro = fC.getSelectedFile();
				if (ficheiro.getName().equalsIgnoreCase("Dados.txt"))
					avancar = true;
				else
					JOptionPane
							.showMessageDialog(
									null,
									"O ficheiro introduzido é invalido\nO ficheiro de texto deve ter o nome \"Dados\"");
			}
		} while (!avancar);
		return ficheiro;
	}

	public void lerTxt() {
		StringTokenizer st;
		String linha, codigo, nome, bi, cidade, endereco, area, nivelAcademico, tipoServico, equipamento, tipoContrato;
		char genero, criterio;
		long contacto;
		short anoAdmissao, quantidade;
		float preco;
		byte idade;
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					obterFicheiro()));
			linha = br.readLine();
			while (linha != null) {
				st = new StringTokenizer(linha, ";");
				area = st.nextToken();
				preco = Float.parseFloat(st.nextToken());
				tipoServico = st.nextToken();
				codigo = st.nextToken();
				nome = st.nextToken();
				endereco = st.nextToken();
				contacto = Long.parseLong(st.nextToken());
				criterio = st.nextToken().charAt(0);
				if (criterio == 'f' || criterio == 'F') {
					equipamento = st.nextToken();
					quantidade = Short.parseShort(st.nextToken());
					criaFornecedor(area, preco, tipoServico, codigo, nome,
							endereco, contacto, equipamento, quantidade);
				} else if (criterio == 'i' || criterio == 'I') {
					bi = st.nextToken();
					criterio = st.nextToken().charAt(0);
					if (criterio == 't' || criterio == 'T') {
						anoAdmissao = Short.parseShort(st.nextToken());
						genero = st.nextToken().charAt(0);
						nivelAcademico = st.nextToken();
						idade = Byte.parseByte(st.nextToken());
						criaFuncionario(area, preco, tipoServico, codigo, nome,
								endereco, contacto, bi, anoAdmissao, genero,
								nivelAcademico, idade);
					} else if (criterio == 'c' || criterio == 'C') {
						tipoContrato = st.nextToken();
						criaCliente(area, preco, tipoServico, codigo, nome,
								endereco, contacto, bi, tipoContrato);
					}
				}
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Vector getVector() {
		return v;
	}

	public void criaFuncionario(String area, float preco, String tipoServico,
			String codigo, String nome, String endereco, long contacto,
			String bi, short anoAdmissao, char genero, String nivelAcademico,
			byte idade) {
		Funcionario f = new Funcionario();
		f.setArea(area);
		f.setPreco(preco);
		f.setTipoServico(tipoServico);
		f.setCodigo(codigo);
		f.setNome(nome);
		f.setContacto(contacto);
		f.setEndereco(endereco);
		f.setBi(bi);
		f.setNivelAcademico(nivelAcademico);
		f.setGenero(genero);
		f.setAnoAdmissao(anoAdmissao);
		f.setIdade(idade);
		v.add(f);
		v.trimToSize();
	}

	public void criaCliente(String area, float preco, String tipoServico,
			String codigo, String nome, String endereco, long contacto,
			String bi, String tipoContrato) {
		Cliente c = new Cliente();
		c.setArea(area);
		c.setTipoServico(tipoServico);
		c.setPreco(preco);
		c.setCodigo(codigo);
		c.setNome(nome);
		c.setContacto(contacto);
		c.setEndereco(endereco);
		c.setBi(bi);
		c.setTipoContrato(tipoContrato);
		v.add(c);
		v.trimToSize();
	}

	public void criaFornecedor(String area, float preco, String tipoServico,
			String codigo, String nome, String endereco, long contacto,
			String equipamento, short quantidade) {
		Fornecedor f = new Fornecedor();
		f.setArea(area);
		f.setPreco(preco);
		f.setTipoServico(tipoServico);
		f.setCodigo(codigo);
		f.setNome(nome);
		f.setContacto(contacto);
		f.setEndereco(endereco);
		f.setEquipamento(equipamento);
		f.setQuantidade(quantidade);
		v.add(f);
		v.trimToSize();
	}

	public void lerFuncionario() {
		CadastroFuncionario cF = new CadastroFuncionario(v);
	}

	public void lerCliente() {
		CadastroCliente cCli = new CadastroCliente(v);
	}

	public void lerFornecedor() {
		CadastroFornecedor cFor = new CadastroFornecedor(v);
	}

	public void adapGravarInfFicheiroTudo() {
		g.gravarTudo(v);
	}

	public void adapGravarInfFicheiroActualizada() {
		g.gravarUltimo(v);
	}

	public void adapGravarInfObjecto() {
		g.guardarObjecto(v);
	}

	public void adapLerInfObjecto() {
		g.lerDoFichObj("Gestao.dat");
	}

	public void adapVisualTudo() {
	}

	public void adapVisualFuncionario() {
		VisFuncionario vFu = new VisFuncionario(v);
	}

	public void adapVisualFornecedor() {
		VisFornecedor vF = new VisFornecedor(v);
	}

	public void adapVisualCliente() {
		VisCliente vC = new VisCliente(v);
	}

	public void adapRemoverCliente() {
		tarf.removerCliente(v, val.valString((byte) 3, (byte) 6,
				"Introduza o Codigo de Cliente\nEx:VS-111"));
		g.gravarTudo(v);
	}

	public void adapRemoverFuncionario() {
		tarf.removerFuncionario(v, val.valString((byte) 6, (byte) 6,
				"Introduza o codigo de Funcionario\nEx: AS-111"));
		g.gravarTudo(v);
	}

	public void adapRemoverFornecedor() {
		tarf.removerFornecedor(v, val.valString((byte) 6, (byte) 6,
				"Introduza o codigo do Fornecedor\nFS-111"));
		g.gravarTudo(v);
	}

	public void adapFuncMaisAnos() {
		JOptionPane.showMessageDialog(null, calc.funcMaisAnos(v));
	}

	public void adapCalcMediaFuncionarioSector() {
		float a = calc.calcMediaFuncionarioSector(v);
		JOptionPane.showMessageDialog(null,
				"Quantidade media de funcionarios por area: " + a);
	}

	public void adapCalcMediaClienteServico() {
		float m = calc.calcMediaClienteServico(v);
		JOptionPane.showMessageDialog(null,
				"Quantidade media de clientes por area: " + m);
	}

	public void adapQtdMedFuncGen() {
		float m, f;
		m = calc.calcMediaGen(v, 'm', 'M');
		f = calc.calcMediaGen(v, 'f', 'F');
		JOptionPane.showMessageDialog(null,
				"Quantidade media de funcionarios\nHomens: " + m
						+ "%\nMulheres: " + f + "%");
	}

	public void adapQtdFun() {
		int m, f;
		m = calc.qtdGenFuncionario(v, 'm', 'M');
		f = calc.qtdGenFuncionario(v, 'f', 'F');
		JOptionPane.showMessageDialog(null,
				"Quantidade de funcionarios\nHomens: " + m + "\nMulheres: " + f
						+ "\nTotal: " + (m + f));
	}

	public void adapCalcValorRecebidoSector() {
		float c, d, eh, inf;
		c = calc.calcValorRecebidoSector(v, "construcao");
		d = calc.calcValorRecebidoSector(v, "Domesticos");
		eh = calc.calcValorRecebidoSector(v, "Eletricos/Hidricos");
		inf = calc.calcValorRecebidoSector(v, "Informatica");
		JOptionPane.showMessageDialog(null,
				"Valor recebido por cada area:\nConstrucao: " + mt.format(c)
						+ "\nDomestico: " + mt.format(d)
						+ "\nElectricos ou Hidricos: " + mt.format(eh)
						+ "\nInformatica: " + mt.format(inf) + "\n\nTotal: "
						+ (c + d + eh + inf));
	}

	public void adapCalcValorTotalRecebido() {
		JOptionPane.showMessageDialog(null, "A empresa recebeu um total de "
				+ mt.format(calc.calcValorTotalRecebido(v)));
	}

	public void adapServMaisRequisitado() {
		JOptionPane.showMessageDialog(null, "Servico(s) mais requisitado(s):\n"
				+ calc.ServMaisRequisitados(v));
	}

	public void adapAreaComMaisFunc() {
		JOptionPane.showMessageDialog(null, "Area(s) com mais funcionario:\n"
				+ calc.AreaComMaisFuncionarios(v));
	}

	public void adapServicPagoPorCliente() {
		calc.valRecibidoPorCadaServico(v);
	}

	public void adapOrdenaClientePreco() {
		ord.ordenaCliPreco(v);
		JOptionPane.showMessageDialog(null,
				"Ordenamento cliente feito com sucesso");
	}

	public void adapOrdenaFornecedorQuantidade() {
		ord.ordenaFornecedorQuantidade(v);
		JOptionPane.showMessageDialog(null,
				"Ordenamento fornecedor feito com sucesso");
	}

	public void adapOrdenaFuncionarioIdade() {
		ord.ordenaFuncionarioIdade(v);
		JOptionPane.showMessageDialog(null,
				"Ordenamento funcionario feito com sucesso");
	}

	public void adapPesquisarCliente() {
		String cod = val.valString((byte) 6, (byte) 6,
				"Introduza o codigo do Cliente\nEx:VS-111");
		int posicao = tarf.procurarCliente(v, cod);
		if (posicao == -1)
			JOptionPane.showMessageDialog(null, "O codigo " + cod
					+ " nao foi associado a um cliente");
		else {
			VisCliente visC = new VisCliente(v, posicao);
		}
	}

	public void adapPesquisarFornecedor() {
		String cod = val.valString((byte) 6, (byte) 6,
				"Introduza o codigo do Fornecedor\nEx:FS-111");
		int posicao = tarf.procurarFornecedor(v, cod);
		if (posicao == -1)
			JOptionPane.showMessageDialog(null, "O codigo " + cod
					+ " nao foi associado a um fornecedor");
		else {
			VisFornecedor vf = new VisFornecedor(v, posicao);
		}

	}

	public void adapPesquisarFuncionario() {
		String cod = val.valString((byte) 6, (byte) 6,
				"Introduza o codigo do Funcionario\nEx:AS-111");
		int posicao = tarf.procurarFuncionario(v, cod);
		if (posicao == -1)
			JOptionPane.showMessageDialog(null, "O codigo " + cod
					+ " nao foi associado a um funcionario");
		else {
			VisFuncionario vf = new VisFuncionario(v, posicao);
		}
	}

	public void adpIdadeMediaFuncionario() {
		JOptionPane.showMessageDialog(
				null,
				"A idade media dos funcionarios e' de "
						+ calc.calcIdadeMediaFuncio(v) + " anos de idade");
	}

	public void adapVisualizarTudo() {

	}
}