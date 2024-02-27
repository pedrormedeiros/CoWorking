package view;

import javax.swing.JDialog;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class Salas extends JDialog {
	private JTextField inputOcup;

	public JButton imgCreate;
	public JButton imgUpdate;
	public JButton imgDelete;

	public Salas() {
		setTitle("Salas");
		setResizable(false);
		setBounds(new Rectangle(300, 100, 724, 446));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/logo.png")));
		getContentPane().setLayout(null);

		JLabel tipoSala = new JLabel("Categoria:");
		tipoSala.setBounds(24, 58, 74, 14);
		getContentPane().add(tipoSala);

		JLabel codSala = new JLabel("Código:");
		codSala.setBounds(24, 249, 46, 14);
		getContentPane().add(codSala);

		JLabel andarSala = new JLabel("Andar:");
		andarSala.setBounds(298, 249, 46, 14);
		getContentPane().add(andarSala);

		JLabel ocupSala = new JLabel("Ocupação máxima:");
		ocupSala.setBounds(298, 312, 114, 14);
		getContentPane().add(ocupSala);

		JLabel numSala = new JLabel("Número:");
		numSala.setBounds(24, 314, 61, 14);
		getContentPane().add(numSala);

		inputOcup = new JTextField();
		inputOcup.setColumns(10);
		inputOcup.setBounds(422, 309, 86, 20);
		getContentPane().add(inputOcup);

		imgCreate = new JButton("");
		imgCreate.setBackground(new Color(240, 240, 240));
		imgCreate.setBorderPainted(false);
		imgCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgCreate.setIcon(new ImageIcon(Salas.class.getResource("/img/create.png")));
		imgCreate.setBounds(392, 342, 65, 54);
		getContentPane().add(imgCreate);

		imgCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 adicionarSala();
			}
		});

		imgUpdate = new JButton("");
		imgUpdate.setBackground(new Color(240, 240, 240));
		imgUpdate.setBorderPainted(false);
		imgUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgUpdate.setIcon(new ImageIcon(Salas.class.getResource("/img/update.png")));
		imgUpdate.setBounds(488, 342, 65, 54);
		getContentPane().add(imgUpdate);

		imgUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// atualizarFuncionario();
			}
		});

		imgDelete = new JButton("");
		imgDelete.setBackground(new Color(240, 240, 240));
		imgDelete.setBorderPainted(false);
		imgDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgDelete.setIcon(new ImageIcon(Salas.class.getResource("/img/delete.png")));
		imgDelete.setBounds(581, 342, 65, 54);
		getContentPane().add(imgDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 83, 516, 90);
		getContentPane().add(scrollPane);

		tblSalas = new JTable();
		scrollPane.setViewportView(tblSalas);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.setBackground(new Color(240, 240, 240));
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setIcon(new ImageIcon(Salas.class.getResource("/img/search.png")));
		btnPesquisar.setBounds(554, 49, 38, 27);
		getContentPane().add(btnPesquisar);
	

		inputCategoria = new JComboBox();
		inputCategoria.setModel(new DefaultComboBoxModel(new String[] { "", "Sala de reunião", "Sala de conferência", "Espaço de eventos", "Escritório privado" }));
		inputCategoria.setBounds(95, 54, 443, 22);
		getContentPane().add(inputCategoria);
	
		inputCategoria.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				buscarSalaNaTabela();
			}
		});

		inputCod = new JComboBox();
		inputCod.setModel(new DefaultComboBoxModel(new String[] { "", "REU", "CONF", "EVENT", "PRIV" }));
		inputCod.setBounds(74, 245, 147, 22);
		getContentPane().add(inputCod);

		inputAndar = new JComboBox();
		inputAndar.setModel(
		new DefaultComboBoxModel(new String[] { "", "Subsolo", "Térreo", "1º andar", "2º andar", "3º andar" }));
		inputAndar.setBounds(338, 245, 157, 22);
		getContentPane().add(inputAndar);

		inputNum = new JTextField();
		inputNum.setBounds(95, 309, 86, 20);
		getContentPane().add(inputNum);
		inputNum.setColumns(10);

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// btnBuscarFuncionario();
			}
		});

		tblSalas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// setarCaixasTexto();
			}
		});

	} // Fim do construtor

	// Criar um objeto da classe DAO para estabelecer conexão com banco
	DAO dao = new DAO();
	private JTable tblSalas;
	private JComboBox inputCategoria;
	private JComboBox inputCod;
	private JComboBox inputAndar;
	private JTextField inputNum;

	private void adicionarSala() {
		String create = "insert into salas (andarSala, numeroSala, tipoSala, codigoSala,ocupacaoSala) values (?, ?, ?, ?, ?);";

		// Validação do nome do funcionário
		if (inputCategoria.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Categoria da sala obrigatório!");
			inputCategoria.requestFocus();
		}

		// Validação do login do funcionário
		else if (inputCod.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "código da sala obrigatório!");
			inputCod.requestFocus();
		}

		// Validação da senha do funcionário
		else if (inputAndar.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Andar da sala obrigatório!");
			inputAndar.requestFocus();
		}

		// Validação do email do funcionário
		else if (inputNum.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Número da sala obrigatório!");
			inputNum.requestFocus();
		}
		
		//Validação da ocupação máxima da sala 
		else if (inputOcup.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ocupação máxima oobrigatório!");
			inputNum.requestFocus();
		}
		
		
		else {

			try {
				// Estabelecer a conexão
				Connection conexaoBanco = dao.conectar();

				// Preparar a execusão do script SQL
				PreparedStatement executarSQL = conexaoBanco.prepareStatement(create);

				// Substituir os pontos de interrogação pelo conteúdo das caixas de texto
				// (inputs)
				executarSQL.setString(1, inputAndar.getSelectedItem().toString());
				executarSQL.setString(2, inputNum.getText());
				executarSQL.setString(3, inputCategoria.getSelectedItem().toString());
				executarSQL.setString(4, inputCod.getSelectedItem().toString());
				executarSQL.setString(5, inputOcup.getText());

				// Executar os comandos SQL e inserir o funcionário no banco de dados
				executarSQL.executeUpdate();

				JOptionPane.showMessageDialog(null, "Sala cadastrada com sucesso!");
				limparCampos();

				conexaoBanco.close();
			}

			catch (SQLIntegrityConstraintViolationException error) {
				JOptionPane.showMessageDialog(null, "Sala já cadastrada!");
			}

			catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void buscarSalaNaTabela() {
		String readTabela = "select tipoSala as Categoria, andarSala as Andar, numeroSala as Número from salas where tipoSala = ?;";

		try {
			// Estabelecer a conexão
			Connection conexaoBanco = dao.conectar();

			// Preparar a execução dos comandos SQL
			PreparedStatement executarSQL = conexaoBanco.prepareStatement(readTabela);

			// Substituir o ? pelo conteúdo da caixa de texto
			executarSQL.setString(1, inputCategoria.getSelectedItem().toString());

			// Executar o comando SQL
			ResultSet resultadoExecucao = executarSQL.executeQuery();

			// Exibir o resultado na tabela, utilização da biblioteca rs2xml para "popular"
			// a tabela
			tblSalas.setModel(DbUtils.resultSetToTableModel(resultadoExecucao));

			conexaoBanco.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

	private void setarCaixasTexto() {

		// Criar uma variável para receber a linha da tabela
		int setarLinha = tblSalas.getSelectedRow();

		inputCategoria.setSelectedItem(tblSalas.getModel().getValueAt(setarLinha, 1).toString());

	}

	// Criar método para buscar funcionário pelo botão Pesquisar
	private void btnBuscarSala() {
		String readBtn = "select * from salas where numeroSala = ?;";

		try {
			// Estabelecer a conexão
			Connection conexaoBanco = dao.conectar();

			// Preparar a execução do comando SQL
			PreparedStatement executarSQL = conexaoBanco.prepareStatement(readBtn);

			// Substituir o ponto de interrogação pelo conteúdo da caixa de texto (nome)
			executarSQL.setString(1, inputNum.getText());

			// Executar o comando SQL e exibir o resultado no formulário funcionário (todos
			// os seus dados)
			ResultSet resultadoExecucao = executarSQL.executeQuery();

			if (resultadoExecucao.next()) {
				// Preencher os campos do formulário
				inputAndar.setSelectedItem(resultadoExecucao.getString(2));
				inputCod.setSelectedItem(resultadoExecucao.getString(5));
				inputCategoria.setSelectedItem(resultadoExecucao.getString(6));

			}

			conexaoBanco.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

	private void atualizarFuncionario() {
		String update = "update funcionario set nomeFunc = ?, login = ?, senha = md5(?), email = ?,"
				+ " perfil = ? where idFuncionario = ?;";

		try {
			// Estabelecer a conexão
			Connection conexaoBanco = dao.conectar();

			// Preparar a execusão do script SQL
			PreparedStatement executarSQL = conexaoBanco.prepareStatement(update);

			// Substituir os pontos de interrogação pelo conteúdo das caixas de texto
			// (inputs)
			executarSQL.setString(1, inputAndar.getSelectedItem().toString());
			executarSQL.setString(2, inputNum.getText());
			executarSQL.setString(1, inputCategoria.getSelectedItem().toString());
			executarSQL.setString(4, inputCod.getSelectedItem().toString());
			executarSQL.setString(5, inputOcup.getText());

			// Executar os comandos SQL e atualizar o funcionário no banco de dados
			executarSQL.executeUpdate();

			JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
			limparCampos();

			conexaoBanco.close();
		}

		catch (SQLIntegrityConstraintViolationException error) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro. \nO login e/ou e-mail já estão sendo usados");
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	
	private void limparCampos() {
		inputCategoria.setSelectedIndex(-1);
		inputCod.setSelectedIndex(-1);
		inputAndar.setSelectedIndex(-1);
		inputNum.setText(null);
		inputCategoria.requestFocus();
		
	}
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salas dialog = new Salas();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
