package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GruposController<E>implements ActionListener {
	
	private static List<String> listaAlunos = new ArrayList<>();
	private static JTextField tfCodGrupo;
	private static JTextField tfTema;
	private static JTextField tfRaAluno;
	private JTable tbAlunos;
	private JComboBox<E> cbOrientador;
	private JComboBox<E> cbArea;
	private String nomeArquivo;
	
	public GruposController(JTextField tfCodGrupo, JTextField tfTema, JTextField tfRaAluno, JTable tbAlunos,JComboBox<E> cbOrientador, JComboBox<E> cbArea) {
		
		super();
		this.tfCodGrupo = tfCodGrupo;
		this.tfTema = tfTema;
		this.tfRaAluno = tfRaAluno;
		this.tbAlunos = tbAlunos;
		this.cbOrientador = cbOrientador;
		this.cbArea = cbArea;
		this.nomeArquivo = "grupos.csv";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void cadastrarGrupo(String codigo, String tema, String orientador, String area, String subArea) {
        // Montar uma string com os dados do grupo no formato CSV
        String dadosGrupo = codigo + "," + tema + "," + orientador + "," + area + "," + subArea;

        // Adicionar os alunos à string de dados do grupo
        for (String aluno : listaAlunos) {
            dadosGrupo += "," + aluno;
        }

        // Chamar o método para escrever os dados no arquivo CSV
        escreverCSV(dadosGrupo, "grupos.csv");
        
        JOptionPane.showMessageDialog(null, "Grupo cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        // Limpar os campos de entrada e a lista de alunos após salvar os dados
        tfCodGrupo.setText("");
        tfTema.setText("");
        tfRaAluno.setText("");
        listaAlunos.clear();
    }
		


	public static void adicionarAluno(String raAluno) {
	    listaAlunos.add(raAluno);
        JOptionPane.showMessageDialog(null, "Aluno adicionado ao grupo", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void escreverCSV(String dadosGrupo, String nomeArquivo) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
	    	writer.write(dadosGrupo);
	        writer.newLine();

	        // Verificar se há alunos na lista
	        if (!listaAlunos.isEmpty()) {
	            // Montar uma string com os alunos no formato CSV
	            String alunosCSV = String.join(",", listaAlunos);

	            // Escrever a lista de alunos em uma linha separada
	            writer.write(alunosCSV);
	            writer.newLine();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}		
}
