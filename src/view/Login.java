package view;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class Login extends JDialog {
	private JTextField inputLogin;
	private JPasswordField inputSenha;
	public Login() {
		setResizable(false);
		setTitle("Login");
		setBounds(new Rectangle(0, 0, 629, 387));
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/logo.png")));
		getContentPane().setLayout(null);
		
		JLabel txtLogin = new JLabel("Login:");
		txtLogin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtLogin.setBounds(202, 157, 46, 17);
		getContentPane().add(txtLogin);
		
		JLabel txtSenha = new JLabel("Senha:");
		txtSenha.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtSenha.setBounds(202, 217, 46, 14);
		getContentPane().add(txtSenha);
		
		inputLogin = new JTextField();
		inputLogin.setHorizontalAlignment(SwingConstants.CENTER);
		inputLogin.setBounds(247, 154, 125, 20);
		getContentPane().add(inputLogin);
		inputLogin.setColumns(10);
		
		inputSenha = new JPasswordField();
		inputSenha.setHorizontalAlignment(SwingConstants.CENTER);
		inputSenha.setBounds(247, 214, 125, 20);
		getContentPane().add(inputSenha);
		
		JLabel tituloLogin = new JLabel("Acessar Conta");
		tituloLogin.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		tituloLogin.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		tituloLogin.setBounds(0, 44, 613, 27);
		getContentPane().add(tituloLogin);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setBounds(258, 273, 89, 23);
		getContentPane().add(btnLogin);
		
		JLabel imgDatabase = new JLabel("");
		imgDatabase.setIcon(new ImageIcon(Login.class.getResource("/img/databaseOff.png")));
		imgDatabase.setBounds(10, 273, 54, 58);
		getContentPane().add(imgDatabase);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run () {
				try {
					Login dialog = new Login ();
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
