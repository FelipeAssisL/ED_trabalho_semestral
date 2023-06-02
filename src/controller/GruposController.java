package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GruposController<E>implements ActionListener {
	
	private JTextField tfCodGrupo;
	private JTextField tfTema;
	private JTextField tfRaAluno;
	private JTable tbAlunos;
	private JComboBox<E> cbOrientador;
	private JComboBox<E> cbArea;
	
	public GruposController(JTextField tfCodGrupo, JTextField tfTema, JTextField tfRaAluno, JTable tbAlunos,JComboBox<E> cbOrientador, JComboBox<E> cbArea) {
		
		super();
		this.tfCodGrupo = tfCodGrupo;
		this.tfTema = tfTema;
		this.tfRaAluno = tfRaAluno;
		this.tbAlunos = tbAlunos;
		this.cbOrientador = cbOrientador;
		this.cbArea = cbArea;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
