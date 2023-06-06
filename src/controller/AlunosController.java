package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Aluno;

public class AlunosController implements ActionListener {
    
    static List<Aluno> alunos = new ArrayList<>();
    private JTextField tfAluno;
    private JTextField tfRA;
    
    public AlunosController(JTextField tfAluno, JTextField tfRA) {
        super();
        this.tfAluno = tfAluno;
        this.tfRA = tfRA;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String nome = tfAluno.getText();
        String ra = tfRA.getText();

        if (nome.isEmpty() || ra.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Aluno aluno = new Aluno(nome, ra);

            //Adicionar o aluno à lista de alunos (ou realizar outra operação desejada)
            alunos.add(aluno);

            // Salvar os alunos em um arquivo .csv
            salvarAlunosEmCSV(alunos);

            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // Limpar os campos de texto após o cadastro
            tfAluno.setText("");
            tfRA.setText("");
        }
    }

    private void salvarAlunosEmCSV(List<Aluno> alunos) {
    String nomeArquivo = "alunos.csv";
    try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            //Escreve o cabeçalho no arquivo
            writer.println("Nome,RA");

             //Escreve os alunos no arquivo
             for (Aluno aluno : alunos) {
                writer.println(aluno.getNome() + "," + aluno.getRa());
            }     
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar alunos em " + nomeArquivo, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}