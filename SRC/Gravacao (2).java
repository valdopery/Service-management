import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Gravacao extends JFrame implements Serializable {
	Cliente c;
	Servico se;
	Funcionario f;
	Fornecedor fo;

	public Gravacao() {
		c = new Cliente();
		se = new Servico();
		f = new Funcionario();
		fo = new Fornecedor();
	}

	// Grava toda a informação actualizada num ficheiro de objectos
	public void guardarObjecto(Vector vv) {
		try {
			FileOutputStream f = new FileOutputStream("Gestao.dat");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(vv);
			o.close();
		} catch (IOException x) {
			System.out.println(x.getMessage());
		}
	}

	public void lerDoFichObj(String nomeFich) {
		Vector vc;
		try {
			FileInputStream fIS = new FileInputStream(nomeFich);
			ObjectInputStream oIS = new ObjectInputStream(fIS);
			vc = (Vector) oIS.readObject();
			oIS.close();
		} catch (FileNotFoundException e) {
			System.out.println("O ficheiro " + nomeFich
					+ " não foi encontrado!");
		} catch (ClassCastException cCE) {
			System.out.println(cCE.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException i) {
			System.out.println(i.getMessage());
		}
	}

	// Grava toda a informação actualizada num ficheiro de texto(acrescenta mais
	// um registo)
	public void gravarUltimo(Vector v) {
		String s = "";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Dados.txt",
					true));
			se = (Servico) v.elementAt(v.size() - 1);
			if (se instanceof Cliente) {
				c = (Cliente) se;
				s = c.getArea() + ";" + c.getPreco() + ";" + c.getTipoServico()
						+ ";" + c.getCodigo() + ";" + c.getNome() + ";"
						+ c.getEndereco() + ";" + c.getContacto() + ";I;"
						+ c.getBi() + ";C;" + c.getTipoContrato();
			} else if (se instanceof Fornecedor) {
				fo = (Fornecedor) se;
				s = fo.getArea() + ";" + fo.getPreco() + ";"
						+ fo.getTipoServico() + ";" + fo.getCodigo() + ";"
						+ fo.getNome() + ";" + fo.getEndereco() + ";"
						+ fo.getContacto() + ";F;" + fo.getEquipamento() + ";"
						+ fo.getQuantidade();
			} else if (se instanceof Funcionario) {
				f = (Funcionario) se;
				s = f.getArea() + ";" + f.getPreco() + ";" + f.getTipoServico()
						+ ";" + f.getCodigo() + ";" + f.getNome() + ";"
						+ f.getEndereco() + ";" + f.getContacto() + ";I;"
						+ f.getBi() + ";T;" + f.getAnoAdmissao() + ";"
						+ f.getGenero() + ";" + f.getNivelAcademico() + ";"
						+ f.getIdade();
			}
			bw.newLine();
			bw.write(s);
			bw.close();
		} catch (IOException x) {
			System.out.println(x.getMessage());
		}
	}

	// Utilizado quando eliminanos um registo para gravar nova informacao
	public void gravarTudo(Vector v) {
		String s = "";
		try {
			JFileChooser fC = new JFileChooser();
			fC.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fC.setDialogTitle("Gravar");
			fC.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter objecto = new FileNameExtensionFilter(
					"objecto .dat", "dat");
			fC.setFileFilter(objecto);
			FileNameExtensionFilter texto = new FileNameExtensionFilter(
					"texto .txt", "txt");
			fC.setFileFilter(texto);
			if (fC.showDialog(getComponent(0), "gravar") == JFileChooser.APPROVE_OPTION) {
				File ficheiro = fC.getSelectedFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(ficheiro));
				for (int i = 0; i < v.size(); i++) {
					se = (Servico) v.elementAt(i);
					if (se instanceof Cliente) {
						c = (Cliente) se;
						s = c.getArea() + ";" + c.getPreco() + ";"
								+ c.getTipoServico() + ";" + c.getCodigo()
								+ ";" + c.getNome() + ";" + c.getEndereco()
								+ ";" + c.getContacto() + ";I;" + c.getBi()
								+ ";C;" + c.getTipoContrato();
					} else if (se instanceof Fornecedor) {
						fo = (Fornecedor) se;
						s = fo.getArea() + ";" + fo.getPreco() + ";"
								+ fo.getTipoServico() + ";" + fo.getCodigo()
								+ ";" + fo.getNome() + ";" + fo.getEndereco()
								+ ";" + fo.getContacto() + ";F;"
								+ fo.getEquipamento() + ";"
								+ fo.getQuantidade();
					} else if (se instanceof Funcionario) {
						f = (Funcionario) se;
						s = f.getArea() + ";" + f.getPreco() + ";"
								+ f.getTipoServico() + ";" + f.getCodigo()
								+ ";" + f.getNome() + ";" + f.getEndereco()
								+ ";" + f.getContacto() + ";I;" + f.getBi()
								+ ";T;" + f.getAnoAdmissao() + ";"
								+ f.getGenero() + ";" + f.getNivelAcademico()
								+ ";" + f.getIdade();
					}
					bw.write(s);
					if (i < (v.size() - 1))
						bw.newLine();
				}
				bw.close();
			}
		} catch (IOException x) {
			System.out.println(x.getMessage());
		}
	}

	// Grava dados de funcionários (código, nome, idade) admitidos num
	// determinado ano
	public void gravarAno(Vector v, short ano) {
		String s;
		Servico se;
		Cliente c;
		Funcionario f;
		Fornecedor fo;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Dados.txt"));
			for (int i = 0; i < v.size(); i++) {
				se = (Servico) v.elementAt(i);
				if (se instanceof Funcionario) {
					f = (Funcionario) se;
					if (f.getAnoAdmissao() == ano) {
						s = f.getCodigo() + ";" + f.getNome() + ";"
								+ f.getIdade();
						bw.write(s);
						if (i < (v.size() - 1))
							bw.newLine();
					}
				}
			}
			bw.close();
		} catch (IOException x) {
			System.out.println(x.getMessage());
		}
	}

	public void gravarTodasContas(String[][] contas) {
		String s = "";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Contas.txt"));
			for (int i = 0; i < contas.length; i++) {
				if (contas[i][0] != null) {
					s = contas[i][0] + ";" + contas[i][1] + ";" + contas[i][2]
							+ ";" + contas[i][3];
					bw.write(s);
					if (i < (contas.length - 1) && contas[i + 1][0] != null)
						bw.newLine();
				}
			}
			bw.close();
		} catch (ArrayIndexOutOfBoundsException ai) {
			System.out.println("Lista cheia");
		} catch (IOException x) {
			JOptionPane.showMessageDialog(null, x.getMessage());
		}
	}

	public void gravarNovaConta(String nome, String passe, String pergunta,
			String resposta) {
		String s = "";
		s += nome + ";" + passe + ";" + pergunta + ";" + resposta;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Contas.txt",
					true));
			bw.newLine();
			bw.write(s);
			bw.close();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, ioe.getMessage());
		}
	}

	public String[][] lerContas() {
		String nome, passe, pergunta, resposta, linha;
		StringTokenizer st;
		String[][] contas = new String[100][4];
		int i = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Contas.txt"));
			linha = br.readLine();
			while (linha != null) {
				st = new StringTokenizer(linha, ";");
				contas[i][0] = st.nextToken(); // lê Nome
				contas[i][1] = st.nextToken(); // lê Passe
				contas[i][2] = st.nextToken(); // lê Pergunta
				contas[i][3] = st.nextToken(); // lê Resposta
				i++;
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException fn) {
			JOptionPane.showMessageDialog(null,
					"O ficheiro contas.txt não foi encontrado");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, ioe.getMessage());
		}
		return contas;
	}
}