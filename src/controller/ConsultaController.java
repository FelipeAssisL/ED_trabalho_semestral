package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Grupo;
import model.Orientacao;

public class ConsultaController implements ActionListener {
	private JTable tbConsultaGrupo;
	
	public ConsultaController(JTable tbConsultaGrupo) {
		super();
		this.tbConsultaGrupo = tbConsultaGrupo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void buscarPorCodigo(String codigo) throws IOException {
		
	    DefaultTableModel model = (DefaultTableModel) tbConsultaGrupo.getModel();
	    model.setRowCount(0); // Limpa a tabela
	    String nomeArq = "grupos.csv";
	    List<Grupo> grupos = lerDadosDoCSV(nomeArq);
	    
	    for (Grupo grupo : grupos) {
	        if (grupo.getCodigo() == codigo) {
	        	System.out.println("teste");
	            Object[] rowData = {grupo.getCodigo(), grupo.getSubarea()};
	            model.addRow(rowData);
	        }
	    }
	}		


	public void buscarPorSubarea(String subarea) throws IOException {
		
	    DefaultTableModel model = (DefaultTableModel) tbConsultaGrupo.getModel();
	    model.setRowCount(0); // Limpa a tabela
	    
	    String nomeArq = "grupos.csv";
	    List<Grupo> grupos = lerDadosDoCSV(nomeArq);
	    
	    for (Grupo grupo : grupos) {
	        if (grupo.getSubarea().equals(subarea)) {
	            Object[] rowData = {grupo.getCodigo(), grupo.getSubarea()};
	            model.addRow(rowData);
	        }
	    }
	}
	
	public List<Grupo> lerDadosDoCSV(String nomeArq) throws IOException {
		
	    List<Grupo> grupos = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(nomeArq))) {
	        String linha;
	        while ((linha = br.readLine()) != null) {
	            String[] dados = linha.split(",");
	            String codigo = dados[0];
	            String subarea = "";
	            String area ="";
	            String tema="";
	            String orientador="";

	            Grupo grupo = new Grupo(codigo, tema, orientador, area, subarea);
	            grupos.add(grupo);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return grupos;
	}

	public Orientacao buscarUltimaOrientacao(String codigoGrupo) {
		String arqNome = "orientações.csv";
		List<Orientacao> orientacoes = lerDadosDoCSVOrienta(arqNome);
	    for (int i = orientacoes.size() - 1; i >= 0; i--) {
	        Orientacao orientacao = (Orientacao) orientacoes.get(i);
	        if (orientacao.getGrupo() == codigoGrupo) {
	            return orientacao;
	        }
	    }

	    return null;
	}
	
	private List<Orientacao> lerDadosDoCSVOrienta(String arquivoCSV) {
	    List<Orientacao> orientacoes = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
	        String linha;
	        while ((linha = br.readLine()) != null) {
	            String[] dados = linha.split(",");
	            String codigoGrupo =dados[0];
	            String descricao = dados[0];

	            Orientacao orientacao = new Orientacao(codigoGrupo, descricao);
	            orientacoes.add(orientacao);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return orientacoes;
	}
}




