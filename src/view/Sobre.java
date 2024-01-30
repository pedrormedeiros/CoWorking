package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Sobre extends JDialog {
	public Sobre() {
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("Sobre o software");
		titulo.setBackground(new Color(255, 0, 0));
		titulo.setBounds(138, 98, 160, 20);
		titulo.setForeground(new Color(255, 0, 0));
		titulo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(titulo);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
