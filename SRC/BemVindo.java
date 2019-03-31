import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

public class BemVindo extends JFrame {
	private JLabel saudacoes, contaAdmin, contaConvi, dica;
	private JButton bt1, bt2,btSair;
	private Container cont;
	private JPanel painel1, painel2, painel3,painel4;
	private Icon imgAd1, imgAd2, imgCv1, imgCv2;
        private Login lg;
//        private Convidado cv;

	public BemVindo() {
		super("Gestao de Servicos");
                cont = getContentPane();
                setIconImage(Toolkit.getDefaultToolkit().getImage("es.png"));
		imgAd1 = new ImageIcon("images10.png");
		imgAd2 = new ImageIcon("images7.png");
		imgCv1 = new ImageIcon("images8.png");
		imgCv2 = new ImageIcon("images.png");
		
		painel1 = new JPanel();
		painel1.setLayout(new GridLayout(3,1));
		painel2 = new JPanel();
		painel2.setLayout(new GridLayout(3,1));
		painel3 = new JPanel();
		painel3.setLayout(new GridLayout(3,1));
		painel4 = new JPanel();
		painel4.setLayout(new GridLayout(3,1));
		    
		saudacoes = new JLabel("Bem Vindo(a)",SwingConstants.CENTER);
		saudacoes.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		painel1.add(saudacoes);
		
		bt1 = new JButton(imgAd1);
		bt1.setRolloverIcon(imgAd2);
		painel2.add(bt1);
		
		contaAdmin = new JLabel("Administrador",SwingConstants.CENTER);
		contaAdmin.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		painel2.add(contaAdmin);
		
		bt2 = new JButton(imgCv1);
		bt2.setRolloverIcon(imgCv2);
		painel4.add(bt2);
		
		contaConvi = new JLabel("Convidado",SwingConstants.CENTER);
		contaConvi.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		painel4.add(contaConvi);
		
		
                dica = new JLabel("Por favor, seleccione a conta ",SwingConstants.CENTER);
		dica.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		painel3.add(dica);
                btSair = new JButton("Sair");
		painel3.add(btSair);
		
               
                cont.add(painel1, BorderLayout.NORTH);
		cont.add(painel2, BorderLayout.WEST);
		cont.add(painel3, BorderLayout.SOUTH);
		cont.add(painel4, BorderLayout.EAST);
		
		setVisible(true);
		setSize(500, 400);
		setLocationRelativeTo(null);
                
                Eventos eventos = new Eventos();
		bt1.addActionListener(eventos);
                bt2.addActionListener(eventos);
                btSair.addActionListener(eventos);
	}
        private class Eventos implements ActionListener {
		public void actionPerformed(ActionEvent x) {
			if (x.getSource() == bt1) {
                            dispose();
                            lg=new Login();
                            lg.setVisible(true);  
                        }else if(x.getSource() == bt2){
                            dispose();
//				cv = new Convidado();
//				cv.setVisible(true);
                        } else if(x.getSource() == btSair){
                         System.exit(0);
                        }
		}
	}
	public static void main(String[] args) {
		BemVindo bv = new BemVindo();
		bv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
