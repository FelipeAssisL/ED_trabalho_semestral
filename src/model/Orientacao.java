package model;

public class Orientacao {
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
}