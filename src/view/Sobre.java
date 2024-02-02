package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Sobre extends JDialog {
	public Sobre() {
		setTitle("Sobre");
		setBounds(new Rectangle(629, 387, 629, 387));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/logo.png")));
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("Sobre o software");
		titulo.setBackground(new Color(0, 0, 0));
		titulo.setBounds(0, 23, 612, 20);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(titulo);
		
		JLabel descricao1 = new JLabel("O software CoWorking trata-se de um protótipo cujo o objetivo é ");
		descricao1.setBounds(new Rectangle(0, 0, 629, 387));
		descricao1.setHorizontalAlignment(SwingConstants.CENTER);
		descricao1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		descricao1.setBounds(0, 132, 612, 14);
		getContentPane().add(descricao1);
		
		JLabel descricao2 = new JLabel(" possibilitar o gereciamento de reserva de salas em um espaço colaborativo.\r\n");
		descricao2.setHorizontalAlignment(SwingConstants.CENTER);
		descricao2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		descricao2.setBounds(0, 178, 612, 14);
		getContentPane().add(descricao2);
		
		JLabel versao = new JLabel("Versão 1.0.0 ");
		versao.setHorizontalAlignment(SwingConstants.CENTER);
		versao.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		versao.setBounds(-39, 272, 651, 14);
		getContentPane().add(versao);
		
		JLabel atualizacao = new JLabel("Última versão: 31/01/2024 ");
		atualizacao.setHorizontalAlignment(SwingConstants.CENTER);
		atualizacao.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		atualizacao.setBounds(-39, 297, 651, 14);
		getContentPane().add(atualizacao);
		
		JLabel imgMIT = new JLabel("");
		imgMIT.setIcon(new ImageIcon(Sobre.class.getResource("/img/mitLicense.png")));
		imgMIT.setBounds(558, 281, 54, 66);
		getContentPane().add(imgMIT);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run () {
				try {
					Sobre dialog = new Sobre ();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
