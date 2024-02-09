package view;

import java.awt.EventQueue;


import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Home extends JDialog{
	
	public JLabel txtUsuarioLogado;
	public JPanel panelUsuario;
	public JLabel txtData;
	
	
	
	//Construtor
	public Home() {
		 addWindowListener (new WindowAdapter() {
			 public void windowActivated(WindowEvent e) {
				 Date dataSistema = new Date();
				 DateFormat formatadorData = DateFormat.getDateInstance(DateFormat.FULL);
				 txtData.setText(formatadorData.format(dataSistema));
			 }
		 });
		 
		setBounds(new Rectangle(452, 301, 452, 301));
		setResizable(false);
		setTitle("Home");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/img/logo.png")));
		getContentPane().setLayout(null);
		
		JButton btnUser = new JButton("");
		btnUser.setBorderPainted(false);
		btnUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUser.setIcon(new ImageIcon(Home.class.getResource("/img/user.png")));
		btnUser.setBounds(24, 60, 89, 95);
		getContentPane().add(btnUser);
		
			btnUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Funcionarios funcionarios = new Funcionarios();
					funcionarios.setVisible(true);
				}
				
			});
			
		
		JButton btnRoom = new JButton("");
		btnRoom.setBorderPainted(false);
		btnRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRoom.setIcon(new ImageIcon(Home.class.getResource("/img/room.png")));
		btnRoom.setBounds(159, 60, 89, 95);
		getContentPane().add(btnRoom);
		
		btnRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salas salas = new Salas();
				salas.setVisible(true);
			}
			
		});
		
		JButton btnReserve = new JButton("");
		btnReserve.setBorderPainted(false);
		btnReserve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReserve.setIcon(new ImageIcon(Home.class.getResource("/img/reserve.png")));
		btnReserve.setBounds(296, 60, 116, 95);
		getContentPane().add(btnReserve);
		
		panelUsuario = new JPanel();
		panelUsuario.setBounds(0, 215, 436, 47);
		getContentPane().add(panelUsuario);
		panelUsuario.setLayout(null);
		
		txtUsuarioLogado = new JLabel("");
		txtUsuarioLogado.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuarioLogado.setBounds(10, 11, 174, 25);
		panelUsuario.add(txtUsuarioLogado);
		
		txtData = new JLabel("");
		txtData.setHorizontalAlignment(SwingConstants.LEFT);
		txtData.setBounds(213, 11, 213, 25);
		panelUsuario.add(txtData);
		
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservas reservas = new Reservas();
				reservas.setVisible(true);
			}
			
		});
		
	}
		

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run () {
				try {
					Home dialog = new Home ();
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

			