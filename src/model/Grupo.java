package model;

public class Grupo {
    private String codigo;
    private String tema;
    private String orientador;
    private String area;

    public Grupo(String codigo, String tema, String orientador, String area) {
        this.codigo = codigo;
        this.tema = tema;
        this.orientador = orientador;
        this.area = area;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTema() {
        return tema;
    }

    public String getOrientador() {
        return orientador;
    }

    public String getArea() {
        return area;
    }
}
