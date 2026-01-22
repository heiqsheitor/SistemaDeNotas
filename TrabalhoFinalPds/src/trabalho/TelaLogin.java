package trabalho;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private String user = "heitor";
	private String senha = "123";
	private Usuario usuario;
	private JTextField tFUsuario;
	private JPasswordField pFSenha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setTitle("Tela Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null); 
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(126, 71, 46, 14);
		contentPane.add(lblUsuario);
		
		tFUsuario = new JTextField();
		tFUsuario.setBounds(195, 68, 86, 20);
		contentPane.add(tFUsuario);
		tFUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(126, 133, 46, 14);
		contentPane.add(lblSenha);
		
		pFSenha = new JPasswordField();
		pFSenha.setBounds(195, 130, 86, 20);
		contentPane.add(pFSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario = new Usuario(tFUsuario.getText(), pFSenha.getText());
				
				if(usuario.getUsuario().equals(user) && usuario.getSenha().equals(senha)){ 
					JOptionPane.showMessageDialog(null, "Login autorizado");
					JOptionPane.showMessageDialog(null, usuario.getMsg());
					MenuInicial menu = new MenuInicial();
					menu.setVisible(true);
				    dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos");
					
				}
				LimpaCampos();
			}
		});
		btnEntrar.setBounds(171, 206, 89, 23);
		contentPane.add(btnEntrar);
	}
	private void LimpaCampos() {
		tFUsuario.setText("");
		pFSenha.setText("");
		tFUsuario.requestFocus();
	}
}