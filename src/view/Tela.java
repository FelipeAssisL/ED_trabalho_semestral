package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.AlunosController;
import controller.GruposController;
import controller.OrientacaoController;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField tfAluno;
	private JTextField tfRA;
	private JTextField tfTema;
	private JTextField tfCodGrupo;
	private JTextField tfRaAluno;
	private JTextField tfCodigo;
	private JTable tbConsultaGrupo;
	private JTextField tfCodGrupoOrientacao;
	private JTextField tfCodGrupoBuscaOrientacao;
	private JTable tbListaOrientacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 511, 306);
		contentPane.add(tabbedPane);
		
		// TELA CADASTRO ALUNO
		JPanel tabAluno = new JPanel();
		tabbedPane.addTab("Cadastrar Aluno", null, tabAluno, "Cadastro de alunos");
		tabAluno.setLayout(null);
		
		JLabel lblAluno = new JLabel("Aluno");
		lblAluno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAluno.setBounds(99, 56, 46, 14);
		tabAluno.add(lblAluno);
		
		JLabel lblRA = new JLabel("RA");
		lblRA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRA.setBounds(99, 117, 46, 14);
		tabAluno.add(lblRA);
		
		tfAluno = new JTextField();
		tfAluno.setToolTipText("Informe o nome do Aluno");
		tfAluno.setBounds(155, 55, 223, 20);
		tabAluno.add(tfAluno);
		tfAluno.setColumns(10);
		
		tfRA = new JTextField();
		tfRA.setToolTipText("Informe o RA do aluno");
		tfRA.setBounds(155, 114, 223, 20);
		tabAluno.add(tfRA);
		tfRA.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(218, 186, 102, 23);
		tabAluno.add(btnCadastrar);
		
		// TELA CONSULTA GRUPO
		JPanel tabConsutaGrupo = new JPanel();
		tabbedPane.addTab("Consultar Grupo", null, tabConsutaGrupo, null);
		tabConsutaGrupo.setLayout(null);
		
		JLabel lblCodBusca = new JLabel("Código");
		lblCodBusca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodBusca.setBounds(10, 24, 62, 14);
		tabConsutaGrupo.add(lblCodBusca);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(57, 22, 62, 20);
		tabConsutaGrupo.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JButton btnBusca = new JButton("Buscar");
		btnBusca.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBusca.setBounds(123, 20, 89, 23);
		tabConsutaGrupo.add(btnBusca);
		
		tbConsultaGrupo = new JTable();
		tbConsultaGrupo.setBounds(10, 87, 486, 180);
		tabConsutaGrupo.add(tbConsultaGrupo);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 49, 486, 14);
		tabConsutaGrupo.add(separator_2);
		
		JLabel lblSubarea = new JLabel("Subarea");
		lblSubarea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubarea.setBounds(222, 25, 64, 14);
		tabConsutaGrupo.add(lblSubarea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(276, 21, 111, 22);
		tabConsutaGrupo.add(comboBox);
		
		JButton btnBuscaSubArea = new JButton("Buscar p/ Subarea");
		btnBuscaSubArea.setToolTipText("Buscar por Subarea");
		btnBuscaSubArea.setBounds(397, 21, 89, 23);
		tabConsutaGrupo.add(btnBuscaSubArea);
		
		// TELA CADASTRO ORIENTAÇÃO
		JPanel tabOrientacao = new JPanel();
		tabbedPane.addTab("Cadastrar Orientação", null, tabOrientacao, null);
		tabOrientacao.setLayout(null);
		
		JLabel lblCodOrientacao = new JLabel("Código do gupo");
		lblCodOrientacao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodOrientacao.setBounds(19, 22, 107, 17);
		tabOrientacao.add(lblCodOrientacao);
		
		tfCodGrupoOrientacao = new JTextField();
		tfCodGrupoOrientacao.setBounds(136, 21, 86, 20);
		tabOrientacao.add(tfCodGrupoOrientacao);
		tfCodGrupoOrientacao.setColumns(10);
		
		JTextArea taOrientacao = new JTextArea();
		taOrientacao.setBounds(19, 87, 457, 136);
		tabOrientacao.add(taOrientacao);
		
		JButton btnCadastrarOrientacao = new JButton("Cadastrar");
		btnCadastrarOrientacao.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrarOrientacao.setBounds(194, 232, 110, 23);
		tabOrientacao.add(btnCadastrarOrientacao);
		
		JLabel lblOrientacao = new JLabel("Orientação:");
		lblOrientacao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOrientacao.setBounds(19, 62, 74, 14);
		tabOrientacao.add(lblOrientacao);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 50, 476, 1);
		tabOrientacao.add(separator_1);
		
		// TELA CADASTRO GRUPOS
		JPanel tabGrupo = new JPanel();
		tabbedPane.addTab("Cadastrar Grupos", null, tabGrupo, null);
		tabGrupo.setLayout(null);
		
		JLabel lblCod = new JLabel("Código");
		lblCod.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCod.setBounds(27, 11, 46, 14);
		tabGrupo.add(lblCod);
		
		JLabel lblArea = new JLabel("Área do trabalho");
		lblArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblArea.setBounds(244, 41, 115, 14);
		tabGrupo.add(lblArea);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTema.setBounds(27, 36, 46, 14);
		tabGrupo.add(lblTema);
		
		JLabel lblOrientador = new JLabel("Orientador");
		lblOrientador.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOrientador.setBounds(277, 11, 66, 14);
		tabGrupo.add(lblOrientador);
		
		JComboBox cbOrientador = new JComboBox();
		cbOrientador.setModel(new DefaultComboBoxModel(new String[] {"Colevati", "Cristina", "Welingtton", "Satoshi", "Luciano"}));
		cbOrientador.setBounds(367, 8, 129, 22);
		tabGrupo.add(cbOrientador);
		
		JComboBox cbArea = new JComboBox();
		cbArea.setModel(new DefaultComboBoxModel(new String[] {"Engenharia", "Redes", "Desenvolvimento", "Dados", "Segurança"}));
		cbArea.setBounds(367, 38, 129, 22);
		tabGrupo.add(cbArea);
		
		JComboBox cbSubArea = new JComboBox();
		cbSubArea.setModel(new DefaultComboBoxModel(new String[] {"Engenharia de Software", "Engenharia de Sistemas", "Segurança de Redes", "Administração de Redes", "Desenvolvimento Web\r\n"
				+ "Desenvolvimento Mobile", "Análise de Dados" , "Criptografia", "Segurança de Aplicações Web"}));
		cbSubArea.setBounds(367, 64, 129, 22);
		tabGrupo.add(cbSubArea);
		
		tfTema = new JTextField();
		tfTema.setBounds(80, 36, 138, 20);
		tabGrupo.add(tfTema);
		tfTema.setColumns(10);
		
		tfCodGrupo = new JTextField();
		tfCodGrupo.setBounds(80, 9, 72, 20);
		tabGrupo.add(tfCodGrupo);
		tfCodGrupo.setColumns(10);
		
		JButton btnCadastrarGrupo = new JButton("Cadastrar");
		btnCadastrarGrupo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrarGrupo.setBounds(169, 219, 115, 23);
		tabGrupo.add(btnCadastrarGrupo);
		
		JLabel lblAlunoRA = new JLabel("RA Aluno");
		lblAlunoRA.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlunoRA.setBounds(63, 146, 102, 14);
		tabGrupo.add(lblAlunoRA);
		
		tfRaAluno = new JTextField();
		tfRaAluno.setBounds(130, 144, 154, 20);
		tabGrupo.add(tfRaAluno);
		tfRaAluno.setColumns(10);
		
		JButton btnAdicionarAluno = new JButton("Adicionar");
		btnAdicionarAluno.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarAluno.setBounds(298, 142, 104, 23);
		tabGrupo.add(btnAdicionarAluno);
		
		JLabel lblSubArea = new JLabel("Subarea");
		lblSubArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubArea.setBounds(298, 67, 80, 14);
		tabGrupo.add(lblSubArea);
			
		//TELA CONSULTA ORIENTAÇÃO
		JPanel tabConsultarOrientacao = new JPanel();
		tabbedPane.addTab("Consultar Orientação", null, tabConsultarOrientacao, null);
		tabConsultarOrientacao.setLayout(null);
		
		JLabel lblCodGrupoOrientacao = new JLabel("Código do grupo");
		lblCodGrupoOrientacao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodGrupoOrientacao.setBounds(10, 11, 125, 14);
		tabConsultarOrientacao.add(lblCodGrupoOrientacao);
		
		tfCodGrupoBuscaOrientacao = new JTextField();
		tfCodGrupoBuscaOrientacao.setBounds(120, 9, 86, 20);
		tabConsultarOrientacao.add(tfCodGrupoBuscaOrientacao);
		tfCodGrupoBuscaOrientacao.setColumns(10);
		
		JButton btnBuscarOrientacao = new JButton("Buscar");
		btnBuscarOrientacao.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscarOrientacao.setBounds(216, 8, 89, 23);
		tabConsultarOrientacao.add(btnBuscarOrientacao);
		
		tbListaOrientacao = new JTable();
		tbListaOrientacao.setBounds(10, 79, 125, 177);
		tabConsultarOrientacao.add(tbListaOrientacao);
		
		JLabel lblListaOrientacao = new JLabel("Lista de Orientações");
		lblListaOrientacao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListaOrientacao.setBounds(10, 54, 125, 14);
		tabConsultarOrientacao.add(lblListaOrientacao);
		
		JLabel lblDescrOrientacao = new JLabel("Descrição da Orientação");
		lblDescrOrientacao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescrOrientacao.setBounds(185, 54, 189, 14);
		tabConsultarOrientacao.add(lblDescrOrientacao);
		
		JTextPane tpDescrOrientacao = new JTextPane();
		tpDescrOrientacao.setBounds(185, 79, 300, 177);
		tabConsultarOrientacao.add(tpDescrOrientacao);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 486, 45);
		tabConsultarOrientacao.add(separator);
	
		
		AlunosController aluno = new AlunosController(tfAluno, tfRA);
		
		//BOTOES DA TELA DE CADASTRO DE ALUNO
		
		btnCadastrar.addActionListener(aluno);
		
		
		//BOTOES DA TELA DE CADASTRO DO GRUPO

		btnCadastrarGrupo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	List<String> listaAlunos = new ArrayList<>();
		        // Obter os valores dos campos de entrada
		        String codigo = tfCodGrupo.getText();
		        String tema = tfTema.getText();
		        String orientador = cbOrientador.getSelectedItem().toString();
		        String area = cbArea.getSelectedItem().toString();
		        String subArea = cbSubArea.getSelectedItem().toString();

		        // Montar uma string com os dados do grupo no formato CSV
		        String dadosGrupo = codigo + "," + tema + "," + orientador + "," + area + "," + subArea;

		        // Adicionar os alunos à string de dados do grupo
		        for (String aluno : listaAlunos) {
		            dadosGrupo += "," + aluno;
		        }

		        // Chamar o método para escrever os dados no arquivo CSV
		        GruposController.escreverCSV(dadosGrupo, "grupos.csv");

		        // Limpar os campos de entrada e a lista de alunos após salvar os dados
		        tfCodGrupo.setText("");
		        tfTema.setText("");
		        listaAlunos.clear();
		    }
		});
		
		btnAdicionarAluno.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obter o RA do aluno digitado no campo de entrada
		        String raAluno = tfRaAluno.getText();

		        // Executar a lógica para adicionar o aluno à tabela
		        GruposController.adicionarAluno(raAluno);
		    }
		});


//		//BOTOES DA TELA DE CADASTRO DE ORIENTAÇÃO
		OrientacaoController orientacao = new OrientacaoController(tfCodGrupoOrientacao,  taOrientacao);
		btnCadastrarOrientacao.addActionListener(orientacao);

//		//BOTOES DA TELA DE CONSULTA DE GRUPOS
//		btnBusca.addActionListener();
//		btnBuscaSubArea.addActionListener();
		
//		//BOTOES DA TELA DE CONSULTA DE ORIENTAÇÕES
//		btnBuscarOrientacao.addActionListener();
	}
}

