package model;

public class Orientacao implements CharSequence {
    private String grupo;
    private String orientacao;
    
    public Orientacao(String grupo, String orientacao) {
        this.grupo = grupo;
        this.orientacao = orientacao;
    }
    
    public String getGrupo() {
        return grupo;
    }
    public String getOrientacao() {
        return orientacao;
    }

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
}