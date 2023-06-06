package model;

public class Grupo {
    private String codigo;
    private String tema;
    private String orientador;
    private String area;
    private String subarea;

    public Grupo(String codigo, String tema, String orientador, String area, String subarea) {
        this.codigo = codigo;
        this.tema = tema;
        this.orientador = orientador;
        this.area = area;
        this.subarea = subarea;
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

	public Object getSubarea() {
		return subarea;
	}
}
