package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import utils.Pilha;
import model.Orientacao;

public class OrientacaoController implements ActionListener{
    
    static Pilha pilha = new Pilha();
    private JTextField tfCodGrupoOrientacao;
    private JTextArea taOrientacao;
    
    public OrientacaoController(JTextField tfCodGrupoOrientacao, JTextArea taOrientacao2) {
        super();
        this.tfCodGrupoOrientacao = tfCodGrupoOrientacao;
        this.taOrientacao = taOrientacao2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String codGrupo = tfCodGrupoOrientacao.getText();
        String orientacao = taOrientacao.getText();
        
        if (codGrupo.isEmpty() || orientacao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Orientacao orient = new Orientacao(codGrupo, orientacao);
            System.out.println(orient);
            pilha.push(orient);
            JOptionPane.showMessageDialog(null, "Orientação cadastrada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            try {
               salvaremCSV(pilha);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // Limpar os campos de texto após o cadastro
            tfCodGrupoOrientacao.setText("");
            taOrientacao.setText("");
        }
        
    }
	private void salvaremCSV(Pilha pilha) throws Exception {
		String nomeArq = "orientações.csv";
		 try {
			 FileWriter writer = new FileWriter(nomeArq, true);
	            while (!pilha.isEmpty()) {
	                Orientacao linha = pilha.pop();
	                writer.append (linha);
	                writer.append("\n");
	            }

	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar os dados no arquivo CSV: " + e.getMessage());
	        }
	}
}