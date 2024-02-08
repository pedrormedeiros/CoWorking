package view;

import javax.swing.JDialog;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Rectangle;

public class  Reservas extends JDialog {
	public Reservas() {
		setBounds(new Rectangle(0, 0, 450, 300));
		setResizable(false);
		setTitle("Reservas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reservas.class.getResource("/img/logo.png")));
		getContentPane().setLayout(null);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run () {
				try {
					Reservas dialog = new Reservas ();
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



