package trabalho;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastroAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFNome;
	private JTextField tFNota1;
	private JTextField tfNotas2;
	private JTextField tFNota3;

	public class Sistema {
	    public static List<AlunoNotas> alunos = new ArrayList<>();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno frame = new CadastroAluno();
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
	public CadastroAluno() {
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null); 
		
		
		
		JLabel lblNome = new JLabel("Nome do Aluno");
		lblNome.setBounds(74, 33, 89, 14);
		contentPane.add(lblNome);
		
		tFNome = new JTextField();
		tFNome.setBounds(173, 30, 107, 20);
		contentPane.add(tFNome);
		tFNome.setColumns(10);
		
		JLabel lblPeriodo = new JLabel("Período");
		lblPeriodo.setBounds(74, 73, 46, 14);
		contentPane.add(lblPeriodo);
		
		JComboBox cbPeriodo = new JComboBox();
		cbPeriodo.setModel(new DefaultComboBoxModel(new String[] {"Matutino", "Vespertino", "Noturno"}));
		cbPeriodo.setBounds(173, 69, 107, 22);
		contentPane.add(cbPeriodo);
		
		JLabel lblMaiorIdade = new JLabel("Maior de Idade");
		lblMaiorIdade.setBounds(74, 113, 89, 14);
		contentPane.add(lblMaiorIdade);
		
		ButtonGroup botoes = new ButtonGroup();
        
		JRadioButton rbSim = new JRadioButton("Sim");
		rbSim.setBounds(173, 109, 65, 23);
		contentPane.add(rbSim);
		
		JRadioButton rbNao = new JRadioButton("Não");
		rbNao.setBounds(250, 109, 65, 23);
		contentPane.add(rbNao);
		
		botoes.add(rbSim);
        botoes.add(rbNao);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tFNome.getText();
		        String periodo = cbPeriodo.getSelectedItem().toString();

		        if (nome.isEmpty() || tFNota1.getText().isEmpty() || tfNotas2.getText().isEmpty() || tFNota3.getText().isEmpty()) {
		        		JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
		        		return;
		        }

		        double n1 = Double.parseDouble(tFNota1.getText());
		        double n2 = Double.parseDouble(tfNotas2.getText());
		        double n3 = Double.parseDouble(tFNota3.getText());

		        AlunoNotas aluno = new AlunoNotas(nome, periodo, n1, n2, n3);
		        Sistema.alunos.add(aluno);

		        JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");

		        LimpaCampos2();
		    }
		});
		
		btnCadastrar.setBounds(84, 227, 107, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setBounds(74, 170, 46, 14);
		contentPane.add(lblNotas);
		
		tFNota1 = new JTextField();
		tFNota1.setBounds(140, 167, 46, 20);
		contentPane.add(tFNota1);
		tFNota1.setColumns(10);
		
		tfNotas2 = new JTextField();
		tfNotas2.setBounds(196, 167, 46, 20);
		contentPane.add(tfNotas2);
		tfNotas2.setColumns(10);
		
		tFNota3 = new JTextField();
		tFNota3.setBounds(250, 167, 46, 20);
		contentPane.add(tFNota3);
		tFNota3.setColumns(10);
		
		JButton btnVoltarMenu = new JButton("Voltar ao Menu");
		btnVoltarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuInicial().setVisible(true);
				dispose();
			}
		});
		btnVoltarMenu.setBounds(241, 227, 125, 23);
		contentPane.add(btnVoltarMenu);
	}

	private void LimpaCampos2() {
		tFNome.setText("");
	     tFNota1.setText("");
	     tfNotas2.setText("");
	     tFNota3.setText("");
	}
}